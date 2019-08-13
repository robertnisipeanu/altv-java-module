package alt.java.entity;

import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class Blip extends WorldObject {

    public Blip(Pointer objectPointer) {
        super(objectPointer);
    }

    public final boolean isGlobal(){
        throw new NotImplementedException("TODO");
    }
    public final Player getTarget(){
        throw new NotImplementedException("TODO");
    }

    public final boolean isAttached(){
        throw new NotImplementedException("TODO");
    }
    public final Entity attachedTo(){
        throw new NotImplementedException("TODO");
    }
    public final short getBlipType(){
        throw new NotImplementedException("TODO");
    }

    public final void setSprite(int sprite){
        throw new NotImplementedException("TODO");
    }
    public final void setColor(short color){
        throw new NotImplementedException("TODO");
    }
    public final void setRoute(boolean state){
        throw new NotImplementedException("TODO");
    }
    public final void setRouteColor(short color){
        throw new NotImplementedException("TODO");
    }

}
