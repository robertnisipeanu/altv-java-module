#include "JavaResource_API.h"

void (*JavaResource_OnTick_Callback)(uintptr_t);
bool (*JavaResource_Start_Callback)(uintptr_t);
bool (*JavaResource_Stop_Callback)(uintptr_t);
void (*JavaResource_CreateBaseObject_Callback)(uintptr_t, uintptr_t);
void (*JavaResource_RemoveBaseObject_Callback)(uintptr_t, uintptr_t);
#pragma region Events callback
bool (*JavaResource_OnEvent_Callback)(uintptr_t, uintptr_t); // arg2: pointer to the CEvent object
bool (*JavaResource_PlayerConnectEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_PlayerDisconnectEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_ServerScriptEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_ClientScriptEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_MetaChangeEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_SyncedMetaChangeEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_PlayerDamageEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_PlayerDeathEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_CheckpointEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_ColshapeEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_PlayerEnterVehicleEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_PlayerLeaveVehicleEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_PlayerChangeVehicleSeatEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_RemoveEntityEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_DataNodeReceivedEvent_Callback)(uintptr_t, uintptr_t);
bool (*JavaResource_ConsoleCommandEvent_Callback)(uintptr_t, uintptr_t);
#pragma endregion

void alt_JavaResource_OnTick_Callback_Register(void (*cb)(uintptr_t)) {
	JavaResource_OnTick_Callback = cb;
}

void alt_JavaResource_Start_Callback_Register(bool(*cb)(uintptr_t))
{
	JavaResource_Start_Callback = cb;
}

void alt_JavaResource_Stop_Callback_Register(bool(*cb)(uintptr_t))
{
	JavaResource_Stop_Callback = cb;
}

void alt_JavaResource_OnCreateBaseObject_Callback_Register(void (*cb)(uintptr_t, uintptr_t)) {
	JavaResource_CreateBaseObject_Callback = cb;
}

void alt_JavaResource_OnRemoveBaseObject_Callback_Register(void (*cb)(uintptr_t, uintptr_t)) {
	JavaResource_RemoveBaseObject_Callback = cb;
}

#pragma region Events callback register
void alt_JavaResource_OnEvent_Callback_Register(bool (*cb)(uintptr_t, uintptr_t))
{
	JavaResource_OnEvent_Callback = cb;
}
void alt_JavaResource_PlayerConnectEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_PlayerConnectEvent_Callback = cb;
}
void alt_JavaResource_PlayerDisconnectEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_PlayerDisconnectEvent_Callback = cb;
}
void alt_JavaResource_ServerScriptEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_ServerScriptEvent_Callback = cb;
}
void alt_JavaResource_ClientScriptEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_ClientScriptEvent_Callback = cb;
}
void alt_JavaResource_MetaChangeEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_MetaChangeEvent_Callback = cb;
}
void alt_JavaResource_SyncedMetaChangeEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_SyncedMetaChangeEvent_Callback = cb;
}
void alt_JavaResource_PlayerDamageEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_PlayerDamageEvent_Callback = cb;
}
void alt_JavaResource_PlayerDeathEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_PlayerDeathEvent_Callback = cb;
}
void alt_JavaResource_CheckpointEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_CheckpointEvent_Callback = cb;
}
void alt_JavaResource_ColshapeEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_ColshapeEvent_Callback = cb;
}
void alt_JavaResource_PlayerEnterVehicleEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_PlayerEnterVehicleEvent_Callback = cb;
}
void alt_JavaResource_PlayerLeaveVehicleEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_PlayerLeaveVehicleEvent_Callback = cb;
}
void alt_JavaResource_PlayerChangeVehicleSeatEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_PlayerChangeVehicleSeatEvent_Callback = cb;
}
void alt_JavaResource_RemoveEntityEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_RemoveEntityEvent_Callback = cb;
}
void alt_JavaResource_DataNodeReceivedEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_DataNodeReceivedEvent_Callback = cb;
}
void alt_JavaResource_ConsoleCommandEvent_Callback_Register(bool(*cb)(uintptr_t, uintptr_t))
{
	JavaResource_ConsoleCommandEvent_Callback = cb;
}
#pragma endregion

