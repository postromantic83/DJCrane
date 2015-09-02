package controller;

import model.Section;
import view.ControlPanel;
import view.CraneComboboxPanel;
import view.CranePanel;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by SashaNote on 06.08.2015.
 *
 * SRP: this is base for tower crane models
 *
 * change request: adding new functions for all tower cranes
 *
 */
public class TowerCrane extends AbstractCrane {


    protected ArrayList<Section> towerCollection = new ArrayList<Section>();

    public void makeTower() {
    }

    public ArrayList<Section> getTower() {

        return (ArrayList<Section>)  Collections.EMPTY_LIST;
    }

    public double getHeight() {
        double height = 0;
        return height;
    }
    public double getHeightUnderJib(double height) {
        double heightUnderJib = 0;
        return heightUnderJib;
    }

    public void createControl(TowerCrane crane) {
    }


    public TowerCrane setConcreteTowerCrane(ControlPanel lc) {
        return null;
    }
}