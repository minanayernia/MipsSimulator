//Dedicated to Goli

package simulator;

import simulator.control.Simulator;
import simulator.gates.combinational.And;
import simulator.gates.combinational.ByteMemory;
import simulator.gates.sequential.BigClock;
import simulator.gates.sequential.Clock;
import simulator.network.Link;
import simulator.network.Linkable;
import simulator.wrapper.wrappers.*;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Sample {
    public static void main(String[] args) {

       // MIPS
        BigClock clock = new BigClock("clock") ;
//        Clock clock = new Clock("clock", 2000) ;
//        DFlipFlop shift0 = new DFlipFlop("SHIFT0", "2X2", clock.getOutput(0), Simulator.falseLogic);
//        DFlipFlop shift1 = new DFlipFlop("SHIFT1", "2X2", clock.getOutput(0), shift0.getOutput(0));
        DFlipFlop shift1 = new DFlipFlop("shift1" , "2x2" , Simulator.trueLogic , clock.getOutput(0)) ;
////
        InstructionMemory InstMem = new InstructionMemory("instmem" , "49x32") ;
        controlUnit control = new controlUnit("control" , "6x10") ;
        AluControl alucontrol = new AluControl("alucontrol" , "8x3") ;

        RegisterFile regfile = new RegisterFile("regfile" , "49x64") ;
        Alu alu = new Alu("ALU","67X33");
        DataMemory dataMemory = new DataMemory("DATAMEMORY","49X32");
        Multiplexer[] MemToReg = new Multiplexer[32];
        Multiplexer[] chooseJumpOrMux = new Multiplexer[32] ;
        Multiplexer[] AluSrc = new Multiplexer[32];
        Multiplexer[] choosePcOrALU = new Multiplexer[32] ;
        signExtend signextend = new signExtend("signextend" , "16x32") ;
        shiftLeft32Bit shiftleft32 = new shiftLeft32Bit("shiftleft32" ,"32x32") ;


        DFlipFlop[] PC = new DFlipFlop[32];

        for (int i = 0; i < 32; ++i) {
            PC[i] = new DFlipFlop("D" + i, "2X2", clock.getOutput(0));
        }

        Link[] counterInit = new Link[32];
        for (int i = 0; i < 32; ++i) {
            counterInit[i] = Simulator.falseLogic;
        }
//
//
        Adder adder1 = new Adder("ADDER1", "64X33");
        for (int i =0; i < 32; ++i) {
            adder1.addInput(PC[i].getOutput(0));
        }
        Link[] four = new Link[32];
        for (int i =0; i < 29; ++i) {
            four[i] = Simulator.falseLogic;
        }
        four[29] = Simulator.trueLogic;
        four[30] = Simulator.falseLogic;
        four[31] = Simulator.falseLogic;

        adder1.addInput(four);

        //multiplexer for choosing between jump address & res of another multi
        for(int i =0 ; i < 32 ; i++){
            chooseJumpOrMux[i] = new Multiplexer("MuxJump"+i,"3X1");
        }
//
        Multiplexer[] PCSelect = new Multiplexer[32];
        for (int i =0; i < 32; ++i) {
            PCSelect[i] = new Multiplexer("M" + i, "3X1",
                    shift1.getOutput(0), chooseJumpOrMux[i].getOutput(0), counterInit[i]);
        }
        for (int i =0; i < 32; ++i) {
            PC[i].addInput(PCSelect[i].getOutput(0));
        }
//         input for instruction memory (address) = PC
        InstMem.addInput(Simulator.falseLogic);
        for(int i = 0 ; i < 16  ; i++){
            InstMem.addInput(PC[i+16].getOutput(0)) ;

        }


        for(int i = 0 ; i < 32 ; i++){
            InstMem.addInput(Simulator.falseLogic);
        }




//        // sign extend [0-15]
        for(int i = 0 ; i < 16 ; i++){
            signextend.addInput(InstMem.getOutput(i)) ;
        }

        // out put sign extend for input shift left 32 bit
        for(int i = 0  ; i < 32 ; i++){
            shiftleft32.addInput(signextend.getOutput(i));
        }


//        // shift left [0-25]
        shiftLeft shiftleft1 = new shiftLeft("shiftleft1" , "26x28") ;
        for(int i = 0 ; i < 26 ; i++){
            shiftleft1.addInput(InstMem.getOutput(i)) ;
        }
//        // control unit
        for(int i = 26 ; i < 32 ; i++){
            control.addInput(InstMem.getOutput(i)) ;
        }

        // input for alu control instruction[0-5]
        for(int i = 0 ; i < 6 ; i++){
            alucontrol.addInput(InstMem.getOutput(i));
        }
        alucontrol.addInput(control.getOutput(8)) ; //aluOp[0]
        alucontrol.addInput(control.getOutput(7)) ; //aluOp[1]

        // jump address = adder1[0-3] + shift left 1 [0-27]
        Link[] jumpAddress = new Link[32] ;
        jumpAddress[0] = adder1.getOutput(1) ;
        jumpAddress[1] = adder1.getOutput(2) ;
        jumpAddress[2] = adder1.getOutput(3) ;
        jumpAddress[3] = adder1.getOutput(4) ;

        for(int i = 4 ,j = 0 ; i < 32 ; i++ , j++){
            jumpAddress[i] = shiftleft1.getOutput(j);
        }


//         input for register file for register 1 address
        for(int i = 21 ; i < 26 ; i++){
            regfile.addInput(InstMem.getOutput(i)) ;
        }
        // input for register file for register 2 address
        for(int i = 16 ; i < 21 ; i++){
            regfile.addInput(InstMem.getOutput(i));
        }


        //input of mux that goes into write reg for register file

        Multiplexer mux2x1_1 = new Multiplexer("mux2x1_1" , "3x1") ;
        Multiplexer mux2x1_2 = new Multiplexer("mux2x1_2" , "3x1") ;
        Multiplexer mux2x1_3 = new Multiplexer("mux2x1_3" , "3x1") ;
        Multiplexer mux2x1_4 = new Multiplexer("mux2x1_4" , "3x1") ;
        Multiplexer mux2x1_5 = new Multiplexer("mux2x1_5" , "3x1") ;


        //adder 2 for pc + 4 and shif lest 32 bit
        Adder adder2 = new Adder("adder2" , "64x33") ;
        for(int i = 1 ; i < 33 ; i++){
            adder2.addInput(adder1.getOutput(i));
        }
        for(int i = 0 ; i < 32 ; i++){
            adder2.addInput(shiftleft32.getOutput(i));
        }




        mux2x1_1.addInput(control.getInput(0) , InstMem.getOutput(16) , InstMem.getOutput(11));
        mux2x1_2.addInput(control.getInput(0) , InstMem.getOutput(17) , InstMem.getOutput(12));
        mux2x1_3.addInput(control.getInput(0) , InstMem.getOutput(18) , InstMem.getOutput(13));
        mux2x1_4.addInput(control.getInput(0) , InstMem.getOutput(19) , InstMem.getOutput(14));
        mux2x1_5.addInput(control.getInput(0) , InstMem.getOutput(20) , InstMem.getOutput(15));



        //input register file (write reg)
        regfile.addInput(
                mux2x1_1.getOutput(0) ,
                mux2x1_2.getOutput(0) ,
                mux2x1_3.getOutput(0) ,
                mux2x1_4.getOutput(0) ,
                mux2x1_5.getOutput(0)
        );

        //multilpexer between dataMemory output and alu result
        for (int i =0; i < 32; ++i) {  //select memToreg
            MemToReg[i] = new Multiplexer("Mux" + i, "3X1",
                    control.getOutput(2), alu.getOutput(i),dataMemory.getOutput(i));
        }

        //write data or 0 for register file
        Multiplexer[] data0select = new Multiplexer[32] ;
        for (int i = 0 ; i < 32 ; i++){
            data0select[i] = new Multiplexer("MUX"+i , "3x1",control.getOutput(3),Simulator.falseLogic,MemToReg[i].getOutput(0));
        }

        // write data for register file
        for(int i = 0 ; i < 32 ; i++){
            regfile.addInput(data0select[i].getOutput(0));
        }
        // reg write for register file
        regfile.addInput(control.getOutput(3));
        // clock for register file
        regfile.addInput(clock.getOutput(0));




        //multiplexer between signextend and ergfile
        for (int i =0; i < 32; ++i) {
            AluSrc[i] = new Multiplexer("MUX" + i, "3X1",
                     control.getOutput(1),regfile.getOutput(i + 32), signextend.getOutput(i));
        }

        //alu
        for(int i =0 ; i < 32 ; i++){       //first input alu from  first regfile
            alu.addInput(regfile.getOutput(i));
        }
        for(int i =0 ; i < 32 ; ++i){       //second input alu from multiplexer (signextend and regfile)
            alu.addInput(AluSrc[i].getOutput(0));
        }
        alu.addInput(alucontrol.getOutput(0));
        alu.addInput(alucontrol.getOutput(1));
        alu.addInput(alucontrol.getOutput(2));

        //Data memory
        dataMemory.addInput(control.getOutput(5));  //memwrite
        for(int i =0 ; i < 16 ; i++){  //address
            dataMemory.addInput(alu.getOutput(i));
        }
        for(int i =32 ; i < 64 ; i++){    //write data (second output from regfile)
            dataMemory.addInput(regfile.getOutput(i));
        }


        // multiplexer for choosing between PC + 4 & ALU result
        And and = new And("And",control.getOutput(6),alu.getOutput(32)); //and (branch , zero)
        for(int i =0  , j = 1; i < 32 ; i++ , j++){
            choosePcOrALU[i] = new Multiplexer("muxPc"+i ,"3X1",and.getOutput(0), adder1.getOutput(j),adder2.getOutput(j));
        }

        //multiplexer for choosing between jump address & res of another multi
        for(int i =0 ; i < 32 ; i++){
            chooseJumpOrMux[i].addInput(control.getOutput(9),choosePcOrALU[i].getOutput(0),jumpAddress[i]);
        }


        Simulator.debugger.addTrackItem(clock , InstMem , signextend , shiftleft1 , alucontrol , shiftleft32 , regfile , control , adder1 , alu , dataMemory ,

                data0select[0] ,
                data0select[1] ,
                data0select[2] ,
                data0select[3] ,
                data0select[4] ,
                data0select[5] ,
                data0select[6] ,
                data0select[7] ,
                data0select[8] ,
                data0select[9] ,
                data0select[10] ,
                data0select[11] ,
                data0select[12] ,
                data0select[13] ,
                data0select[14] ,
                data0select[15] ,
                data0select[16] ,
                data0select[17] ,
                data0select[18] ,
                data0select[19] ,
                data0select[20] ,
                data0select[21] ,
                data0select[22] ,
                data0select[23] ,
                data0select[24] ,
                data0select[25] ,
                data0select[26] ,
                data0select[27] ,
                data0select[28] ,
                data0select[29] ,
                data0select[30] ,
                data0select[31]
                );
        Simulator.debugger.addTrackItem(InstMem);

        Simulator.debugger.setDelay(0);

        Simulator.circuit.startCircuit(4);
    }
}