#pragma region Resource info
const char* alt_JavaResource_GetName(uintptr_t resourcePointer) {
	JavaResource* resource = reinterpret_cast<JavaResource*>(resourcePointer);
	return resource->GetName().CStr();
}

const char* alt_JavaResource_CreationInfo_GetName(uintptr_t creationInfoPointer)
{
	auto* creationInfo = reinterpret_cast<alt::IResource::CreationInfo*>(creationInfoPointer);
	return creationInfo->name.CStr();
}

const char* alt_JavaResource_GetPath(uintptr_t resourcePointer)
{
	JavaResource* resource = reinterpret_cast<JavaResource*>(resourcePointer);
	return resource->GetPath().CStr();
}

const char* alt_JavaResource_CreationInfo_GetPath(uintptr_t creationInfoPointer)
{
	auto* creationInfo = reinterpret_cast<alt::IResource::CreationInfo*>(creationInfoPointer);
	return creationInfo->path.CStr();
}

const char* alt_JavaResource_GetMain(uintptr_t resourcePointer)
{
	JavaResource* resource = reinterpret_cast<JavaResource*>(resourcePointer);
	const char* returningChar = resource->GetMain().CStr();
	return resource->GetMain().CStr();
}

const char* alt_JavaResource_CreationInfo_GetMain(uintptr_t creationInfoPointer)
{
	auto* creationInfo = reinterpret_cast<alt::IResource::CreationInfo*>(creationInfoPointer);
	//return creationInfo->main.ToString().c_str();
	return creationInfo->main.CStr();
}
#pragma endregion

int32_t alt_JavaResource_CEvent_GetType(uintptr_t ceventPointer)
{
	auto *cEvent = reinterpret_cast<alt::CEvent*>(ceventPointer);
	return static_cast<int32_t>(cEvent->GetType());
}

#pragma region Event info

	#pragma region PlayerConnectEvent
const char* alt_JavaResource_PlayerConnectEvent_GetReason(uintptr_t eventPointer) {
	auto *event = reinterpret_cast<alt::CPlayerConnectEvent*>(eventPointer);
	return event->GetReason().CStr() ? event->GetReason().CStr() : "";
}

uintptr_t alt_JavaResource_PlayerConnectEvent_GetTarget(uintptr_t eventPointer)
{
	auto* event = reinterpret_cast<alt::CPlayerConnectEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}
	#pragma endregion

	#pragma region PlayerDisconnectEvent
const char* alt_JavaResource_PlayerDisconnectEvent_GetReason(uintptr_t eventPointer)
{
	auto* event = reinterpret_cast<alt::CPlayerDisconnectEvent*>(eventPointer);
	return event->GetReason().CStr();
}
uintptr_t alt_JavaResource_PlayerDisconnectEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDisconnectEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}
	#pragma endregion

	#pragma region ServerScriptEvent
const char* alt_JavaResource_ServerScriptEvent_GetName(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CServerScriptEvent*>(eventPointer);
	return event->GetName().CStr();
}
	#pragma endregion

	#pragma region ClientScriptEvent
const char* alt_JavaResource_ClientScriptEvent_GetName(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CClientScriptEvent*>(eventPointer);
	return event->GetName().CStr();
}
uintptr_t alt_JavaResource_ClientScriptEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CClientScriptEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}
	#pragma endregion

	#pragma region MetaChangeEvent
	#pragma endregion

	#pragma region SyncedMetaChangeEvent
	#pragma endregion

	#pragma region PlayerDamageEvent
uintptr_t alt_JavaResource_PlayerDamageEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDamageEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}

uintptr_t alt_JavaResource_PlayerDamageEvent_GetAttacker(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDamageEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetAttacker());
}

uint16_t alt_JavaResource_PlayerDamageEvent_GetDamage(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDamageEvent*>(eventPointer);
	return event->GetDamage();
}

uint32_t alt_JavaResource_PlayerDamageEvent_GetWeapon(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDamageEvent*>(eventPointer);
	return event->GetWeapon();
}
	#pragma endregion

	#pragma region PlayerDeathEvent
uintptr_t alt_JavaResource_PlayerDeathEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDeathEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}

uintptr_t alt_JavaResource_PlayerDeathEvent_GetKiller(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDeathEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetKiller());
}

