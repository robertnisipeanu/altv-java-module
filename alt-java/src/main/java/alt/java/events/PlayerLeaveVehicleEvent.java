package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Player;
import alt.java.entity.Vehicle;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class PlayerLeaveVehicleEvent extends AltEvent {
    public PlayerLeaveVehicleEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Vehicle getTarget(){
        throw new NotImplementedException("TODO");
    }

    public Player getPlayer(){
        throw new NotImplementedException("TODO");
    }

    public short getSeat(){
        return API.libc.alt_JavaResource_PlayerLeaveVehicleEvent_GetSeat(eventPointer);
    }
}
