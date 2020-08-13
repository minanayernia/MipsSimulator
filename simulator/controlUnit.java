package simulator;

import simulator.gates.combinational.And;
import simulator.gates.combinational.Not;
import simulator.gates.combinational.Or;
import simulator.network.Link;
import simulator.wrapper.Wrapper;

public class controlUnit extends Wrapper {

    public controlUnit(String label, String stream, Link... links) {
        super(label, stream, links);
    }

    @Override
    public void initialize() {
        And and1 = new And("and1") ;
        And and2 = new And("and2") ;
        And and3 = new And("and3") ;
        And and4 = new And("and4") ;
        And and5 = new And("and5") ;
        And and6 = new And("and6") ;
        Or or1 = new Or("or1") ;
        Or or2 = new Or("or2") ;
        Or or3 = new Or("or3") ;
        Or or4 = new Or("or4") ;
        Not not1 = new Not("not1") ;
        Not not2 = new Not("not2") ;
        Not not3 = new Not("not3") ;
        Not not4 = new Not("not4") ;
        Not not5 = new Not("not5") ;
        Not not6 = new Not("not6") ;
        not1.addInput(getInput(0));
        not2.addInput(getInput(1));
        not3.addInput(getInput(2));
        not4.addInput(getInput(3));
        not5.addInput(getInput(4));
        not6.addInput(getInput(5));
        and1.addInput(not1.getOutput(0) , not2.getOutput(0) , not3.getOutput(0) , not4.getOutput(0) , not5.getOutput(0) , not6.getOutput(0)); // r-format
        and2.addInput(getInput(0) , not2.getOutput(0) , not3.getOutput(0) , not4.getOutput(0) , getInput(4) , getInput(5)); //lw
        and3.addInput(getInput(0) , not2.getOutput(0) , getInput(2) , not4.getOutput(0) , getInput(4) , getInput(5)); //sw
        and4.addInput(not1.getOutput(0) , not2.getOutput(0) , not3.getOutput(0) , getInput(3) , not5.getOutput(0) , not6.getOutput(0)); //beq
        and5.addInput(not1.getOutput(0) , not2.getOutput(0) , not3.getOutput(0) , not4.getOutput(0) , getInput(4) , not6.getOutput(0)); //j
        and6.addInput(not1.getOutput(0) , not2.getOutput(0) , getInput(2) , not4.getOutput(0) , not5.getOutput(0) , not6.getOutput(0));
        or1.addInput(and2.getOutput(0) , and3.getOutput(0));
        or3.addInput(or1.getOutput(0) , and6.getOutput(0)); //ALU src
        or2.addInput(and1.getOutput(0) , and2.getOutput(0));
        or4.addInput(or2.getOutput(0) , and6.getOutput(0)); //reg write
        addOutput(and1.getOutput(0) , or3.getOutput(0) , and2.getOutput(0) , or4.getOutput(0) , and2.getOutput(0) , and3.getOutput(0) , and4.getOutput(0) , and1.getOutput(0) , and4.getOutput(0) , and5.getOutput(0));
        //regdst-ALUsrc-memtoreg-regwrite-memread-memwrite-branch-ALUop1-ALUop0-jump
    }

}
