package alt.java.util;

public class RGBA {

    private short r=0,g=0,b=0,a=0;

    public RGBA(){

    }

    public RGBA(short r, short g, short b, short a){
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public short getR(){
        return r;
    }
    public short getG(){
        return g;
    }
    public short getB(){
        return b;
    }
    public short getA(){
        return a;
    }

    public void setR(short r){
        this.r=r;
    }
    public void setG(short g){
        this.g=g;
    }
    public void setB(short b){
        this.b=b;
    }
    public void setA(short a){
        this.a=a;
    }

}
