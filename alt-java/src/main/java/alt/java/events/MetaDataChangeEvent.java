package alt.java.events;

import alt.java.entity.Entity;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class MetaDataChangeEvent extends AltEvent {
    public MetaDataChangeEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Entity getTarget(){
        throw new NotImplementedException("TODO");
    }

    public String getKey(){
        throw new NotImplementedException("TODO");
    }

    /**
     * TODO: MValue getVal()
     */
}
