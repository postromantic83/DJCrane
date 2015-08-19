package controller;

import view.CranePanel;

/**
 * Created by ShurikNote on 29.07.2015.
 *
 * SRP: changing general methods
 */
public interface Cranable {

/*
*
* Constants for offline database mode
*
* later I refactor it
*
* */


    public boolean DATABASE_ACTIVATE = false;



    /*
    * Crane methods
    * SRM: define main methods for all types of cranes
    *
    * */

    void setModel (String model);
    void setProducer(String producer);
    String getModel();
    String getProducer();
    String [] getAvailableModels();

    void createControl(CranePanel cranePanel, TowerCrane crane);


}
