package controller;

import view.CranePanel;

/**
 * Created by sokolov on 19.02.2015.
 *
 * SRP: build Everdigm tower crane
 *
 * change request: extending tower functions
 *
 */
public class EverdigmCrane extends TowerCrane {
    CranePanel parent;


    public EverdigmCrane (CranePanel cranePanel){
        this.parent = cranePanel;




    }
    public String[] availableModels(){
        final String EVERDIGMMODELS[]={"Everdigm KH-310"};
        return EVERDIGMMODELS;
    }



}
