package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Entity;
import alt.java.entity.Player;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class PlayerDeathEvent extends AltEvent {
    public PlayerDeathEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Player getTarget(){
        throw new NotImplementedException("TODO");
    }

    public Entity getKiller(){
        throw new NotImplementedException("TODO");
    }

    public long getWeapon(){
        return API.libc.alt_JavaResource_PlayerDeathEvent_GetWeapon(eventPointer);
    }
}
