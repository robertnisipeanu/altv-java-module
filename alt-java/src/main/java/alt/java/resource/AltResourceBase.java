package alt.java.resource;


import jnr.ffi.Pointer;

public abstract class AltResourceBase implements AltResourceBaseInterface {

    Pointer resourcePointer;
    public String getResourceName(){

        return null;
    }

}
