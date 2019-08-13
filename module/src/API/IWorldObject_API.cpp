#include "IWorldObject_API.h"

int16_t alt_IWorldObject_GetDimension(uintptr_t worldObjectPointer) {
	auto* worldObject = reinterpret_cast<alt::IWorldObject*>(worldObjectPointer);
	return worldObject->GetDimension();
}

void alt_IWorldObject_SetDimension(uintptr_t worldObjectPointer, int16_t dimension) {
	auto* worldObject = reinterpret_cast<alt::IWorldObject*>(worldObjectPointer);
	worldObject->SetDimension(dimension);
}