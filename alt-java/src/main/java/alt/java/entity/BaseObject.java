package alt.java.entity;

import alt.java.AltJavaNative.API;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class BaseObject {

    final Pointer baseObjectPointer;

    BaseObject(Pointer objectPointer){
        this.baseObjectPointer = objectPointer;
    }

    public final short getType() {
        return API.libc.alt_IBaseObject_GetType(baseObjectPointer);
    }

    /*
    TODO: GetMeta/SetMeta
     */

}
