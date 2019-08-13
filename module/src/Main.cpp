// CMakeProject1.cpp : Defines the entry point for the application.
//

#include "Main.h"
#include <altv-cpp-api\SDK.h>
#include "ScriptRuntimeHandler.h"

EXPORT bool altMain(alt::IServer* server) {
	server->LogInfo("test-module: Thanks for loading me!");
	auto* scriptRuntimeHandler = new ScriptRuntimeHandler(server);
	server->RegisterScriptRuntime("java", scriptRuntimeHandler);
	return true;
}

EXPORT uint32_t GetSDKVersion() {
	return ALTV_SDK_VERSION;
}
