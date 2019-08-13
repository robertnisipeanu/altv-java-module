package alt.java.events;

import alt.java.AltJavaNative.API;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;

public class ConsoleCommandEvent extends AltEvent {
    public ConsoleCommandEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public String getName(){
        return API.libc.alt_JavaResource_ConsoleCommandEvent_GetName(eventPointer);
    }

    public ArrayList<String> getArgs(){
        throw new NotImplementedException("TODO");
    }
}
