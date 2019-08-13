package alt.java.resource;

import alt.java.Alt;
import alt.java.util.exceptions.ResourceLoadFailException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public final class ResourceClassLoader extends URLClassLoader {

    private JavaResourceLoader loader;
    private File file;
    public AltResource resource;

    ResourceClassLoader(final JavaResourceLoader loader, final ClassLoader parent, final File file) throws MalformedURLException, ResourceLoadFailException {
        super(new URL[] {file.toURI().toURL()}, parent);
        if(loader == null) {
            Alt.logError("There has been an error while loading class loader (JavaResourceLoader can't be null)");
            return;
        }
        this.loader = loader;
        this.file = file;

        try{
            ArrayList<Class<? extends AltResource>> findResources = getResourceClasses(file);
            if(findResources.size() > 1){
                Alt.logError("JAR can only have one class extending AltResource");
                return;
            }
            if(findResources.size() == 0){
                Alt.logError("JAR doesn't have any class extending AltResource");
                return;
            }

            // At this point, we are sure there is only one class extending AltResource
            Class<? extends AltResource> resourceClass = findResources.get(0);

            // Initialize resource
            resource = resourceClass.getDeclaredConstructor().newInstance();
        } catch(IOException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
            throw new ResourceLoadFailException(e.toString());
        }


    }


    /**
     * Searches for all classes extending AltResource
     * @param file .jar file to search inside
     * @return an ArrayList with all classes that extends AltResource
     * @throws IOException if fail to read jar file
     */
    private ArrayList<Class<? extends AltResource>> getResourceClasses(File file) throws IOException{
        ArrayList<Class<? extends AltResource>> classes = new ArrayList<>();

        JarInputStream jarFile = new JarInputStream(new FileInputStream(file));
        JarEntry jarEntry;
        while(true){
            jarEntry = jarFile.getNextJarEntry();
            if(jarEntry == null)
                break;

            if(jarEntry.getName().endsWith(".class")){
                String currentEntry = jarEntry.getName().replaceAll("/", ".").replace(".class", "");
                Class<?> foundClass;
                try {
                    foundClass = Class.forName(currentEntry, true, this);
                } catch (ClassNotFoundException e) {
                    continue;
                }
                if(AltResource.class.isAssignableFrom(foundClass)){
                    Class<? extends AltResource> resourceClass = foundClass.asSubclass(AltResource.class);
                    classes.add(resourceClass);
                }

            }
        }

        return classes;
    }

}
