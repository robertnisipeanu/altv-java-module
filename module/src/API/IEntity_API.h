#include <cstdint>
#include <altv-cpp-api/SDK.h>


#ifndef EXPORT
#define EXPORT _declspec(dllexport)
#endif // !EXPORT

#ifdef __cplusplus
extern "C" {
#endif

	EXPORT uint16_t alt_IEntity_GetID(uintptr_t entityPointer);
	EXPORT uint32_t alt_IEntity_GetModel(uintptr_t entityPointer);
	
	/*
	TODO: Get/SetRotation; Get/SetSyncedMetaData;
	*/

#ifdef __cplusplus
}
#endif