package simulator;

import simulator.gates.combinational.ByteMemory;
import simulator.gates.combinational.Memory;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

import javax.xml.crypto.Data;
import java.util.List;

public class DataMemory extends Wrapper {
    public DataMemory(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        ByteMemory memory = new ByteMemory("DATAMEMORY");
        Boolean[][] temp = new Boolean[65536][8];
        for (int i = 0; i < 65536; ++i) {
            for (int j = 0; j < 8; ++j) {
                temp[i][j] = true;
            }
        }
        for (int i = 0; i < 8; ++i) {
            temp[1][i] = true;
        }

        memory.setMemory(temp);

        memory.addInput(getInput(0)); //memWrite

        //address
        for(int i =1 ; i<17 ; i++)
            memory.addInput(getInput(i));

        //write data
        for(int i=17 ; i<49 ; i++)
            memory.addInput(getInput(i));



        for(int i=0 ; i< 32 ; i++){
            addOutput(memory.getOutput(i));
        }



    }
}
