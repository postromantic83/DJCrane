package view;




import mainpack.PropertyMain;
import model.Section;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Sokolov on 03.02.2015.
 *
 * SRP: draw model from tower collection
 *
 * change request: adding new elements to draw
 *
 */
public class VisioPanel extends JPanel {

    private ArrayList towerCollection;
    private Graphics2D g;
    private int x;
    private int y;
    private int m;
    private String element;


    private BasicStroke pen1;
    private BasicStroke pen2;

    PropertyMain props;


    VisioPanel() {
        props = new PropertyMain();

    }

    public void setCollection(ArrayList collect) {
        this.towerCollection = collect;


    }


    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        g = (Graphics2D) gr;
        drawCrane(g);


    }

    /*
    *   method for saving PNG files
    *
    *   the same directory
    *
    * */
    public void savePNG (){

        BufferedImage bi = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gra = bi.createGraphics();
        gra = drawCrane(gra);
        gra.drawImage(bi, null, 0, 0);

        try {
            ImageIO.write(bi, "JPEG", new File("MyImageName.JPG"));
            ImageIO.write(bi, "PNG", new File("MyPNGImageName.PNG"));

        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    public Graphics2D drawCrane(Graphics2D graph) {
        this.g = graph;

        pen1 = new BasicStroke(1);
        pen2 = new BasicStroke(2);



        x = props.getSTARTX();
        y = props.getSTARTY();
        m = props.getSCALE();


        if (this.towerCollection != null) {
            Iterator<Section> sectionIterator = this.towerCollection.iterator();
            int n = 0;
            int size;



            while (sectionIterator.hasNext()) {

                element = sectionIterator.next().name;
                n++;

                if (element.equals("sect154HC1616")) {
                    drawSectionReinforced(10, 2);

                }

                if (element.equals("sect154HC168")) {
                    drawSection(10,2);

                }
                if (element.equals("sect132HC168")) {
                    drawSection(10,2);

                }

                if (element.equals("sect132HC125")) {
                    drawSection(12,2);


                }

                if (element.equals("sect132HC5")) {
                    drawSection(5,2);

                }
                if (element.equals("sect132HC25")) {
                    drawSection(3, 2);


                }
                if (element.equals("K439A")) {
                    drawSectionReinforced(5, 2);

                }
                if (element.equals("K437A")) {
                    drawSection(5,2);

                }
                if (element.equals("K437C")) {
                    drawSection(3, 2);

                }



                switch (element.toString()) {
                    case ("SR26E 10.5m 50/50"):
                        drawSectionReinforced(10,1);
                        break;
                    case ("SR24E 10.5m 40/40"):
                        drawSection(10, 1);
                        break;
                    case ("S24E 10.5m 40/40"):
                        drawSection(10,1);
                        break;
                    case ("S24A 3.0m"):
                        drawSection(3,1);
                        break;
                    case ("S20/S20 1.5m"):
                        drawSection(1,1);
                        break;

                }





            }

            //slewing platform
            y -= 1 * m;
            g.drawRect(x + ((int) (0.1 * m)), y, (int) (1.8 * m), 1 * m);

            //
            y -= 4 * m;
            g.drawRect(x, y, 2 * m, 4 * m);

            //jib
            g.drawLine(x, y, x + 30 * m, y);
            g.drawLine(x + 2 * m, y, x + 3 * m, y - 1 * m);
            g.drawLine(x + 29 * m, y - 1 * m, x + 3 * m, y - 1 * m);
            g.drawLine(x + 29 * m, y - 1 * m, x + 30 * m, y);

            //counterjib
            //y-=1*m;
            g.drawRect(x - 10 * m, y - (int) (0.2 * m), 10 * m, (int) (0.2 * m));

            //tower head
            g.drawLine(x, y, x + 1 * m, y - 5 * m);
            g.drawLine(x + 2 * m, y, x + m, y - 5 * m);


            //jib suspension
            g.drawLine(x + m, y - 5 * m, x - 8 * m, y - (int) (0.2 * m));
            g.drawLine(x + m, y - 5 * m, x + 20 * m, y - m);



        }
        return g;
    }
    private void drawSection(int height, int width){
            g.drawString(element.toString(), x + 3 * m, y);
            y = y - height * m;
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width * m, height * m);

    }
    private void drawSectionReinforced(int height, int width){
        g.setStroke(pen2);
        y = y - height * m;
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width * m, height * m);
        g.setStroke(pen1);

    }





}












