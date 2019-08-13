package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Player;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class PlayerDisconnectEvent extends AltEvent {
    public PlayerDisconnectEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Player getTarget(){
        throw new NotImplementedException("TODO");
    }

    public String getReason(){
        return API.libc.alt_JavaResource_PlayerDisconnectEvent_GetReason(eventPointer);
    }

}
