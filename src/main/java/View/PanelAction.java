package View;

import Contrl.Crane;
import Contrl.EverdigmCrane;
import Contrl.LiebherrCrane;
import Contrl.PotainCrane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sokolov on 03.02.2015.
 *
 *
 *
 */
public class PanelAction implements ActionListener {

    CranePanel cranePanel;
    Crane crane;
    JPanel panControl;
    ControlPanel controlPanel;

    public PanelAction(CranePanel cranePanel, ControlPanel controlPanel) {

        System.out.println ("PanelAction - constr: " + controlPanel.toString());
        this.cranePanel = cranePanel;
        this.controlPanel = controlPanel;

        System.out.println("this.controlPanel: : " + this.controlPanel.toString());

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();
        int val1;



        System.out.println("controlPanel: " + controlPanel.toString());



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
           cranePanel.setComb2(crane.getAvailableModels());
           }






        if (src==cranePanel.comb2){




            //clean and fill comb3 from crane class
            cranePanel.comb3.removeAllItems();
            cranePanel.setComb3(crane.getAvailableModifications((String) cranePanel.comb2.getSelectedItem()));
            crane.setModel((String) cranePanel.comb2.getSelectedItem());
            crane.createControl(cranePanel, crane);



            }



        prepareCrane();

        }

        public void prepareCrane (){


            System.out.println("setTowerCombination method!");


        }


    }

