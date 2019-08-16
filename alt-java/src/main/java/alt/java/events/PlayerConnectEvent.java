package alt.java.events;

import alt.java.Alt;
import alt.java.AltJavaNative.API;
import alt.java.AltJavaNative.AltNative;
import alt.java.entity.InternalEntityManager;
import alt.java.entity.Player;
import alt.java.resource.AltResource;
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
        return InternalEntityManager.getPlayerFromPointerForResource(
                AltNative.getResourceFromCallerClass(StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass()),
                API.libc.alt_JavaResource_PlayerConnectEvent_GetTarget(eventPointer)
        );
    }

}
