#include "IPlayer_API.h"

bool alt_IPlayer_IsConnected(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsConnected();
}

uint32_t alt_IPlayer_GetPing(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetPing();
}

const char* alt_IPlayer_GetIP(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetIP().CStr();
}

void alt_IPlayer_Despawn(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->Despawn();
}

const char* alt_IPlayer_GetName(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetName().CStr();
}

uint64_t alt_IPlayer_GetSocialID(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetSocialID();
}

uint64_t alt_IPlayer_GetHwidHash(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetHwidHash();
}

uint64_t alt_IPlayer_GetHwidExHash(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetHwidExHash();
}

const char* alt_IPlayer_GetAuthToken(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetAuthToken().CStr();
}

uint16_t alt_IPlayer_GetHealth(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetHealth();
}

void alt_IPlayer_SetHealth(uintptr_t playerPointer, uint16_t health) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetHealth(health);
}

uint16_t alt_IPlayer_GetMaxHealth(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetMaxHealth();
}

void alt_IPlayer_SetMaxHealth(uintptr_t playerPointer, uint16_t health) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetMaxHealth(health);
}

void alt_IPlayer_SetDateTime(uintptr_t playerPointer, int day, int month, int year, int hour, int minute, int second) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetDateTime(day, month, year, hour, minute, second);
}

void alt_IPlayer_SetWeather(uintptr_t playerPointer, uint32_t weather) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetWeather(weather);
}

void alt_IPlayer_GiveWeapon(uintptr_t playerPointer, uint32_t weapon, int32_t ammo, bool selectWeapon) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->GiveWeapon(weapon, ammo, selectWeapon);
}

void alt_IPlayer_RemoveWeapon(uintptr_t playerPointer, uint32_t weapon) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->RemoveWeapon(weapon);
}

void alt_IPlayer_RemoveAllWeapons(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->RemoveAllWeapons();
}

void alt_IPlayer_AddWeaponComponent(uintptr_t playerPointer, uint32_t weapon, uint32_t component) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->AddWeaponComponent(weapon, component);
}

void alt_IPlayer_RemoveWeaponComponent(uintptr_t playerPointer, uint32_t weapon, uint32_t component) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->RemoveWeaponComponent(weapon, component);
}

void alt_IPlayer_SetWeaponTintIndex(uintptr_t playerPointer, uint32_t weapon, uint8_t tintIndex) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetWeaponTintIndex(weapon, tintIndex);
}

uint8_t alt_IPlayer_GetCurrentWeaponTintIndex(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetCurrentWeaponTintIndex();
}

uint32_t alt_IPlayer_GetCurrentWeapon(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetCurrentWeapon();
}

void alt_IPlayer_SetCurrentWeapon(uintptr_t playerPointer, uint32_t weapon) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetCurrentWeapon(weapon);
}

bool alt_IPlayer_IsDead(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsDead();
}

bool alt_IPlayer_IsJumping(uintptr_t playerPointer) {
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsJumping();
}

bool alt_IPlayer_IsInRagdoll(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsInRagdoll();
}

bool alt_IPlayer_IsAiming(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsAiming();
}

bool alt_IPlayer_IsShooting(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsShooting();
}

bool alt_IPlayer_IsReloading(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsReloading();
}

uint16_t alt_IPlayer_GetArmour(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetArmour();
}

void alt_IPlayer_SetArmour(uintptr_t playerPointer, uint16_t armor)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetArmour(armor);
}

uint16_t alt_IPlayer_GetMaxArmour(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetMaxArmour();
}

void alt_IPlayer_SetMaxArmour(uintptr_t playerPointer, uint16_t armor)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetMaxArmour(armor);
}

float alt_IPlayer_GetMoveSpeed(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetMoveSpeed();
}

uint32_t alt_IPlayer_GetWeapon(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetWeapon();
}

uint16_t alt_IPlayer_GetAmmo(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetAmmo();
}

bool alt_IPlayer_IsInVehicle(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsInVehicle();
}

uintptr_t alt_IPlayer_GetVehicle(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return reinterpret_cast<uintptr_t>(player->GetVehicle());
}

uint8_t alt_IPlayer_GetSeat(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->GetSeat();
}

uintptr_t alt_IPlayer_GetEntityAimingAt(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return reinterpret_cast<uintptr_t>(player->GetEntityAimingAt());
}

bool alt_IPlayer_IsFlashlightActive(uintptr_t playerPointer)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	return player->IsFlashlightActive();
}

void alt_IPlayer_Kick(uintptr_t playerPointer, const char * reason)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->Kick(reason);
}

void alt_IPlayer_SetModel(uintptr_t playerPointer, uint32_t model)
{
	auto* player = reinterpret_cast<alt::IPlayer*>(playerPointer);
	player->SetModel(model);
}
