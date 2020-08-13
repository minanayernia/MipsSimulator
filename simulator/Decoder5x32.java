package simulator;

import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class Decoder5x32 extends Wrapper {
    public Decoder5x32(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {

        Decoder2x4 dec2_0 = new Decoder2x4("dec2to4" , "2x4") ;
        Decoder3x8 dec3_1 = new Decoder3x8("dec3to8_1" , "4x8");
        Decoder3x8 dec3_2 = new Decoder3x8("dec3to8_2" , "4x8");
        Decoder3x8 dec3_3 = new Decoder3x8("dec3to8_3" , "4x8");
        Decoder3x8 dec3_4 = new Decoder3x8("dec3to8_4" , "4x8");

        dec2_0.addInput(getInput(0) , getInput(1));
        dec3_1.addInput(getInput(2) , getInput(3) , getInput(4) , dec2_0.getOutput(0));
        dec3_2.addInput(getInput(2) , getInput(3) , getInput(4) , dec2_0.getOutput(1));
        dec3_3.addInput(getInput(2) , getInput(3) , getInput(4) , dec2_0.getOutput(2));
        dec3_4.addInput(getInput(2) , getInput(3) , getInput(4) , dec2_0.getOutput(3));

        addOutput(
                //1decoder
                dec3_1.getOutput(0),
                dec3_1.getOutput(1),
                dec3_1.getOutput(2),
                dec3_1.getOutput(3),
                dec3_1.getOutput(4),
                dec3_1.getOutput(5),
                dec3_1.getOutput(6),
                dec3_1.getOutput(7),
                //2decoder
                dec3_2.getOutput(0),
                dec3_2.getOutput(1),
                dec3_2.getOutput(2),
                dec3_2.getOutput(3),
                dec3_2.getOutput(4),
                dec3_2.getOutput(5),
                dec3_2.getOutput(6),
                dec3_2.getOutput(7),
                //3decoder
                dec3_3.getOutput(0),
                dec3_3.getOutput(1),
                dec3_3.getOutput(2),
                dec3_3.getOutput(3),
                dec3_3.getOutput(4),
                dec3_3.getOutput(5),
                dec3_3.getOutput(6),
                dec3_3.getOutput(7),
                //4decoder
                dec3_4.getOutput(0),
                dec3_4.getOutput(1),
                dec3_4.getOutput(2),
                dec3_4.getOutput(3),
                dec3_4.getOutput(4),
                dec3_4.getOutput(5),
                dec3_4.getOutput(6),
                dec3_4.getOutput(7));


    }
}
