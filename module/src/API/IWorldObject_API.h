#include <cstdint>
#include <altv-cpp-api/SDK.h>


#ifndef EXPORT
#define EXPORT _declspec(dllexport)
#endif // !EXPORT

#ifdef __cplusplus
extern "C" {
#endif

	EXPORT int16_t alt_IWorldObject_GetDimension(uintptr_t worldObjectPointer);
	EXPORT void alt_IWorldObject_SetDimension(uintptr_t worldObjectPointer, int16_t dimension);

	/*
	TODO: Get/SetPosition;
	*/

#ifdef __cplusplus
}
#endif