package simulator;

import simulator.Register;
import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.network.Link;
//import simulator.wrapper.Decoder;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.Decoder;
import simulator.wrapper.wrappers.Multiplexer;

public class RegisterFile extends Wrapper {
    public RegisterFile(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        //inputs : 5bit reg1  for read ,  5bit reg2  for read , 5bit reg3 for write , 1bit regwrite , 32bit write data
        //initializing registers for first time
        Register[] RegFile = new Register[32] ;
        for (int i = 0; i < 32; i++) {
            RegFile[i] = new Register("R" + i, "33X32");
        }

        //write part
        //inputs 10-14 == write register
        Decoder dec =  new Decoder("decoder" , "5x32" ,
                getInput(10),
                getInput(11),
                getInput(12),
                getInput(13),
                getInput(14)
        );

        Mux2x1[][] writeSelect = new Mux2x1[32][32];
        // REGISTER CLOCK = DECODER[I] && REGWRITE
        // input 47 = reqwrite bit
        // FOR EACH REGISTER
        And[] ands = new And[32];
//        //getInput(47) = regwrite
        for (int i = 0; i < 32; ++i)
            ands[i] = new And("A" + i, dec.getOutput(i), getInput(47));

        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                writeSelect[i][j] = new Mux2x1("M" +i +j, "3X1", RegFile[i].getOutput(j),
                        getInput(15 + j), ands[i].getOutput(0));
            }
        }
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                RegFile[i].addInput(writeSelect[i][j].getOutput(0));
            }
            RegFile[i].addInput(getInput(48));
        }

//
        Multiplexer[] firstReadSelect = new Multiplexer[32];
        for (int i = 0; i < 32; ++i)
            firstReadSelect[i] = new Multiplexer("MUX" + i, "37X1");
        for (int i = 0; i < 32; ++i)
            for (int j = 0; j < 5; ++j)
                firstReadSelect[i].addInput(getInput(j));
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                firstReadSelect[i].addInput(RegFile[j].getOutput(i));
            }
            addOutput(firstReadSelect[i].getOutput(0));
        }

        Multiplexer[] secondReadSelect = new Multiplexer[32];
        for (int i = 0; i < 32; ++i)
            secondReadSelect[i] = new Multiplexer("MUX2" + i, "37X1");
        for (int i = 0; i < 32; ++i)
            for (int j = 0; j < 5; ++j)
                secondReadSelect[i].addInput(getInput(j + 5));
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < 32; ++j) {
                secondReadSelect[i].addInput(RegFile[j].getOutput(i));
            }
            addOutput(secondReadSelect[i].getOutput(0));
        }

//        ///////////////////////////////////////////////////////////////////////////


    }}


