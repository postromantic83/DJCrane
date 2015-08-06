package control;

import view.*;

/**
 * Created by SashaNote on 05.08.2015.
 *
 * SRM: define main control functions for all type of cranes (tower cranes, allterraincranes, autocranes ets.)
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
    public void createControl() {
        //do nothing

    }


}
