package gui;

import javax.swing.*;
public class Frame extends JFrame {

    public Frame(int WIDTH, int HEIGHT) {
        setTitle("RenderEngine");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
