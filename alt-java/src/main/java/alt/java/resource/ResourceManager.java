package alt.java.resource;

import alt.java.Alt;
import alt.java.AltJavaNative.API;
import alt.java.events.AltEvent;
import alt.java.events.EventManager;
import alt.java.events.PlayerConnectEvent;
import alt.java.util.exceptions.ResourceLoadFailException;
import jnr.ffi.Pointer;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * This will take care of loading/unloading resources, registering/firing events
 */
public class ResourceManager {

    //region define callbacks
    private static API.alt_JavaResource_Start_Callback ResourceStartCallback = ResourceManager::On_ResourceStart;
    private static API.alt_JavaResource_Stop_Callback ResourceStopCallback = ResourceManager::On_ResourceStop;
    private static API.alt_JavaResource_OnTick_Callback ResourceOnTickCallback = ResourceManager::On_ResourceTick;
    //private static API.alt_JavaResource_OnEvent_Callback ResourceOnEventCallback = ResourceManager::On_ResourceEvent;
    //endregion

    private static JavaResourceLoader loader;
    private static HashMap<Pointer, AltResource> resourceList = new HashMap<>();

    /**
     * TODO: Event Listener(Register, Invoke)
     * https://github.com/Bukkit/Bukkit/blob/master/src/main/java/org/bukkit/plugin/SimplePluginManager.java#L521
     */

    /**
     * Initialize the loader and resource callbacks
     */
    public static void initResourceManager(){
        // Initialize resource loader
        loader = new JavaResourceLoader();

        API.libc.alt_JavaResource_Start_Callback_Register(ResourceStartCallback);
        API.libc.alt_JavaResource_Stop_Callback_Register(ResourceStopCallback);
        API.libc.alt_JavaResource_OnTick_Callback_Register(ResourceOnTickCallback);
        // API.libc.alt_JavaResource_OnEvent_Callback_Register(ResourceOnEventCallback);
        EventManager.initializeEventManager();
    }

    public static AltResource getResource(Pointer resourcePointer){
        return resourceList.get(resourcePointer);
    }

    /**
     * Callback from resource `Start` method
     * @param resourcePointer C Pointer to the resource
     * @return
     */
    private static boolean On_ResourceStart(Pointer resourcePointer){
        if(!resourceList.containsKey(resourcePointer)) return false; // If resourceList doesn't contains resourcePointer then it means the resource has failed initialization
        AltResource resource = resourceList.get(resourcePointer);
        resource.onStart();
        return true;
    }

    /**
     * Callback from resource `OnTick` method
     * @param resourcePointer
     */
    private static void On_ResourceTick(Pointer resourcePointer){
        if(!resourceList.containsKey(resourcePointer)) return;
        AltResource resource = resourceList.get(resourcePointer);
        resource.onTick();
    }

    /**
     * Callback from resource `Stop` method
     * @param resourcePointer
     * @return
     */
    private static boolean On_ResourceStop(Pointer resourcePointer){
        if(!resourceList.containsKey(resourcePointer)) return true;
        AltResource resource = resourceList.get(resourcePointer);
        resource.onStop();
        return true;
    }

    /**
     * Callback from ScriptRuntimeHandler `CreateResource` method
     * @param resourcePointer C Pointer to the resource
     * @param creationInfoPointer C Pointer to the alt::CEvent::CreationInfo* object
     */
    public static void On_ResourceCreate(Pointer resourcePointer, Pointer creationInfoPointer){
        Alt.logInfo("Reasource create: "+resourcePointer.address());

        // Get .jar file
        File file = new File( API.libc.alt_JavaResource_CreationInfo_GetPath(creationInfoPointer)+ "\\" +
                API.libc.alt_JavaResource_CreationInfo_GetMain(creationInfoPointer));
        Alt.logInfo("file path: "+file.getPath());

        // Try to load the resource
        AltResource resource;
        try {
            resource = loader.loadResource(creationInfoPointer, file);
            resource.resourcePointer = resourcePointer;
        } catch (FileNotFoundException e) {
            Alt.logError("Resource not found\n"+e.toString());
            return;
        } catch(ResourceLoadFailException e){
            Alt.logError("Failed to load resource\n"+e.toString());
            return;
        }
        resourceList.put(resourcePointer, resource); // Add resource to resourceList Map
    }


}
