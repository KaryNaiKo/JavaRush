package com.javarush.task.task24.test.SimpleGUI.ColorMusic;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Павлуша on 19.11.2017.
 */
public class MyDrawPanel extends JPanel implements ControllerEventListener {
    boolean msg = false;

    @Override
    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }

    public void paintComponent(Graphics g) {
        if(msg) {
            Graphics2D g2 = (Graphics2D) g;

            int r = (int) (Math.random() * 250);
            int gr = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);

            g.setColor(new Color(r, gr, b));

            int ht = (int) (Math.random() * 120) + 10;
            int width = (int) (Math.random() * 120) + 10;

            int x = (int) (Math.random() * 40) + 50;
            int y = (int) (Math.random() * 40) + 50;

            g.fillRect(x, y, ht, width);
            msg = false;
        }
    }
}
