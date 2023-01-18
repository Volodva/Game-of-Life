package base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window implements Runnable {

    JFrame frame;
    Box[][] boxes;
    Timer timer;

    @Override
    public void run() {

        initFrame();
        initBoxes();
        initNearBoxes();
    }

    private void initFrame() {

        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * Config.WIDTH, Config.SIZE * Config.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("LIFE OF GAME");

        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    stopRestartTimer();
                }
            }
        });
    }

    private void initBoxes() {

        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {

                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);

            }
        }
    }

    private void initNearBoxes() {

        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                for (int nearx = -1; nearx <= 1; nearx++) {
                    for (int neary = -1; neary <= 1; neary++) {
                        if (!(nearx == 0 && neary == 0)) {
                            boxes[x][y].getCell().addNear(boxes[
                                    (x + nearx + Config.WIDTH) % Config.WIDTH]
                                    [(y + neary + Config.HEIGHT) % Config.HEIGHT]
                                    .getCell());
                        }
                    }
                }
            }
        }
    }

    public void start() {

        Action t = new Action();
        timer = new Timer(Config.SLEEP_MS, t);
        timer.start();
    }

    private void stopRestartTimer() {

        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }


    private class Action implements ActionListener {
        private boolean turnOn = false;

        @Override
        public void actionPerformed(ActionEvent e) {

            turnOn = !turnOn;
            for (int x = 0; x < Config.WIDTH; x++) {
                for (int y = 0; y < Config.HEIGHT; y++) {

                    if (turnOn) {
                        boxes[x][y].step1();
                    } else {
                        boxes[x][y].step2();
                    }
                }
            }
        }
    }

}