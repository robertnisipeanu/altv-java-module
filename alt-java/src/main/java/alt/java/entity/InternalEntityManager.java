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

    public static void initializeInternalEntityManager(){
        API.libc.alt_JavaResource_OnCreateBaseObject_Callback_Register(CreateBaseObjectCallback);
        API.libc.alt_JavaResource_OnRemoveBaseObject_Callback_Register(RemoveBaseObjectCallback);
    }

    public static ArrayList<Player> getPlayersForResource(AltResource resource){
        throw new NotImplementedException("TODO");
        //return entity_playerList.get(resource);
    }

    public static ArrayList<Vehicle> getVehiclesForResource(AltResource resource){
        throw new NotImplementedException("TODO");
        //return entity_vehicleList.get(resource);
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
                break;
            case BaseObjectType.Vehicle:
                baseObject = new Vehicle(baseObjectPointer);
                // entity_vehicleList.computeIfAbsent(resource, v -> new ArrayList<>()).add(((Vehicle)baseObject));
                entity_vehicleList.computeIfAbsent(resource, v -> new HashMap<>()).put(baseObjectPointer, ((Vehicle)baseObject));
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
        
    }

    /*
    TODO: Add entities on base object creation
     */

}
