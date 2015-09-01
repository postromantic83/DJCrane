package view;


import mainpack.PropertyMain;
import model.CraneStructure;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sokolov on 02.02.2015.
 *
 * SRP: create main program field
 *
 * change request: configuring main program form
 *
 */
public class CranePanel extends JPanel {


    private JLabel label;
    private CranePanelMenu cranePanelMenu;
    private CraneComboboxPanel craneComboboxPanel;

    //get params from properties
    PropertyMain proper = new PropertyMain();




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


    VisioPanel mp1 = new VisioPanel();

    public CraneComboboxPanel getComboboxPanel (){return this.craneComboboxPanel;}


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
        panUp.setLayout(new BoxLayout(panUp, BoxLayout.Y_AXIS));


        pan2.setLayout(g1);
        panLeft.setLayout(new BoxLayout(panLeft, BoxLayout.Y_AXIS));

        cranePanelMenu = new CranePanelMenu();
        panUp.add(cranePanelMenu.getMenu());

        craneComboboxPanel = new CraneComboboxPanel(this);
        panUp.add(craneComboboxPanel.getComboboxPanel());





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







    }


    public void addContol(JPanel controlPanel) {


        //control panel adding
        panLeft.removeAll();
        panLeft.add(controlPanel);
        System.out.println(controlPanel);



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



}