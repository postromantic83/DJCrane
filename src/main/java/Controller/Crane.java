package controller;

/**
 * Created by ShurikNote on 29.07.2015.
 */


import java.util.ArrayList;
import view.*;


public class Crane extends AbstractCrane  {

    //CranePanel panel1;
    String model;
    String producer;



    public float getHeight(){
        return 0;
    }

        public float getHeight2(float f){

        return 0;
    }

    public Crane setTowerCombination(CranePanel parent, ControlPanel cp){

    return new Crane();
    }
    public void setModel (String md){
        this.model=md;
    }
    public void setProdecer (String pr){
        this.producer=pr;
    }
    public String getModel (){return this.model;}
    public String getProducer(){return this.producer;}


    public void createControl (){}
    public void createControl (CranePanel cranePanel, Crane crane){}

    public String [] getAvailableModels (){

        return null;
    }

    public String [] getAvailableModifications(String mod){

        return null;
    }



    //������������� � �����������:

    public void makeTower() {}
    public ArrayList getTower(){

        return null;
    }


    public ControlPanel setControl(CranePanel cp){
        return null;
    }



    public static void main (String [] args) {
        CranePanel panel1 = new CranePanel();

    }


}