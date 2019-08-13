package alt.java.entity;

import alt.java.util.RGBA;
import jnr.ffi.Pointer;
import org.apache.commons.lang3.NotImplementedException;

public class Vehicle extends Entity {

    public Vehicle(Pointer objectPointer) {
        super(objectPointer);
    }

    public Player getDriver(){
        throw new NotImplementedException("TODO");
    }

    public short getMod(short category){
        throw new NotImplementedException("TODO");
    }
    public short getModsCount(short category){
        throw new NotImplementedException("TODO");
    }

    public short getModKitsCount(){
        throw new NotImplementedException("TODO");
    }
    public short getModKit(){
        throw new NotImplementedException("TODO");
    }
    public boolean setModKit(short id){
        throw new NotImplementedException("TODO");
    }

    public boolean isPrimaryColorRGB(){
        throw new NotImplementedException("TODO");
    }
    public short getPrimaryColor(){
        throw new NotImplementedException("TODO");
    }
    public RGBA getPrimaryColorRGB(){
        throw new NotImplementedException("TODO");
    }
    public void setPrimaryColor(short color){
        throw new NotImplementedException("TODO");
    }
    public void setPrimaryColorRGB(RGBA color){
        throw new NotImplementedException("TODO");
    }

    public boolean isSecondaryColorRGB(){
        throw new NotImplementedException("TODO");
    }
    public short getSecondaryColor(){
        throw new NotImplementedException("TODO");
    }
    public RGBA getSecondaryColorRGB(){
        throw new NotImplementedException("TODO");
    }
    public void setSecondaryColor(short color){
        throw new NotImplementedException("TODO");
    }
    public void setSecondaryColorRGB(RGBA color){
        throw new NotImplementedException("TODO");
    }

    public short getPearlColor(){
        throw new NotImplementedException("TODO");
    }
    public void setPearlColor(short color){
        throw new NotImplementedException("TODO");
    }

    public short getWheelColor(){
        throw new NotImplementedException("TODO");
    }
    public void setWheelColor(short color){
        throw new NotImplementedException("TODO");
    }

    public short getInteriorColor(){
        throw new NotImplementedException("TODO");
    }
    public void setInteriorColor(short color){
        throw new NotImplementedException("TODO");
    }

    public short getDashboardColor(){
        throw new NotImplementedException("TODO");
    }
    public short setDashboardColor(short color){
        throw new NotImplementedException("TODO");
    }

    public boolean isTireSmokeColorCustom(){
        throw new NotImplementedException("TODO");
    }
    public RGBA getTireSmokeColor(){
        throw new NotImplementedException("TODO");
    }
    public void setTireSmokeColor(RGBA color){
        throw new NotImplementedException("TODO");
    }

    public short getWheelType(){
        throw new NotImplementedException("TODO");
    }
    public short getWheelVariation(){
        throw new NotImplementedException("TODO");
    }
    public void setWheels(short type, short variation){
        throw new NotImplementedException("TODO");
    }

    public boolean getCustomTires(){
        throw new NotImplementedException("TODO");
    }
    public void setCustomTires(boolean state){
        throw new NotImplementedException("TODO");
    }

    public short getSpecialDarkness(){
        throw new NotImplementedException("TODO");
    }
    public void setSpecialDarkness(short value){
        throw new NotImplementedException("TODO");
    }

    public long getNumberplateIndex(){
        throw new NotImplementedException("TODO");
    }
    public void setNumberplateIndex(long index){
        throw new NotImplementedException("TODO");
    }

    public String getNumberplateText(){
        throw new NotImplementedException("TODO");
    }
    public void setNumberplateText(String text){
        throw new NotImplementedException("TODO");
    }

    public short getWindowTint(){
        throw new NotImplementedException("TODO");
    }
    public void setWindowTint(short tint){
        throw new NotImplementedException("TODO");
    }

