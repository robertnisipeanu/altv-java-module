package alt.java.resource;

import alt.java.AltJavaNative.API;
import alt.java.util.exceptions.ResourceLoadFailException;
import jnr.ffi.Pointer;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class JavaResourceLoader {

    private final Map<String, Class<?>> classes = new HashMap<>();
    private final Map<String, ResourceClassLoader> loaders = new LinkedHashMap<>();
    //private final Map<ResourceClassLoader, AltResource> resources = new HashMap<>();

    public JavaResourceLoader(){

    }

    public AltResource loadResource(Pointer creationInfoPointer, final File file) throws FileNotFoundException, ResourceLoadFailException {
        if(!file.exists()){
            throw new FileNotFoundException(file.getPath() + " does not exist");
        }

        final File parentFile = file.getParentFile();
        ResourceClassLoader loader;
        try{
            loader = new ResourceClassLoader(this, getClass().getClassLoader(), file);
        } catch(MalformedURLException e){
            throw new FileNotFoundException(e.toString());
        }

        String resourceName = API.libc.alt_JavaResource_CreationInfo_GetName(creationInfoPointer);

        loaders.put(resourceName, loader);

        return loader.resource;
    }

}
