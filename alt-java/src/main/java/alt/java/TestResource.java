package alt.java;

import alt.java.resource.AltResource;

import java.util.Random;

public class TestResource extends AltResource {

    @Override
    public void onStart(){
        System.out.println("TestResource extends AltResource started");
    }

    @Override
    public void onStop() {

    }

}
