package pl.martiego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyListner implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("nice");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
