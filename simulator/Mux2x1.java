package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import javax.xml.crypto.OctetStreamData;

public class Mux2x1 extends Wrapper {
    public Mux2x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        // a,b input
        // c select
        And a1 = new And("And1") ;
        And a2 = new And("And2") ;
        Not n = new Not("not") ;
        Or o1 = new Or("Or") ;
        n.addInput(getInput(2));
        a1.addInput(getInput(0) ,n.getOutput(0)); //c'a
        a2.addInput(getInput(1), getInput(2));//cb
        o1.addInput(a1.getOutput(0) , a2.getOutput(0));

        addOutput(o1.getOutput(0));




    }
}
