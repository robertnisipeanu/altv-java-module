#include "ScriptRuntimeHandler_API.h"

void (*ScriptRuntimeHandler_CreateResource_Callback)(uintptr_t, uintptr_t);
void (*ScriptRuntimeHandler_RemoveResource_Callback)(uintptr_t);

void alt_ScriptRuntimeHandler_CreateResource_Callback_Register(void(*cb)(uintptr_t, uintptr_t))
{
	ScriptRuntimeHandler_CreateResource_Callback = cb;
}

void alt_ScriptRuntimeHandler_RemoveResource_Callback_Register(void(*cb)(uintptr_t))
{
	ScriptRuntimeHandler_RemoveResource_Callback = cb;
}
