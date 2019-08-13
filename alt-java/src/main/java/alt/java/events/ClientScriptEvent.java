package alt.java.events;

import alt.java.entity.Player;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class ClientScriptEvent extends AltEvent {
    public ClientScriptEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Player getTarget(){
        throw new NotImplementedException("TODO");
    }

    public String getName(){
        throw new NotImplementedException("TODO");
    }

    /**
     * TODO: MValueList getArgs()
     */

}
