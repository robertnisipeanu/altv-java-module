package alt.java.AltJavaNative;

import jnr.ffi.Pointer;
import jnr.ffi.Runtime;
import jnr.ffi.Struct;
import jnr.ffi.annotations.Delegate;
import jnr.ffi.annotations.Encoding;
import jnr.ffi.types.int32_t;
import jnr.ffi.types.u_int32_t;
import jnr.ffi.types.u_int16_t;
import jnr.ffi.types.u_int8_t;
import jnr.ffi.types.int16_t;

public class API {

    public static Pointer serverPointer;
    public static Runtime runtime;
    public static API.CAPIFunctions libc;

    /**
     * `Pointer` represents a pointer to a C(++) method/object
     * `interface_name` represents a pointer (callback method) to a Java method
     * Check module "_API" files for a better understanding of what all this does
    */

    //region ScriptRuntimeHandler_API.h
    public interface alt_ScriptRuntimeHandler_CreateResource_Callback{
        @Delegate void callback(Pointer resourcePointer, Pointer creationInfoPointer);
    }
    //endregion

    //region JavaResource_API.h
    public interface alt_JavaResource_Start_Callback{
        @Delegate boolean callback(Pointer resourcePointer);
    }

    public interface alt_JavaResource_OnTick_Callback{
        @Delegate void callback(Pointer resourcePointer);
    }

    public interface alt_JavaResource_Stop_Callback{
        @Delegate boolean callback(Pointer resourcePointer);
    }

    public interface alt_JavaResource_OnCreateBaseObject_Callback{
        @Delegate void callback(Pointer resourcePointer, Pointer baseObjectPointer);
    }

    public interface alt_JavaResource_OnRemoveBaseObject_Callback{
        @Delegate void callback(Pointer resourcePointer, Pointer baseObjectPointer);
    }

