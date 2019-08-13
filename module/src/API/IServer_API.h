#pragma once

#include <cstdint>
#include <altv-cpp-api/SDK.h>
#include <altv-cpp-api/IServer.h>


#ifndef EXPORT
#define EXPORT _declspec(dllexport)
#endif // !EXPORT

#ifdef __cplusplus
extern "C" {
#endif

	EXPORT void alt_IServer_LogInfo(uintptr_t serverPointer, const char* message);
	EXPORT void alt_IServer_LogError(uintptr_t serverPointer, const char* message);
	EXPORT void alt_IServer_LogWarning(uintptr_t serverPointer, const char* message);
	EXPORT void alt_IServer_LogDebug(uintptr_t serverPointer, const char* message);
	EXPORT void alt_IServer_LogColored(uintptr_t serverPointer, const char* message);
	EXPORT uint32_t alt_IServer_Hash(uintptr_t serverPointer, const char* stringToHash);
	EXPORT const char* alt_IServer_GetRootDirectory(uintptr_t serverPointer);

#ifdef __cplusplus
}
#endif