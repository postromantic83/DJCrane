package control;

import view.CranePanel;

/**
 * Created by sokolov on 19.02.2015.
 */
public class EverdigmCrane extends Crane {
    CranePanel parent;


    public EverdigmCrane (CranePanel cranePanel){
        this.parent = cranePanel;




    }
    public String[] availableModels(){
        final String EVERDIGMMODELS[]={"Everdigm KH-310"};
        return EVERDIGMMODELS;
    }



}
