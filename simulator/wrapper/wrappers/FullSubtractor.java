package simulator.wrapper.wrappers;

import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class FullSubtractor extends Wrapper {
    public FullSubtractor(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        HalfSubtractor hs1 = new HalfSubtractor("HALFSUBTRACTOR1","2X2",getInput(0),getInput(1));
        HalfSubtractor hs2 = new HalfSubtractor("HALFSUBTRACTOR2","2X2",hs1.getOutput(0),getInput(2));
        Or or = new Or("OR",hs2.getOutput(1),hs1.getOutput(1));

        addOutput(hs2.getOutput(0),or.getOutput(0));

    }
}
