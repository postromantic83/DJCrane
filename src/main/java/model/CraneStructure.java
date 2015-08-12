package model;

import java.util.ArrayList;
import java.util.SortedSet;

/**
 * Created by SashaNote on 12.08.2015.
 *
 * SRM: get all modifications data
 *
 */
public class CraneStructure {
 ArrayList<String> availableModels;
    public CraneStructure(){
        availableModels = new ArrayList<String>();



    }



    public String[] getAvailableProducers(){
        final String PRODUCER[]={"- - -","Liebherr","Potain", "Everdigm"};
        return PRODUCER;
    }

     public synchronized void setAvailableModels (String producer) {
         availableModels.clear();

         //Later I will change this to SQL exec

         if(producer=="- - -")
             availableModels.add("unAvailable");
         if (producer=="Liebherr"){
             availableModels.add ("Liebherr 112EC-H8");
             availableModels.add ("Liebherr 132EC-H8");
             availableModels.add ("Liebherr 154EC-H8");

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
    public String [] getAvailableModels (){

        String[] arrayModels = new String[availableModels.size()];
        arrayModels = availableModels.toArray(arrayModels);
        return arrayModels;
    }








}
