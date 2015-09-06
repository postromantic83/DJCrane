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

    public int getK439A (){return sect_K439A.getValue();}
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

        BoxLayout layout = new BoxLayout(panControl,BoxLayout.PAGE_AXIS);

//        FlowLayout layout=new FlowLayout(FlowLayout.LEFT);


        panControl.setLayout(layout);


    }


    @Override
    public void setControl (TowerCrane crane) {

       //NEW INIVERSAL PANEL ADDING:

        sect_K439A = new ButtonPanelView("K439A",this);
        sect_K437A = new ButtonPanelView("K437A",this);
        sect_K437C = new ButtonPanelView("K437C",this);




        addButton(sect_K439A);
        addButton(sect_K437A);

        for(int i=0; i<20;i++)
        addButton(new ButtonPanelView("K437C",this));



    }
    private void addButton (ButtonPanelView buttonPanelView){

        buttonPanelView.addObserver(this);
        panControl.add(buttonPanelView.getButtonPanel());

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
        if (o==sect_K437A) System.out.println((Integer)arg);
//        if (o==sect_K439C) System.out.println((Integer)arg);



        //TODO setTower();
    }
}
