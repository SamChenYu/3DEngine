package gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    private final Panel panel;
    public double angleX, angleY;
    private final double sensitivty = 0.1;

    private volatile boolean leftPressed = false;
    private volatile boolean rightPressed = false;
    private volatile boolean upPressed = false;
    private volatile boolean downPressed = false;



    public KeyHandler(Panel panel) {
        this.panel = panel;
        angleX = 0.0;
        angleY = 0.0;
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
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
        }
        update();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
            case KeyEvent.VK_UP:
                upPressed = false;
            case KeyEvent.VK_DOWN:
                downPressed = false;
        }

    }

    public void update() {


        if (leftPressed) {
            if(angleX > 0) {
                angleX *= 1.0;
            }
            angleX += sensitivty;
        } else if (rightPressed) {
            if(angleX < 0) {
                angleX *= 1.0;
            }
            angleX += sensitivty;
        }

        if (upPressed) {
            if(angleY > 0) {
                angleY *= 1.0;
            }
            angleY += sensitivty;
        } else if (downPressed) {
            if(angleY < 0) {
                angleY *= 1.0;
            }
            angleY += sensitivty;
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

}
