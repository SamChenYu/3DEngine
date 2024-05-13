package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
public class MouseHandler implements MouseMotionListener, MouseWheelListener {


    // Dependecy Injection
    private final Panel panel;

    private int prevX, prevY;
    public double angleX, angleY, angleZ;


    public MouseHandler(Panel panel) {
        this.panel = panel;
        prevX = 0;
        prevY = 0;
        angleX = 0.0;
        angleY = 0.0;
        angleZ = 0.0;
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
        angleX += deltaX * sensitivity * -1.0;
        angleY += deltaY * sensitivity * -1.0;
        panel.mouseInput = true;
        panel.repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        double sensitivity = 0.1;
        angleZ += notches * sensitivity * -1.0;
        panel.mouseInput = true;
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

    public double getAngleZ() {
        return angleZ;
    }

    public void setAngleX(double newAngle) {
        angleX = newAngle;
    }

    public void setAngleY(double newAngle) {
        angleY = newAngle;
    }

    public void setAngleZ(double newAngle) { angleZ = newAngle; }


}
