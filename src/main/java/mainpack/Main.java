package mainpack;

import controller.TowerCrane;
import view.CranePanel;

/**
 * Created by ShurikNote on 28.07.2015.
 *
 * This is the launcher class
 *
 * SRP: start the application in current environment (desktop)
 *
 * will chnge only if I need special params for starting (such as localization or etc.)
 *
 */
public class Main {
    public static void main(String[] args) {

        PropertyMain prop = new PropertyMain();
        prop.loadParams();



        //just now only towercranea, then abstractcrain will be extended for other cranes


        TowerCrane crane = new TowerCrane();
        CranePanel cranePanel = new CranePanel();

    }


}
