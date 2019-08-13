package alt.java.entity;

import alt.java.util.Position;
import alt.java.util.Rotation;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;

public class Player extends Entity {

    public Player(Pointer objectPointer) {
        super(objectPointer);
    }

    public boolean isConnected(){
        throw new NotImplementedException("TODO");
    }

    public long getPing(){
        throw new NotImplementedException("TODO");
    }
    public String getIP(){
        throw new NotImplementedException("TODO");
    }

    public void spawn(Position position, long delayMs){
        throw new NotImplementedException("TODO");
    }
    public void despawn(){
        throw new NotImplementedException("TODO");
    }

    public String getName(){
        throw new NotImplementedException("TODO");
    }

    /**
     * TODO: Parse unsigned?
     */
    public long getSocialID(){
        throw new NotImplementedException("TODO");
    }
    public long getHwidHash(){
        throw new NotImplementedException("TODO");
    }
    public long getHwidExHash(){
        throw new NotImplementedException("TODO");
    }
    public String getAuthToken(){
        throw new NotImplementedException("TODO");
    }

    public int getHealth(){
        throw new NotImplementedException("TODO");
    }
    public void setHealth(int health){
        throw new NotImplementedException("TODO");
    }
    public int getMaxHealth(){
        throw new NotImplementedException("TODO");
    }
    public void setMaxHealth(int maxHealth){
        throw new NotImplementedException("TODO");
    }

    public void setDateTime(int day, int month, int year, int hour, int minute, int second){
        throw new NotImplementedException("TODO");
    }
    public void setWeather(long weather){
        throw new NotImplementedException("TODO");
    }

    public void giveWeapon(long weapon, int ammo, boolean selectWeapon){
        throw new NotImplementedException("TODO");
    }
    public void removeWeapon(long weapon){
        throw new NotImplementedException("TODO");
    }
    public void removeAllWeapons(){
        throw new NotImplementedException("TODO");
    }

    public void addWeaponComponent(long weapon, long component){
        throw new NotImplementedException("TODO");
    }
    public void removeWeaponComponent(long weapon, long component){
        throw new NotImplementedException("TODO");

    }
    public ArrayList<Long> getCurrentWeaponComponents(){
        throw new NotImplementedException("TODO");
    }

    public void setWeaponTintIndex(long weapon, short tintIndex){
        throw new NotImplementedException("TODO");
    }
    public short getCurrentWeaponTintIndex(){
        throw new NotImplementedException("TODO");
    }

    public long getCurrentWeapon(){
        throw new NotImplementedException("TODO");
    }
    public void setCurrentWeapon(long weapon){
        throw new NotImplementedException("TODO");
    }

    public boolean IsDead(){
        throw new NotImplementedException("TODO");
    }

    public boolean isJumping(){
        throw new NotImplementedException("TODO");
    }
    public boolean isInRagdoll(){
        throw new NotImplementedException("TODO");
    }
    public boolean isAiming(){
        throw new NotImplementedException("TODO");
    }
    public boolean isShooting(){
        throw new NotImplementedException("TODO");
    }
    public boolean isReloading(){
        throw new NotImplementedException("TODO");
    }

    public int getArmour(){
        throw new NotImplementedException("TODO");
    }
    public void setArmour(int armour){
        throw new NotImplementedException("TODO");
    }
    public int getMaxArmour(){
        throw new NotImplementedException("TODO");
    }
    public void setMaxArmour(int maxArmour){
        throw new NotImplementedException("TODO");
    }

    public float getMoveSpeed(){
        throw new NotImplementedException("TODO");
    }

    public long getWeapon(){
        throw new NotImplementedException("TODO");
    }
    public int getAmmo(){
        throw new NotImplementedException("TODO");
    }

    public Position getAimPos(){
        throw new NotImplementedException("TODO");
    }
    public Rotation getHeadRotation(){
        throw new NotImplementedException("TODO");
    }

    public boolean isInVehicle(){
        throw new NotImplementedException("TODO");
    }
    public Vehicle getVehicle(){
        throw new NotImplementedException("TODO");
    }
    public short getSeat(){
        throw new NotImplementedException("TODO");
    }

    public Entity getEntityAimingAt(){
        throw new NotImplementedException("TODO");
    }
    public Position getEntityAimOffset(){
        throw new NotImplementedException("TODO");
    }

    public boolean isFlashlightActive(){
        throw new NotImplementedException("TODO");
    }

    public void kick(String reason){
        throw new NotImplementedException("TODO");
    }

    public void setModel(long model){
        throw new NotImplementedException("TODO");
    }
}
