package View;

import Contrl.Crane;

import javax.swing.*;

/**
 * Created by sokolov on 16.02.2015.
 */
public class ControlPanel extends JPanel {

   private Crane crane;

    ControlPanel (){


    }

    @Override
    public String toString() {
        return "CONTROL_PANEL";
    }

    public  void setControl(ControlPanel lp) {

        System.out.println("CONTROL_PANEL setControl - method!");

    };

    //getters for sections
    public int getS120HC_25 (){ return 0;}
    public int getS120HC_50 (){ return 0;}
    public int getS154HC_168 (){ return 0;}
    public int getS154HC_1616 (){ return 0;}
    public int getS120HC_125() {return 0;}
    public int getS132HC_168() {return 0;}





}