    //region Event callbacks
    public interface alt_JavaResource_OnEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer ceventPointer);
    }

    public interface alt_JavaResource_PlayerConnectEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_PlayerDisconnectEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_ServerScriptEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_ClientScriptEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_MetaChangeEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_SyncedMetaChangeEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_PlayerDamageEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_PlayerDeathEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_CheckpointEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_ColshapeEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_PlayerEnterVehicleEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_PlayerLeaveVehicleEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_PlayerChangeVehicleSeatEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_RemoveEntityEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_DataNodeReceivedEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }

    public interface alt_JavaResource_ConsoleCommandEvent_Callback{
        @Delegate boolean callback(Pointer resourcePointer, Pointer eventPointer);
    }
    //endregion

    //endregion


    public interface CAPIFunctions{

        //region ScriptRuntimeHandler_API.h
        void alt_ScriptRuntimeHandler_CreateResource_Callback_Register(alt_ScriptRuntimeHandler_CreateResource_Callback cb);
        //endregion

        //region JavaResource_API.h
        void alt_JavaResource_Start_Callback_Register(alt_JavaResource_Start_Callback cb);
        void alt_JavaResource_OnTick_Callback_Register(alt_JavaResource_OnTick_Callback cb);
        void alt_JavaResource_Stop_Callback_Register(alt_JavaResource_Stop_Callback cb);
        void alt_JavaResource_OnCreateBaseObject_Callback_Register(alt_JavaResource_OnCreateBaseObject_Callback cb);
        void alt_JavaResource_OnRemoveBaseObject_Callback_Register(alt_JavaResource_OnRemoveBaseObject_Callback cb);
        void alt_JavaResource_OnEvent_Callback_Register(alt_JavaResource_OnEvent_Callback cb);
            //region Event register callback
        void alt_JavaResource_PlayerConnectEvent_Callback_Register(alt_JavaResource_PlayerConnectEvent_Callback cb);
        void alt_JavaResource_PlayerDisconnectEvent_Callback_Register(alt_JavaResource_PlayerDisconnectEvent_Callback cb);
        void alt_JavaResource_ServerScriptEvent_Callback_Register(alt_JavaResource_ServerScriptEvent_Callback cb);
        void alt_JavaResource_ClientScriptEvent_Callback_Register(alt_JavaResource_ClientScriptEvent_Callback cb);
        void alt_JavaResource_MetaChangeEvent_Callback_Register(alt_JavaResource_MetaChangeEvent_Callback cb);
        void alt_JavaResource_SyncedMetaChangeEvent_Callback_Register(alt_JavaResource_SyncedMetaChangeEvent_Callback cb);
        void alt_JavaResource_PlayerDamageEvent_Callback_Register(alt_JavaResource_PlayerDamageEvent_Callback cb);
        void alt_JavaResource_PlayerDeathEvent_Callback_Register(alt_JavaResource_PlayerDeathEvent_Callback cb);
        void alt_JavaResource_CheckpointEvent_Callback_Register(alt_JavaResource_CheckpointEvent_Callback cb);
        void alt_JavaResource_ColshapeEvent_Callback_Register(alt_JavaResource_ColshapeEvent_Callback cb);
        void alt_JavaResource_PlayerEnterVehicleEvent_Callback_Register(alt_JavaResource_PlayerEnterVehicleEvent_Callback cb);
        void alt_JavaResource_PlayerLeaveVehicleEvent_Callback_Register(alt_JavaResource_PlayerLeaveVehicleEvent_Callback cb);
        void alt_JavaResource_PlayerChangeVehicleSeatEvent_Callback_Register(alt_JavaResource_PlayerChangeVehicleSeatEvent_Callback cb);
        void alt_JavaResource_RemoveEntityEvent_Callback_Register(alt_JavaResource_RemoveEntityEvent_Callback cb);
        void alt_JavaResource_DataNodeReceivedEvent_Callback_Register(alt_JavaResource_DataNodeReceivedEvent_Callback cb);
        void alt_JavaResource_ConsoleCommandEvent_Callback_Register(alt_JavaResource_ConsoleCommandEvent_Callback cb);
        //endregion

            //region Events info
                //region PlayerConnectEvent
        @Encoding("UTF-8") String alt_JavaResource_PlayerConnectEvent_GetReason(Pointer eventPointer);
        Pointer alt_JavaResource_PlayerConnectEvent_GetTarget(Pointer eventPointer);
                //endregion

                //region PlayerDisconnectEvent
        @Encoding("UTF-8") String alt_JavaResource_PlayerDisconnectEvent_GetReason(Pointer eventPointer);
        Pointer alt_JavaResource_PlayerDisconnectEvent_GetTarget(Pointer eventPointer);
                //endregion

                // TODO: ServerScriptEvent + ClientScriptEvent
                //region ServerScriptEvent
                //endregion
                //region ClientScriptEvent
                //endregion
                // TODO: MetaChangeEvent + SyncedMetaChangeEvent
                //region MetaChangeEvent
                //endregion
                //region SyncedMetaChangeEvent
                //endregion

                //region PlayerDamageEvent
        Pointer alt_JavaResource_PlayerDamageEvent_GetTarget(Pointer eventPointer);
        Pointer alt_JavaResource_PlayerDamageEvent_GetAttacker(Pointer eventPointer);
        @u_int16_t int alt_JavaResource_PlayerDamageEvent_GetDamage(Pointer eventPointer);
        @u_int32_t long alt_JavaResource_PlayerDamageEvent_GetWeapon(Pointer eventPointer);
                //endregion

                //region PlayerDeathEvent
        Pointer alt_JavaResource_PlayerDeathEvent_GetTarget(Pointer eventPointer);
        Pointer alt_JavaResource_PlayerDeathEvent_GetKiller(Pointer eventPointer);
        @u_int32_t long alt_JavaResource_PlayerDeathEvent_GetWeapon(Pointer eventPointer);
                //endregion

                //region CheckpointEvent
        Pointer alt_JavaResource_CheckpointEvent_GetTarget(Pointer eventPointer);
        Pointer alt_JavaResource_CheckpointEvent_GetEntity(Pointer eventPointer);
        boolean alt_JavaResource_CheckpointEvent_GetState(Pointer eventPointer);
                //endregion

                //region ColshapeEvent
        Pointer alt_JavaResource_ColshapeEvent_GetTarget(Pointer eventPointer);
        Pointer alt_JavaResource_ColshapeEvent_GetEntity(Pointer eventPointer);
        boolean alt_JavaResource_ColshapeEvent_GetState(Pointer eventPointer);
                //endregion

                //region PlayerEnterVehicleEvent
        Pointer alt_JavaResource_PlayerEnterVehicleEvent_GetTarget(Pointer eventPointer);
        Pointer alt_JavaResource_PlayerEnterVehicleEvent_GetPlayer(Pointer eventPointer);
        @u_int8_t short alt_JavaResource_PlayerEnterVehicleEvent_GetSeat(Pointer eventPointer);
                //endregion

                //region PlayerLeaveVehicleEvent
        Pointer alt_JavaResource_PlayerLeaveVehicleEvent_GetTarget(Pointer eventPointer);
        Pointer alt_JavaResource_PlayerLeaveVehicleEvent_GetPlayer(Pointer eventPointer);
        @u_int8_t short alt_JavaResource_PlayerLeaveVehicleEvent_GetSeat(Pointer eventPointer);
                //endregion

                //region PlayerChangeVehicleSeatEvent
        Pointer alt_JavaResource_PlayerChangeVehicleSeatEvent_GetTarget(Pointer eventPointer);
        Pointer alt_JavaResource_PlayerChangeVehicleSeatEvent_GetPlayer(Pointer eventPointer);
        @u_int8_t short alt_JavaResource_PlayerChangeVehicleSeatEvent_GetOldSeat(Pointer eventPointer);
        @u_int8_t short alt_JavaResource_PlayerChangeVehicleSeatEvent_GetNewSeat(Pointer eventPointer);
                //endregion

                //region RemoveEntityEvent
        Pointer alt_JavaResource_RemoveEntityEvent_GetEntity(Pointer eventPointer);
                //endregion

                //region DataNodeReceivedEvent
        @Encoding("UTF-8") String alt_JavaResource_DataNodeReceivedEvent_GetName(Pointer eventPointer);
        @Encoding("UTF-8") String alt_JavaResource_DataNodeReceivedEvent_GetJson(Pointer eventPointer);
                //endregion

                //region ConsoleCommandEvent
        @Encoding("UTF-8") String alt_JavaResource_ConsoleCommandEvent_GetName(Pointer eventPointer);
                //endregion
            //endregion

        @Encoding("UTF-8") String alt_JavaResource_GetName(Pointer resourcePointer);
        @Encoding("UTF-8") String alt_JavaResource_CreationInfo_GetName(Pointer creationInfoPointer);
        @Encoding("UTF-8") String alt_JavaResource_GetPath(Pointer resourcePointer);
        @Encoding("UTF-8") String alt_JavaResource_CreationInfo_GetPath(Pointer creationInfoPointer);
        @Encoding("UTF-8") String alt_JavaResource_GetMain(Pointer resourcePointer);
        @Encoding("UTF-8") String alt_JavaResource_CreationInfo_GetMain(Pointer creationInfoPointer);
        @int32_t int alt_JavaResource_CEvent_GetType(Pointer ceventPointer);
        //endregion

        //region IServer_API.h
        void alt_IServer_LogInfo(Pointer serverPointer, @Encoding("UTF-8") String message);
        void alt_IServer_LogError(Pointer serverPointer, @Encoding("UTF-8") String message);
        void alt_IServer_LogWarning(Pointer serverPointer, @Encoding("UTF-8") String message);
        void alt_IServer_LogDebug(Pointer serverPointer, @Encoding("UTF-8") String message);
        void alt_IServer_LogColored(Pointer serverPointer, @Encoding("UTF-8") String message);
        @u_int32_t long alt_IServer_Hash(Pointer serverPointer, @Encoding("UTF-8") String stringToHash);
        @Encoding("UTF-8") String alt_IServer_GetRootDirectory(Pointer serverPointer);
        //endregion

        //region IBaseObject_API.h
        @u_int8_t short alt_IBaseObject_GetType(Pointer baseObjectPointer);
        //endregion

        //region IWorldObject_API.h
        @int16_t short alt_IWorldObject_GetDimension(Pointer worldObjectPointer);
        void alt_IWorldObject_SetDimension(Pointer worldObjectPointer, @int16_t short dimension);
        //endregion

        //region IEntity_API.h
        @u_int16_t int alt_IEntity_GetID(Pointer entityPointer);
        @u_int32_t long alt_IEntity_GetModel(Pointer entityPointer);
        //endregion

    }
}
