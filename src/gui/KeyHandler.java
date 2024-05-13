package gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    private final Panel panel;
    public double angleX, angleY, angleZ;
    private final double sensitivty = 0.1;

    private volatile boolean leftPressed = false;
    private volatile boolean rightPressed = false;
    private volatile boolean upPressed = false;
    private volatile boolean downPressed = false;
    private volatile boolean rollLeftPressed = false;
    private volatile boolean rollRightPressed = false;



    public KeyHandler(Panel panel) {
        this.panel = panel;
        angleX = 0.0;
        angleY = 0.0;
        angleZ = 0.0;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {

            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_Q:
                rollLeftPressed = true;
                break;
            case KeyEvent.VK_E:
                rollRightPressed = true;
                break;
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
            case KeyEvent.VK_A:
                leftPressed = false;
            case KeyEvent.VK_D:
                rightPressed = false;
            case KeyEvent.VK_W:
                upPressed = false;
            case KeyEvent.VK_S:
                downPressed = false;
            case KeyEvent.VK_Q:
                rollLeftPressed = false;
            case KeyEvent.VK_E:
                rollRightPressed = false;
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
            angleX -= sensitivty;
        } else if (rightPressed) {
            angleX += sensitivty;
        }

        if (upPressed) {
            angleY += sensitivty;
        } else if (downPressed) {
            angleY -= sensitivty;
        }

        if(rollLeftPressed) {
            angleZ -= sensitivty;
        } else if(rollRightPressed) {
            angleZ += sensitivty;
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

    public double getAngleZ() { return angleZ; }

    public void setAngleX(double newAngle) {
        angleX = newAngle;
    }

    public void setAngleY(double newAngle) {
        angleY = newAngle;
    }

    public void setAngleZ(double newAngle) {
        angleZ = newAngle;
    }

}
