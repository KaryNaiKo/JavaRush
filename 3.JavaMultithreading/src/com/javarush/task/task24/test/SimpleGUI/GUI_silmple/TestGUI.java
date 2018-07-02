package com.javarush.task.task24.test.SimpleGUI.GUI_silmple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Павлуша on 15.11.2017.
 */
public class TestGUI {
    public static int countOfClic;
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TestGUI testGUI = new TestGUI();
        testGUI.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListner());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListner());

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class LabelListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(countOfClic + " timp click");
            countOfClic++;
        }
    }

    class ColorListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }
}
