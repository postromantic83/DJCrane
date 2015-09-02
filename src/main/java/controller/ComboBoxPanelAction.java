package controller;

import controller.*;
import view.CraneComboboxPanel;
import view.CranePanel;

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
public class ComboBoxPanelAction implements ActionListener {


    private CraneComboboxPanel craneComboboxPanel;
    private TowerCrane crane;
    private CranePanel cranePanel;

    public ComboBoxPanelAction(CraneComboboxPanel craneComboboxPanel, CranePanel cranePanel) {


        this.craneComboboxPanel = craneComboboxPanel;
        this.cranePanel = cranePanel;

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object src = actionEvent.getSource();


            //set customer
            if (src == craneComboboxPanel.getProducerComboBox()) {

                if (craneComboboxPanel.getProducerComboBox().getSelectedItem() == "Liebherr") {

                crane = new LiebherrCrane(craneComboboxPanel);

            } else if (craneComboboxPanel.getProducerComboBox().getSelectedItem() == "Potain") {

                crane = new PotainCrane(craneComboboxPanel);

            } else if (craneComboboxPanel.getProducerComboBox().getSelectedItem() == "Everdigm") {

                crane = new EverdigmCrane(craneComboboxPanel);

            }

            craneComboboxPanel.fillModelComboBox((String) craneComboboxPanel.getProducerComboBox().getSelectedItem());

        }


        //set model
        if (src == craneComboboxPanel.getModelComboBox()) {

            craneComboboxPanel.fillModificationComboBox((String) craneComboboxPanel.getModelComboBox().getSelectedItem());
            crane.setModel((String) craneComboboxPanel.getModelComboBox().getSelectedItem());
            crane.createControl(crane, cranePanel);


        }


    }

    public TowerCrane getCrane () {return crane;}

    }

