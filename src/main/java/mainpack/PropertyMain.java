package mainpack;

/**
 * Created by ShurikNote on 28.07.2015.
 *
 * SRM: read program constants
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

    private int FIELD_WIDTH;
    private int FIELD_HEIGHT;
    private int STARTX;
    private int STARTY;
    private int SCALE;

    public PropertyMain (){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/DJCrane.properties");
            property.load(fis);

            this.FIELD_WIDTH = Integer.valueOf(property.getProperty("FIELD_WIDTH", "1"));
            this.FIELD_HEIGHT = Integer.valueOf(property.getProperty("FIELD_HEIGHT", "1"));
            this.STARTX = Integer.valueOf(property.getProperty("STARTX", "1"));
            this.STARTY = Integer.valueOf(property.getProperty("STARTY", "1"));
            this.SCALE = Integer.valueOf(property.getProperty("SCALE", "1"));

            logger.info("params readed");
            logger.info("current params are: {} x {}", this.FIELD_WIDTH, this.FIELD_HEIGHT);



            }
             catch (IOException e) {
            logger.error("Error reading property file, creating default params!");
            this.FIELD_WIDTH = 1024;
            this.FIELD_HEIGHT = 768;
            this.STARTX = 200;
            this.STARTY = 650;
            this.SCALE = 10;
        }
    }
}
