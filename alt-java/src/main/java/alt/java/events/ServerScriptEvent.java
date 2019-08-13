package alt.java.events;

import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class ServerScriptEvent extends AltEvent {
    public ServerScriptEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public String getName(){
        throw new NotImplementedException("TODO");
    }

    /**
     * TODO: MValueList getArgs()
     */
}
