package view;




import mainpack.PropertyMain;

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
 */
public class VisioPanel extends JPanel {

    private ArrayList col2;
    private Graphics2D g;
    PropertyMain props;


    VisioPanel() {

    }

    public void setCollection(ArrayList collect) {
        this.col2 = collect;


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
        gra.drawImage(bi,null,0,0);

        try {
            ImageIO.write(bi, "JPEG", new File("MyImageName.JPG"));
            ImageIO.write(bi, "PNG", new File("MyPNGImageName.PNG"));

        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    public Graphics2D drawCrane(Graphics2D graph) {
        this.g = graph;

        BasicStroke pen1 = new BasicStroke(1);
        BasicStroke pen2 = new BasicStroke(2);


        int x = STARTX;
        int y = STARTY;
        int m = SCALE;


        if (this.col2 != null) {
            Iterator<Section> it1 = this.col2.iterator();
            int n = 0;
            int size;
            String element;


            while (it1.hasNext()) {

                element = it1.next().name;
                n++;

                if (element.equals("sect154HC1616")) {
                    g.drawString(String.valueOf(n), x + 3 * m, y);
                    y = y - 10 * m;
                    g.setColor(Color.BLACK);

                    g.setStroke(pen2);
                    g.drawRect(x, y, 2 * m, 10 * m);
                    g.setStroke(pen1);


                }

                if (element.equals("sect154HC168")) {
                    g.drawString(String.valueOf(n), x + 3 * m, y);
                    y = y - 10 * m;
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, 2 * m, 10 * m);


                }
                if (element.equals("sect132HC168")) {
                    g.drawString(String.valueOf(n), x + 3 * m, y);
                    y = y - 10 * m;
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, 2 * m, 10 * m);


                }

                if (element.equals("sect132HC125")) {
                    g.drawString(String.valueOf(n), x + 3 * m, y);
                    y = y - 12 * m;
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, 2 * m, 12 * m);


                }

                if (element.equals("sect132HC5")) {
                    g.drawString(String.valueOf(n), x + 3 * m, y);
                    y = y - 5 * m;
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, 2 * m, 5 * m);


                }
                if (element.equals("sect132HC25")) {
                    g.drawString(String.valueOf(n), x + 3 * m, y);
                    y = y - 25;
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, 2 * m, (int) (2.5 * m));


                }


            }
            //рисуем голову крана
            //поворотка
            y -= 1 * m;
            g.drawRect(x + ((int) (0.1 * m)), y, (int) (1.8 * m), 1 * m);

            //кабина
            y -= 4 * m;
            g.drawRect(x, y, 2 * m, 4 * m);

            //стрела
            g.drawLine(x, y, x + 30 * m, y);
            g.drawLine(x + 2 * m, y, x + 3 * m, y - 1 * m);
            g.drawLine(x + 29 * m, y - 1 * m, x + 3 * m, y - 1 * m);
            g.drawLine(x + 29 * m, y - 1 * m, x + 30 * m, y);

            //консоль
            //y-=1*m;
            g.drawRect(x - 10 * m, y - (int) (0.2 * m), 10 * m, (int) (0.2 * m));

            //оголовок
            g.drawLine(x, y, x + 1 * m, y - 5 * m);
            g.drawLine(x + 2 * m, y, x + m, y - 5 * m);


            //ванты
            g.drawLine(x + m, y - 5 * m, x - 8 * m, y - (int) (0.2 * m));
            g.drawLine(x + m, y - 5 * m, x + 20 * m, y - m);



        }
        return g;


    }
}












