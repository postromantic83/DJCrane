package view;

import javax.swing.*;

/**
 * Created by SashaNote on 25.08.2015.
 */
public class CranePanelMenu extends JMenuBar{

    private JMenuBar jmb;

    protected CranePanelMenu(){

         jmb = new JMenuBar();
        JMenu jmFile = new JMenu("Menu");
        JMenuItem jmSave = new JMenuItem("Save as png");

        jmb.add(jmFile);
        jmFile.add(jmSave);


    }
    public JMenuBar getMenu(){ return jmb;}








}
