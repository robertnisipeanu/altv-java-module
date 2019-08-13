#include <cstdint>
#include <altv-cpp-api/SDK.h>


#ifndef EXPORT
#define EXPORT _declspec(dllexport)
#endif // !EXPORT

#ifdef __cplusplus
extern "C" {
#endif

	EXPORT bool alt_IPlayer_IsConnected(uintptr_t playerPointer);

	EXPORT uint32_t alt_IPlayer_GetPing(uintptr_t playerPointer);
	EXPORT const char* alt_IPlayer_GetIP(uintptr_t playerPointer);

	/*
	TODO: Spawn(Position pos, uint32_t delayMs)
	*/

	EXPORT void alt_IPlayer_Despawn(uintptr_t playerPointer);

	EXPORT uint64_t alt_IPlayer_GetSocialID(uintptr_t playerPointer);
	EXPORT uint64_t alt_IPlayer_GetHwidHash(uintptr_t playerPointer);
	EXPORT uint64_t alt_IPlayer_GetHwidExHash(uintptr_t playerPointer);
	EXPORT const char* alt_IPlayer_GetAuthToken(uintptr_t playerPointer);

	EXPORT uint16_t alt_IPlayer_GetHealth(uintptr_t playerPointer);
	EXPORT void alt_IPlayer_SetHealth(uintptr_t playerPointer, uint16_t health);
	EXPORT uint16_t alt_IPlayer_GetMaxHealth(uintptr_t playerPointer);
	EXPORT void alt_IPlayer_SetMaxHealth(uintptr_t playerPointer, uint16_t health);

	/*
	TODO: Continue from https://github.com/altmp/cpp-sdk/blob/beta/entities/IPlayer.h#L32
	*/

#ifdef __cplusplus
}
#endif