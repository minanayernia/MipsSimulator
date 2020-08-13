package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.Adder;
import simulator.wrapper.wrappers.DFlipFlop;
import simulator.wrapper.wrappers.Multiplexer;

public class MIPS extends Wrapper {
    public MIPS(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {













    }
}
