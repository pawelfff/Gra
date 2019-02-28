package pl.martiego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Postac {
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

    //Sterowanie ;p easy
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

    public Image postac = (Image)image();

    int x = 50;
    int y = 50;

    private int dx = 10;
    private int dy = 10;

    int xPostaci = postac.getWidth(null);
    int yPostaci = postac.getHeight(null);

    JPanel pojemnik;
}
