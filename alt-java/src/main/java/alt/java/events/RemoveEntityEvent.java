package alt.java.events;

import alt.java.entity.Entity;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class RemoveEntityEvent extends AltEvent {
    public RemoveEntityEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Entity getEntity(){
        throw new NotImplementedException("TODO");
    }
}
