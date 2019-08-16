#include "IEntity_API.h"

uint16_t alt_IEntity_GetID(uintptr_t entityPointer) {
	auto* entity = dynamic_cast<alt::IEntity*>(reinterpret_cast<alt::IBaseObject*>(entityPointer));
	return entity->GetID();
}

uint32_t alt_IEntity_GetModel(uintptr_t entityPointer) {
	auto* entity = dynamic_cast<alt::IEntity*>(reinterpret_cast<alt::IBaseObject*>(entityPointer));
	return entity->GetModel();
}