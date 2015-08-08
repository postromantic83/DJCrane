package controller;

import view.CranePanel;

/**
 * Created by ShurikNote on 29.07.2015.
 */
public interface Cranable {

/*
*
* Constants for offline database mode
*
* */


    public boolean DATABASE_ACTIVATE = false;

    //as soon as I connect to database constans will be useless


    public final String POTAINMODELS[]={"Potain MDT-178","Potain MDT218J10", "Potain MCT-88"};
    public final String EVERDIGMMODELS[]={"Everdigm KH-310"};
    public final String variant[]={"На анкерах","На раме"};

    /*
    * Crane methods
    * */

    void setModel (String model);
    void setProducer(String producer);
    String getModel();
    String getProducer();
    String [] getAvailableModels();

    void createControl(CranePanel cranePanel, TowerCrane crane);


}
