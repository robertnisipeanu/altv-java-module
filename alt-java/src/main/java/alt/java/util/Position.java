package alt.java.util;

public class Position {

    private float x,y,z;

    public Position(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Position(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getZ(){
        return z;
    }

    public Position setX(float x){
        this.x = x;
        return this;
    }

    public Position setY(float y){
        this.y = y;
        return this;
    }

    public Position setZ(float z){
        this.z = z;
        return this;
    }

    public Position setXYZ(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

}
