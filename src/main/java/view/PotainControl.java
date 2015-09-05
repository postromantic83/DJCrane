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
    private JPanel panControl = new JPanel();

    private ButtonPanelView sect_K439A;
    private ButtonPanelView sect_K437A;
    private ButtonPanelView sect_K437C;

    public int getK439A (){
        return sect_K439A.getTextFieldValue();
    }

    public int getK437C(){
        return sect_K437A.getTextFieldValue();
    }



    public JPanel getControlPanel(){return panControl;}

    public PotainControl(TowerCrane crane, CranePanel cranePanel) {
        this.crane = crane;
        this.cranePanel = cranePanel;

    }


    @Override
    public void setControl (TowerCrane crane) {



                    //NEW INIVERSAL PANEL ADDING:

        sect_K439A = new ButtonPanelView("K439A");
        sect_K437A = new ButtonPanelView("K437A");
        sect_K437C = new ButtonPanelView("K437C");

        sect_K439A.addObserver(this);
        sect_K437A.addObserver(this);
        sect_K437C.addObserver(this);

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
    }
}
