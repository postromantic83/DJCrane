package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by SashaNote on 12.08.2015.
 */
public class CraneStructureTest {

    private CraneStructure craneStructure;
    private ArrayList<String> availableModels;
    private ArrayList<String> availableModifications;

    @Before
    public void setUp(){
         craneStructure = new CraneStructure();
    }

    @Test
    public void getIncorrectAvailableProducers() throws Exception {
        String [] producers = craneStructure.getAvailableProducers();
        assertEquals ("Wrong data (producer)",producers [1],"Liebherr");
        assertEquals ("Wrong data (producer)",producers [2],"Potain");
        assertEquals("Wrong data (producer)", producers[3], "Everdigm");
    }
    @Test
    public void getIncorrectModel(){
        craneStructure.setAvailableModels("Liebherr");
        assertEquals("Wrong data (model)",craneStructure.getAvailableModels()[0],"Liebherr 112EC-H8");

        craneStructure.setAvailableModels("Potain");
        assertEquals("Wrong data (model)",craneStructure.getAvailableModels()[1],"Potain MCT-88");

    }
    @Test
    public void setIncorrectdefine (){

        //this setter modifies private variables
        //how can I get it ?




    }













}