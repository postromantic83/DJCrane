package controller;

import model.Section;
import view.ControlPanel;
import view.CraneComboboxPanel;
import view.CranePanel;
import view.PotainControl;

import java.util.ArrayList;

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

    private CraneComboboxPanel craneComboboxPanel;


    private int sect_K439A;
    private int sect_K437A;
    private int sect_K437C;

    public PotainCrane (CraneComboboxPanel craneComboboxPanel) {
        this.craneComboboxPanel = craneComboboxPanel;
    }

    @Override
    public ArrayList<Section> getTower() {
        return super.getTower();
    }

    @Override
    public void makeTower() {
        super.makeTower();
    }

    @Override
    public TowerCrane setConcreteTowerCrane(ControlPanel lc) {
        return super.setConcreteTowerCrane(lc);
    }

    public void createControl ( TowerCrane crane, CranePanel cranePanel){

        ControlPanel controlPanel = new PotainControl(crane,cranePanel);
        controlPanel.setControl(crane);
        cranePanel.addContol(controlPanel.getControlPanel());

    }





}
