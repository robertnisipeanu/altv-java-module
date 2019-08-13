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