package mainpack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by ShurikNote on 28.07.2015.
 */
public class PropertyMainTest {
    PropertyMain proper;


    @Before
    public void setUp (){
        proper = new PropertyMain();
        }



    @Test
    public void propertiReturnsIncorrectFileValues (){
        assertEquals ("Width is not correct!",1000,proper.getFIELD_WIDTH());
        assertEquals ("Height is not correct!",768,proper.getFIELD_HEIGHT());
        assertEquals ("Start_x is not correct!",200,proper.getSTARTX());
        assertEquals ("Start_y is not correct!",650,proper.getSTARTY());
        assertEquals ("Scale is not correct!",10,proper.getSCALE());
        }

    @Test(expected = IOException.class)
    public void whenFileNotFoundExceptionIsThrown () throws IOException {
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/DJCrane2.properties");
        property.load(fis);

    }

}