    public short getDirtLevel(){
        throw new NotImplementedException("TODO");
    }
    public void setDirtLevel(short level){
        throw new NotImplementedException("TODO");
    }

    public boolean isExtraOn(short extraID){
        throw new NotImplementedException("TODO");
    }
    public void toggleExtra(short extraID, boolean state){
        throw new NotImplementedException("TODO");
    }

    public boolean isNeonActive(){
        throw new NotImplementedException("TODO");
    }
    /**
     * TODO: GetNeonActive
     * https://github.com/altmp/cpp-sdk/blob/master/entities/IVehicle.h#L81
     */
    public void setNeonActive(boolean left, boolean right, boolean front, boolean back){
        throw new NotImplementedException("TODO");
    }
    public RGBA getNeonColor(){
        throw new NotImplementedException("TODO");
    }
    public void setNeonColor(RGBA color){
        throw new NotImplementedException("TODO");
    }

    public short getLivery(){
        throw new NotImplementedException("TODO");
    }

    public void setLivery(short livery){
        throw new NotImplementedException("TODO");
    }

    public short getRoofLivery(){
        throw new NotImplementedException("TODO");
    }

    public void setRoofLivery(short livery){
        throw new NotImplementedException("TODO");
    }

    public String getAppearanceDataBase64(){
        throw new NotImplementedException("TODO");
    }
    public void loadAppearanceDataFromBase64(String base64){
        throw new NotImplementedException("TODO");
    }

    // Vehicle game state
    public boolean isEngineOn(){
        throw new NotImplementedException("TODO");
    }
    public void setEngineOn(boolean state){
        throw new NotImplementedException("TODO");
    }

    public boolean isHandbrakeActive(){
        throw new NotImplementedException("TODO");
    }

    public short getHeadlightColor(){
        throw new NotImplementedException("TODO");
    }
    public void setHeadlightColor(short color){
        throw new NotImplementedException("TODO");
    }

    public long getRadioStationIndex(){
        throw new NotImplementedException("TODO");
    }
    public void setRadioStationIndex(long stationIndex){
        throw new NotImplementedException("TODO");
    }

    public boolean isSirenActive(){
        throw new NotImplementedException("TODO");
    }
    public void setSirenActive(boolean state){
        throw new NotImplementedException("TODO");
    }

    public short getLockState(){
        throw new NotImplementedException("TODO");
    }
    public void setLockState(short state){
        throw new NotImplementedException("TODO");
    }

    public short getDoorState(short doorID){
        throw new NotImplementedException("TODO");
    }
    public void setDoorState(short doorID, short state){
        throw new NotImplementedException("TODO");
    }

    public boolean isWindowOpened(short windowID){
        throw new NotImplementedException("TODO");
    }
    public void setWindowOpened(short windowID, boolean state){
        throw new NotImplementedException("TODO");
    }

    public boolean isDaylightOn(){
        throw new NotImplementedException("TODO");
    }
    public boolean isNightlightOn(){
        throw new NotImplementedException("TODO");
    }

    public boolean isRoofOpened(){
        throw new NotImplementedException("TODO");
    }
    public void setRoofOpened(boolean state){
        throw new NotImplementedException("TODO");
    }

    public boolean isFlamethrowerActive(){
        throw new NotImplementedException("TODO");
    }

    public float getLightsMultiplier(){
        throw new NotImplementedException("TODO");
    }

    public void setLightsMultiplier(float multiplier){
        throw new NotImplementedException("TODO");
    }

    public String getGameStateBase64(){
        throw new NotImplementedException("TODO");
    }
    public void loadGameStateFromBase64(String base64){
        throw new NotImplementedException("TODO");
    }

    // Vehicle health
    public int getEngineHealth(){
        throw new NotImplementedException("TODO");
    }
    public void setEngineHealth(int health){
        throw new NotImplementedException("TODO");
    }

    public int getPetrolTankHealth(){
        throw new NotImplementedException("TODO");
    }
    public void setPetrolTankHealth(int health){
        throw new NotImplementedException("TODO");
    }

