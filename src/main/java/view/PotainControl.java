package view;

import controller.TowerCrane;
import model.Section;
import unipanel.ButtonPanelView;
import unipanel.UpDownButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PotainControl extends ControlPanel implements Observer {

    private TowerCrane crane;
    private CranePanel cranePanel;
    public JPanel panControl;

    private ButtonPanelView sect_K439A;
    private ButtonPanelView sect_K437A;
    private ButtonPanelView sect_K437C;

    private ButtonPanelView sect_SR26E;
    private ButtonPanelView sect_SR24E;
    private ButtonPanelView sect_S24E;
    private ButtonPanelView sect_S24A;
    private ButtonPanelView sect_S20S20;




    private UpDownButtonPanel updownPanel;
    private GridBagLayout layout;
    private GridBagConstraints gridBagConstraints;

    public int getK439A (){return sect_K439A.getValue();}
    public int getK437A(){return sect_K437A.getValue();    }
    public int getK437C(){return sect_K437C.getValue();    }

    public int getS20S20(){return sect_S20S20.getValue();}
    public int getS24A(){return sect_S24A.getValue();}
    public int getS24E(){return sect_S24E.getValue();}
    public int getSR24E(){return sect_SR26E.getValue();}
    public int getSR26E(){return sect_SR26E.getValue();}


    public JPanel getControlPanel(){return panControl;}

    public PotainControl(TowerCrane crane, CranePanel cranePanel) {
        this.crane = crane;
        this.cranePanel = cranePanel;
        panControl = new JPanel();

        layout =new GridBagLayout();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor=GridBagConstraints.EAST;
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=GridBagConstraints.RELATIVE;
        //gridBagConstraints.gridwidth = 200;


    }


    @Override
    public void setControl (TowerCrane crane) {

        if (crane.getModel()=="Potain MDT-178" | crane.getModel()=="Potain MDT-218") {
            sect_K439A = new ButtonPanelView("K439A", this);
            sect_K437A = new ButtonPanelView("K437A", this);
            sect_K437C = new ButtonPanelView("K437C", this);

            addButton(sect_K439A);
            addButton(sect_K437A);
            addButton(sect_K437C);
        }
        if (crane.getModel()=="Potain MCT-88" | crane.getModel()=="Potain MC-85B") {
            sect_S20S20 = new ButtonPanelView("S20/S20 1.5m", this);
            sect_S24A = new ButtonPanelView("S24A 3.0m", this);
            sect_S24E = new ButtonPanelView("S24E 10.5m 40/40", this);
            sect_SR24E = new ButtonPanelView("S24E 10.5m 40/40", this);
            sect_SR26E = new ButtonPanelView("SR26E 10.5m 50/50",this);

            addButton(sect_S20S20);
            addButton(sect_S24A);
            addButton(sect_S24E);
            addButton(sect_SR24E);
            addButton(sect_SR26E);
        }

            updownPanel = new UpDownButtonPanel(this);
            addUniButtonPanel(updownPanel);

    }
    private void addButton (ButtonPanelView buttonPanelView){

        layout.setConstraints(buttonPanelView.getButtonPanel(), gridBagConstraints);
        panControl.setLayout(layout);
        panControl.add(buttonPanelView.getButtonPanel());

        buttonPanelView.addObserver(this);

    }

    private void addUniButtonPanel(UpDownButtonPanel upDownButtonPanel){
        layout.setConstraints(upDownButtonPanel.getUpDownButtonPanel(), gridBagConstraints);
        panControl.setLayout(layout);
        panControl.add(upDownButtonPanel.getUpDownButtonPanel());
        upDownButtonPanel.addObserver(this);

    }



    private void setTower(){

        crane = crane.setConcreteTowerCrane(this);
        crane.makeTower();


/*        cranePanel.visioPanel.setCollection(crane.getTower());
        cranePanel.visioPanel.repaint();


        cranePanel.hHeader1.setText(Double.toString(crane.getHeight()));
        cranePanel.hHeader2.setText(Double.toString(crane.getHeightUnderJib(crane.getHeight())));*/
    }

    @Override
    public void update(Observable o, Object arg) {

        if (o==updownPanel & updownPanel.isUpButtonPressed())
            if (crane.getModel()=="Potain MDT-178" | crane.getModel()=="Potain MDT-218") towerUp_MDT();
                else towerUp_MCT();
        if (o==updownPanel & !updownPanel.isUpButtonPressed())
            if (crane.getModel()=="Potain MDT-178" | crane.getModel()=="Potain MDT-218") towerDown_MDT();
                else towerDown_MCT();

        makeTowerCollection();
        visioRedraw();

    }





    private void towerUp_MDT(){
    if (sect_K437A.getValue()<8) sect_K437A.increasing();
        else if(sect_K439A.getValue()==0)sect_K439A.increasing();
            else if(sect_K439A.getValue()==1 & sect_K437A.getValue()<9 &sect_K437C.getValue()==0)sect_K437A.increasing();
                else if (sect_K439A.getValue()==1 & sect_K437A.getValue()==9 & sect_K437C.getValue()==0) {sect_K437A.decreasing();sect_K437C.increasing();sect_K437C.increasing();}
    }

    private void towerUp_MCT(){
        if (sect_SR26E.getValue()==0) sect_SR26E.increasing();
            else if (sect_SR24E.getValue()==0) sect_SR24E.increasing();
                else if (sect_S24E.getValue()==0)sect_S24E.increasing();
                    else if (sect_SR26E.getValue()==1)sect_SR26E.increasing();
                        else if (sect_S24A.getValue()<2)sect_S24A.increasing();
                            else if (sect_S20S20.getValue()==0)sect_S20S20.increasing();

    }

    private void towerDown_MDT(){
        if (sect_K437C.getValue()>0) sect_K437C.decreasing();
            else if((sect_K439A.getValue()>0) & (sect_K439A.getValue()>=1)) sect_K439A.decreasing();
                else if(sect_K437A.getValue()>0)sect_K437A.decreasing();

    }
    private void towerDown_MCT(){
        if(sect_S20S20.getValue()>0)sect_S20S20.decreasing();
            else if(sect_S24A.getValue()>0)sect_S24A.decreasing();
                else if(sect_S24E.getValue()>0)sect_S24E.decreasing();
                    else if(sect_SR24E.getValue()>0)sect_SR24E.decreasing();
                        else if(sect_SR26E.getValue()>0)sect_SR26E.decreasing();

    }
    private ArrayList towerCollection = new ArrayList();

    private int indexCollection;
    private void makeTowerCollection (){
        indexCollection=0;
        towerCollection.clear();
        addSectionElement(sect_K439A);
        addSectionElement(sect_K437A);
        addSectionElement(sect_K437C);



    }
    private void visioRedraw(){
        cranePanel.visioPanel.setCollection(towerCollection);
        cranePanel.visioPanel.repaint();

    }


    private void addSectionElement (ButtonPanelView element){
        for (int i=1;i<=element.getValue();i++) {
            towerCollection.add(new Section(element.getName(), indexCollection));
            indexCollection++;
        }
    }


}
