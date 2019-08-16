package alt.java.entity;

import alt.java.AltJavaNative.API;
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

    public short getDimension(){
        return API.libc.alt_IWorldObject_GetDimension(baseObjectPointer);
    }

    public void setPosition(){
        throw new NotImplementedException("TODO");
    }

    public void setDimension(short dimension){
        API.libc.alt_IWorldObject_SetDimension(baseObjectPointer, dimension);
    }

}
