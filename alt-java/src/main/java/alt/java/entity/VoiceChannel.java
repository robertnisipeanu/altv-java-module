package alt.java.entity;

import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class VoiceChannel extends BaseObject {

    public VoiceChannel(Pointer objectPointer) {
        super(objectPointer);
    }

    public void addPlayer(Player player){
        throw new NotImplementedException("TODO");
    }

    public void removePlayer(Player player){
        throw new NotImplementedException("TODO");
    }

    public void mutePlayer(Player player){
        throw new NotImplementedException("TODO");
    }

    public void unmutePlayer(Player player){
        throw new NotImplementedException("TODO");
    }

    public boolean isPlayerConnected(Player player){
        throw new NotImplementedException("TODO");
    }

    public boolean isPlayerMuted(Player player){
        throw new NotImplementedException("TODO");
    }

    public boolean isSpatial(){
        throw new NotImplementedException("TODO");
    }

    public float getMaxDistance(){
        throw new NotImplementedException("TODO");
    }

}
