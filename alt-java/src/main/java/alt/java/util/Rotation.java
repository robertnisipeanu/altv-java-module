package alt.java.util;

public class Rotation {
    private float pitch, roll, yaw;

    public Rotation(){
        pitch = 0;
        roll = 0;
        yaw = 0;
    }

    public Rotation(float pitch, float roll, float yaw){
        this.pitch = pitch;
        this.roll = roll;
        this.yaw = yaw;
    }

    public float getPitch(){
        return pitch;
    }

    public float getRoll(){
        return roll;
    }

    public float getYaw(){
        return yaw;
    }

    public Rotation setPitch(float pitch){
        this.pitch = pitch;
        return this;
    }

    public Rotation setRoll(float roll){
        this.roll = roll;
        return this;
    }

    public Rotation setYaw(float yaw){
        this.yaw = yaw;
        return this;
    }

    public Rotation setPitchRollYaw(float pitch, float roll, float yaw){
        this.pitch = pitch;
        this.roll = roll;
        this.yaw = yaw;
        return this;
    }
}
