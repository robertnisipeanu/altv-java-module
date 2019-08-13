#pragma once

#include <altv-cpp-api/SDK.h>
#include <altv-cpp-api/IResource.h>
#include <altv-cpp-api/IServer.h>
#include <altv-cpp-api/events/CMetaDataChangeEvent.h>
#include <jni.h>
#include "ScriptVM.h"
#include "JavaResource_API.h"

class JavaResource : public alt::IResource {

	bool OnEvent(const alt::CEvent* ev) override;
	void OnTick() override;
	bool Start() override;
	bool Stop() override;
	void OnCreateBaseObject(alt::IBaseObject* object) override;
	void OnRemoveBaseObject(alt::IBaseObject* object) override;
	//void* GetBaseObjectPointer(alt::IBaseObject baseObject);
	//void* GetEntityPointer(alt::IEntity* entity);

public:
	JavaResource(alt::IServer* server, ScriptVM* scriptVM, alt::IResource::CreationInfo* info);

private:
	alt::IServer* server;
	ScriptVM* vm;
	jclass* resourceManager;
};