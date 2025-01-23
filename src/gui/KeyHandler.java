package gui;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    private final Panel panel;
    private final double sensitivty = 300;

    private volatile boolean leftPressed = false;
    private volatile boolean rightPressed = false;
    private volatile boolean upPressed = false;
    private volatile boolean downPressed = false;
    private volatile boolean rollLeftPressed = false;
    private volatile boolean rollRightPressed = false;



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
                rollRightPressed = true;
                break;
            case KeyEvent.VK_E:
                rollLeftPressed = true;
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
                rollRightPressed = false;
            case KeyEvent.VK_E:
                rollLeftPressed = false;
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
            panel.tracer.perspectiveProjection.eye.x += sensitivty;
        } else if (rightPressed) {
            panel.tracer.perspectiveProjection.eye.x -= sensitivty;
        }

        if (upPressed) {
            panel.tracer.perspectiveProjection.eye.z += sensitivty;
        } else if (downPressed) {
            panel.tracer.perspectiveProjection.eye.z -= sensitivty;
        }

        if(rollLeftPressed) {
            panel.tracer.perspectiveProjection.eye.y += sensitivty;
        } else if(rollRightPressed) {
            panel.tracer.perspectiveProjection.eye.y -= sensitivty;
        }

        panel.mouseInput = false;
        panel.repaint();
    }




}
