package unipanel;

import view.ControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by SashaNote on 03.09.2015.
 */
public class ButtonPanelView extends Observable {

    protected JPanel buttonPanel;
    protected ControlPanel controlPanel;
    protected String name;
    protected int value;

    private JButton increaseButton = new JButton("+");
    private JButton decreaseButton = new JButton("-");
    private JTextField jTextField = new JTextField("0");
    private JLabel jLabel;


    public int getValue (){return value;}

    public ButtonPanelView (String name, ControlPanel controlPanel){
        this.buttonPanel = new JPanel ();
        this.name = name;
        this.controlPanel = controlPanel;

        this.addObserver((Observer) controlPanel);

        jLabel = new JLabel (name);

        GridBagLayout gb1 = new GridBagLayout();
        this.buttonPanel.setLayout(gb1);

        GridBagConstraints cLab1 = new GridBagConstraints();
        cLab1.anchor=GridBagConstraints.WEST;
        cLab1.gridx=1;
        cLab1.gridy=GridBagConstraints.RELATIVE;

        gb1.setConstraints(jLabel, cLab1);
        this.buttonPanel.add(jLabel);


        GridBagConstraints cBtn;
        cBtn = new GridBagConstraints();
        cBtn.anchor=GridBagConstraints.WEST;
        cBtn.gridx=2;
        cBtn.gridy=GridBagConstraints.RELATIVE;

        this.buttonPanel.add(increaseButton);

        gb1.setConstraints(increaseButton, cBtn);

        cBtn.gridx=3;

        gb1.setConstraints(decreaseButton, cBtn);
        this.buttonPanel.add(decreaseButton);

        GridBagConstraints cTxt = new GridBagConstraints();
        cTxt = new GridBagConstraints();
        cTxt.anchor=GridBagConstraints.EAST;
        cTxt.gridx=4;
        cTxt.gridy=GridBagConstraints.RELATIVE;
        cTxt.ipadx=30;
        cTxt.weightx=0.5;

        gb1.setConstraints(jTextField, cTxt);
        this.buttonPanel.add(jTextField);

        increaseButton.setActionCommand("increase");
        decreaseButton.setActionCommand("decrease");
        jTextField.setActionCommand("textField");


        controlPanel.panControl.add(this.getButtonPanel());


        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val1 = Integer.parseInt(jTextField.getText());
                val1++;
                jTextField.setText(String.valueOf(val1));
                hasModified();
            }
        });

        decreaseButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val1 = Integer.parseInt(jTextField.getText());
                if (val1 > 0) {
                    val1--;
                    jTextField.setText(String.valueOf(val1));
                    hasModified();
                }
            }
        });

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            hasModified();
            }
        });



    }
    private void setValue(){
        value = Integer.parseInt(jTextField.getText());

    }


    private void hasModified (){
        setValue();
        setChanged();
        notifyObservers(value);

    }

    public JPanel getButtonPanel () {return this.buttonPanel;}

    public int getTextFieldValue(){
        return Integer.parseInt(jTextField.getText());
    }

}
