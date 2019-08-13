package alt.java.entity;

import alt.java.util.RGBA;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class Checkpoint extends WorldObject {

    public Checkpoint(Pointer objectPointer) {
        super(objectPointer);
    }

    public boolean isGlobal(){
        throw new NotImplementedException("TODO");
    }

    public Player getTarget(){
        throw new NotImplementedException("TODO");
    }

    public short getCheckpointType(){
        throw new NotImplementedException("TODO");
    }

    public float getHeight(){
        throw new NotImplementedException("TODO");
    }

    public float getRadius(){
        throw new NotImplementedException("TODO");
    }

    public RGBA getColor(){
        throw new NotImplementedException("TODO");
    }

    public boolean isEntityIn(Entity entity){
        throw new NotImplementedException("TODO");
    }

}
