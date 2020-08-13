package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Decoder3x8 extends Wrapper {
    public Decoder3x8(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        //input4 == enable


        Not n1 = new Not("Not1");
        Not n2 = new Not("Not2");
        Not n3 = new Not("Not3");

        And a1 = new And("And1");
        And a2 = new And("And2");
        And a3 = new And("And3");
        And a4 = new And("And4");
        And a5 = new And("And5");
        And a6 = new And("And6");
        And a7 = new And("And7");
        And a8 = new And("And8");

        n1.addInput(getInput(0)); //a'
        n2.addInput(getInput(1)); //b'
        n3.addInput(getInput(2)); //c'

        a1.addInput(getInput(0) , getInput(1) , getInput(2) , getInput(3)); //abc
        a2.addInput(n1.getOutput(0) , getInput(1) , getInput(2), getInput(3)); //a'bc
        a3.addInput(getInput(0) , n2.getOutput(0) , getInput(2), getInput(3)); //ab'c
        a4.addInput(getInput(0) , getInput(1) , n3.getOutput(0), getInput(3)); //abc'
        a5.addInput(n1.getOutput(0), n2.getOutput(0) , getInput(2), getInput(3)); //a'b'c
        a6.addInput(n1.getOutput(0) , getInput(1) , n3.getOutput(0), getInput(3)); //a'bc'
        a7.addInput(getInput(0) , n2.getOutput(0) , n3.getOutput(0), getInput(3)); //ab'c'
        a8.addInput(n1.getOutput(0) , n2.getOutput(0) , n3.getOutput(0), getInput(3)); //a'b'c'

        addOutput(a8.getOutput(0),a7.getOutput(0) , a6.getOutput(0) , a5.getOutput(0) , a4.getOutput(0) , a3.getOutput(0) , a2.getOutput(0) , a1.getOutput(0));


    }
}
