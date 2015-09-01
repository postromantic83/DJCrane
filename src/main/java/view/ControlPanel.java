package view;

import controller.TowerCrane;

import javax.swing.*;

/**
 * Created by sokolov on 16.02.2015.
 *
 * SRP: factory of controlled params
 *
 * change request: adding new getters
 *
 */
public class ControlPanel extends JPanel {

   private TowerCrane crane;

    ControlPanel (){


    }

    @Override
    public String toString() {
        return "CONTROL_PANEL";
    }

    public  void setControl(TowerCrane crane) {



    };

 public JPanel getControlPanel(){return null;}

    //getters for sections
    public int getS120HC_25 (){ return 0;}
    public int getS120HC_50 (){ return 0;}
    public int getS154HC_168 (){ return 0;}
    public int getS154HC_1616 (){ return 0;}
    public int getS120HC_125() {return 0;}
    public int getS132HC_168() {return 0;}





}
