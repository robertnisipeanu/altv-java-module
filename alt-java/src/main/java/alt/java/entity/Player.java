package alt.java.entity;

import alt.java.AltJavaNative.API;
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
        return API.libc.alt_IPlayer_IsConnected(baseObjectPointer);
    }

    public long getPing(){
        return API.libc.alt_IPlayer_GetPing(baseObjectPointer);
    }
    public String getIP(){
        return API.libc.alt_IPlayer_GetIP(baseObjectPointer);
    }

    public void spawn(Position position, long delayMs){
        throw new NotImplementedException("TODO");
    }
    public void despawn(){
        API.libc.alt_IPlayer_Despawn(baseObjectPointer);
    }

    public String getName(){
        return API.libc.alt_IPlayer_GetName(baseObjectPointer);
    }

    /**
     * TODO: Parse unsigned?
     */
    public long getSocialID(){
        return API.libc.alt_IPlayer_GetSocialID(baseObjectPointer);
    }
    public long getHwidHash(){
        return API.libc.alt_IPlayer_GetHwidHash(baseObjectPointer);
    }
    public long getHwidExHash(){
        return API.libc.alt_IPlayer_GetHwidExHash(baseObjectPointer);
    }
    public String getAuthToken(){
        return API.libc.alt_IPlayer_GetAuthToken(baseObjectPointer);
    }

    public int getHealth(){
        return API.libc.alt_IPlayer_GetHealth(baseObjectPointer);
    }
    public void setHealth(int health){
        API.libc.alt_IPlayer_SetHealth(baseObjectPointer, health);
    }
    public int getMaxHealth(){
        return API.libc.alt_IPlayer_GetMaxHealth(baseObjectPointer);
    }
    public void setMaxHealth(int maxHealth){
        API.libc.alt_IPlayer_SetMaxHealth(baseObjectPointer, maxHealth);
    }

    public void setDateTime(int day, int month, int year, int hour, int minute, int second){
        API.libc.alt_IPlayer_SetDateTime(baseObjectPointer, day, month, year, hour, minute, second);
    }
    public void setWeather(long weather){
        API.libc.alt_IPlayer_SetWeather(baseObjectPointer, weather);
    }

    public void giveWeapon(long weapon, int ammo, boolean selectWeapon){
        API.libc.alt_IPlayer_GiveWeapon(baseObjectPointer, weapon, ammo, selectWeapon);
    }
    public void removeWeapon(long weapon){
        API.libc.alt_IPlayer_RemoveWeapon(baseObjectPointer, weapon);
    }
    public void removeAllWeapons(){
        API.libc.alt_IPlayer_RemoveAllWeapons(baseObjectPointer);
    }

    public void addWeaponComponent(long weapon, long component){
        API.libc.alt_IPlayer_AddWeaponComponent(baseObjectPointer, weapon, component);
    }
    public void removeWeaponComponent(long weapon, long component){
        API.libc.alt_IPlayer_RemoveWeaponComponent(baseObjectPointer, weapon, component);
    }

    public ArrayList<Long> getCurrentWeaponComponents(){
        throw new NotImplementedException("TODO");
    }

    public void setWeaponTintIndex(long weapon, short tintIndex){
        API.libc.alt_IPlayer_SetWeaponTintIndex(baseObjectPointer, weapon, tintIndex);
    }
    public short getCurrentWeaponTintIndex(){
        return API.libc.alt_IPlayer_GetCurrentWeaponTintIndex(baseObjectPointer);
    }

    public long getCurrentWeapon(){
        return API.libc.alt_IPlayer_GetCurrentWeapon(baseObjectPointer);
    }
    public void setCurrentWeapon(long weapon){
        API.libc.alt_IPlayer_SetCurrentWeapon(baseObjectPointer, weapon);
    }

    public boolean IsDead(){
        return API.libc.alt_IPlayer_IsDead(baseObjectPointer);
    }

    public boolean isJumping(){
        return API.libc.alt_IPlayer_IsJumping(baseObjectPointer);
    }
    public boolean isInRagdoll(){
        return API.libc.alt_IPlayer_IsInRagdoll(baseObjectPointer);
    }
    public boolean isAiming(){
        return API.libc.alt_IPlayer_IsAiming(baseObjectPointer);
    }
    public boolean isShooting(){
        return API.libc.alt_IPlayer_IsShooting(baseObjectPointer);
    }
    public boolean isReloading(){
        return API.libc.alt_IPlayer_IsReloading(baseObjectPointer);
    }

    public int getArmour(){
        return API.libc.alt_IPlayer_GetArmour(baseObjectPointer);
    }
    public void setArmour(int armour){
        API.libc.alt_IPlayer_SetArmour(baseObjectPointer, armour);
    }
    public int getMaxArmour(){
        return API.libc.alt_IPlayer_GetMaxArmour(baseObjectPointer);
    }
    public void setMaxArmour(int maxArmour){
        API.libc.alt_IPlayer_SetMaxArmour(baseObjectPointer, maxArmour);
    }

    public float getMoveSpeed(){
        return API.libc.alt_IPlayer_GetMoveSpeed(baseObjectPointer);
    }

    public long getWeapon(){
        return API.libc.alt_IPlayer_GetWeapon(baseObjectPointer);
    }
    public int getAmmo(){
        return API.libc.alt_IPlayer_GetAmmo(baseObjectPointer);
    }

    public Position getAimPos(){
        throw new NotImplementedException("TODO");
    }
    public Rotation getHeadRotation(){
        throw new NotImplementedException("TODO");
    }

    public boolean isInVehicle(){
        return API.libc.alt_IPlayer_IsInVehicle(baseObjectPointer);
    }
    public Vehicle getVehicle(){
        throw new NotImplementedException("TODO");
    }
    public short getSeat(){
        return API.libc.alt_IPlayer_GetSeat(baseObjectPointer);
    }

    public Entity getEntityAimingAt(){
        throw new NotImplementedException("TODO");
    }
    public Position getEntityAimOffset(){
        throw new NotImplementedException("TODO");
    }

    public boolean isFlashlightActive(){
        return API.libc.alt_IPlayer_IsFlashlightActive(baseObjectPointer);
    }

    public void kick(String reason){
        API.libc.alt_IPlayer_Kick(baseObjectPointer, reason);
    }

    public void kick(){
        kick("kicked out");
    }

    public void setModel(long model){
        API.libc.alt_IPlayer_SetModel(baseObjectPointer, model);
    }
}
