#include <cstdint>
#include <altv-cpp-api/SDK.h>


#ifndef EXPORT
#define EXPORT _declspec(dllexport)
#endif // !EXPORT

// Need to use extern "C" else the name of the functions gets mangled and JAVA won't be able to find them anymore
#ifdef __cplusplus
extern "C" {
#endif

	EXPORT uint8_t alt_IBaseObject_GetType(uintptr_t baseObjectPointer);

	/*
	TODO: Get/SetMetaData;
	*/

#ifdef __cplusplus
}
#endif