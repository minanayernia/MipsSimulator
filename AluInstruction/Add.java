package AluInstruction;

import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.FullAdder;
import simulator.wrapper.wrappers.HalfAdder;

public class Add extends Wrapper {
    public Add(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        HalfAdder ha = new HalfAdder("HALFADDER" , "2X2" , getInput(0),getInput(32));
        FullAdder fa1 = new FullAdder("FULLADDER1","3X2",getInput(1),getInput(33),ha.getOutput(0));
        FullAdder fa2 = new FullAdder("FULLADDER2","3x2",getInput(2),getInput(34),fa1.getOutput(0));
        FullAdder fa3 = new FullAdder("FULLADDER3","3x2",getInput(3),getInput(35),fa2.getOutput(0));
        FullAdder fa4 = new FullAdder("FULLADDER4","3x2",getInput(4),getInput(36),fa3.getOutput(0));
        FullAdder fa5 = new FullAdder("FULLADDER5","3X2",getInput(5),getInput(37),fa4.getOutput(0));
        FullAdder fa6 = new FullAdder("FULLADDER6","3X2",getInput(6),getInput(38),fa5.getOutput(0));
        FullAdder fa7 = new FullAdder("FULLADDER7","3X2",getInput(7),getInput(39),fa6.getOutput(0));
        FullAdder fa8 = new FullAdder("FULLADDER8","3X2",getInput(8),getInput(40),fa7.getOutput(0));
        FullAdder fa9 = new FullAdder("FULLADDER9","3X2",getInput(9),getInput(41),fa8.getOutput(0));
        FullAdder fa10 = new FullAdder("FULLADDER10","3X2",getInput(10),getInput(42),fa9.getOutput(0));
        FullAdder fa11 = new FullAdder("FULLADDER11","3X2",getInput(11),getInput(43),fa10.getOutput(0));
        FullAdder fa12 = new FullAdder("FULLADDER12","3X2",getInput(12),getInput(44),fa11.getOutput(0));
        FullAdder fa13 = new FullAdder("FULLADDER13","3X2",getInput(13),getInput(45),fa12.getOutput(0));
        FullAdder fa14 = new FullAdder("FULLADDER14","3X2",getInput(14),getInput(46),fa13.getOutput(0));
        FullAdder fa15 = new FullAdder("FULLADDER15","3X2",getInput(15),getInput(47),fa14.getOutput(0));
        FullAdder fa16 = new FullAdder("FULLADDER16","3X2",getInput(16),getInput(48),fa15.getOutput(0));
        FullAdder fa17 = new FullAdder("FULLADDER17","3X2",getInput(17),getInput(49),fa16.getOutput(0));
        FullAdder fa18 = new FullAdder("FULLADDER18","3X2",getInput(18),getInput(50),fa17.getOutput(0));
        FullAdder fa19 = new FullAdder("FULLADDER19","3X2",getInput(19),getInput(51),fa18.getOutput(0));
        FullAdder fa20 = new FullAdder("FULLADDER20","3X2",getInput(20),getInput(52),fa19.getOutput(0));
        FullAdder fa21 = new FullAdder("FULLADDER21","3X2",getInput(21),getInput(53),fa20.getOutput(0));
        FullAdder fa22 = new FullAdder("FULLADDER22","3X2",getInput(22),getInput(54),fa21.getOutput(0));
        FullAdder fa23 = new FullAdder("FULLADDER23","3X2",getInput(23),getInput(55),fa22.getOutput(0));
        FullAdder fa24 = new FullAdder("FULLADDER24","3X2",getInput(24),getInput(56),fa23.getOutput(0));
        FullAdder fa25 = new FullAdder("FULLADDER25","3X2",getInput(25),getInput(57),fa24.getOutput(0));
        FullAdder fa26 = new FullAdder("FULLADDER26","3X2",getInput(26),getInput(58),fa25.getOutput(0));
        FullAdder fa27 = new FullAdder("FULLADDER27","3X2",getInput(27),getInput(59),fa26.getOutput(0));
        FullAdder fa28 = new FullAdder("FULLADDER28","3X2",getInput(28),getInput(60),fa27.getOutput(0));
        FullAdder fa29 = new FullAdder("FULLADDER29","3X2",getInput(29),getInput(61),fa28.getOutput(0));
        FullAdder fa30 = new FullAdder("FULLADDER30","3X2",getInput(30),getInput(62),fa29.getOutput(0));
        FullAdder fa31 = new FullAdder("FULLADDER31","3X2",getInput(31),getInput(63),fa30.getOutput(0));

        addOutput(
                fa31.getOutput(1),
                fa30.getOutput(1),
                fa29.getOutput(1),
                fa28.getOutput(1),
                fa27.getOutput(1),
                fa26.getOutput(1),
                fa25.getOutput(1),
                fa24.getOutput(1),
                fa23.getOutput(1),
                fa22.getOutput(1),
                fa21.getOutput(1),
                fa20.getOutput(1),
                fa19.getOutput(1),
                fa18.getOutput(1),
                fa17.getOutput(1),
                fa16.getOutput(1),
                fa15.getOutput(1),
                fa14.getOutput(1),
                fa13.getOutput(1),
                fa12.getOutput(1),
                fa11.getOutput(1),
                fa10.getOutput(1),
                fa9.getOutput(1),
                fa8.getOutput(1),
                fa7.getOutput(1),
                fa6.getOutput(1),
                fa5.getOutput(1),
                fa4.getOutput(1),
                fa3.getOutput(1),
                fa2.getOutput(1),
                fa1.getOutput(1),
                ha.getOutput(1)
        );



    }
}
