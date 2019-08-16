package alt.java.events;

import alt.java.Alt;
import alt.java.AltJavaNative.API;
import alt.java.resource.AltResource;
import alt.java.resource.ResourceManager;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EventManager {

    private static HashMap<AltResource, Set<Object>> listeners = new HashMap<>();

    //region define event callbacks
    private static API.alt_JavaResource_PlayerConnectEvent_Callback PlayerConnectEvent = EventManager::On_PlayerConnectEvent;
    private static API.alt_JavaResource_PlayerDisconnectEvent_Callback PlayerDisconnectEvent = EventManager::On_PlayerDisconnectEvent;
    private static API.alt_JavaResource_ServerScriptEvent_Callback ServerScriptEvent = EventManager::On_ServerScriptEvent;
    private static API.alt_JavaResource_ClientScriptEvent_Callback ClientScriptEvent = EventManager::On_ClientScriptEvent;
    private static API.alt_JavaResource_MetaChangeEvent_Callback MetaChangeEvent = EventManager::On_MetaChangeEvent;
    private static API.alt_JavaResource_SyncedMetaChangeEvent_Callback SyncedMetaChangeEvent = EventManager::On_SyncedMetaChangeEvent;
    private static API.alt_JavaResource_PlayerDamageEvent_Callback PlayerDamageEvent = EventManager::On_PlayerDamageEvent;
    private static API.alt_JavaResource_PlayerDeathEvent_Callback PlayerDeathEvent = EventManager::On_PlayerDeathEvent;
    private static API.alt_JavaResource_CheckpointEvent_Callback CheckpointEvent = EventManager::On_CheckpointEvent;
    private static API.alt_JavaResource_ColshapeEvent_Callback ColshapeEvent = EventManager::On_ColshapeEvent;
    private static API.alt_JavaResource_PlayerEnterVehicleEvent_Callback PlayerEnterVehicleEvent = EventManager::On_PlayerEnterVehicleEvent;
    private static API.alt_JavaResource_PlayerLeaveVehicleEvent_Callback PlayerLeaveVehicleEvent = EventManager::On_PlayerLeaveVehicleEvent;
    private static API.alt_JavaResource_PlayerChangeVehicleSeatEvent_Callback PlayerChangeVehicleSeatEvent = EventManager::On_PlayerChangeVehicleSeatEvent;
    private static API.alt_JavaResource_RemoveEntityEvent_Callback RemoveEntityEvent = EventManager::On_RemoveEntityEvent;
    private static API.alt_JavaResource_DataNodeReceivedEvent_Callback DataNodeReceivedEvent = EventManager::On_DataNodeChangeEvent;
    private static API.alt_JavaResource_ConsoleCommandEvent_Callback ConsoleCommandEvent = EventManager::On_ConsoleCommandEvent;
    //endregion

    /**
     * Register callbacks to events
     * WARNING: Do not use this function in resources, instead use {@link alt.java.Alt#registerListener(AltResource, Object)}
     */
    public static void initializeEventManager(){
        API.libc.alt_JavaResource_PlayerConnectEvent_Callback_Register(PlayerConnectEvent);
        API.libc.alt_JavaResource_PlayerDisconnectEvent_Callback_Register(PlayerDisconnectEvent);
        API.libc.alt_JavaResource_ServerScriptEvent_Callback_Register(ServerScriptEvent);
        API.libc.alt_JavaResource_ClientScriptEvent_Callback_Register(ClientScriptEvent);
        API.libc.alt_JavaResource_MetaChangeEvent_Callback_Register(MetaChangeEvent);
        API.libc.alt_JavaResource_SyncedMetaChangeEvent_Callback_Register(SyncedMetaChangeEvent);
        API.libc.alt_JavaResource_PlayerDamageEvent_Callback_Register(PlayerDamageEvent);
        API.libc.alt_JavaResource_PlayerDeathEvent_Callback_Register(PlayerDeathEvent);
        API.libc.alt_JavaResource_CheckpointEvent_Callback_Register(CheckpointEvent);
        API.libc.alt_JavaResource_ColshapeEvent_Callback_Register(ColshapeEvent);
        API.libc.alt_JavaResource_PlayerEnterVehicleEvent_Callback_Register(PlayerEnterVehicleEvent);
        API.libc.alt_JavaResource_PlayerLeaveVehicleEvent_Callback_Register(PlayerLeaveVehicleEvent);
        API.libc.alt_JavaResource_PlayerChangeVehicleSeatEvent_Callback_Register(PlayerChangeVehicleSeatEvent);
        API.libc.alt_JavaResource_RemoveEntityEvent_Callback_Register(RemoveEntityEvent);
        API.libc.alt_JavaResource_DataNodeReceivedEvent_Callback_Register(DataNodeReceivedEvent);
        API.libc.alt_JavaResource_ConsoleCommandEvent_Callback_Register(ConsoleCommandEvent);
    }

    /**
     * WARNING: Use Alt.registerListener instead
     */
    public static void registerListener(AltResource resource, Object listener){
        Set<Object> resourceListeners;
        if(listeners.containsKey(resource))
            resourceListeners = listeners.get(resource);
        else
            resourceListeners = new HashSet<>();
        resourceListeners.add(listener);
        listeners.put(resource, resourceListeners);
    }

    private static boolean verifyEventMethod(Method method, Class<?> eventType){
        if(!method.isAnnotationPresent(EventHandler.class)) return false;
        if(method.getParameterCount() != 1) return false;
         return eventType.isAssignableFrom(method.getParameterTypes()[0]);
    }

    private static void fireEvent(Pointer resourcePointer, Object eventObject) {
        AltResource resource = ResourceManager.getResource(resourcePointer);
        if(resource == null) return;

        for(Object eventListener : listeners.get(resource)){
            Class<?> eventListenerClass = eventListener.getClass();
            Method[] methods = eventListenerClass.getDeclaredMethods();
            for(Method method : methods){
                if(!verifyEventMethod(method, eventObject.getClass())) continue;
                try{
                    method.invoke(eventListener, eventObject);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    Alt.logError("There has been an error while processing events: "+ ExceptionUtils.getStackTrace(e));
                }
            }
        }
    }

    //region Event callbacks
    private static boolean On_PlayerConnectEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new PlayerConnectEvent(eventPointer));

        return true;
    }

    private static boolean On_PlayerDisconnectEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new PlayerDisconnectEvent(eventPointer));
        return true;
    }

    private static boolean On_ServerScriptEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new ServerScriptEvent(eventPointer));
        return true;
    }

    private static boolean On_ClientScriptEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new ClientScriptEvent(eventPointer));
        return true;
    }

    private static boolean On_MetaChangeEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new MetaDataChangeEvent(eventPointer));
        return true;
    }

    private static boolean On_SyncedMetaChangeEvent(Pointer resourcePointer, Pointer eventPointer){
        // TODO: Implement
        return true;
    }

    private static boolean On_PlayerDamageEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new PlayerDamageEvent(eventPointer));
        return true;
    }

    private static boolean On_PlayerDeathEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new PlayerDeathEvent(eventPointer));
        return true;
    }

    private static boolean On_CheckpointEvent(Pointer resourcePointer, Pointer eventPointer){
        return true;
    }

    private static boolean On_ColshapeEvent(Pointer resourcePointer, Pointer eventPointer){
        return true;
    }

    private static boolean On_PlayerEnterVehicleEvent(Pointer resourcePointer, Pointer eventPointer){
        return true;
    }

    private static boolean On_PlayerLeaveVehicleEvent(Pointer resourceEPointer, Pointer eventPointer){
        return true;
    }

    private static boolean On_PlayerChangeVehicleSeatEvent(Pointer resourcePointer, Pointer eventPointer){
        return true;
    }

    private static boolean On_RemoveEntityEvent(Pointer resourcePointer, Pointer eventPointer){
        return true;
    }

    private static boolean On_DataNodeChangeEvent(Pointer resourcePointer, Pointer eventPointer){
        return true;
    }

    private static boolean On_ConsoleCommandEvent(Pointer resourcePointer, Pointer eventPointer){
        fireEvent(resourcePointer, new ConsoleCommandEvent(eventPointer));
        return true;
    }

    //endregion
    
}
