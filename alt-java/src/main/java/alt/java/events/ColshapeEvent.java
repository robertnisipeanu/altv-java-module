package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Colshape;
import alt.java.entity.Entity;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class ColshapeEvent extends AltEvent {
    public ColshapeEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Colshape getTarget(){
        throw new NotImplementedException("TODO");
    }

    public Entity getEntity(){
        throw new NotImplementedException("TODO");
    }

    public boolean getState(){
        return API.libc.alt_JavaResource_ColshapeEvent_GetState(eventPointer);
    }
}
