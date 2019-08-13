package alt.java.entity;

import alt.java.util.Position;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class WorldObject extends BaseObject {

    private int dimension;

    public WorldObject(Pointer objectPointer) {
        super(objectPointer);
    }

    public Position getPosition(){
        throw new NotImplementedException("TODO");
    }

    public int getDimension(){
        throw new NotImplementedException("TODO");
    }

    public void setPosition(){
        throw new NotImplementedException("TODO");
    }

    public void setDimension(){
        throw new NotImplementedException("TODO");
    }

}