    public short getWheelsCount(){
        throw new NotImplementedException("TODO");
    }

    public boolean isWheelBurst(short wheelID){
        throw new NotImplementedException("TODO");
    }
    public void setWheelBurst(short wheelID, boolean state){
        throw new NotImplementedException("TODO");
    }

    public boolean doesWheelHasTire(short wheelID){
        throw new NotImplementedException("TODO");
    }
    public void setWheelHasTire(short wheelID, boolean state){
        throw new NotImplementedException("TODO");
    }

    public float getWheelHealth(short wheelID){
        throw new NotImplementedException("TODO");
    }
    public void setWheelHealth(short wheelID, float health){
        throw new NotImplementedException("TODO");
    }

    public short getRepairsCount(){
        throw new NotImplementedException("TODO");
    }

    public long getBodyHealth(){
        throw new NotImplementedException("TODO");
    }
    public void setBodyHealth(long health){
        throw new NotImplementedException("TODO");
    }
    public long getBodyAdditionalHealth(){
        throw new NotImplementedException("TODO");
    }
    public void setBodyAdditionalHealth(long health){
        throw new NotImplementedException("TODO");
    }

    public String getHealthDataBase64(){
        throw new NotImplementedException("TODO");
    }
    public void LoadHealthDataFromBase64(String base64){
        throw new NotImplementedException("TODO");
    }

    // Vehicle damage
    public short getPartDamageLevel(short partID){
        throw new NotImplementedException("TODO");
    }
    public void setPartDamageLevel(short partID, short damage){
        throw new NotImplementedException("TODO");
    }
    public short getPartBulletHoles(short partID){
        throw new NotImplementedException("TODO");
    }
    public void setPartBulletHoles(short partID, short shootsCount){
        throw new NotImplementedException("TODO");
    }
    public boolean isLightDamaged(short lightID){
        throw new NotImplementedException("TODO");
    }
    public void setLightDamaged(short lightID, boolean isDamaged){
        throw new NotImplementedException("TODO");
    }
    public boolean isWindowDamaged(short windowID){
        throw new NotImplementedException("TODO");
    }
    public void setWindowDamaged(short windowID, boolean isDamaged){
        throw new NotImplementedException("TODO");
    }
    public boolean isSpecialLightDamaged(short specialLightID){
        throw new NotImplementedException("TODO");
    }
    public void setSpecialLightDamaged(short specialLightID, boolean isDamaged){
        throw new NotImplementedException("TODO");
    }
    public boolean hasArmoredWindows(){
        throw new NotImplementedException("TODO");
    }
    public float getArmoredWindowHealth(short windowID){
        throw new NotImplementedException("TODO");
    }
    public void setArmoredWindowHealth(short windowID, float health){
        throw new NotImplementedException("TODO");
    }
    public short getArmoredWindowShootCount(short windowID){
        throw new NotImplementedException("TODO");
    }
    public void setArmoredWindowShootCount(short windowID, short count){
        throw new NotImplementedException("TODO");
    }
    public short getBumperDamageLevel(short bumperID){
        throw new NotImplementedException("TODO");
    }
    public void setBumperDamageLevel(short bumperID, short damageLevel){
        throw new NotImplementedException("TODO");
    }

    public String getDamageDataBase64(){
        throw new NotImplementedException("TODO");
    }
    public void loadDamageDataFromBase64(String base64){
        throw new NotImplementedException("TODO");
    }

    // Vehicle script data
    public void setManualEngineControl(boolean state){
        throw new NotImplementedException("TODO");
    }
    public boolean isManualengineControl(){
        throw new NotImplementedException("TODO");
    }

    public String getScriptDataBase64(){
        throw new NotImplementedException("TODO");
    }
    public void loadScriptDataFromBase64(String base64){
        throw new NotImplementedException("TODO");
    }
}
