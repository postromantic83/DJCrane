package control;

import testmodel.Section;

import java.util.ArrayList;

/**
 * Created by SashaNote on 06.08.2015.
 */
public class TowerCrane extends AbstractCrane{


    protected ArrayList<Section> towerCollection = new ArrayList<Section>();

    public void makeTower () {}

    public ArrayList <Section> getTower(){

        return towerCollection;
    }

    public double getHeight (){
        double height = 0;
        return height;
    }


}
