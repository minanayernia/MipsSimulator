package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class signExtend extends Wrapper {
    public signExtend(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {


        And and1 = new And("and1") ;
        and1.addInput(getInput(0) , Simulator.trueLogic);
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(and1.getOutput(0));
        addOutput(getInput(0));
        addOutput(getInput(1));
        addOutput(getInput(2));
        addOutput(getInput(3));
        addOutput(getInput(4));
        addOutput(getInput(5));
        addOutput(getInput(6));
        addOutput(getInput(7));
        addOutput(getInput(8));
        addOutput(getInput(9));
        addOutput(getInput(10));
        addOutput(getInput(11));
        addOutput(getInput(12));
        addOutput(getInput(13));
        addOutput(getInput(14));
        addOutput(getInput(15));




    }
}
