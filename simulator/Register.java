package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.sequential.Clock;
//import simulator.gates.sequential.flipflops.DFlipFlop;
import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.DFlipFlop;

public class Register extends Wrapper {
    public Register(String label, String stream, Link... links) {
        super(label, stream, links);
    }

//    register[0] =new DFlipFlop("d" , Simulator.trueLogic , Simulator.falseLogic) ;

    @Override
    public void initialize() {
        DFlipFlop[] register = new DFlipFlop[32];
        for (int i = 0 ; i < 32 ; i++){
            register[i] =new DFlipFlop("d" , "2x2" , getInput(32) , getInput(i)) ;
        }
        for ( int i = 0 ; i < 32 ; i++){
            addOutput(register[i].getOutput(0));
        }
    }

}
