package AluInstruction;

import simulator.gates.combinational.And;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class AndInst extends Wrapper {
    public AndInst(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And and1 = new And("AND1");
        And and2 = new And("AND2");
        And and3 = new And("AND3");
        And and4 = new And("AND4");
        And and5 = new And("AND5");
        And and6 = new And("AND6");
        And and7 = new And("AND7");
        And and8 = new And("AND8");
        And and9 = new And("AND9");
        And and10 = new And("AND10");
        And and11 = new And("AND11");
        And and12 = new And("AND12");
        And and13 = new And("AND13");
        And and14 = new And("AND14");
        And and15 = new And("AND15");
        And and16 = new And("AND16");
        And and17 = new And("AND17");
        And and18 = new And("AND18");
        And and19 = new And("AND19");
        And and20 = new And("AND20");
        And and21 = new And("AND21");
        And and22 = new And("AND22");
        And and23 = new And("AND23");
        And and24 = new And("AND24");
        And and25 = new And("AND25");
        And and26 = new And("AND26");
        And and27 = new And("AND27");
        And and28 = new And("AND28");
        And and29 = new And("AND29");
        And and30 = new And("AND30");
        And and31 = new And("AND31");
        And and32 = new And("AND32");
        and1.addInput(getInput(0),getInput(32));
        and2.addInput(getInput(1),getInput(33));
        and3.addInput(getInput(2),getInput(34));
        and4.addInput(getInput(3),getInput(35));
        and5.addInput(getInput(4),getInput(36));
        and6.addInput(getInput(5),getInput(37));
        and7.addInput(getInput(6),getInput(38));
        and8.addInput(getInput(7),getInput(39));
        and9.addInput(getInput(8),getInput(40));
        and10.addInput(getInput(9),getInput(41));
        and11.addInput(getInput(10),getInput(42));
        and12.addInput(getInput(11),getInput(43));
        and13.addInput(getInput(12),getInput(44));
        and14.addInput(getInput(13),getInput(45));
        and15.addInput(getInput(14),getInput(46));
        and16.addInput(getInput(15),getInput(47));
        and17.addInput(getInput(16),getInput(48));
        and18.addInput(getInput(17),getInput(49));
        and19.addInput(getInput(18),getInput(50));
        and20.addInput(getInput(19),getInput(51));
        and21.addInput(getInput(20),getInput(52));
        and22.addInput(getInput(21),getInput(53));
        and23.addInput(getInput(22),getInput(54));
        and24.addInput(getInput(23),getInput(55));
        and25.addInput(getInput(24),getInput(56));
        and26.addInput(getInput(25),getInput(57));
        and27.addInput(getInput(26),getInput(58));
        and28.addInput(getInput(27),getInput(59));
        and29.addInput(getInput(28),getInput(60));
        and30.addInput(getInput(29),getInput(61));
        and31.addInput(getInput(30),getInput(62));
        and32.addInput(getInput(31),getInput(63));
        addOutput(and1.getOutput(0));
        addOutput(and2.getOutput(0));
        addOutput(and3.getOutput(0));
        addOutput(and4.getOutput(0));
        addOutput(and5.getOutput(0));
        addOutput(and6.getOutput(0));
        addOutput(and7.getOutput(0));
        addOutput(and8.getOutput(0));
        addOutput(and9.getOutput(0));
        addOutput(and10.getOutput(0));
        addOutput(and11.getOutput(0));
        addOutput(and12.getOutput(0));
        addOutput(and13.getOutput(0));
        addOutput(and14.getOutput(0));
        addOutput(and15.getOutput(0));
        addOutput(and16.getOutput(0));
        addOutput(and17.getOutput(0));
        addOutput(and18.getOutput(0));
        addOutput(and19.getOutput(0));
        addOutput(and20.getOutput(0));
        addOutput(and21.getOutput(0));
        addOutput(and22.getOutput(0));
        addOutput(and23.getOutput(0));
        addOutput(and24.getOutput(0));
        addOutput(and25.getOutput(0));
        addOutput(and26.getOutput(0));
        addOutput(and27.getOutput(0));
        addOutput(and28.getOutput(0));
        addOutput(and29.getOutput(0));
        addOutput(and30.getOutput(0));
        addOutput(and31.getOutput(0));
        addOutput(and32.getOutput(0));

    }
}
