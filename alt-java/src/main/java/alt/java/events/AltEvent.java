package alt.java.events;

import alt.java.AltJavaNative.API;
import jnr.ffi.Pointer;

public class AltEvent {

    Pointer eventPointer;

    public AltEvent(Pointer eventPointer){
        this.eventPointer = eventPointer;
    }

    public int getType(){
        return API.libc.alt_JavaResource_CEvent_GetType(eventPointer);
    }

}
