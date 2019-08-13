#pragma once

#include <altv-cpp-api/SDK.h>
#include <jni.h>
// #include <cstdint>

class ScriptVM {
	bool StartVM();
	// static void JCallback_Alive(JNIEnv* e, jobject obj);
public:
	ScriptVM(alt::IServer* server);
	JavaVM* jvm; // Pointer to JVM
	JNIEnv* env; // Pointer to native interface (JNI)
	jclass JavaClass_AltNative;
	// jclass JavaClass_ResourceManager;
private:
	// alt::IServer* server;
	jint vmres;
	void Java_StartAlt(jclass jClass, uintptr_t serverPointer);
	// void Java_StartMe(jclass jClass);
	// void Java_PrintBooleanValue(jclass jClass, jboolean value);

};