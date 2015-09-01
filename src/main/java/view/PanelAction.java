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


    private CraneComboboxPanel craneComboboxPanel;
    private TowerCrane crane;
    private CranePanel cranePanel;

    public PanelAction(CraneComboboxPanel craneComboboxPanel, CranePanel cranePanel) {


        this.craneComboboxPanel = craneComboboxPanel;
        this.cranePanel = cranePanel;

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();


            //set customer
            if (src == craneComboboxPanel.comb1) {

                if (craneComboboxPanel.comb1.getSelectedItem() == "Liebherr") {

                crane = new LiebherrCrane(craneComboboxPanel);

            } else if (craneComboboxPanel.comb1.getSelectedItem() == "Potain") {

                crane = new PotainCrane(craneComboboxPanel);

            } else if (craneComboboxPanel.comb1.getSelectedItem() == "Everdigm") {

                crane = new EverdigmCrane(craneComboboxPanel);

            }
            //clean and fill comb3 from crane class
            craneComboboxPanel.comb2.removeAllItems();
            craneComboboxPanel.setComb2((String) craneComboboxPanel.comb1.getSelectedItem());

        }


        //set model
        if (src == craneComboboxPanel.comb2) {


            //clean and fill comb3 from crane class
            craneComboboxPanel.comb3.removeAllItems();
            craneComboboxPanel.setComb3((String) craneComboboxPanel.comb2.getSelectedItem());
            crane.setModel((String) craneComboboxPanel.comb2.getSelectedItem());


            crane.createControl(crane, cranePanel);


        }


    }

    public TowerCrane getCrane () {return crane;}

    }

