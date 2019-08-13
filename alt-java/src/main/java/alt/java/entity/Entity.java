package alt.java.entity;

import alt.java.util.Rotation;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class Entity extends WorldObject {

    public Entity(Pointer objectPointer) {
        super(objectPointer);
    }

    public int getId(){
        throw new NotImplementedException("TODO");
    }

    public long getModel(){
        throw new NotImplementedException("TODO");
    }

    public Rotation getRotation(){
        throw new NotImplementedException("TODO");
    }
    public void setRotation(Rotation rotation){
        throw new NotImplementedException("TODO");
    }

}
