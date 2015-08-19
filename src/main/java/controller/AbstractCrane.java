package controller;

import view.*;

/**
 * Created by SashaNote on 05.08.2015.
 *
 * SRP: define main controller functions for all type of cranes (tower cranes, allterraincranes, autocranes ets.)
 *
 * change request: adding new general crane params
 *
 */
public abstract class AbstractCrane implements Cranable{

    protected String model;
    protected String producer;
    protected PanelAction panelAction;



    @Override
    public void setModel(String model) {
        this.model = model;

    }

    @Override
    public void setProducer(String producer) {
        this.producer = producer;

    }


    @Override
    public String getModel() {
        return model;

    }

    @Override
    public String getProducer() {
        return producer;
    }

    @Override
    public void createControl(CranePanel cranePanel, TowerCrane crane) {
        //do nothing

    }

    @Override
    public String[] getAvailableModels() {
        return new String[0];
    }

    public String [] getAvailableModifications(String mod){

        return new String[0];
    }
}
