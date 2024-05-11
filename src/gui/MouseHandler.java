package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener {


    // Dependecy Injection
    private final Panel panel;

    private int prevX, prevY;
    public double angleX, angleY;
    public MouseHandler(Panel panel) {
        this.panel = panel;
        prevX = 0;
        prevY = 0;
        angleX = 0.0;
        angleY = 0.0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int newX = e.getX();
        int newY = e.getY();

        int deltaX = newX - prevX;
        int deltaY = newY - prevY;

        prevX = newX;
        prevY = newY;

        // Sensitivity factor
        double sensitivity = 0.01;

        angleX += deltaX * sensitivity;
        angleY += deltaY * sensitivity;
        panel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        prevX = e.getX();
        prevY = e.getY();
    }

    public double getAngleX() {
        return angleX;
    }

    public double getAngleY() {
        return angleY;
    }
}