uint32_t alt_JavaResource_PlayerDeathEvent_GetWeapon(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerDeathEvent*>(eventPointer);
	return event->GetWeapon();
}
	#pragma endregion

	#pragma region CheckpointEvent
uintptr_t alt_JavaResource_CheckpointEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CCheckpointEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}

uintptr_t alt_JavaResource_CheckpointEvent_GetEntity(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CCheckpointEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetEntity());
}

bool alt_JavaResource_CheckpointEvent_GetState(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CCheckpointEvent*>(eventPointer);
	return event->GetState();
}
	#pragma endregion

	#pragma region ColshapeEvent
uintptr_t alt_JavaResource_ColshapeEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CColShapeEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}

uintptr_t alt_JavaResource_ColshapeEvent_GetEntity(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CColShapeEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetEntity());
}

bool alt_JavaResource_ColshapeEvent_GetState(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CColShapeEvent*>(eventPointer);
	return event->GetState();
}
	#pragma endregion

	#pragma region PlayerEnterVehicleEvent
uintptr_t alt_JavaResource_PlayerEnterVehicleEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerEnterVehicleEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}

uintptr_t alt_JavaResource_PlayerEnterVehicleEvent_GetPlayer(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerEnterVehicleEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetPlayer());
}

uint8_t alt_JavaResource_PlayerEnterVehicleEvent_GetSeat(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerEnterVehicleEvent*>(eventPointer);
	return event->GetSeat();
}
	#pragma endregion

	#pragma region PlayerLeaveVehicleEvent
uintptr_t alt_JavaResource_PlayerLeaveVehicleEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerLeaveVehicleEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}

uintptr_t alt_JavaResource_PlayerLeaveVehicleEvent_GetPlayer(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerLeaveVehicleEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetPlayer());
}

uint8_t alt_JavaResource_PlayerLeaveVehicleEvent_GetSeat(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerLeaveVehicleEvent*>(eventPointer);
	return event->GetSeat();
}
	#pragma endregion

	#pragma region PlayerChangeVehicleSeatEvent
uintptr_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetTarget(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerChangeVehicleSeatEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetTarget());
}

uintptr_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetPlayer(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerChangeVehicleSeatEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetPlayer());
}

uint8_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetOldSeat(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerChangeVehicleSeatEvent*>(eventPointer);
	return event->GetOldSeat();
}

uint8_t alt_JavaResource_PlayerChangeVehicleSeatEvent_GetNewSeat(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CPlayerChangeVehicleSeatEvent*>(eventPointer);
	return event->GetNewSeat();
}
	#pragma endregion

	#pragma region RemoveEntityEvent
uintptr_t alt_JavaResource_RemoveEntityEvent_GetEntity(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CRemoveEntityEvent*>(eventPointer);
	return reinterpret_cast<uintptr_t>(event->GetEntity());
}
	#pragma endregion

	#pragma region DataNodeReceivedEvent
const char* alt_JavaResource_DataNodeReceivedEvent_GetName(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CDataNodeReceivedEvent*>(eventPointer);
	return event->GetName().CStr();
}

const char* alt_JavaResource_DataNodeReceivedEvent_GetJson(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CDataNodeReceivedEvent*>(eventPointer);
	return event->GetJson().CStr();
}
	#pragma endregion

	#pragma region ConsoleCommandEvent
const char* alt_JavaResource_ConsoleCommandEvent_GetName(uintptr_t eventPointer) {
	auto* event = reinterpret_cast<alt::CConsoleCommandEvent*>(eventPointer);
	return event->GetName().CStr();
}
	#pragma endregion

#pragma endregion


// TODO
#pragma region MValue
uint8_t alt_MValue_GetType(uintptr_t mvaluePointer)
{
	auto* mvalue = reinterpret_cast<alt::MValue*>(mvaluePointer);
	if (mvalue->GetType() == alt::MValue::Type::BOOL) return 1;
	if (mvalue->GetType() == alt::MValue::Type::INT) return 2;
	if (mvalue->GetType() == alt::MValue::Type::UINT) return 3;
}
bool alt_MValue_GetBoolean(uintptr_t mvaluePointer) {
	auto* mvalue = reinterpret_cast<alt::MValue*>(mvaluePointer);
	return mvalue->Get<bool>();
}
#pragma endregion