package controller;

import view.CraneComboboxPanel;
import view.CranePanel;

/**
 * Created by sokolov on 19.02.2015.
 *
 * SRP: build Potain tower
 *
 * change request: extending tower functions
 *
 *
 */
public class PotainCrane extends TowerCrane {

    CraneComboboxPanel parent;




    public PotainCrane (CraneComboboxPanel craneComboboxPanel) {

        this.parent = craneComboboxPanel;

    }




    public String[] availableModels(){
        final String POTAINMODELS[]={"Potain MDT-178","Potain MDT218J10", "Potain MCT-88"};
        return POTAINMODELS;
    }

}
