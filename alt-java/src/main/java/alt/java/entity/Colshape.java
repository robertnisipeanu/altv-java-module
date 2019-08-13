package alt.java.entity;

import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class Colshape extends WorldObject {

    public Colshape(Pointer objectPointer) {
        super(objectPointer);
    }

    public short getColshapeType(){
        throw new NotImplementedException("TODO");
    }

    public boolean isEntityIn(Entity entity){
        throw new NotImplementedException("TODO");
    }

}
