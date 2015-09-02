package model;

import java.util.ArrayList;


/**
 * Created by SashaNote on 12.08.2015.
 *
 * SRP: get all modifications data
 *
 * change request: changing data source
 *
 */
public class CraneStructure {
    private ArrayList<String> availableModels;
    private ArrayList<String> availableModifications;
    public CraneStructure(){
        availableModels = new ArrayList<String>();
        availableModifications = new ArrayList<String>();



    }



    public String[] getAvailableProducers(){
        final String PRODUCER[]={"- - -","Liebherr","Potain", "Everdigm"};
        return PRODUCER;
    }

     public void setAvailableModels (String producer) {
         availableModels.clear();

         //Later I will change this to SQL exec

         if(producer=="- - -")
             availableModels.add("unAvailable");
         if (producer=="Liebherr"){
             availableModels.add ("Liebherr 112EC-H8");
             availableModels.add ("Liebherr 132EC-H8");
             availableModels.add ("Liebherr 154EC-H10");

         }
         if (producer=="Potain"){
             availableModels.add ("Potain MDT-178");
             availableModels.add ("Potain MCT-88");
             availableModels.add ("Potain MC-85B");
         }
         if (producer=="Everdigm"){
             availableModels.add ("Everdigm KH-310");
         }

    }
    //getters specially return String Array

    public String [] getAvailableModels (){


        String[] arrayModels = new String[availableModels.size()];
        arrayModels = availableModels.toArray(arrayModels);
        return arrayModels;
    }

    public void setAvailableModifications (String model) {
        availableModifications.clear();
        if (model == "Liebherr 112EC-H8" | model == "Liebherr 132EC-H8")

        {
            availableModifications.add("Anchor 120HC/AHK-07");
            availableModifications.add("Anchor 154HC/AHK-06");
            availableModifications.add("Stationar undercarridge 120HC");
            availableModifications.add("Stationar undercarridge 154HC");

        } else if (model == "Liebherr 154EC-H10") {
            availableModifications.add("Anchor 154HC/AHK-06");
            availableModifications.add("Stationar undercarridge 154HC");

        } else

        if (model == "Potain MDT-178")

        {
            availableModifications.add("Anchor P41A");
            availableModifications.add("Anchor R40A");
            availableModifications.add("Stationar undercarridge S41");

        }
        else {
            availableModifications.add("UnAvailableModifications");
        }


    }
    public String [] getAvailableModifications (){
        String[] arrayModifications = new String[availableModels.size()];
        arrayModifications = availableModifications.toArray(arrayModifications);
        return arrayModifications;

    }

}
