package io.docuport_g1.step_definitions;

import io.cucumber.java.en.Given;

public class DebugCucumber {
    @Given("This is a debug step")
    public void this_is_a_debug_step() {
        System.out.println("This is a debug step");

    }

//    @Given("This is a debug step")
//    public void thisIsADebugStep() {
//        System.out.println("This is a debug step");
}

