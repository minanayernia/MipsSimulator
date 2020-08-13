package simulator;

import simulator.control.Simulator;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class shiftLeft32Bit extends Wrapper {
    public shiftLeft32Bit(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        getInput(0) ;
        getInput(1) ;

        for(int i = 2 ; i <= 31 ; i++){
            addOutput(getInput(i));
        }
        addOutput(Simulator.falseLogic);
        addOutput(Simulator.falseLogic);


    }
}
