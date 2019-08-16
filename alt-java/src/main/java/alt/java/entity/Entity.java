package alt.java.entity;

import alt.java.AltJavaNative.API;
import alt.java.util.Rotation;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class Entity extends WorldObject {

    public Entity(Pointer objectPointer) {
        super(objectPointer);
    }

    public int getID(){
        return API.libc.alt_IEntity_GetID(baseObjectPointer);
    }

    public long getModel(){
        return API.libc.alt_IEntity_GetModel(baseObjectPointer);
    }

    public Rotation getRotation(){
        throw new NotImplementedException("TODO");
    }
    public void setRotation(Rotation rotation){
        throw new NotImplementedException("TODO");
    }

}
