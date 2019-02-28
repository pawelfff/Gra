package pl.martiego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


    public class Main extends JFrame {

        public Main() {
            this.setTitle("Gra");
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setBounds(width / 4,height / 4,width / 2,height / 2);

            this.setResizable(false);

            panelAnimacji.setBackground(Color.gray);
            this.getContentPane().add(panelAnimacji);

        }

        private PanelAnimacji panelAnimacji = new PanelAnimacji();

        private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        private int height = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    public class PanelAnimacji extends JPanel implements KeyListener{
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
        ThreadGroup grupaWatkow = new ThreadGroup("Grupa Kropelek");

        Postac postac;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                postac.goRight();
            }

            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                postac.goLeft();
            }

            else if (e.getKeyCode() == KeyEvent.VK_UP) {
                postac.goUp();
            }

            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                postac.goDown();
            }
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
