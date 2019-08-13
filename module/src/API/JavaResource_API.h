#pragma once

#include <cstdint>
#include <altv-cpp-api/SDK.h>
#include "../JavaResource.h"


#ifndef EXPORT
#define EXPORT _declspec(dllexport)
#endif // !EXPORT

// Need to use extern "C" else the name of the functions gets mangled and JAVA won't be able to find them anymore
#ifdef __cplusplus
extern "C" {
#endif

	/*
		Model: static `RETURNING_TYPE` (*CallbackName) (`ARGUMENTS_TYPE`)
		Usually first argument will be the pointer to the resource, if there will be any other arg or first argument has different purpose then that'll be added as a comment with `// arg{number}: description`
	*/
	extern void (*JavaResource_OnTick_Callback)(uintptr_t);
	extern bool (*JavaResource_Start_Callback)(uintptr_t);
	extern bool (*JavaResource_Stop_Callback)(uintptr_t);
	extern void (*JavaResource_CreateBaseObject_Callback)(uintptr_t, uintptr_t); // arg2: pointer to alt::IBaseObject*
	extern void (*JavaResource_RemoveBaseObject_Callback)(uintptr_t, uintptr_t);
#pragma region Events callback
	extern bool (*JavaResource_OnEvent_Callback)(uintptr_t, uintptr_t); // arg2: pointer to the CEvent object
	extern bool (*JavaResource_PlayerConnectEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_PlayerDisconnectEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_ServerScriptEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_ClientScriptEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_MetaChangeEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_SyncedMetaChangeEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_PlayerDamageEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_PlayerDeathEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_CheckpointEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_ColshapeEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_PlayerEnterVehicleEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_PlayerLeaveVehicleEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_PlayerChangeVehicleSeatEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_RemoveEntityEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_DataNodeReceivedEvent_Callback)(uintptr_t, uintptr_t);
	extern bool (*JavaResource_ConsoleCommandEvent_Callback)(uintptr_t, uintptr_t);
#pragma endregion

	/*
		Those will be called from Java, first argument being the pointer to the resource it wants to register the event and the second argument being the pointer to the (java) method that will be called("the callback")
	*/
	EXPORT void alt_JavaResource_OnTick_Callback_Register(void (*cb)(uintptr_t));
	EXPORT void alt_JavaResource_Start_Callback_Register(bool (*cb)(uintptr_t));
	EXPORT void alt_JavaResource_Stop_Callback_Register(bool (*cb)(uintptr_t));
	EXPORT void alt_JavaResource_OnCreateBaseObject_Callback_Register(void (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_OnRemoveBaseObject_Callback_Register(void (*cb)(uintptr_t, uintptr_t));
#pragma region Events callback register
	EXPORT void alt_JavaResource_OnEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_PlayerConnectEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_PlayerDisconnectEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_ServerScriptEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_ClientScriptEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_MetaChangeEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_SyncedMetaChangeEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_PlayerDamageEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_PlayerDeathEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_CheckpointEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_ColshapeEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_PlayerEnterVehicleEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_PlayerLeaveVehicleEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_PlayerChangeVehicleSeatEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_RemoveEntityEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_DataNodeReceivedEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_JavaResource_ConsoleCommandEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t));
#pragma endregion

	/*
		Methods that the Java API will be able to call
	*/
#pragma region Resource information
	EXPORT const char* alt_JavaResource_GetName(uintptr_t resourcePointer);
	EXPORT const char* alt_JavaResource_CreationInfo_GetName(uintptr_t creationInfoPointer);
	EXPORT const char* alt_JavaResource_GetPath(uintptr_t resourcePointer);
	EXPORT const char* alt_JavaResource_CreationInfo_GetPath(uintptr_t creationInfoPointer);
	EXPORT const char* alt_JavaResource_GetMain(uintptr_t resourcePointer);
	EXPORT const char* alt_JavaResource_CreationInfo_GetMain(uintptr_t creationInfoPointer);
	EXPORT int32_t alt_JavaResource_CEvent_GetType(uintptr_t ceventPointer);
#pragma endregion

#pragma region Events info

	#pragma region PlayerConnectEvent
	EXPORT const char* alt_JavaResource_PlayerConnectEvent_GetReason(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_PlayerConnectEvent_GetTarget(uintptr_t eventPointer);
	#pragma endregion

	#pragma region PlayerDisconnectEvent
	EXPORT const char* alt_JavaResource_PlayerDisconnectEvent_GetReason(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_PlayerDisconnectEvent_GetTarget(uintptr_t eventPointer);
	#pragma endregion

	// TODO: ServerScriptEvent->GetArgs()
	#pragma region ServerScriptEvent
	EXPORT const char* alt_JavaResource_ServerScriptEvent_GetName(uintptr_t eventPointer);
	#pragma endregion

	// TODO: ClientScriptEvent->GetArgs()
	#pragma region ClientScriptEvent
	EXPORT const char* alt_JavaResource_ClientScriptEvent_GetName(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_ClientScriptEvent_GetTarget(uintptr_t eventPointer);
	#pragma endregion

	// TODO
	#pragma region MetaChangeEvent
	#pragma endregion

	// TODO
	#pragma region SyncedMetaChangeEvent
	#pragma endregion

	#pragma region PlayerDamageEvent
	EXPORT uintptr_t alt_JavaResource_PlayerDamageEvent_GetTarget(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_PlayerDamageEvent_GetAttacker(uintptr_t eventPointer);
	EXPORT uint16_t alt_JavaResource_PlayerDamageEvent_GetDamage(uintptr_t eventPointer);
	EXPORT uint32_t alt_JavaResource_PlayerDamageEvent_GetWeapon(uintptr_t eventPointer);
	#pragma endregion

	#pragma region PlayerDeathEvent
	EXPORT uintptr_t alt_JavaResource_PlayerDeathEvent_GetTarget(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_PlayerDeathEvent_GetKiller(uintptr_t eventPointer);
	EXPORT uint32_t alt_JavaResource_PlayerDeathEvent_GetWeapon(uintptr_t eventPointer);
	#pragma endregion

	#pragma region CheckpointEvent
	EXPORT uintptr_t alt_JavaResource_CheckpointEvent_GetTarget(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_CheckpointEvent_GetEntity(uintptr_t eventPointer);
	EXPORT bool alt_JavaResource_CheckpointEvent_GetState(uintptr_t eventPointer);
	#pragma endregion

	#pragma region ColshapeEvent
	EXPORT uintptr_t alt_JavaResource_ColshapeEvent_GetTarget(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_ColshapeEvent_GetEntity(uintptr_t eventPointer);
	EXPORT bool alt_JavaResource_ColshapeEvent_GetState(uintptr_t eventPointer);
	#pragma endregion

	#pragma region PlayerEnterVehicleEvent
	EXPORT uintptr_t alt_JavaResource_PlayerEnterVehicleEvent_GetTarget(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_PlayerEnterVehicleEvent_GetPlayer(uintptr_t eventPointer);
	EXPORT uint8_t alt_JavaResource_PlayerEnterVehicleEvent_GetSeat(uintptr_t eventPointer);
	#pragma endregion

	#pragma region PlayerLeaveVehicleEvent
	EXPORT uintptr_t alt_JavaResource_PlayerLeaveVehicleEvent_GetTarget(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_PlayerLeaveVehicleEvent_GetPlayer(uintptr_t eventPointer);
	EXPORT uint8_t alt_JavaResource_PlayerLeaveVehicleEvent_GetSeat(uintptr_t eventPointer);
	#pragma endregion

	#pragma region PlayerChangeVehicleSeatEvent
	EXPORT uintptr_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetTarget(uintptr_t eventPointer);
	EXPORT uintptr_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetPlayer(uintptr_t eventPointer);
	EXPORT uint8_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetOldSeat(uintptr_t eventPointer);
	EXPORT uint8_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetNewSeat(uintptr_t eventPointer);
	#pragma endregion

	#pragma region RemoveEntityEvent
	uintptr_t alt_JavaResource_RemoveEntityEvent_GetEntity(uintptr_t eventPointer);
	#pragma endregion

	#pragma region DataNodeReceivedEvent
	EXPORT const char* alt_JavaResource_DataNodeReceivedEvent_GetName(uintptr_t eventPointer);
	EXPORT const char* alt_JavaResource_DataNodeReceivedEvent_GetJson(uintptr_t eventPointer);
	#pragma endregion

	#pragma region ConsoleCommandEvent
	EXPORT const char* alt_JavaResource_ConsoleCommandEvent_GetName(uintptr_t eventPointer);
	#pragma endregion

#pragma endregion Events info

#pragma region MValue
	EXPORT uint8_t alt_MValue_GetType(uintptr_t mvaluePointer);
#pragma endregion

#ifdef __cplusplus
}
#endif