package simulator.wrapper.wrappers;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Xor;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class HalfSubtractor extends Wrapper {
    public HalfSubtractor(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        Xor xor = new Xor("XOR");
        Not not = new Not("Not");
        And and = new And("AND");

        xor.addInput(getInput(0),getInput(1)); //diff
        not.addInput(getInput(0));
        and.addInput(not.getOutput(0), getInput(1)); //borrow

        addOutput(xor.getOutput(0),and.getOutput(0));

    }
}
