package org.example.javapractice.JFrame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setSize(800, 500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btn1 = new JButton("ColdBrew");
        JButton btn2 = new JButton("Espresso");
        JButton btn3 = new JButton("Frappuccino");

        add(btn1);
        add(btn2);
        add(btn3);

        setVisible(true);
    }
}
