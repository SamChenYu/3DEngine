package gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener, Runnable {

    private final Panel panel;
    public double angleX, angleY;

    private volatile boolean leftPressed = false;
    private volatile boolean rightPressed = false;
    private volatile boolean upPressed = false;
    private volatile boolean downPressed = false;


    public KeyHandler(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
            case KeyEvent.VK_UP:
                upPressed = true;
            case KeyEvent.VK_DOWN:
                downPressed = true;
        }
        update();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
        }
        update();
    }

    public void update() {
        if (leftPressed) {
            angleX = -0.1;
        } else
        if (rightPressed) {
            angleX = 0.1;
        }

        if (upPressed) {
            angleY = -0.1;
        } else
        if (downPressed) {
            angleY = 0.1;
        }
        panel.mouseInput = false;
        panel.repaint();
    }

    public double getAngleX() {
        return angleX;
    }

    public double getAngleY() {
        return angleY;
    }

    @Override
    public void run() {
        while (true) {
            update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
