package pl.martiego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Ramka extends JFrame {
    private Ramka.PanelAnimacji panelAnimacji = new Ramka.PanelAnimacji();

    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    private List<Przeciwnik> listaPrzeciwnikow;

    public Ramka() {
        this.setTitle("Gra");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(width / 4,height / 4,width / 2,height / 2);

        this.setResizable(false);
        listaPrzeciwnikow = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            listaPrzeciwnikow.add(new Przeciwnik());

        panelAnimacji.setBackground(Color.gray);
        this.getContentPane().add(panelAnimacji);


    }


    public class PanelAnimacji extends JPanel implements KeyListener {
        public PanelAnimacji() {
            JButton start = new JButton("start");
            postac = new Postac(this);

            start.addKeyListener(this);

            start.addActionListener(e -> {
                postac.setX(50);
                postac.setY(50);
                watek = new Thread(new PostacRunnable(postac));
                watek.start();

            });
            this.add(start ,BorderLayout.SOUTH);

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(postac.getImage(), postac.getX(), postac.getY(), null);
            for (Przeciwnik p : listaPrzeciwnikow) {
                g.drawImage(p.getImage(), p.getX(), p.getY(), null);
            }
        }

        Thread watek;
        Postac postac;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE)

                compare();
            else
                postac.go(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }


        private void compare() {
            for (Przeciwnik p : listaPrzeciwnikow) {
                if ((p.getX() >= postac.getX() && (p.getX() + p.getxPostaci()) <= (postac.getX() + postac.getxPostaci()) &&
                        p.getY() >= postac.getY() && (p.getY() + p.getyPostaci()) <= (postac.getY() + postac.getyPostaci())) )
                {
                    p.zdrowie(postac.atak(p.zdrowie));
                    if (p.zdrowie <= 0)
                    {
                        postac.levelup();
                        listaPrzeciwnikow.remove(p);
                        break;

                    }
                }

            }



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
