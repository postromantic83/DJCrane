package controller;

import model.Section;
import view.*;

import java.util.ArrayList;

/**
 * Created by Sokolov on 03.02.2015.
 *
 * SRP: build Liebherr towers
 *
 * change request: extending tower functions
 *
 */

public class LiebherrCrane extends TowerCrane {



    private CraneComboboxPanel craneComboboxPanel;

    private LiebherrCrane concreteCrane132;



    private int i,n;
    private int s154hc168, s154hc1616,s132hc5,s132hc25,s132hc125,s132hc168;
    private String modelName;

    public TowerCrane setConcreteTowerCrane(ControlPanel liebherrControl) {

        concreteCrane132 = new Builder("Liebherr 132EC-H8")
                .s132hc25(liebherrControl.getS120HC_25())
                .s132hc5(liebherrControl.getS120HC_50())
                .s132hc125(liebherrControl.getS120HC_125())
                .s132hc168(liebherrControl.getS132HC_168())
                .s154hc168(liebherrControl.getS154HC_168())
                .s154hc1616(liebherrControl.getS154HC_1616())
                .build();


        return concreteCrane132;
    }


    //Builder pattern for new crane
    private static class Builder {
        private int s154hc168=0;
        private int s154hc1616=0;
        private int s132hc5=0;
        private int s132hc25 =0;
        private int s132hc125=0;
        private int s132hc168=0;

        private String modelName = "";


        private Builder (String name){
            modelName = name;}

        private Builder s154hc168 (int val)
        {s154hc168 = val; return this;}
        private Builder s154hc1616 (int val)
        {s154hc1616=val; return this;}
        private Builder s132hc125 (int val)
        {s132hc125=val; return this;}
        private Builder s132hc168 (int val)
        {s132hc168=val; return this;}

        private Builder s132hc5 (int val)
        {s132hc5=val; return this;}
        private Builder s132hc25 (int val)
        {s132hc25=val; return this;}
        private LiebherrCrane build ()
        {return new LiebherrCrane(this);}
    }

    private LiebherrCrane (Builder builder){
        s154hc168 = builder.s154hc168;
        s154hc1616=builder.s154hc1616;
        s132hc168 = builder.s132hc168;
        s132hc125=builder.s132hc125;
        s132hc5=builder.s132hc5;
        s132hc25=builder.s132hc25;
    }



    ArrayList<Section> towerSectionCollection = new ArrayList<Section>();


    @Override
    public String toString() {
        return "Liebherr crane class!";
    }


    /**
     * This is the special method to ordering tower
     */

    public void makeTower (){

        n=1;
        towerSectionCollection.clear();

        for ( i=1;i<=s154hc1616;i++){
            towerSectionCollection.add(new Section("sect154HC1616", n));
            n++;
        }
        for ( i=1;i<=s154hc168;i++){
            towerSectionCollection.add(new Section("sect154HC168", n));
            n++;
        }
        for ( i=1;i<=s132hc168;i++){
            towerSectionCollection.add(new Section("sect132HC168", n));
            n++;
        }
        for ( i=1;i<=s132hc125;i++){
            towerSectionCollection.add(new Section("sect132HC125", n));
            n++;
        }
        for ( i=1;i<=s132hc5;i++){
            towerSectionCollection.add(new Section("sect132HC5", n));
            n++;
        }
        for ( i=1;i<=s132hc25;i++){
            towerSectionCollection.add(new Section("sect132HC25", n));
            n++;
        }


    }

    @Override
    public ArrayList <Section> getTower(){
        return towerSectionCollection;
    }




    public LiebherrCrane (CraneComboboxPanel craneComboboxPanel) {

        this.craneComboboxPanel = craneComboboxPanel;

    }






    //current active controller panel
    //return later (suppressed!)

    public void createControl ( TowerCrane crane, CranePanel cranePanel){

        ControlPanel controlPanel = new LiebherrControl(crane,cranePanel);
        controlPanel.setControl(crane);
        cranePanel.addContol(controlPanel.getControlPanel());
    }










    public double getHeight(){
        double height = (double) (0.22+10.0*s154hc1616 + 10.0*s154hc168+ 10.0*s132hc168+12.5*s132hc125 + 5.0*s132hc5+2.5*s132hc25+4.7-3);
        return height;
    }

    public double getHeightUnderJib(double height) {

        double height2 =  height+3.0;

        return height2;



    }



}
