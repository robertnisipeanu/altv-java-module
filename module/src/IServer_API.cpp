#include "IServer_API.h"

void alt_IServer_LogInfo(uintptr_t serverPointer, const char* message)
{
	auto* server = reinterpret_cast<alt::IServer*>(serverPointer);
	server->LogInfo(message);
}

void alt_IServer_LogError(uintptr_t serverPointer, const char* message)
{
	auto* server = reinterpret_cast<alt::IServer*>(serverPointer);
	server->LogError(message);
}

void alt_IServer_LogWarning(uintptr_t serverPointer, const char* message)
{
	auto* server = reinterpret_cast<alt::IServer*>(serverPointer);
	server->LogWarning(message);
}

void alt_IServer_LogDebug(uintptr_t serverPointer, const char* message)
{
	auto* server = reinterpret_cast<alt::IServer*>(serverPointer);
	server->LogDebug(message);
}

void alt_IServer_LogColored(uintptr_t serverPointer, const char* message)
{
	auto* server = reinterpret_cast<alt::IServer*>(serverPointer);
	server->LogColored(message);
}

uint32_t alt_IServer_Hash(uintptr_t serverPointer, const char* stringToHash)
{
	auto* server = reinterpret_cast<alt::IServer*>(serverPointer);
	return server->Hash(stringToHash);
}

const char* alt_IServer_GetRootDirectory(uintptr_t serverPointer)
{
	auto* server = reinterpret_cast<alt::IServer*>(serverPointer);
	return server->GetRootDirectory().CStr();
}

