package simulator;


import AluInstruction.*;
import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;
import simulator.wrapper.wrappers.Adder;

public class Alu extends Wrapper {
    public Alu(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {


        Add adder = new Add("ADDER", "64X32",
                getInput(31), getInput(30), getInput(29), getInput(28), getInput(27), getInput(26), getInput(25),
                getInput(24), getInput(23), getInput(22), getInput(21), getInput(20), getInput(19), getInput(18),
                getInput(17), getInput(16), getInput(15), getInput(14), getInput(13), getInput(12), getInput(11),
                getInput(10), getInput(9), getInput(8), getInput(7), getInput(6), getInput(5), getInput(4), getInput(3),
                getInput(2), getInput(1), getInput(0), getInput(63), getInput(62), getInput(61), getInput(60), getInput(59),
                getInput(58), getInput(57), getInput(56), getInput(55), getInput(54), getInput(53), getInput(52), getInput(51),
                getInput(50), getInput(49), getInput(48), getInput(47), getInput(46), getInput(45), getInput(44), getInput(43),
                getInput(42), getInput(41), getInput(40), getInput(39), getInput(38), getInput(37), getInput(36), getInput(35),
                getInput(34), getInput(33), getInput(32));


        OrInst or = new OrInst("OR1","64X32",
                getInput(0), getInput(1), getInput(2), getInput(3), getInput(4), getInput(5), getInput(6),
                getInput(7), getInput(8), getInput(9), getInput(10), getInput(11), getInput(12), getInput(13),
                getInput(14), getInput(15), getInput(16), getInput(17), getInput(18), getInput(19), getInput(20),
                getInput(21), getInput(22), getInput(23), getInput(24), getInput(25), getInput(26), getInput(27), getInput(28),
                getInput(29), getInput(30), getInput(31), getInput(32), getInput(33), getInput(34), getInput(35), getInput(36),
                getInput(37), getInput(38), getInput(39), getInput(40), getInput(41), getInput(42), getInput(43), getInput(44),
                getInput(45), getInput(46), getInput(47), getInput(48), getInput(49), getInput(50), getInput(51), getInput(52),
                getInput(53), getInput(54), getInput(55), getInput(56), getInput(57), getInput(58), getInput(59), getInput(60),
                getInput(61), getInput(62), getInput(63));


        AndInst and = new AndInst("AND","64x32",
                getInput(0), getInput(1), getInput(2), getInput(3), getInput(4), getInput(5), getInput(6),
                getInput(7), getInput(8), getInput(9), getInput(10), getInput(11), getInput(12), getInput(13),
                getInput(14), getInput(15), getInput(16), getInput(17), getInput(18), getInput(19), getInput(20),
                getInput(21), getInput(22), getInput(23), getInput(24), getInput(25), getInput(26), getInput(27), getInput(28),
                getInput(29), getInput(30), getInput(31), getInput(32), getInput(33), getInput(34), getInput(35), getInput(36),
                getInput(37), getInput(38), getInput(39), getInput(40), getInput(41), getInput(42), getInput(43), getInput(44),
                getInput(45), getInput(46), getInput(47), getInput(48), getInput(49), getInput(50), getInput(51), getInput(52),
                getInput(53), getInput(54), getInput(55), getInput(56), getInput(57), getInput(58), getInput(59), getInput(60),
                getInput(61), getInput(62), getInput(63));


        Sub sub = new Sub("SUB","64X32",
                getInput(31), getInput(30), getInput(29), getInput(28), getInput(27), getInput(26), getInput(25),
                getInput(24), getInput(23), getInput(22), getInput(21), getInput(20), getInput(19), getInput(18),
                getInput(17), getInput(16), getInput(15), getInput(14), getInput(13), getInput(12), getInput(11),
                getInput(10), getInput(9), getInput(8), getInput(7), getInput(6), getInput(5), getInput(4), getInput(3),
                getInput(2), getInput(1), getInput(0), getInput(63), getInput(62), getInput(61), getInput(60), getInput(59),
                getInput(58), getInput(57), getInput(56), getInput(55), getInput(54), getInput(53), getInput(52), getInput(51),
                getInput(50), getInput(49), getInput(48), getInput(47), getInput(46), getInput(45), getInput(44), getInput(43),
                getInput(42), getInput(41), getInput(40), getInput(39), getInput(38), getInput(37), getInput(36), getInput(35),
                getInput(34), getInput(33), getInput(32));


        Slt slt = new Slt("SLT" ,"64X32",
                getInput(31), getInput(30), getInput(29), getInput(28), getInput(27), getInput(26), getInput(25),
                getInput(24), getInput(23), getInput(22), getInput(21), getInput(20), getInput(19), getInput(18),
                getInput(17), getInput(16), getInput(15), getInput(14), getInput(13), getInput(12), getInput(11),
                getInput(10), getInput(9), getInput(8), getInput(7), getInput(6), getInput(5), getInput(4), getInput(3),
                getInput(2), getInput(1), getInput(0), getInput(63), getInput(62), getInput(61), getInput(60), getInput(59),
                getInput(58), getInput(57), getInput(56), getInput(55), getInput(54), getInput(53), getInput(52), getInput(51),
                getInput(50), getInput(49), getInput(48), getInput(47), getInput(46), getInput(45), getInput(44), getInput(43),
                getInput(42), getInput(41), getInput(40), getInput(39), getInput(38), getInput(37), getInput(36), getInput(35),
                getInput(34), getInput(33), getInput(32));


        multiplexer8x1 mux1 = new multiplexer8x1("MUX1","11X1");
        multiplexer8x1 mux2 = new multiplexer8x1("MUX2","11X1");
        multiplexer8x1 mux3 = new multiplexer8x1("MUX3","11X1");
        multiplexer8x1 mux4 = new multiplexer8x1("MUX4","11X1");
        multiplexer8x1 mux5 = new multiplexer8x1("MUX5","11X1");
        multiplexer8x1 mux6 = new multiplexer8x1("MUX6","11X1");
        multiplexer8x1 mux7 = new multiplexer8x1("MUX7","11X1");
        multiplexer8x1 mux8 = new multiplexer8x1("MUX8","11X1");
        multiplexer8x1 mux9 = new multiplexer8x1("MUX9","11X1");
        multiplexer8x1 mux10 = new multiplexer8x1("MUX10","11X1");
        multiplexer8x1 mux11 = new multiplexer8x1("MUX11","11X1");
        multiplexer8x1 mux12 = new multiplexer8x1("MUX12","11X1");
        multiplexer8x1 mux13 = new multiplexer8x1("MUX13","11X1");
        multiplexer8x1 mux14 = new multiplexer8x1("MUX14","11X1");
        multiplexer8x1 mux15 = new multiplexer8x1("MUX15","11X1");
        multiplexer8x1 mux16 = new multiplexer8x1("MUX16","11X1");
        multiplexer8x1 mux17 = new multiplexer8x1("MUX17","11X1");
        multiplexer8x1 mux18 = new multiplexer8x1("MUX18","11X1");
        multiplexer8x1 mux19 = new multiplexer8x1("MUX19","11X1");
        multiplexer8x1 mux20 = new multiplexer8x1("MUX20","11X1");
        multiplexer8x1 mux21 = new multiplexer8x1("MUX21","11X1");
        multiplexer8x1 mux22 = new multiplexer8x1("MUX22","11X1");
        multiplexer8x1 mux23 = new multiplexer8x1("MUX23","11X1");
        multiplexer8x1 mux24 = new multiplexer8x1("MUX24","11X1");
        multiplexer8x1 mux25 = new multiplexer8x1("MUX25","11X1");
        multiplexer8x1 mux26 = new multiplexer8x1("MUX26","11X1");
        multiplexer8x1 mux27 = new multiplexer8x1("MUX27","11X1");
        multiplexer8x1 mux28 = new multiplexer8x1("MUX28","11X1");
        multiplexer8x1 mux29 = new multiplexer8x1("MUX29","11X1");
        multiplexer8x1 mux30 = new multiplexer8x1("MUX30","11X1");
        multiplexer8x1 mux31 = new multiplexer8x1("MUX31","11X1");
        multiplexer8x1 mux32 = new multiplexer8x1("MUX32","11X1");

        mux1.addInput(and.getOutput(0),or.getOutput(0),adder.getOutput(0), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(0),slt.getOutput(0),getInput(64),getInput(65),getInput(66));
        mux2.addInput(and.getInput(1),or.getOutput(1),adder.getOutput(1), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(1),slt.getOutput(1),getInput(64),getInput(65),getInput(66));
        mux3.addInput(and.getInput(2),or.getOutput(2),adder.getOutput(2), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(2),slt.getOutput(2),getInput(64),getInput(65),getInput(66));
        mux4.addInput(and.getInput(3),or.getOutput(3),adder.getOutput(3), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(3),slt.getOutput(3),getInput(64),getInput(65),getInput(66));
        mux5.addInput(and.getInput(4),or.getOutput(4),adder.getOutput(4), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(4),slt.getOutput(4),getInput(64),getInput(65),getInput(66));
        mux6.addInput(and.getInput(5),or.getOutput(5),adder.getOutput(5), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(5),slt.getOutput(5),getInput(64),getInput(65),getInput(66));
        mux7.addInput(and.getInput(6),or.getOutput(6),adder.getOutput(6), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(6),slt.getOutput(6),getInput(64),getInput(65),getInput(66));
        mux8.addInput(and.getInput(7),or.getOutput(7),adder.getOutput(7), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(7),slt.getOutput(7),getInput(64),getInput(65),getInput(66));
        mux9.addInput(and.getInput(8),or.getOutput(8),adder.getOutput(8), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(8),slt.getOutput(8),getInput(64),getInput(65),getInput(66));
        mux10.addInput(and.getInput(9),or.getOutput(9),adder.getOutput(9), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(9),slt.getOutput(9),getInput(64),getInput(65),getInput(66));
        mux11.addInput(and.getInput(10),or.getOutput(10),adder.getOutput(10), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(10),slt.getOutput(10),getInput(64),getInput(65),getInput(66));
        mux12.addInput(and.getInput(11),or.getOutput(11),adder.getOutput(11), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(11),slt.getOutput(11),getInput(64),getInput(65),getInput(66));
        mux13.addInput(and.getInput(12),or.getOutput(12),adder.getOutput(12), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(12),slt.getOutput(12),getInput(64),getInput(65),getInput(66));
        mux14.addInput(and.getInput(13),or.getOutput(13),adder.getOutput(13), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(13),slt.getOutput(13),getInput(64),getInput(65),getInput(66));
        mux15.addInput(and.getInput(14),or.getOutput(14),adder.getOutput(14), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(14),slt.getOutput(14),getInput(64),getInput(65),getInput(66));
        mux16.addInput(and.getInput(15),or.getOutput(15),adder.getOutput(15), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(15),slt.getOutput(15),getInput(64),getInput(65),getInput(66));
        mux17.addInput(and.getInput(16),or.getOutput(16),adder.getOutput(16), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(16),slt.getOutput(16),getInput(64),getInput(65),getInput(66));
        mux18.addInput(and.getInput(17),or.getOutput(17),adder.getOutput(17), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(17),slt.getOutput(17),getInput(64),getInput(65),getInput(66));
        mux19.addInput(and.getInput(18),or.getOutput(18),adder.getOutput(18), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(18),slt.getOutput(18),getInput(64),getInput(65),getInput(66));
        mux20.addInput(and.getOutput(19),or.getOutput(19),adder.getOutput(19), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(19),slt.getOutput(19),getInput(64),getInput(65),getInput(66));
        mux21.addInput(and.getInput(20),or.getOutput(20),adder.getOutput(20), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(20),slt.getOutput(20),getInput(64),getInput(65),getInput(66));
        mux22.addInput(and.getInput(21),or.getOutput(21),adder.getOutput(21), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(21),slt.getOutput(21),getInput(64),getInput(65),getInput(66));
        mux23.addInput(and.getInput(22),or.getOutput(22),adder.getOutput(22), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(22),slt.getOutput(22),getInput(64),getInput(65),getInput(66));
        mux24.addInput(and.getInput(23),or.getOutput(23),adder.getOutput(23), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(23),slt.getOutput(23),getInput(64),getInput(65),getInput(66));
        mux25.addInput(and.getInput(24),or.getOutput(24),adder.getOutput(24), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(24),slt.getOutput(24),getInput(64),getInput(65),getInput(66));
        mux26.addInput(and.getInput(25),or.getOutput(25),adder.getOutput(25), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(25),slt.getOutput(25),getInput(64),getInput(65),getInput(66));
        mux27.addInput(and.getInput(26),or.getOutput(26),adder.getOutput(26), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(26),slt.getOutput(26),getInput(64),getInput(65),getInput(66));
        mux28.addInput(and.getInput(27),or.getOutput(27),adder.getOutput(27), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(27),slt.getOutput(27),getInput(64),getInput(65),getInput(66));
        mux29.addInput(and.getInput(28),or.getOutput(28),adder.getOutput(28), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(28),slt.getOutput(28),getInput(64),getInput(65),getInput(66));
        mux30.addInput(and.getInput(29),or.getOutput(29),adder.getOutput(29), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(29),slt.getOutput(29),getInput(64),getInput(65),getInput(66));
        mux31.addInput(and.getInput(30),or.getOutput(30),adder.getOutput(30), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(30),slt.getOutput(30),getInput(64),getInput(65),getInput(66));
        mux32.addInput(and.getInput(31),or.getOutput(31),adder.getOutput(31), Simulator.trueLogic,Simulator.trueLogic
                ,Simulator.trueLogic,sub.getOutput(31),slt.getOutput(31),getInput(64),getInput(65),getInput(66));



        addOutput(mux1.getOutput(0));
        addOutput(mux2.getOutput(0));
        addOutput(mux3.getOutput(0));
        addOutput(mux4.getOutput(0));
        addOutput(mux5.getOutput(0));
        addOutput(mux6.getOutput(0));
        addOutput(mux7.getOutput(0));
        addOutput(mux8.getOutput(0));
        addOutput(mux9.getOutput(0));
        addOutput(mux10.getOutput(0));
        addOutput(mux11.getOutput(0));
        addOutput(mux12.getOutput(0));
        addOutput(mux13.getOutput(0));
        addOutput(mux14.getOutput(0));
        addOutput(mux15.getOutput(0));
        addOutput(mux16.getOutput(0));
        addOutput(mux17.getOutput(0));
        addOutput(mux18.getOutput(0));
        addOutput(mux19.getOutput(0));
        addOutput(mux20.getOutput(0));
        addOutput(mux21.getOutput(0));
        addOutput(mux22.getOutput(0));
        addOutput(mux23.getOutput(0));
        addOutput(mux24.getOutput(0));
        addOutput(mux25.getOutput(0));
        addOutput(mux26.getOutput(0));
        addOutput(mux27.getOutput(0));
        addOutput(mux28.getOutput(0));
        addOutput(mux29.getOutput(0));
        addOutput(mux30.getOutput(0));
        addOutput(mux31.getOutput(0));
        addOutput(mux32.getOutput(0));

        Or orsub = new Or("Orsub",sub.getOutput(0),sub.getOutput(1),
                sub.getOutput(2),sub.getOutput(3),sub.getOutput(4),sub.getOutput(5),sub.getOutput(6),
                sub.getOutput(7),sub.getOutput(8),sub.getOutput(9),sub.getOutput(10),sub.getOutput(11),sub.getOutput(12),
                sub.getOutput(13),sub.getOutput(14),sub.getOutput(15),sub.getOutput(16),sub.getOutput(17),sub.getOutput(18),
                sub.getOutput(19),sub.getOutput(20),sub.getOutput(21),sub.getOutput(22),sub.getOutput(23),sub.getOutput(24),
                sub.getOutput(25),sub.getOutput(26),sub.getOutput(27),sub.getOutput(28),sub.getOutput(29),sub.getOutput(30),
                sub.getOutput(31));
        Mux2x1 mux2x1 = new Mux2x1("Mux2x1" , "3X1");
        mux2x1.addInput(Simulator.trueLogic);
        mux2x1.addInput(Simulator.falseLogic);
        mux2x1.addInput(orsub.getOutput(0));

        addOutput(mux2x1.getOutput(0)); //zero



    }
}
