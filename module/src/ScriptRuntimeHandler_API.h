#pragma once

#include <cstdint>

#ifndef EXPORT
#define EXPORT _declspec(dllexport)
#endif // !EXPORT

#ifdef __cplusplus
extern "C" {
#endif


	// Pointer to callbacks <-> See JavaResource_API.h comments for more details
	extern void (*ScriptRuntimeHandler_CreateResource_Callback)(uintptr_t, uintptr_t); // arg2: pointer to alt::Resource::CreationInfo
	extern void (*ScriptRuntimeHandler_RemoveResource_Callback)(uintptr_t);

	// Register pointer to callbacks <-> See JavaResource_API.h comments for more details
	EXPORT void alt_ScriptRuntimeHandler_CreateResource_Callback_Register(void (*cb)(uintptr_t, uintptr_t));
	EXPORT void alt_ScriptRuntimeHandler_RemoveResource_Callback_Register(void (*cb)(uintptr_t));

#ifdef __cplusplus
}
#endif