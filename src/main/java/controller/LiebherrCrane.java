package controller;

import model.Section;
import view.ControlPanel;
import view.CranePanel;
import view.LiebherrControl;

import java.util.ArrayList;

/**
 * Created by Sokolov on 03.02.2015.
 *
 * SRM: build Liebherr towers
 *
 */

public class LiebherrCrane extends TowerCrane {



    CranePanel cranePanel;
    ControlPanel lp;
    LiebherrCrane crane132;



    private int i,n;
    private int s154hc168, s154hc1616,s132hc5,s132hc25,s132hc125,s132hc168;
    private String modelName;



    //Builder pattern for new crane
    public static class Builder {
        private int s154hc168=0;
        private int s154hc1616=0;
        private int s132hc5=0;
        private int s132hc25 =0;
        private int s132hc125=0;
        private int s132hc168=0;

        private String modelName = "";


        public Builder (String name){
            this.modelName = name;}

        public Builder s154hc168 (int val)
        {s154hc168 = val; return this;}
        public Builder s154hc1616 (int val)
        {s154hc1616=val; return this;}
        public Builder s132hc125 (int val)
        {s132hc125=val; return this;}
        public Builder s132hc168 (int val)
        {s132hc168=val; return this;}

        public Builder s132hc5 (int val)
        {s132hc5=val; return this;}
        public Builder s132hc25 (int val)
        {s132hc25=val; return this;}
        public LiebherrCrane build ()
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


    ArrayList<Section> col1 = new ArrayList<Section>();


    @Override
    public String toString() {
        return "Liebherr crane class!";
    }


    /**
     * This is the special method to ordering tower
     */

    public void makeTower (){

        n=1;
        col1.clear();

        for ( i=1;i<=s154hc1616;i++){
            col1.add(new Section("sect154HC1616",n));
            n++;
        }
        for ( i=1;i<=s154hc168;i++){
            col1.add(new Section("sect154HC168",n));
            n++;
        }
        for ( i=1;i<=s132hc168;i++){
            col1.add(new Section("sect132HC168",n));
            n++;
        }
        for ( i=1;i<=s132hc125;i++){
            col1.add(new Section("sect132HC125",n));
            n++;
        }
        for ( i=1;i<=s132hc5;i++){
            col1.add(new Section("sect132HC5",n));
            n++;
        }
        for ( i=1;i<=s132hc25;i++){
            col1.add(new Section("sect132HC25",n));
            n++;
        }


    }







    public ArrayList getTower(){
        return col1;
    }




    public LiebherrCrane (CranePanel cranePanel) {

        this.cranePanel = cranePanel;

    }


    public String[] getAvailableModels(){
        final String LIEBHERRMODELS[]={"Liebherr 112EC-H8","Liebherr 132EC-H8", "Liebherr 154EC-H10"};
        return LIEBHERRMODELS;
    }

    public String [] getAvailableModifications(String mod){


        if (mod=="Liebherr 112EC-H8" | mod=="Liebherr 132EC-H8" )

        {
            String MODIFS[] = {"Anchor 120HC/AHK-07", "Anchor 154HC/AHK-06","Stationar undercarridge 120HC", "Stationar undercarridge 154HC"};
            return MODIFS;
        }else if ( mod == "Liebherr 154EC-H10"){
            String MODIFS[] = { "Anchor 154HC/AHK-06", "Stationar undercarridge 154HC"};
            return MODIFS;
        }


        else {
            String MODIFS[] = {"- - -"};
            return MODIFS;
        }
    }


    //current active controller panel
    //return later (suppressed!)

    public void createControl (CranePanel cranePanel, TowerCrane crane){

        ControlPanel lp = new LiebherrControl(cranePanel, this);
        lp.setControl(lp);
    }


  /*  public ControlPanel setControl(CranePanel cp){

        ControlPanel lp = new LiebherrControl(cp, this);
        return lp;
    }*/




    public TowerCrane setTowerCombination(CranePanel parent, ControlPanel lc) {

        crane132 = new Builder("Liebherr 132EC-H8")
                .s132hc25(lc.getS120HC_25())
                .s132hc5(lc.getS120HC_50())
                .s132hc125(lc.getS120HC_125())
                .s132hc168(lc.getS132HC_168())
                .s154hc168(lc.getS154HC_168())
                .s154hc1616(lc.getS154HC_1616())
                .build();


    return crane132;

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
