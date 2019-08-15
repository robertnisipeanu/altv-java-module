package alt.java.entity;

import alt.java.Alt;
import alt.java.AltJavaNative.API;
import alt.java.resource.AltResource;
import alt.java.resource.ResourceManager;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;

public final class InternalEntityManager {

    private static HashMap<AltResource, HashMap<Pointer, BaseObject>> entity_baseObjectList = new HashMap<>();
    private static HashMap<AltResource, HashMap<Pointer, Player>> entity_playerList = new HashMap<>();
    private static HashMap<AltResource, HashMap<Pointer, Vehicle>> entity_vehicleList = new HashMap<>();
    private static HashMap<AltResource, HashMap<Pointer, Entity>> entity_entityList = new HashMap<>();
    /* TODO: Implement Entity type on object creation/deletion */

    public static void initializeInternalEntityManager(){
        API.libc.alt_JavaResource_OnCreateBaseObject_Callback_Register(CreateBaseObjectCallback);
        API.libc.alt_JavaResource_OnRemoveBaseObject_Callback_Register(RemoveBaseObjectCallback);
    }

    public static Player getPlayerFromPointerForResource(AltResource resource, Pointer playerPointer){
        return entity_playerList.get(resource).get(playerPointer); // Gonna throw a NullPointerException if key doesn't exists, but if this method is called then the key should exist
    }

    public static Vehicle getVehicleFromPointerForResource(AltResource resource, Pointer vehiclePointer){
        return entity_vehicleList.get(resource).get(vehiclePointer);
    }

    public static BaseObject getBaseObjectFromPointerForResource(AltResource resource, Pointer baseObjectPointer){
        return entity_baseObjectList.get(resource).get(baseObjectPointer);
    }

    public static Entity getEntityFromPointerForResource(AltResource resource, Pointer entityPointer){
        return entity_entityList.get(resource).get(entityPointer);
    }

    public static ArrayList<Player> getPlayersForResource(AltResource resource){
        return new ArrayList<>(entity_playerList.get(resource).values());
    }

    public static ArrayList<Vehicle> getVehiclesForResource(AltResource resource){
        return new ArrayList<>(entity_vehicleList.get(resource).values());
    }

    public static ArrayList<Entity> getEntitiesForResource(AltResource resource){
        return new ArrayList<>(entity_entityList.get(resource).values());
    }

    private static API.alt_JavaResource_OnCreateBaseObject_Callback CreateBaseObjectCallback = InternalEntityManager::OnCreateBaseObject;
    private static API.alt_JavaResource_OnRemoveBaseObject_Callback RemoveBaseObjectCallback = InternalEntityManager::OnRemoveBaseObject;

    private static void OnCreateBaseObject(Pointer resourcePointer, Pointer baseObjectPointer){
        BaseObject baseObject;
        AltResource resource = ResourceManager.getResource(resourcePointer);
        switch(API.libc.alt_IBaseObject_GetType(baseObjectPointer)){
            case BaseObjectType.Player:
                baseObject = new Player(baseObjectPointer);
                // entity_playerList.computeIfAbsent(resource, v -> new ArrayList<>()).add(((Player)baseObject));
                entity_playerList.computeIfAbsent(resource, v-> new HashMap<>()).put(baseObjectPointer, ((Player)baseObject));
                entity_entityList.computeIfAbsent(resource, v-> new HashMap<>()).put(baseObjectPointer, ((Entity)baseObject));
                break;
            case BaseObjectType.Vehicle:
                baseObject = new Vehicle(baseObjectPointer);
                // entity_vehicleList.computeIfAbsent(resource, v -> new ArrayList<>()).add(((Vehicle)baseObject));
                entity_vehicleList.computeIfAbsent(resource, v -> new HashMap<>()).put(baseObjectPointer, ((Vehicle)baseObject));
                entity_entityList.computeIfAbsent(resource, v-> new HashMap<>()).put(baseObjectPointer, ((Entity)baseObject));
                break;
            case BaseObjectType.Blip:
                baseObject = new Blip(baseObjectPointer);
                break;
            case BaseObjectType.VoiceChannel:
                baseObject = new VoiceChannel(baseObjectPointer);
                break;
            case BaseObjectType.ColShape:
                baseObject = new Colshape(baseObjectPointer);
                break;
            default:
                baseObject = new BaseObject(baseObjectPointer);
                break;
        }
        // entity_baseObjectList.computeIfAbsent(resource, v->new ArrayList<>()).add(baseObject);
        entity_baseObjectList.computeIfAbsent(resource, v -> new HashMap<>()).put(baseObjectPointer, baseObject);
    }

    private static void OnRemoveBaseObject(Pointer resourcePointer, Pointer baseObjectPointer){
        AltResource resource = ResourceManager.getResource(resourcePointer);
        switch(API.libc.alt_IBaseObject_GetType(baseObjectPointer)){
            case BaseObjectType.Player:
                entity_playerList.computeIfAbsent(resource, v -> new HashMap<>()).remove(baseObjectPointer);
                entity_entityList.computeIfAbsent(resource, v -> new HashMap<>()).remove(baseObjectPointer);
                break;
            case BaseObjectType.Vehicle:
                entity_vehicleList.computeIfAbsent(resource, v -> new HashMap<>()).remove(baseObjectPointer);
                entity_entityList.computeIfAbsent(resource, v -> new HashMap<>()).remove(baseObjectPointer);
                break;
            default:
                break;
        }

        entity_baseObjectList.computeIfAbsent(resource, v -> new HashMap<>()).remove(baseObjectPointer);
    }

}
