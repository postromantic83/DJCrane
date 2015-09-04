package unipanel;

import javax.swing.*;

/**
 * Created by SashaNote on 03.09.2015.
 */
public class ButtonPanelView extends JPanel {

    protected JPanel buttonPanel;


    ButtonPanelView (){
        this.buttonPanel = new JPanel ();
    }

    public JPanel getPanel () {return buttonPanel;}


    public void addButton (String name) {

    JButton nm = new JButton(name);
    this.buttonPanel.add(nm);

    }
    public void addAnyButton (String name) throws ClassNotFoundException {




    }



}
