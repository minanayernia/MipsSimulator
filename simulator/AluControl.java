package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class AluControl extends Wrapper {
    public AluControl(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And and1 = new And("and1") ;
        And and2 = new And("and2") ;
        Or or1 = new Or("or1") ;
        Or or2 = new Or("or2") ;
        Or or3 = new Or("or3") ;
        Not not1 = new Not("not1") ;
        Not not2 = new Not("not2") ;
        getInput(4) ;
        getInput(5) ;
        or1.addInput(getInput(0) , getInput(3));
        and1.addInput(or1.getOutput(0) , getInput(7)); //operation 0
        and2.addInput(getInput(1) , getInput(7));
        or2.addInput(and2.getOutput(0) , getInput(6)); //operation 2
        not1.addInput(getInput(2));
        not2.addInput(getInput(7));
        or3.addInput(not1.getOutput(0) , not2.getOutput(0)); //operation 1
        addOutput(and1.getOutput(0) , or3.getOutput(0) , or2.getOutput(0));




    }
}
