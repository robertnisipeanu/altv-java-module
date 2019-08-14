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

	EXPORT void alt_IPlayer_SetDateTime(uintptr_t playerPointer, int day, int month, int year, int hour, int minute, int second);
	EXPORT void alt_IPlayer_SetWeather(uintptr_t playerPointer, uint32_t weather);

	EXPORT void alt_IPlayer_GiveWeapon(uintptr_t playerPointer, uint32_t weapon, int32_t ammo, bool selectWeapon);
	EXPORT void alt_IPlayer_RemoveWeapon(uintptr_t playerPointer, uint32_t weapon);
	EXPORT void alt_IPlayer_RemoveAllWeapons(uintptr_t playerPointer);

	EXPORT void alt_IPlayer_AddWeaponComponent(uintptr_t playerPointer, uint32_t weapon, uint32_t component);
	EXPORT void alt_IPlayer_RemoveWeaponComponent(uintptr_t playerPointer, uint32_t weapon, uint32_t component);
	/* TODO: alt::Array<uint32_t> GetCurrentWeaponComponents()*/

	EXPORT void alt_IPlayer_SetWeaponTintIndex(uintptr_t playerPointer, uint32_t weapon, uint8_t tintIndex);
	EXPORT uint8_t alt_IPlayer_GetCurrentWeaponTintIndex(uintptr_t playerPointer);

	EXPORT uint32_t alt_IPlayer_GetCurrentWeapon(uintptr_t playerPointer);
	EXPORT void alt_IPlayer_SetCurrentWeapon(uintptr_t playerPointer, uint32_t weapon);

	EXPORT bool alt_IPlayer_IsDead(uintptr_t playerPointer);

	EXPORT bool alt_IPlayer_IsJumping(uintptr_t playerPointer);
	EXPORT bool alt_IPlayer_IsInRagdoll(uintptr_t playerPointer);
	EXPORT bool alt_IPlayer_IsAiming(uintptr_t playerPointer);
	EXPORT bool alt_IPlayer_IsShooting(uintptr_t playerPointer);
	EXPORT bool alt_IPlayer_IsReloading(uintptr_t playerPointer);

	EXPORT uint16_t alt_IPlayer_GetArmour(uintptr_t playerPointer);
	EXPORT void alt_IPlayer_SetArmour(uintptr_t playerPointer, uint16_t armor);
	EXPORT uint16_t alt_IPlayer_GetMaxArmour(uintptr_t playerPointer);
	EXPORT void alt_IPlayer_SetMaxArmour(uintptr_t playerPointer, uint16_t armor);

	EXPORT float alt_IPlayer_GetMoveSpeed(uintptr_t playerPointer);

	EXPORT uint32_t alt_IPlayer_GetWeapon(uintptr_t playerPointer);
	EXPORT uint16_t alt_IPlayer_GetAmmo(uintptr_t playerPointer);

	/*
	TODO: GetAimPos() and GetHeadRotation()
	*/

	EXPORT bool alt_IPlayer_IsInVehicle(uintptr_t playerPointer);
	EXPORT uintptr_t alt_IPlayer_GetVehicle(uintptr_t playerPointer);
	EXPORT uint8_t alt_IPlayer_GetSeat(uintptr_t playerPointer);

	EXPORT uintptr_t alt_IPlayer_GetEntityAimingAt(uintptr_t playerPointer);
	/* TODO: Position GetEntityAimOffset() */

	EXPORT bool alt_IPlayer_IsFlashlightActive(uintptr_t playerPointer);

	EXPORT void alt_IPlayer_Kick(uintptr_t playerPointer, const char* reason);

	EXPORT void alt_IPlayer_SetModel(uintptr_t playerPointer, uint32_t model);

#ifdef __cplusplus
}
#endif