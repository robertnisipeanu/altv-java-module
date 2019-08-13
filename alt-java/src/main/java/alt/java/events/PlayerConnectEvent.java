package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Player;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class PlayerConnectEvent extends AltEvent {

    public PlayerConnectEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public String getReason(){
        return API.libc.alt_JavaResource_PlayerConnectEvent_GetReason(eventPointer);
    }

    public Player getTarget() {
        throw new NotImplementedException("TODO");
    }

}
