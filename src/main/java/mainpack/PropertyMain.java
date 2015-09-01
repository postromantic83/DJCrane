package mainpack;

/**
 * Created by ShurikNote on 28.07.2015.
 *
 * SRP: read program constants
 *
 * change request: adding or changing application params
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created by ShurikNote on 16.07.2015.
 */
public class PropertyMain {

    Logger logger = LoggerFactory.getLogger(Main.class);


    public int getFIELD_WIDTH(){
        return FIELD_WIDTH;
    }
    public int getFIELD_HEIGHT() {
        return FIELD_HEIGHT;
    }
    public int getSTARTX() {return STARTX;   }
    public int getSTARTY() { return STARTY;}
    public int getSCALE() {
        return SCALE;
    }

    private static int FIELD_WIDTH;
    private static int FIELD_HEIGHT;
    private static int STARTX;
    private static int STARTY;
    private static int SCALE;


    public PropertyMain (){}

    public void loadParams (){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/DJCrane.properties");
            property.load(fis);

            FIELD_WIDTH = Integer.valueOf(property.getProperty("FIELD_WIDTH", "640"));
            FIELD_HEIGHT = Integer.valueOf(property.getProperty("FIELD_HEIGHT", "480"));
            STARTX = Integer.valueOf(property.getProperty("STARTX", "100"));
            STARTY = Integer.valueOf(property.getProperty("STARTY", "100"));
            SCALE = Integer.valueOf(property.getProperty("SCALE", "10"));

            logger.info("params readed");
//            logger.info("current params are: {} x {}", this.FIELD_WIDTH, this.FIELD_HEIGHT);



            }
             catch (IOException e) {
            logger.error("Error reading property file, creating default params!");

            FIELD_WIDTH = 1024;
            FIELD_HEIGHT = 768;
            STARTX = 200;
            STARTY = 650;
            SCALE = 10;
        }
    }
}
