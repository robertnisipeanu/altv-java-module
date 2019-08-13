#pragma once

#include <altv-cpp-api/SDK.h>
#include <altv-cpp-api/IScriptRuntime.h>
#include "ScriptVM.h"
#include "JavaResource.h"
#include "API/ScriptRuntimeHandler_API.h"

class ScriptRuntimeHandler : public alt::IScriptRuntime
{
	alt::IResource *CreateResource(alt::IResource::CreationInfo *info) override;
	void RemoveResource(alt::IResource *resource) override;

	void OnTick() override;

	public:
		ScriptRuntimeHandler(alt::IServer* server);
		ScriptVM* scriptVM;
		
	private:
		alt::IServer *server;
};