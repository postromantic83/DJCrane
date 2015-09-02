package view;

import controller.TowerCrane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SashaNote on 02.09.2015.
 */
public class PotainControl extends ControlPanel {

    private TowerCrane crane;
    private CranePanel cranePanel;
    private int val1;


    private JPanel panControl = new JPanel();
    //MDT tower controller initialize
    private JLabel lb_K439A = new JLabel("K439A 5,0 m");
    private JLabel lb_K437A = new JLabel("K473A 5,0 m");
    private JLabel lb_K437C = new JLabel("K437C 3,0 m");

    private JButton bt_K439A_inc = new JButton("+");
    private JButton bt_K437A_inc = new JButton("+");
    private JButton bt_K437C_inc = new JButton("+");


    private JButton bt_K439A_dec = new JButton("-");
    private JButton bt_K437A_dec = new JButton("-");
    private JButton bt_K437C_dec = new JButton("-");

    JTextField tx_K439A = new JTextField("0");
    JTextField tx_K437A = new JTextField("0");
    JTextField tx_K437C = new JTextField("0");

    public JPanel getControlPanel(){return panControl;}

    public int getK439A() {return Integer.parseInt(tx_K439A.getText());}
    public int getK437A() {return Integer.parseInt(tx_K437A.getText());}
    public int getK437C() {return Integer.parseInt(tx_K437C.getText());}


    public PotainControl(TowerCrane crane, CranePanel cranePanel) {

        this.crane = crane;
        this.cranePanel = cranePanel;

    }


    @Override
    public void setControl (TowerCrane crane) {


        //bag for elements
        GridBagLayout gb1 = new GridBagLayout();
        panControl.setLayout(gb1);
        //dependencies
        GridBagConstraints cLab1 = new GridBagConstraints();
        cLab1.anchor = GridBagConstraints.WEST;
        cLab1.gridx = 1;
        cLab1.gridy = GridBagConstraints.RELATIVE;

        //set labels dependencies
        gb1.setConstraints(lb_K439A, cLab1);
        gb1.setConstraints(lb_K437A, cLab1);
        gb1.setConstraints(lb_K437C, cLab1);


        panControl.add(lb_K439A);
        panControl.add(lb_K437A);
        panControl.add(lb_K437C);


        //increment buttons
        GridBagConstraints cBtn;
        cBtn = new GridBagConstraints();
        cBtn.anchor = GridBagConstraints.WEST;
        cBtn.gridx = 2;
        cBtn.gridy = GridBagConstraints.RELATIVE;

        gb1.setConstraints(bt_K439A_inc, cBtn);
        gb1.setConstraints(bt_K437A_inc, cBtn);
        gb1.setConstraints(bt_K437C_inc, cBtn);


        panControl.add(bt_K439A_inc);
        panControl.add(bt_K437A_inc);
        panControl.add(bt_K437C_inc);


        //decrement buttons
        cBtn.gridx = 3;

        gb1.setConstraints(bt_K439A_dec, cBtn);
        gb1.setConstraints(bt_K437A_dec, cBtn);
        gb1.setConstraints(bt_K437C_dec, cBtn);


        panControl.add(bt_K439A_dec);
        panControl.add(bt_K437A_dec);
        panControl.add(bt_K437C_dec);


        //textfield params
        GridBagConstraints cTxt = new GridBagConstraints();
        cTxt = new GridBagConstraints();
        cTxt.anchor = GridBagConstraints.EAST;
        cTxt.gridx = 4;
        cTxt.gridy = GridBagConstraints.RELATIVE;
        cTxt.ipadx = 30;
        cTxt.weightx = 0.5;

        gb1.setConstraints(tx_K439A, cTxt);
        gb1.setConstraints(tx_K437A, cTxt);
        gb1.setConstraints(tx_K437C, cTxt);


        panControl.add(tx_K439A);
        panControl.add(tx_K437A);
        panControl.add(tx_K437C);

        bt_K439A_dec.setActionCommand("K439A_dec");
        bt_K437A_dec.setActionCommand("K437A_dec");
        bt_K437C_dec.setActionCommand("K437C_dec");

        bt_K439A_inc.setActionCommand("K439A_inc");
        bt_K437A_inc.setActionCommand("K437A_inc");
        bt_K437C_inc.setActionCommand("K437C_inc");


        bt_K439A_inc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val1 = Integer.parseInt(tx_K439A.getText());
                val1++;
                tx_K439A.setText(String.valueOf(val1));
                setTower();
            }
        });

        bt_K439A_dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val1 = Integer.parseInt(tx_K439A.getText());
                if (val1>0) {
                    val1--;
                    tx_K439A.setText(String.valueOf(val1));
                }
                setTower();

            }
        });

        bt_K437A_inc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val1 = Integer.parseInt(tx_K437A.getText());
                val1++;
                tx_K437A.setText(String.valueOf(val1));
                setTower();
            }
        });

        bt_K437A_dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val1 = Integer.parseInt(tx_K437A.getText());
                if (val1>0) {
                    val1--;
                    tx_K437A.setText(String.valueOf(val1));
                }
                setTower();
            }
        });

        bt_K437C_inc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val1 = Integer.parseInt(tx_K437C.getText());
                val1++;
                tx_K437C.setText(String.valueOf(val1));
                setTower();
            }
        });

        bt_K437C_dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                val1 = Integer.parseInt(tx_K437C.getText());
                if (val1>0) {
                    val1--;
                    tx_K437C.setText(String.valueOf(val1));
                }
                setTower();
            }
        });






    }
    private void setTower(){

        crane = crane.setConcreteTowerCrane(this);
        crane.makeTower();


        cranePanel.mp1.setCollection(crane.getTower());
        cranePanel.mp1.repaint();


        cranePanel.hHeader1.setText(Double.toString(crane.getHeight()));
        cranePanel.hHeader2.setText(Double.toString(crane.getHeightUnderJib(crane.getHeight())));
    }

}
