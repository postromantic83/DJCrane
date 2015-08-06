package View;

import Contrl.Crane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sokolov on 25.02.2015.
 */
public class LiebherrControl extends ControlPanel {

    ControlPanel lp;


    int val1;

    @Override
    public String toString() {
        return "Liebherrcontrol!";
    }

//    PanelAction panelAction = new PanelAction(this);

    Crane crane;
    CranePanel cranePanel;
    JPanel panControl = new JPanel();
//120-132HC tower control initialize
    JLabel lb120_25 = new JLabel("120HC 2,5 m");
    JLabel lb120_50 = new JLabel("120HC 5,0 m");
    JLabel lb120_125 = new JLabel("120HC 12,5 m");

    JLabel lb132_168 = new JLabel("132HC 10 m 16x8");
    JLabel lb154_168 = new JLabel("154HC 10 m 16x8");
    JLabel lb154_1616 = new JLabel("154HC 10 m 16x16");




    JButton bt120_25inc = new JButton("+");
    JButton bt120_50inc = new JButton("+");
    JButton bt120_125inc = new JButton("+");
    JButton bt132_168inc = new JButton("+");
    JButton bt154_168inc = new JButton("+");
    JButton bt154_1616inc = new JButton("+");

    JButton bt120_25dec = new JButton("-");
    JButton bt120_50dec = new JButton("-");
    JButton bt120_125dec = new JButton("-");
    JButton bt132_168dec = new JButton("-");
    JButton bt154_168dec = new JButton("-");
    JButton bt154_1616dec = new JButton("-");

    JTextField tx120_25 = new JTextField("0");
    JTextField tx120_50 = new JTextField("0");
    JTextField tx120_125 = new JTextField("0");
    JTextField tx132_168 = new JTextField("0");

    JTextField tx154_168 = new JTextField("0");
    JTextField tx154_1616 = new JTextField("0");

    LiebherrControl (){}


    public LiebherrControl(CranePanel cp, Crane crane){
        this.cranePanel = cp;
        this.crane= crane;

    }

//    LiebherrControl (LiebherrCrane model){
//        this.crane = model;
//    }

