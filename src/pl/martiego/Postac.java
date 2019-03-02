package pl.martiego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Postac {

    private Image postac = (Image)image();

    private int x = 50;
    private int y = 50;

    public int zdrowie = 100;
    public int atak = 50;

    private int dx = 10;
    private int dy = 10;

    private int xPostaci = postac.getWidth(null);
    private int yPostaci = postac.getHeight(null);

    private JPanel pojemnik;

    public void levelup ()
    {
        zdrowie = zdrowie + 20;
        atak = atak + 10 ;

    }
    public int atak (int zdrowie)
    {

        zdrowie = zdrowie - atak;
     return zdrowie;
    }

    public Postac(JPanel pojemnik) {
        this.pojemnik = pojemnik;
    }

    public Image getImage() {
        return postac;
    }

    public void go(int key) {
        if(key == KeyEvent.VK_RIGHT)
            goRight();
        else if(key == KeyEvent.VK_LEFT)
            goLeft();
        else if(key == KeyEvent.VK_UP)
            goUp();
        else if(key == KeyEvent.VK_DOWN)
            goDown();
    }

    private void goRight() {
        if(pojemnik.getBounds().getMaxX() - xPostaci <= x) {
            x = (int)pojemnik.getBounds().getMaxX() - xPostaci;
        }
        else {
            //System.out.println(x);
            //System.out.println((int)pojemnik.getBounds().getMaxX());
            x += dx;
        }

    }

    private void goLeft() {
        if(pojemnik.getBounds().getMinX() >= x) {
            x = 0;
        }
        else {
            x -= dx;
        }
    }

    private void goUp() {
        if(pojemnik.getBounds().getMinY() >= y) {
            y = 0;
        }
        else {
            y -= dy;
        }
    }

    private void goDown() {
        if(pojemnik.getBounds().getMaxY() - yPostaci <= y) {
            y = (int)pojemnik.getBounds().getMaxY() - yPostaci;
        }
        else {
            y += dy;
        }
    }

    public Image image() {
        //Zastanawiam się co to jest, ale to pozwala nam szukać tego obrazka wewnątrz archiwum, tzn. ze JAR otwarza obrazek ^^
        java.net.URL imgURL = getClass().getResource("kropelka.gif");
        return new ImageIcon(imgURL).getImage();
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxPostaci() {
        return xPostaci;
    }

    public void setxPostaci(int xPostaci) {
        this.xPostaci = xPostaci;
    }

    public int getyPostaci() {
        return yPostaci;
    }

    public void setyPostaci(int yPostaci) {
        this.yPostaci = yPostaci;
    }
    public void zdrowiePostac (int zdrowie)
    {
        this.zdrowie = zdrowie;


    }
}
