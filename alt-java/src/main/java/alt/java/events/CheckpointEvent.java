package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Checkpoint;
import alt.java.entity.Entity;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class CheckpointEvent extends AltEvent {
    public CheckpointEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Checkpoint getTarget(){
        throw new NotImplementedException("TODO");
    }

    public Entity getEntity(){
        throw new NotImplementedException("TODO");
    }

    public boolean getState(){
        return API.libc.alt_JavaResource_CheckpointEvent_GetState(eventPointer);
    }
}
