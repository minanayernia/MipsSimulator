package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class multiplexer8x1 extends Wrapper {
    public multiplexer8x1(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        //first 8 input then 3 selector
        Not not1 = new Not("NOT1");
        Not not2 = new Not("NOT2");
        Not not3 = new Not("NOT3");
       /* not1.addInput(getInput(8)); //selector 0
        not2.addInput(getInput(9)); //selector 1
        not3.addInput(getInput(10)); //selector 2*/
        And and1 =new And("AND1");
        And and2 =new And("AND2");
        And and3 =new And("AND3");
        And and4 =new And("AND4");
        And and5 =new And("AND5");
        And and6 =new And("AND6");
        And and7 =new And("AND7");
        And and8 =new And("AND8");
        not1.addInput(getInput(8)); //selector 0
        not2.addInput(getInput(9)); //selector 1
        not3.addInput(getInput(10)); //selector 2
        and1.addInput(getInput(0),not1.getOutput(0),not2.getOutput(0),not3.getOutput(0));
        and2.addInput(getInput(1),not1.getOutput(0),not2.getOutput(0),getInput(10));
        and3.addInput(getInput(2),not1.getOutput(0),getInput(9),not3.getOutput(0));
        and4.addInput(getInput(3),not1.getOutput(0),getInput(9),getInput(10));
        and5.addInput(getInput(4),getInput(8),not2.getOutput(0),not3.getOutput(0));
        and6.addInput(getInput(5),getInput(8),not2.getOutput(0),getInput(10));
        and7.addInput(getInput(6),getInput(8),getInput(9),not3.getOutput(0));
        and8.addInput(getInput(7),getInput(8),getInput(9),getInput(10));
        Or or = new Or("OR1");
        or.addInput(and1.getOutput(0),and2.getOutput(0),and3.getOutput(0),and4.getOutput(0),
                and5.getOutput(0),and6.getOutput(0),and7.getOutput(0),and8.getOutput(0));

        addOutput(or.getOutput(0));




    }
}