    /*public Container createPanel (Crane inputCrane) {
        this.crane = inputCrane;

        ControlPanel panel = new ControlPanel();
        JButton btt = new JButton("Liebherr 120HC");
        panel.add(btt);


        return panel;
    }*/
        @Override
        public void setControl (ControlPanel lp){
        this.lp = lp;



            //bag for elements
            GridBagLayout gb1 = new GridBagLayout();
            panControl.setLayout(gb1);
            //dependencies
            GridBagConstraints cLab1 = new GridBagConstraints();
            cLab1.anchor=GridBagConstraints.WEST;
            cLab1.gridx=1;
            cLab1.gridy=GridBagConstraints.RELATIVE;

            //set labels dependencies
            gb1.setConstraints(lb120_25,cLab1);
            gb1.setConstraints(lb120_50,cLab1);
            gb1.setConstraints(lb120_125,cLab1);
            gb1.setConstraints(lb132_168,cLab1);
            gb1.setConstraints(lb154_168,cLab1);
            gb1.setConstraints(lb154_1616, cLab1);


            panControl.add(lb120_25);
            panControl.add(lb120_50);
            panControl.add(lb120_125);
            panControl.add(lb132_168);
            panControl.add(lb154_168);
            panControl.add(lb154_1616);


            //increment buttons
            GridBagConstraints cBtn;
            cBtn = new GridBagConstraints();
            cBtn.anchor=GridBagConstraints.WEST;
            cBtn.gridx=2;
            cBtn.gridy=GridBagConstraints.RELATIVE;

            gb1.setConstraints(bt120_25inc, cBtn);
            gb1.setConstraints(bt120_50inc, cBtn);
            gb1.setConstraints(bt120_125inc, cBtn);
            gb1.setConstraints(bt132_168inc, cBtn);
            gb1.setConstraints(bt154_168inc, cBtn);
            gb1.setConstraints(bt154_1616inc, cBtn);

            panControl.add(bt120_25inc);
            panControl.add(bt120_50inc);
            panControl.add(bt120_125inc);
            panControl.add(bt132_168inc);
            panControl.add(bt154_168inc);
            panControl.add(bt154_1616inc);

            //decrement buttons
            cBtn.gridx=3;

            gb1.setConstraints(bt120_25dec, cBtn);
            gb1.setConstraints(bt120_50dec, cBtn);
            gb1.setConstraints(bt120_125dec, cBtn);
            gb1.setConstraints(bt132_168dec, cBtn);
            gb1.setConstraints(bt154_168dec, cBtn);
            gb1.setConstraints(bt154_1616dec, cBtn);

            panControl.add(bt120_25dec);
            panControl.add(bt120_50dec);
            panControl.add(bt120_125dec);
            panControl.add(bt132_168dec);
            panControl.add(bt154_168dec);
            panControl.add(bt154_1616dec);

            //textfield params
            GridBagConstraints cTxt = new GridBagConstraints();
            cTxt = new GridBagConstraints();
            cTxt.anchor=GridBagConstraints.EAST;
            cTxt.gridx=4;
            cTxt.gridy=GridBagConstraints.RELATIVE;
            cTxt.ipadx=30;
            cTxt.weightx=0.5;

            gb1.setConstraints(tx120_25,cTxt);
            gb1.setConstraints(tx120_50,cTxt);
            gb1.setConstraints(tx120_125,cTxt);
            gb1.setConstraints(tx132_168,cTxt);
            gb1.setConstraints(tx154_168,cTxt);
            gb1.setConstraints(tx154_1616, cTxt);

            panControl.add(tx120_25);
            panControl.add(tx120_50);
            panControl.add(tx120_125);
            panControl.add(tx132_168);

            panControl.add(tx154_168);
            panControl.add(tx154_1616);





            cranePanel.panLeft.removeAll();
            cranePanel.panLeft.add(panControl);




            bt120_25dec.setActionCommand("120HC_25dec");
            bt120_50dec.setActionCommand("bt120_50dec");
            bt154_168dec.setActionCommand("bt154_168dec");
            bt154_1616dec.setActionCommand("bt154_1616dec");
            bt120_25inc.setActionCommand("bt120_25inc");
            bt120_50inc.setActionCommand("bt120_50inc");
            bt154_168inc.setActionCommand("bt154_168inc");
            bt154_1616inc.setActionCommand("bt154_1616inc");


            /**
             *  Actions for control panel buttons
             *
            */

            //buttons increase


            bt120_25inc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    val1 = Integer.parseInt(tx120_25.getText());
                    val1++;
                    tx120_25.setText(String.valueOf(val1));
                    setTower();
                }
            });

            bt120_50inc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    val1 = Integer.parseInt(tx120_50.getText());
                    val1++;
                    tx120_50.setText(String.valueOf(val1));
                    setTower();

                }
            });

            bt120_125inc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    val1 = Integer.parseInt(tx120_125.getText());
                    val1++;
                    tx120_125.setText(String.valueOf(val1));
                    setTower();

                }
            });

            bt132_168inc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    val1 = Integer.parseInt(tx132_168.getText());
                    val1++;
                    tx132_168.setText(String.valueOf(val1));
                    setTower();

                }
            });


            bt154_1616inc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        val1 = Integer.parseInt(tx154_1616.getText());
                        val1++;
                        tx154_1616.setText(String.valueOf(val1));
                    setTower();
                }
            });

            bt154_168inc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    val1 = Integer.parseInt(tx154_168.getText());
                    val1++;
                    tx154_168.setText(String.valueOf(val1));
                    setTower();
                }
            });


            //buttons decrease

            bt120_25dec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                        val1 = Integer.parseInt(tx120_25.getText());
                    if (val1>0) {
                        val1--;
                        tx120_25.setText(String.valueOf(val1));

                    }
                    setTower();
                }
            });
            bt120_125dec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    val1 = Integer.parseInt(tx120_125.getText());
                    if (val1>0) {
                        val1--;
                        tx120_125.setText(String.valueOf(val1));
                    }
                    setTower();
                }
            });

            bt132_168dec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    val1 = Integer.parseInt(tx132_168.getText());
                    if (val1>0) {
                        val1--;
                        tx132_168.setText(String.valueOf(val1));
                    }
                    setTower();
                }
            });

            bt120_50dec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    val1 = Integer.parseInt(tx120_50.getText());
                    if (val1>0) {
                        val1--;
                        tx120_50.setText(String.valueOf(val1));
                    }
                    setTower();
                }
            });

            bt154_168dec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    val1 = Integer.parseInt(tx154_168.getText());
                    if (val1>0) {
                        val1--;
                        tx154_168.setText(String.valueOf(val1));
                    }
                    setTower();
                }
            });

            bt154_1616dec.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    val1 = Integer.parseInt(tx154_1616.getText());
                    if (val1>0) {
                        val1--;
                        tx154_1616.setText(String.valueOf(val1));}
                    setTower();
                }
            });

                        }

    private void setTower(){

        crane = crane.setTowerCombination(cranePanel,this);
        crane.makeTower();
        cranePanel.mp1.setCollection(crane.getTower());
        cranePanel.mp1.repaint();

        cranePanel.hHeader1.setText(Float.toString(crane.getHeight()));
        cranePanel.hHeader2.setText(Float.toString(crane.getHeight2(crane.getHeight())));
    }

    //overrided getters to GUI

    @Override
    public int getS120HC_25() {
        return Integer.parseInt(tx120_25.getText());
    }
    @Override
    public int getS120HC_50() {return Integer.parseInt(tx120_50.getText());}
    @Override
    public int getS120HC_125() {
        return Integer.parseInt(tx120_125.getText());
    }
    @Override
    public int getS132HC_168() {return Integer.parseInt(tx132_168.getText());}
    @Override
    public int getS154HC_168() {return Integer.parseInt(tx154_168.getText());}
    @Override
    public int getS154HC_1616() {return Integer.parseInt(tx154_1616.getText());}


    /*@Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == this.bt120_25dec) {

            System.out.println("BUTTON PRESSED!");
        }



    }*/
}
