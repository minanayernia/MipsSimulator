package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.combinational.Memory;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class InstructionMemory extends Wrapper {
    public InstructionMemory(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        ByteMemory mem = new ByteMemory("mem") ;
        mem.addInput(getInput(0));
        Boolean[][] temp = new Boolean[65536][8];
        for (int i = 0; i < 65536; ++i) {
            for (int j = 0; j < 8 ; ++j) {
                temp[i][j] = false;
            }
        }
        temp[0][0] = true ;
        temp[0][1] = false ;
        temp[0][2] = false ;
        temp[0][3] = false ;
        temp[0][4] = true ;
        temp[0][5] = false ;
        temp[0][6] = false ;
        temp[0][7] = false ;
        temp[1][0] = false ;
        temp[1][1] = false ;
        temp[1][2] = false ;
        temp[1][3] = false ;
        temp[1][4] = false ;
        temp[1][5] = false ;
        temp[1][6] = false ;
        temp[1][7] = false ;
        temp[2][0] = true ;
        temp[2][1] = true ;
        temp[2][2] = true ;
        temp[2][3] = true ;
        temp[2][4] = true ;
        temp[2][5] = false ;
        temp[2][6] = false ;
        temp[2][7] = false ;
        temp[3][0] = true ;
        temp[3][1] = true ;
        temp[3][2] = false ;
        temp[3][3] = false ;
        temp[3][4] = false ;
        temp[3][5] = false ;
        temp[3][6] = false ;
        temp[3][7] = false ;


        temp[4][0] = true ;
        temp[4][1] = false ;
        temp[4][2] = false ;
        temp[4][3] = true ;
        temp[4][4] = false ;
        temp[4][5] = false ;
        temp[4][6] = false ;
        temp[4][7] = false ;
        temp[5][0] = false ;
        temp[5][1] = false ;
        temp[5][2] = false ;
        temp[5][3] = false ;
        temp[5][4] = false ;
        temp[5][5] = false ;
        temp[5][6] = false ;
        temp[5][7] = true ;
        temp[6][0] = true ;
        temp[6][1] = true ;
        temp[6][2] = true ;
        temp[6][3] = true ;
        temp[6][4] = true ;
        temp[6][5] = false ;
        temp[6][6] = false ;
        temp[6][7] = false ;
        temp[7][0] = false ;
        temp[7][1] = false ;
        temp[7][2] = false ;
        temp[7][3] = false ;
        temp[7][4] = false ;
        temp[7][5] = false ;
        temp[7][6] = false ;
        temp[7][7] = false ;





        temp[8][0] = true ;
        temp[8][1] = true ;
        temp[8][2] = true ;
        temp[8][3] = true ;
        temp[8][4] = true ;
        temp[8][5] = true ;
        temp[8][6] = true ;
        temp[8][7] = true ;




        mem.setMemory(temp);

        //address
        for (int i = 1; i < 17; i++) {
            mem.addInput(getInput(i));
        }
        //data
        for(int i = 17 ; i < 49 ; i++){
            mem.addInput(getInput(i));
        }

        for (int i = 0 ; i < 32 ; i++){
            addOutput(mem.getOutput(i));
        }

        }
}
