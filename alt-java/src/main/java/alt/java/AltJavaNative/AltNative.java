package alt.java.AltJavaNative;

import alt.java.Alt;
import alt.java.entity.InternalEntityManager;
import alt.java.resource.AltResource;
import alt.java.resource.ResourceClassLoader;
import alt.java.resource.ResourceManager;
import jnr.ffi.*;
import jnr.ffi.Runtime;
import jnr.ffi.types.uintptr_t;

public final class AltNative {

    /**
     * This is the method that will be called through JNI from C++ to initialize the JVM
     * @param serverPointer C Pointer to alt::IServer* object
     */
    private static void initJavaModule(@uintptr_t long serverPointer){
        API.libc = LibraryLoader.create(API.CAPIFunctions.class).load("java-module");
        API.runtime = Runtime.getRuntime(API.libc);
        API.serverPointer = Pointer.wrap(API.runtime, serverPointer);

        Alt.logInfo("[Java] JVM is running");

        ResourceManager.initResourceManager();
        InternalEntityManager.initializeInternalEntityManager();
        registerCallbacks();

    }

    /**
     * ResourceCreate callback to {@link ResourceManager#On_ResourceCreate(Pointer, Pointer)}
     */
    private static API.alt_ScriptRuntimeHandler_CreateResource_Callback ResourceCreateCallback = ResourceManager::On_ResourceCreate;

    /**
     * Pass pointers to java methods (register callbacks) to the C(++) API
     */
    private static void registerCallbacks(){
        //API.libc.PrintFromC(API.serverPointer, CallBackTest);
        API.libc.alt_ScriptRuntimeHandler_CreateResource_Callback_Register(ResourceCreateCallback);
    }

    public static AltResource getResourceFromCallerClass(Class<?> callerClass){
        ClassLoader classLoader = callerClass.getClassLoader();
        if(classLoader instanceof ResourceClassLoader) return ((ResourceClassLoader)classLoader).resource;
        return null;
    }

}