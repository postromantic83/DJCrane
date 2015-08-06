package mainpack;

import Contrl.TowerCrane;
import View.CranePanel;

/**
 * Created by ShurikNote on 28.07.2015.
 *
 * This is the launcher class
 *
 * SRM: start the application in current environment (desktop)
 *
 */
public class Main {
    public static void main(String[] args) {


        //just now only towercranea, then abstractcrain will be extended for other cranes

        TowerCrane crane = new TowerCrane();
        CranePanel cranePanel = new CranePanel();

    }


}
