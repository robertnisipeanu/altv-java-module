#include "JavaResource.h"

bool JavaResource::OnEvent(const alt::CEvent* ev)
{
	bool result = true;
	switch (ev->GetType())
	{
	case alt::CEvent::Type::PLAYER_CONNECT:
		if (JavaResource_PlayerConnectEvent_Callback)
			result = JavaResource_PlayerConnectEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		((alt::CPlayerConnectEvent*) ev)->GetTarget()->Spawn(alt::Position(100, 100, 80), 100);
		((alt::CPlayerConnectEvent*) ev)->GetTarget()->SetHealth(((alt::CPlayerConnectEvent*) ev)->GetTarget()->GetMaxHealth());
		break;
	case alt::CEvent::Type::PLAYER_DISCONNECT:
		if (JavaResource_PlayerDisconnectEvent_Callback)
			result = JavaResource_PlayerDisconnectEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	case alt::CEvent::Type::SERVER_SCRIPT_EVENT:
		if (JavaResource_ServerScriptEvent_Callback)
			result = JavaResource_ServerScriptEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;
	case alt::CEvent::Type::CLIENT_SCRIPT_EVENT:
		if (JavaResource_ClientScriptEvent_Callback)
			result = JavaResource_ClientScriptEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	case alt::CEvent::Type::META_CHANGE:
		if (JavaResource_MetaChangeEvent_Callback)
			result = JavaResource_MetaChangeEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;
	case alt::CEvent::Type::SYNCED_META_CHANGE:
		if (JavaResource_SyncedMetaChangeEvent_Callback)
			result = JavaResource_SyncedMetaChangeEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	case alt::CEvent::Type::PLAYER_DAMAGE:
		if (JavaResource_PlayerDamageEvent_Callback)
			result = JavaResource_PlayerDamageEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;
	case alt::CEvent::Type::PLAYER_DEATH:
		if (JavaResource_PlayerDeathEvent_Callback)
			result = JavaResource_PlayerDeathEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	case alt::CEvent::Type::CHECKPOINT_EVENT:
		if (JavaResource_CheckpointEvent_Callback)
			result = JavaResource_CheckpointEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;
	case alt::CEvent::Type::COLSHAPE_EVENT:
		if (JavaResource_ColshapeEvent_Callback)
			result = JavaResource_ColshapeEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;
	case alt::CEvent::Type::PLAYER_ENTER_VEHICLE:
		if (JavaResource_PlayerEnterVehicleEvent_Callback)
			result = JavaResource_PlayerEnterVehicleEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;
	case alt::CEvent::Type::PLAYER_LEAVE_VEHICLE:
		if (JavaResource_PlayerLeaveVehicleEvent_Callback)
			result = JavaResource_PlayerLeaveVehicleEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;
	case alt::CEvent::Type::PLAYER_CHANGE_VEHICLE_SEAT:
		if (JavaResource_PlayerChangeVehicleSeatEvent_Callback)
			result = JavaResource_PlayerChangeVehicleSeatEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	case alt::CEvent::Type::REMOVE_ENTITY_EVENT:
		if (JavaResource_RemoveEntityEvent_Callback)
			result = JavaResource_RemoveEntityEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	case alt::CEvent::Type::DATA_NODE_RECEIVED_EVENT:
		if (JavaResource_DataNodeReceivedEvent_Callback)
			result = JavaResource_DataNodeReceivedEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	case alt::CEvent::Type::CONSOLE_COMMAND_EVENT:
		if (JavaResource_ConsoleCommandEvent_Callback)
			result = JavaResource_ConsoleCommandEvent_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(ev));
		break;

	default:
		break;
	}
	IResource::OnEvent(ev);
	return result;
}

void JavaResource::OnTick()
{
	//this->server->LogInfo("JavaResource::OnTick()");
	if(JavaResource_OnTick_Callback) JavaResource_OnTick_Callback(reinterpret_cast<uintptr_t>(this));
	IResource::OnTick();
}

bool JavaResource::Start()
{
	if (!JavaResource_Start_Callback(reinterpret_cast<uintptr_t>(this)))
		return false;
	IResource::Start();
	return true;
}

bool JavaResource::Stop()
{

	IResource::Stop();
	return true;
}

void JavaResource::OnCreateBaseObject(alt::IBaseObject* object)
{
	if (JavaResource_CreateBaseObject_Callback) JavaResource_CreateBaseObject_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(object));
}

void JavaResource::OnRemoveBaseObject(alt::IBaseObject* object)
{
	if (JavaResource_RemoveBaseObject_Callback) JavaResource_RemoveBaseObject_Callback(reinterpret_cast<uintptr_t>(this), reinterpret_cast<uintptr_t>(object));
}

JavaResource::JavaResource(alt::IServer* server, ScriptVM* scriptVM, alt::IResource::CreationInfo* info) : alt::IResource(info) {
	this->server = server;
	this->vm = scriptVM;
}
