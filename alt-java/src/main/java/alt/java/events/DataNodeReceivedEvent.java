package alt.java.events;

import alt.java.AltJavaNative.API;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class DataNodeReceivedEvent extends AltEvent {
    public DataNodeReceivedEvent(Pointer eventPointer) {
        super(eventPointer);
    }

    public String getName(){
        return API.libc.alt_JavaResource_DataNodeReceivedEvent_GetName(eventPointer);
    }

    public String getJson(){
        return API.libc.alt_JavaResource_DataNodeReceivedEvent_GetJson(eventPointer);
    }
}
