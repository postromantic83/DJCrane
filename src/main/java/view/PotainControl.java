package view;

import controller.TowerCrane;
import unipanel.ButtonPanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class PotainControl extends ControlPanel implements Observer {

    private TowerCrane crane;
    private CranePanel cranePanel;
    public JPanel panControl;

    private ButtonPanelView sect_K439A;
    private ButtonPanelView sect_K437A;
    private ButtonPanelView sect_K437C;

    public int getK439A (){
        return sect_K439A.getValue();
    }

    public int getK437A(){
        return sect_K437A.getValue();
    }

    public int getK437C(){
        return sect_K437C.getValue();
    }



    public JPanel getControlPanel(){return panControl;}

    public PotainControl(TowerCrane crane, CranePanel cranePanel) {
        this.crane = crane;
        this.cranePanel = cranePanel;
        panControl = new JPanel();

        panControl.setLayout(new BoxLayout(panControl, BoxLayout.Y_AXIS));

    }


    @Override
    public void setControl (TowerCrane crane) {

       //NEW INIVERSAL PANEL ADDING:

        sect_K439A = new ButtonPanelView("K439A",this);
        sect_K437A = new ButtonPanelView("K437A",this);
        sect_K437C = new ButtonPanelView("K437C",this);

       /* sect_K439A.addObserver(this);
        sect_K437A.addObserver(this);
        sect_K437C.addObserver(this);*/
/*
        panControl.add(sect_K439A.getButtonPanel());
        panControl.add(sect_K437A.getButtonPanel());
        panControl.add(sect_K437C.getButtonPanel());*/

    }
    private void setTower(){

        crane = crane.setConcreteTowerCrane(this);
        crane.makeTower();


        cranePanel.mp1.setCollection(crane.getTower());
        cranePanel.mp1.repaint();


        cranePanel.hHeader1.setText(Double.toString(crane.getHeight()));
        cranePanel.hHeader2.setText(Double.toString(crane.getHeightUnderJib(crane.getHeight())));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o==sect_K439A) System.out.println((Integer)arg);



        //TODO setTower();
    }
}
