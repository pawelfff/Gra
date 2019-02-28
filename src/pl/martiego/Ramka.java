package pl.martiego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ramka extends JFrame {
    private Ramka.PanelAnimacji panelAnimacji = new Ramka.PanelAnimacji();

    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public Ramka() {
        this.setTitle("Gra");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(width / 4,height / 4,width / 2,height / 2);

        this.setResizable(false);

        panelAnimacji.setBackground(Color.gray);
        this.getContentPane().add(panelAnimacji);

    }

    public class PanelAnimacji extends JPanel implements KeyListener {
        public PanelAnimacji() {
            JButton start = new JButton("start");
            postac = new Postac(this);

            start.addKeyListener(this);
            start.addActionListener(e -> {
                postac.x = 50;
                postac.y = 50;
                watek = new Thread(new PostacRunnable(postac));
                watek.start();
            });
            this.add(start ,BorderLayout.SOUTH);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(postac.getImage(), postac.x, postac.y, null);
            //g.drawRect(100,100,100,100);
        }

        Thread watek;
        Postac postac;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            postac.go(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        public class PostacRunnable implements Runnable {
            public PostacRunnable(Postac postac) {
                this.postac = postac;
            }
            @Override
            public void run() {
                try {
                    while(!Thread.currentThread().isInterrupted()) {
                        //this.postac.ruszPostac();
                        repaint();
                        Thread.sleep(1);

                    }
                }
                catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            Postac postac;
        }
    }
}
