package view;


import mainpack.PropertyMain;
import model.CraneStructure;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sokolov on 02.02.2015.
 *
 * SRM: create main program field
 *
 */
public class CranePanel extends JPanel {


    private JLabel label;

    //get params from properties
    PropertyMain proper = new PropertyMain();
    CraneStructure craneStructure = new CraneStructure();



    Dimension preferredSize = new Dimension(proper.getFIELD_WIDTH(), proper.getFIELD_HEIGHT());
    public Dimension getPreferredSize() {
        return preferredSize;
    }


    //panHeight
    JLabel labelHeader = new JLabel("Height");
    JLabel labelHeader2 = new JLabel("Height under Jib");
    JLabel hHeader1 = new JLabel("0");
    JLabel hHeader2 = new JLabel("0");


    JPanel panLeft = new JPanel();
    JComboBox comb1 = new JComboBox<String>(craneStructure.getAvailableProducers());
    JComboBox comb2 = new JComboBox<String>();
    JComboBox comb3 = new JComboBox<String>();

    VisioPanel mp1 = new VisioPanel();

    JMenuBar jmb = new JMenuBar();
    JMenu jmFile = new JMenu("Menu");
    JMenuItem jmSave = new JMenuItem("Save as png");


    public CranePanel() {

        JFrame frame = new JFrame("Desktop JCrane Combinator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);





        BorderLayout b1 = new BorderLayout();
        JPanel pan = new JPanel();


        pan.setLayout(b1);


        JPanel pan1 = new JPanel();
        JPanel pan2 = new JPanel();

        JPanel panRight = new JPanel();
        JPanel panUp = new JPanel();
        JPanel panHeight = new JPanel();
        JPanel panControl = new JPanel();

        GridLayout g1 = new GridLayout(4, 2);
        FlowLayout f1 = new FlowLayout();
        GridBagLayout gb1 = new GridBagLayout();
        GridBagLayout gb2 = new GridBagLayout();

        panRight.setLayout(new BoxLayout(panRight, BoxLayout.Y_AXIS));
        panRight.add(panHeight);
        panRight.add(panControl);

        panHeight.setLayout(gb2);
        panControl.setLayout(gb1);


        pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
        panUp.setLayout(new BoxLayout(panUp, BoxLayout.X_AXIS));


        pan2.setLayout(g1);
        panLeft.setLayout(new BoxLayout(panLeft, BoxLayout.Y_AXIS));

        jmb.add(jmFile);
        jmFile.add(jmSave);
        panUp.add(jmb);



        panUp.add(comb1);
        panUp.add(comb2);
        panUp.add(comb3);

        JTextField jt1 = new JTextField("Panel1 FlowLay");
        JLabel l1 = new JLabel("MyPanel (Graphics)");
        JLabel l2 = new JLabel("Control Panel");


        panLeft.add(l2);




        pan1.add(l1);


        pan1.add(mp1);
        mp1.repaint();

        //Шапка с высотами крана
        GridBagConstraints cLab2 = new GridBagConstraints();

        cLab2.anchor = GridBagConstraints.WEST;
        cLab2.gridx = 1;
        cLab2.gridy = GridBagConstraints.RELATIVE;
        gb2.setConstraints(labelHeader, cLab2);
        gb2.setConstraints(labelHeader2, cLab2);

        cLab2.gridx = 4;
        cLab2.ipadx = 30;
        cLab2.weightx = 0.5;
        cLab2.anchor = GridBagConstraints.EAST;


        gb2.setConstraints(hHeader1, cLab2);
        gb2.setConstraints(hHeader2, cLab2);
        panHeight.add(labelHeader);
        panHeight.add(labelHeader2);
        panHeight.add(hHeader1);
        panHeight.add(hHeader2);




        pan.add("West", panLeft);
        pan.add("East", panRight);
        pan.add("North", panUp);
        pan.add("Center", pan1);


        frame.setContentPane(pan);
        frame.pack();
        frame.setBounds(0, 0, proper.getFIELD_WIDTH(), proper.getFIELD_HEIGHT());
        frame.setVisible(true);




        //registering sourcers
        ControlPanel controlPanel = new ControlPanel();

        PanelAction panelAction = new PanelAction(this, controlPanel);


        comb1.addActionListener(panelAction);
        comb2.addActionListener(panelAction);
        comb3.addActionListener(panelAction);

    }


    public void addContol(Container container) {


        //control panel adding
        panLeft.add(container);


    }


    public void addPaneltoFrame(Container container) {

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(this);


    }

    public void add2(Container container) {
        BorderLayout b2 = new BorderLayout();
        container.setLayout(b2);
        container.add(this);


    }


      public void setComb2(String producer) {

          craneStructure.setAvailableModels(producer);

          String [] arrayModels = craneStructure.getAvailableModels();
/*Метод заполняет модельный комбобокс*/

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