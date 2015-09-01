package controller;

import view.CraneComboboxPanel;
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
    CraneComboboxPanel parent;


    public EverdigmCrane (CraneComboboxPanel craneComboboxPanel){
        this.parent = craneComboboxPanel;




    }
    public String[] availableModels(){
        final String EVERDIGMMODELS[]={"Everdigm KH-310"};
        return EVERDIGMMODELS;
    }



}
