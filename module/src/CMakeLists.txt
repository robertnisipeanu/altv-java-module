# CMakeList.txt : CMake project for java_module, include source and define
# project specific logic here.
#
cmake_minimum_required (VERSION 3.8)

set(PROJECT_TITLE java_module)

file(GLOB API_FILES
    "API/*.h"
    "API/*.cpp"
)

set(
    source_list
    "Main.cpp"
    "Main.h"
    "ScriptRuntimeHandler.cpp"
    "ScriptRuntimeHandler.h"
    "ScriptVM.cpp"
    "ScriptVM.h"
    "JavaResource.cpp"
    "JavaResource.h"
    "API/IBaseObject_API.cpp"
    "API/IBaseObject_API.h"
    "API/IPlayer_API.cpp"
    "API/IPlayer_API.h"
    "API/IServer_API.cpp"
    "API/IServer_API.h"
    "API/JavaResource_API.cpp"
    "API/JavaResource_API.h"
    "API/ScriptRuntimeHandler_API.cpp"
    "API/ScriptRuntimeHandler_API.h"
    "API/IWorldObject_API.cpp"
    "API/IWorldObject_API.h"
    "API/IEntity_API.cpp"
    "API/IEntity_API.h"
)

add_library(${PROJECT_TITLE} ${source_list})

foreach(source IN LISTS source_list)
    get_filename_component(source_path "${source}" PATH)
    string(REPLACE "/" "\\" source_path_msvc "${source_path}")
    source_group("${source_path_msvc}" FILES "${source}")
endforeach()

# TODO: Add tests and install targets if needed.

target_compile_definitions(${PROJECT_TITLE} PRIVATE ALT_SERVER_API=true)
target_compile_definitions(${PROJECT_TITLE} PRIVATE _USE_MATH_DEFINES)

set_target_properties(${PROJECT_TITLE} PROPERTIES OUTPUT_NAME "java-module")

target_compile_features(${PROJECT_TITLE} PRIVATE cxx_std_17)

target_include_directories(${PROJECT_TITLE} PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/../thirdparty)
message (STATUS "Included /thirdparty Directory")

target_include_directories(${PROJECT_TITLE} PRIVATE ${CMAKE_CURRENT_SOURCE_DIR}/../jdk-include)
target_link_libraries(${PROJECT_TITLE} ${CMAKE_CURRENT_SOURCE_DIR}/../jdk-libs/jawt.lib)
target_link_libraries(${PROJECT_TITLE} ${CMAKE_CURRENT_SOURCE_DIR}/../jdk-libs/jvm.lib)

add_custom_command(TARGET ${PROJECT_TITLE}
                   POST_BUILD
                   COMMAND copy ARGS "/Y \"$(OutputPath)java-module.dll\" \"$(LocalDebuggerWorkingDirectory)modules\\java-module.dll\""
                   COMMENT "Copy .dll file")

add_custom_command(TARGET ${PROJECT_TITLE}
                   POST_BUILD
                   COMMAND copy ARGS "/Y \"$(OutputPath)java-module.pdb\" \"$(LocalDebuggerWorkingDirectory)modules\\java-module.pdb\""
                   COMMENT "Copy .pdb file")