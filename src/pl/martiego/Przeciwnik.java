package pl.martiego;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Przeciwnik {

    private Image postac = (Image)image();

    private int x = 50;
    private int y = 50;

    private int xPostaci = postac.getWidth(null);
    private int yPostaci = postac.getHeight(null);

    public Przeciwnik() {
        Random random = new Random();

        x = random.nextInt(90) * 10;
        y = random.nextInt(50) * 10;
    }

    public Image image() {
        //Zastanawiam się co to jest, ale to pozwala nam szukać tego obrazka wewnątrz archiwum, tzn. ze JAR otwarza obrazek ^^
        java.net.URL imgURL = getClass().getResource("kropka.gif");
        return new ImageIcon(imgURL).getImage();
    }

    public Image getImage() {
        return postac;
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
}
