package unipanel;

import view.ControlPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;




public class UpDownButtonPanel extends Observable {

    private JButton universalIncreaseButton = new JButton("UP");
    private JButton universalDecreaseButton = new JButton("DOWN");

    private boolean upButtonPressed;

    protected JPanel updownpanel;
    protected ControlPanel controlPanel;


    public JPanel getUpDownButtonPanel () {return this.updownpanel;}

    public UpDownButtonPanel (ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
        this.updownpanel = new JPanel();

        this.addObserver((Observer) controlPanel);




        FlowLayout layout = new FlowLayout(BoxLayout.X_AXIS);
        this.updownpanel.setLayout(layout);

        this.updownpanel.add(universalIncreaseButton);
        this.updownpanel.add(universalDecreaseButton);

        universalIncreaseButton.setActionCommand("UniIncrease");
        universalDecreaseButton.setActionCommand("UniDecrease");

        universalIncreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upButtonPressed=true;
                hasPressed();
            }
        });
        universalDecreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upButtonPressed=false;
                hasPressed();
            }
        });

    }
    public boolean isUpButtonPressed (){return upButtonPressed;}

    private void hasPressed () {
        setChanged();
        notifyObservers(this);
    }
    }



