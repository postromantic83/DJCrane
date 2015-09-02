package view;

import controller.ComboBoxPanelAction;
import model.CraneStructure;

import javax.swing.*;

/**
 * Created by SashaNote on 25.08.2015.
 */
public class CraneComboboxPanel extends JPanel {

    private JPanel comboPanel;
    private CraneStructure craneStructure = new CraneStructure();
    private CranePanel cranePanel;

    private JComboBox producerComboBox = new JComboBox<String>(craneStructure.getAvailableProducers());
    private JComboBox modelComboBox = new JComboBox<String>();
    private JComboBox modificationComboBox = new JComboBox<String>();

    public JComboBox getProducerComboBox () {return producerComboBox;}
    public JComboBox getModelComboBox () {return modelComboBox;}
    public JComboBox getModificationComboBox () {return modificationComboBox;}




    public CraneComboboxPanel(CranePanel cranePanel){
        this.cranePanel = cranePanel;
        comboPanel = new JPanel();
        comboPanel.add(producerComboBox);
        comboPanel.add(modelComboBox);
        comboPanel.add(modificationComboBox);
        ComboBoxPanelAction comboBoxPanelAction = new ComboBoxPanelAction(this, cranePanel);

        producerComboBox.addActionListener(comboBoxPanelAction);
        modelComboBox.addActionListener(comboBoxPanelAction);
        modificationComboBox.addActionListener(comboBoxPanelAction);
    }
    protected JPanel getComboboxPanel(){return comboPanel;}


    public void fillModelComboBox(String producer) {
        craneStructure.setAvailableModels(producer);
        String [] arrayModels = craneStructure.getAvailableModels();
        modelComboBox.removeAllItems();

        for (String s : arrayModels) {
            modelComboBox.addItem(s);
        }
    }

    /*  Adding modification method (modificationComboBox) */

    public void fillModificationComboBox(String model) {
        craneStructure.setAvailableModifications(model);
        String [] arrayModifications = craneStructure.getAvailableModifications();
        modificationComboBox.removeAllItems();

        for (String s : arrayModifications) {
            modificationComboBox.addItem(s);
        }

    }




}
