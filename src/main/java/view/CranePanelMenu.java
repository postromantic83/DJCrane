package view;

import javax.swing.*;

/**
 * Created by SashaNote on 25.08.2015.
 */
public class CranePanelMenu extends JMenuBar{

    private JMenuBar jmb;

    public CranePanelMenu(){

        jmb = new JMenuBar();

        JMenu jmFile = new JMenu("File");

        JMenuItem jmSave = new JMenuItem("Save as png");

            jmb.add(jmFile);
            jmFile.add(jmSave);

        JMenu jmMode = new JMenu ("Mode");
            JMenuItem jmSimpleMode = new JMenuItem("Simple calc");
            JMenuItem jmEngeneerMode = new JMenuItem("Engeneer calc");

            jmb.add(jmMode);
            jmMode.add(jmSimpleMode);
            jmMode.add(jmEngeneerMode);



    }
    public JMenuBar getMenu(){ return jmb;}








}
