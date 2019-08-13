#include "ScriptRuntimeHandler.h"

ScriptRuntimeHandler::ScriptRuntimeHandler(alt::IServer* server) {
	this->server = server;
	this->scriptVM = new ScriptVM(server);
}

alt::IResource *ScriptRuntimeHandler::CreateResource(alt::IResource::CreationInfo *info) {
	this->server->LogInfo("test-module: Request resource load!");
	this->server->LogInfo("[ResInfo] Resource name: "+info->name);
	this->server->LogInfo("[ResInfo] Resource Main: "+info->main);
	this->server->LogInfo("[ResInfo] Resource path: " + info->path);
	this->server->LogInfo("[ResInfo] Resource type: " + info->type);

	auto* javaResource = new JavaResource(this->server, this->scriptVM, info);
	//return nullptr;
	if(ScriptRuntimeHandler_CreateResource_Callback) ScriptRuntimeHandler_CreateResource_Callback(reinterpret_cast<uintptr_t>(javaResource), reinterpret_cast<uintptr_t>(info));

	return javaResource;
}

void ScriptRuntimeHandler::RemoveResource(alt::IResource *resource) {
	// Shutdown resource

	//
	delete resource;
}

void ScriptRuntimeHandler::OnTick()
{
}