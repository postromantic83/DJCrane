package control;

import testview.CranePanel;

/**
 * Created by sokolov on 19.02.2015.
 */
public class PotainCrane extends Crane {

    CranePanel parent;




    public PotainCrane (CranePanel cranePanel) {

        this.parent = cranePanel;

    }




    public String[] availableModels(){
        final String POTAINMODELS[]={"Potain MDT-178","Potain MDT218J10", "Potain MCT-88"};
        return POTAINMODELS;
    }

}
