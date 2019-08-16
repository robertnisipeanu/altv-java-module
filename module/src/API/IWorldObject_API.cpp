#include "IWorldObject_API.h"

int16_t alt_IWorldObject_GetDimension(uintptr_t worldObjectPointer) {
	auto* worldObject = dynamic_cast<alt::IWorldObject*>(reinterpret_cast<alt::IBaseObject*>(worldObjectPointer));
	return worldObject->GetDimension();
}

void alt_IWorldObject_SetDimension(uintptr_t worldObjectPointer, int16_t dimension) {
	auto* worldObject = dynamic_cast<alt::IWorldObject*>(reinterpret_cast<alt::IBaseObject*>(worldObjectPointer));
	worldObject->SetDimension(dimension);
}