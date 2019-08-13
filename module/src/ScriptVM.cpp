#include "ScriptVM.h"
#include <Windows.h>

static alt::IServer* server;

ScriptVM::ScriptVM(alt::IServer* _server) {
	//this->server = server;
	server = _server;
	this->StartVM();
}



bool ScriptVM::StartVM() {

	typedef jint(JNICALL *pCreateJavaVM)(JavaVM **, void**, void *);

	// RUNNING WITH JDK11+ FOR SOME REASON REQUIRES USER INPUT FOR JAVA VM TO START
	HINSTANCE hInstance = LoadLibrary("C:\\Program Files\\Java\\jdk-12.0.2\\bin\\server\\jvm.dll");
	pCreateJavaVM CreateJavaVM = (pCreateJavaVM)GetProcAddress(hInstance, "JNI_CreateJavaVM");

	server->LogInfo("ScriptVM::StartVM is running...");

	JavaVMInitArgs vm_args; // Initialization arguments

	// Options
	JavaVMOption options[2]; // Invocation arguments
	options[0].optionString = "-Djava.class.path=altv-jvm-module;altv-jvm-module/alt-java.jar"; // 
	//options[1].optionString = "-Djava.library.path=altv-jvm-module";
	options[1].optionString = "-Djava.library.path=modules";

	vm_args.options = options;
	vm_args.nOptions = 2; // Number of options

	vm_args.version = JNI_VERSION_9; // Minimum java version
	vm_args.ignoreUnrecognized = JNI_FALSE; // Invalid options results in a fail init

	server->LogInfo("Test0");
	
	// jvm.dll location (/jre/bin/server) needs to be added into PATH or else JNI_CreateJavaVM will result in a module crash (Win32 error 126)
	// vmres = JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);
	vmres = CreateJavaVM(&jvm, (void**)&env, &vm_args);
	server->LogInfo("Test1");
	// delete options; // We don't need the options anymore / For some reason it throws an error if trying to delete options, will have to look into that
	if (vmres < 0) {
		server->LogError("[JVM] Failed to create jvm");
		return false;
	}

	//this->server->LogInfo("[JVM] Successfully created jvm");

	JavaClass_AltNative = env->FindClass("alt/java/AltJavaNative/AltNative");
	// JavaClass_ResourceManager = env->FindClass("alt/java/AltJavaNative/ResourceManager");
	uintptr_t serverPointer = reinterpret_cast<uintptr_t>(server);
	if (JavaClass_AltNative == nullptr) {
		server->LogError("[JVM] Failed to find classes");
		return false;
	}

	Java_StartAlt(JavaClass_AltNative, serverPointer);



	/*server->LogInfo("ScriptVM::Initializing Natives");
	//JNINativeMethod methods[]{ {"answerAlive", "()V", (void *)&JCallback_Alive } };

	JNINativeMethod methods[]{ {"answerAlive", "()V", (void *)&ScriptVM::JCallback_Alive} };

	if (env->RegisterNatives(cls, methods, 1) < 0) {
		if (env->ExceptionOccurred())
			server->LogError("test-module: Exception when registering natives");
		else
			server->LogError("test-module: There was a problem while registering natives");
	}

	server->LogInfo("ScriptVM:Natives init finished");

	Java_StartMe(cls);
	Java_PrintBooleanValue(cls, true);*/

	jboolean flag = env->ExceptionCheck();
	if (flag) {
		server->LogError("Exception occurred while executing Java method");
		env->ExceptionDescribe();
		env->ExceptionClear();
	}

	return true;
}


void ScriptVM::Java_StartAlt(jclass jClass, uintptr_t serverPointer) {
	jmethodID mid = env->GetStaticMethodID(jClass, "initJavaModule", "(J)V");
	if (mid == nullptr)
	{
		server->LogError("[JVM] Failed to find static method initJavaModule");
		return;
	}
	env->CallStaticVoidMethod(jClass, mid, serverPointer);
}

/*void ScriptVM::JCallback_Alive(JNIEnv* e, jobject o) {
	server->LogInfo("test-module: ScriptVM::JCallback_Alive was called!");
}

void ScriptVM::Java_StartMe(jclass jClass) {
	jmethodID mid = env->GetStaticMethodID(jClass, "StartMe", "()V");
	if (mid == nullptr) {
		server->LogError("[JVM] Failed to find static method StartMe");
		return;
	}

	env->CallStaticVoidMethod(jClass, mid);
}

void ScriptVM::Java_PrintBooleanValue(jclass jClass, jboolean value) {
	jmethodID mid = env->GetStaticMethodID(jClass, "PrintBooleanValue", "(Z)V");
	if (mid == nullptr) {
		server->LogError("[JVM] Failed to find static method PrintBooleanValue");
		return;
	}

	env->CallStaticVoidMethod(jClass, mid, value);
}*/