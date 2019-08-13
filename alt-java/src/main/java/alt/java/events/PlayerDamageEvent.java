package alt.java.events;

import alt.java.AltJavaNative.API;
import alt.java.entity.Entity;
import alt.java.entity.Player;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class PlayerDamageEvent extends AltEvent {
    public PlayerDamageEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public Player getTarget(){
        throw new NotImplementedException("TODO");
    }

    public Entity getAttacker(){
        throw new NotImplementedException("TODO");
    }

    public int getDamage(){
        return API.libc.alt_JavaResource_PlayerDamageEvent_GetDamage(eventPointer);
    }

    public long getWeapon(){
        return API.libc.alt_JavaResource_PlayerDamageEvent_GetWeapon(eventPointer);
    }

}
