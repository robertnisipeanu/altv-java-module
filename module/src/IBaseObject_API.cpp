#include "IBaseObject_API.h"

uint8_t alt_IBaseObject_GetType(uintptr_t baseObjectPointer) {
	auto* baseObject = reinterpret_cast<alt::IBaseObject*>(baseObjectPointer);
	switch (baseObject->GetType()) {
	case alt::IBaseObject::Type::PLAYER:
		return 0;
		break;
	case alt::IBaseObject::Type::VEHICLE:
		return 1;
		break;
	case alt::IBaseObject::Type::CHECKPOINT:
		return 2;
		break;
	case alt::IBaseObject::Type::BLIP:
		return 3;
		break;
	case alt::IBaseObject::Type::WEBVIEW:
		return 4;
		break;
	case alt::IBaseObject::Type::VOICE_CHANNEL:
		return 5;
		break;
	case alt::IBaseObject::Type::COLSHAPE:
		return 6;
		break;
	default:
		return 255;
		break;
	}
}