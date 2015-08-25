package view;

import controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sokolov on 03.02.2015.
 *
 * SRP: abstract factory for crane
 *
 * change request: adding new crane producer
 *
 */
public class PanelAction implements ActionListener {

    private CranePanel cranePanel;
    private TowerCrane crane;
//    private JPanel panControl;
    private ControlPanel controlPanel;

    public PanelAction(CraneComboboxPanel cranePanel, ControlPanel controlPanel) {


        this.cranePanel = cranePanel;
        this.controlPanel = controlPanel;



    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();

               //set customer
       if (src==cranePanel.comb1) {

           if (cranePanel.comb1.getSelectedItem() == "Liebherr") {

               crane = new LiebherrCrane(cranePanel);

               }
           else if (cranePanel.comb1.getSelectedItem() == "Potain") {

               crane = new PotainCrane(cranePanel);

           }
           else if (cranePanel.comb1.getSelectedItem() == "Everdigm") {

               crane = new EverdigmCrane(cranePanel);

           }
           //clean and fill comb3 from crane class
           cranePanel.comb2.removeAllItems();
           cranePanel.setComb2((String) cranePanel.comb1.getSelectedItem());
//           cranePanel.setComb2(crane.getAvailableModels());
           }





        //set model
        if (src==cranePanel.comb2){




            //clean and fill comb3 from crane class
            cranePanel.comb3.removeAllItems();
            cranePanel.setComb3((String) cranePanel.comb2.getSelectedItem());
            crane.setModel((String) cranePanel.comb2.getSelectedItem());
            crane.createControl(cranePanel, crane);



            }



//        prepareCrane();

        }

        public void prepareCrane (){

        }


    }

