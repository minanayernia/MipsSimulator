package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Decoder2x4 extends Wrapper {
    public Decoder2x4(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Not n1 = new Not("not1");
        Not n2 = new Not("not2");

        And a1 = new And("And1") ;
        And a2 = new And("And2") ;
        And a3 = new And("And3") ;
        And a4 = new And("And4") ;

        n1.addInput(getInput(0));
        n2.addInput(getInput(1));

        a1.addInput(n1.getOutput(0) , n2.getOutput(0)); //a'b'
        a2.addInput(n1.getOutput(0) , getInput(1)); //a'b
        a3.addInput(getInput(0), n2.getOutput(0)); //ab'
        a4.addInput(getInput(0), getInput(1)); //ab

        addOutput(a1.getOutput(0) , a2.getOutput(0) , a3.getOutput(0) , a4.getOutput(0));

    }
}
