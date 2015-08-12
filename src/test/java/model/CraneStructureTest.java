package model;

import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.*;

/**
 * Created by SashaNote on 12.08.2015.
 */
public class CraneStructureTest {

    @Test
    public void testGetAvailableProducers() throws Exception {
        CraneStructure craneStructure = new CraneStructure();
        String [] producers = craneStructure.getAvailableProducers();
        assertEquals ("Wrong data (producer)",producers [1],"Liebherr");
        assertEquals ("Wrong data (producer)",producers [2],"Potain");
        assertEquals ("Wrong data (producer)",producers [3],"Everdigm");
    }
}