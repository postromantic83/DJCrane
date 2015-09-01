package view;

import model.CraneStructure;

import javax.swing.*;

/**
 * Created by SashaNote on 25.08.2015.
 */
public class CraneComboboxPanel extends JPanel {

    private JPanel comboPanel;
    private CraneStructure craneStructure = new CraneStructure();
    private CranePanel cranePanel;

    JComboBox comb1 = new JComboBox<String>(craneStructure.getAvailableProducers());
    JComboBox comb2 = new JComboBox<String>();
    JComboBox comb3 = new JComboBox<String>();

    CraneComboboxPanel(CranePanel cranePanel){
        this.cranePanel = cranePanel;
        comboPanel = new JPanel();
        comboPanel.add(comb1);
        comboPanel.add(comb2);
        comboPanel.add(comb3);

//        ControlPanel controlPanel = new ControlPanel();
        PanelAction panelAction = new PanelAction(this, cranePanel);

        comb1.addActionListener(panelAction);
        comb2.addActionListener(panelAction);
        comb3.addActionListener(panelAction);



    }
    protected JPanel getComboboxPanel(){return comboPanel;}


    public void setComb2(String producer) {

        craneStructure.setAvailableModels(producer);

        String [] arrayModels = craneStructure.getAvailableModels();


        for (String s : arrayModels) {
            comb2.addItem(s);

        }
    }

    /*  Adding modification method (comb3) */

    public void setComb3(String model) {
        craneStructure.setAvailableModifications(model);
        String [] arrayModifications = craneStructure.getAvailableModifications();
        for (String s : arrayModifications) {
            comb3.addItem(s);


        }

    }




}
