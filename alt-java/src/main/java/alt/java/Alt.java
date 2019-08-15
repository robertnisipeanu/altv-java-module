package alt.java;

import alt.java.AltJavaNative.API;
import alt.java.AltJavaNative.AltNative;
import alt.java.entity.*;
import alt.java.events.EventManager;
import alt.java.resource.AltResource;
import alt.java.resource.ResourceClassLoader;
import alt.java.util.Position;
import alt.java.util.RGBA;
import alt.java.util.Rotation;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;

public final class Alt {

    /**
     * Use this to register classes as event listener
     * @param resource the AltResource that events are registered for
     * @param listener the class that is gonna be registered as an event handler
     */
    public static void registerListener(AltResource resource, Object listener){
        EventManager.registerListener(resource, listener);
    }

    public static long getNetTime(){
        throw new NotImplementedException("TODO");
    }

    public static String getRootDirectory(){
        return API.libc.alt_IServer_GetRootDirectory(API.serverPointer);
    }

    /*
     * WARNING: Do not currently use this, can only get Java Resources

    private static AltResource getResource(String name){
        throw new NotImplementedException("TODO");
    }
    private static boolean requireResource(Pointer referrer, Pointer resource){
        throw new NotImplementedException("TODO");
    }*/



    public static void logInfo(String message){
        /*StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = walker.getCallerClass();
        ClassLoader callerLoader = callerClass.getClassLoader();
        if(callerLoader instanceof ResourceClassLoader){
            API.libc.alt_IServer_LogInfo(API.serverPointer, "Called from resource: "+((ResourceClassLoader)callerLoader).resource.getResourcePointer().address());
        }*/
        /*AltResource testing = AltNative.getResourceFromCallerClass(StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass());
        API.libc.alt_IServer_LogInfo(API.serverPointer, "Called from resource: " + (testing != null ? "yes" : "no"));*/
        API.libc.alt_IServer_LogInfo(API.serverPointer, message);
    }
    public static void logDebug(String message){
        API.libc.alt_IServer_LogDebug(API.serverPointer, message);
    }
    public static void logWarning(String message){
        API.libc.alt_IServer_LogWarning(API.serverPointer, message);
    }
    public static void logError(String message){
        API.libc.alt_IServer_LogError(API.serverPointer, message);
    }
    public static void logColored(String message){
        API.libc.alt_IServer_LogColored(API.serverPointer, message);
    }

    public static long hash(String stringToHash){
        return API.libc.alt_IServer_Hash(API.serverPointer, stringToHash);
    }

    /**
     * TODO: Implement args (MValueList)
     */
    public static void triggerServerEvent(String ev, Object[] args){
        throw new NotImplementedException("TODO");
    }
    public static void triggerClientEvent(Player player, String ev, Object[] args){
        throw new NotImplementedException("TODO");
    }

    public static Vehicle createVehicle(long model, Position pos, Rotation rot){
        throw new NotImplementedException("TODO");
    }

    public static Checkpoint createCheckpoint(Player target, short type, Position position, float radius, float height, RGBA color){
        throw new NotImplementedException("TODO");
    }

    public static Blip createBlip(Player target, short type, Position position){
        throw new NotImplementedException("TODO");
    }
    public static Blip createBlip(Player target, short type, Entity attachTo){
        throw new NotImplementedException("TODO");
    }

    public static VoiceChannel createVoiceChannel(boolean spatial, float maxDistance){
        throw new NotImplementedException("TODO");
    }

    public static Colshape createColshapeCylinder(Position position, float radius, float height){
        throw new NotImplementedException("TODO");
    }
    public static Colshape createColshapeSphere(Position position, float radius){
        throw new NotImplementedException("TODO");
    }
    public static Colshape createColshapeCircle(Position position, float radius){
        throw new NotImplementedException("TODO");
    }
    public static Colshape createColshapeCube(Position position1, Position position2){
        throw new NotImplementedException("TODO");
    }
    public static Colshape createColshapeRectangle(Position position1, Position position2){
        throw new NotImplementedException("TODO");
    }

    public static Entity getEntityByID(){
        throw new NotImplementedException("TODO");
    }

    public static void destroyBaseObject(BaseObject handle){
        throw new NotImplementedException("TODO");
    }

    public static ArrayList<Player> getPlayersByName(String name){
        throw new NotImplementedException("TODO");
    }

    public static ArrayList<Entity> getEntities(){
        return InternalEntityManager.getEntitiesForResource(AltNative.getResourceFromCallerClass(StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass()));
    }
    public static ArrayList<Player> getPlayers(){
        AltResource resource = AltNative.getResourceFromCallerClass(StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass());
        if(resource == null) return null;
        return InternalEntityManager.getPlayersForResource(resource);
    }
    public static ArrayList<Vehicle> getVehicles(){
        AltResource resource = AltNative.getResourceFromCallerClass(StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass());
        if(resource == null) return null;
        return InternalEntityManager.getVehiclesForResource(resource);
    }

}
