package AluInstruction;

import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.FullSubtractor;
import simulator.wrapper.wrappers.HalfSubtractor;

public class Sub extends Wrapper {
    public Sub(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        HalfSubtractor hs1 = new HalfSubtractor("HALFSUBTRACTOR1","2X2",getInput(0),getInput(32));
        FullSubtractor fs1 = new FullSubtractor("FULLSUBTRACTOR1","3X2",getInput(1),getInput(33),hs1.getOutput(1));
        FullSubtractor fs2 = new FullSubtractor("FULLSUBTRACTOR2","3X2",getInput(2),getInput(34),fs1.getOutput(1));
        FullSubtractor fs3 = new FullSubtractor("FULLSUBTRACTOR3","3X2",getInput(3),getInput(35),fs2.getOutput(1));
        FullSubtractor fs4 = new FullSubtractor("FULLSUBTRACTOR4","3X2",getInput(4),getInput(36),fs3.getOutput(1));
        FullSubtractor fs5 = new FullSubtractor("FULLSUBTRACTOR5","3X2",getInput(5),getInput(37),fs4.getOutput(1));
        FullSubtractor fs6 = new FullSubtractor("FULLSUBTRACTOR6","3X2",getInput(6),getInput(38),fs5.getOutput(1));
        FullSubtractor fs7 = new FullSubtractor("FULLSUBTRACTOR7","3X2",getInput(7),getInput(39),fs6.getOutput(1));
        FullSubtractor fs8 = new FullSubtractor("FULLSUBTRACTOR8","3X2",getInput(8),getInput(40),fs7.getOutput(1));
        FullSubtractor fs9 = new FullSubtractor("FULLSUBTRACTOR9","3X2",getInput(9),getInput(41),fs8.getOutput(1));
        FullSubtractor fs10 = new FullSubtractor("FULLSUBTRACTOR10","3X2",getInput(10),getInput(42),fs9.getOutput(1));
        FullSubtractor fs11 = new FullSubtractor("FULLSUBTRACTOR11","3X2",getInput(11),getInput(43),fs10.getOutput(1));
        FullSubtractor fs12 = new FullSubtractor("FULLSUBTRACTOR12","3X2",getInput(12),getInput(44),fs11.getOutput(1));
        FullSubtractor fs13 = new FullSubtractor("FULLSUBTRACTOR13","3X2",getInput(13),getInput(45),fs12.getOutput(1));
        FullSubtractor fs14 = new FullSubtractor("FULLSUBTRACTOR14","3X2",getInput(14),getInput(46),fs13.getOutput(1));
        FullSubtractor fs15 = new FullSubtractor("FULLSUBTRACTOR15","3X2",getInput(15),getInput(47),fs14.getOutput(1));
        FullSubtractor fs16 = new FullSubtractor("FULLSUBTRACTOR16","3X2",getInput(16),getInput(48),fs15.getOutput(1));
        FullSubtractor fs17 = new FullSubtractor("FULLSUBTRACTOR17","3X2",getInput(17),getInput(49),fs16.getOutput(1));
        FullSubtractor fs18 = new FullSubtractor("FULLSUBTRACTOR18","3X2",getInput(18),getInput(50),fs17.getOutput(1));
        FullSubtractor fs19 = new FullSubtractor("FULLSUBTRACTOR19","3X2",getInput(19),getInput(51),fs18.getOutput(1));
        FullSubtractor fs20 = new FullSubtractor("FULLSUBTRACTOR20","3X2",getInput(20),getInput(52),fs19.getOutput(1));
        FullSubtractor fs21 = new FullSubtractor("FULLSUBTRACTOR21","3X2",getInput(21),getInput(53),fs20.getOutput(1));
        FullSubtractor fs22 = new FullSubtractor("FULLSUBTRACTOR22","3X2",getInput(22),getInput(54),fs21.getOutput(1));
        FullSubtractor fs23 = new FullSubtractor("FULLSUBTRACTOR23","3X2",getInput(23),getInput(55),fs22.getOutput(1));
        FullSubtractor fs24 = new FullSubtractor("FULLSUBTRACTOR24","3X2",getInput(24),getInput(56),fs23.getOutput(1));
        FullSubtractor fs25 = new FullSubtractor("FULLSUBTRACTOR25","3X2",getInput(25),getInput(57),fs24.getOutput(1));
        FullSubtractor fs26 = new FullSubtractor("FULLSUBTRACTOR26","3X2",getInput(26),getInput(58),fs25.getOutput(1));
        FullSubtractor fs27 = new FullSubtractor("FULLSUBTRACTOR27","3X2",getInput(27),getInput(59),fs26.getOutput(1));
        FullSubtractor fs28 = new FullSubtractor("FULLSUBTRACTOR28","3X2",getInput(28),getInput(60),fs27.getOutput(1));
        FullSubtractor fs29 = new FullSubtractor("FULLSUBTRACTOR29","3X2",getInput(29),getInput(61),fs28.getOutput(1));
        FullSubtractor fs30 = new FullSubtractor("FULLSUBTRACTOR30","3X2",getInput(30),getInput(62),fs29.getOutput(1));
        FullSubtractor fs31 = new FullSubtractor("FULLSUBTRACTOR31","3X2",getInput(31),getInput(63),fs30.getOutput(1));
        addOutput(fs31.getOutput(0));
        addOutput(fs30.getOutput(0));
        addOutput(fs29.getOutput(0));
        addOutput(fs28.getOutput(0));
        addOutput(fs27.getOutput(0));
        addOutput(fs26.getOutput(0));
        addOutput(fs25.getOutput(0));
        addOutput(fs24.getOutput(0));
        addOutput(fs23.getOutput(0));
        addOutput(fs22.getOutput(0));
        addOutput(fs21.getOutput(0));
        addOutput(fs20.getOutput(0));
        addOutput(fs19.getOutput(0));
        addOutput(fs18.getOutput(0));
        addOutput(fs17.getOutput(0));
        addOutput(fs16.getOutput(0));
        addOutput(fs15.getOutput(0));
        addOutput(fs14.getOutput(0));
        addOutput(fs13.getOutput(0));
        addOutput(fs12.getOutput(0));
        addOutput(fs11.getOutput(0));
        addOutput(fs10.getOutput(0));
        addOutput(fs9.getOutput(0));
        addOutput(fs8.getOutput(0));
        addOutput(fs7.getOutput(0));
        addOutput(fs6.getOutput(0));
        addOutput(fs5.getOutput(0));
        addOutput(fs4.getOutput(0));
        addOutput(fs3.getOutput(0));
        addOutput(fs2.getOutput(0));
        addOutput(fs1.getOutput(0));
        addOutput(hs1.getOutput(0));
        //borrow fs31 ???????

    }
}
