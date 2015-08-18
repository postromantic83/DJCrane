package controller;

import model.Section;
import view.ControlPanel;
import view.CranePanel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by SashaNote on 06.08.2015.
 */
public class TowerCrane extends AbstractCrane {


    protected ArrayList<Section> towerCollection = new ArrayList<Section>();

    public void makeTower() {
    }

    public ArrayList<Section> getTower() {

        return (ArrayList<Section>) Collections.EMPTY_LIST;
    }

    public double getHeight() {
        double height = 0;
        return height;
    }
    public double getHeightUnderJib(double height) {
        double heightUnderJib = 0;
        return heightUnderJib;
    }

    public void createControl(CranePanel cranePanel, TowerCrane crane) {
    }


    public TowerCrane setTowerCombination(CranePanel parent, ControlPanel lc) {
        return null;
    }
}