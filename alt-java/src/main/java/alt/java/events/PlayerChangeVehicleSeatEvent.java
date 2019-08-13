package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Player;
import alt.java.entity.Vehicle;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class PlayerChangeVehicleSeatEvent extends AltEvent {
    public PlayerChangeVehicleSeatEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Vehicle getTarget(){
        throw new NotImplementedException("TODO");
    }

    public Player getPlayer(){
        throw new NotImplementedException("TODO");
    }

    public short getOldSeat(){
        return API.libc.alt_JavaResource_PlayerChangeVehicleSeatEvent_GetOldSeat(eventPointer);
    }

    public short getNewSeat(){
        return API.libc.alt_JavaResource_PlayerChangeVehicleSeatEvent_GetNewSeat(eventPointer);
    }
}
