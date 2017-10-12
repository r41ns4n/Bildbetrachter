package com.sabel;

import javax.swing.*;
import java.awt.*;

public class Bildbetrachter extends JFrame {

    private JPanel jPanelWest, jPanelSouth;
    private JButton jButtonPrev, jButtonNext;
    private ButtonGroup buttonGroup;

    public Bildbetrachter() {
        super("Bilder");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        this.setVisible(true);
    } // END Bildbetrachter()

    private void initComponents() {
        // GENERATE JFRAMES
        jPanelWest = new JPanel();
        // SET BUTTONS HORIZONTAL
        this.jPanelWest.setLayout(new BoxLayout(jPanelWest, BoxLayout.Y_AXIS));
        jPanelSouth = new JPanel();

        // GENERATE RADIOBUTTONS AND SET AS GROUP
        JRadioButton[] jRadios;
        jRadios = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            jRadios[i] = new JRadioButton("Bild" + (i + 1));
            buttonGroup.add(jRadios[i]);
            jPanelWest.add(jRadios[i]);
        }

        // SET BUTTON
        jRadios[0].setSelected(true);

        // GENERATE BUTTONS AND ADD TO PANEL
        jButtonPrev = new JButton("Vorheriges Bild");
        jButtonNext = new JButton("Nächstes Bild");
        jPanelSouth.add(jButtonPrev);
        jPanelSouth.add(jButtonNext);

        // GENERATE ICONS
        Icon icon = new ImageIcon("D:\\G I3A\\Anwendungsentwicklung\\bildbetrachter\\Bild1.jpg");
        JLabel jLabelPictures = new JLabel(icon);
        JScrollPane jScrollPanePictures = new JScrollPane(jLabelPictures);

        // ADD JPANELS TO FRAME
        this.add(jPanelWest, BorderLayout.WEST);
        this.add(jScrollPanePictures, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);
    } // END void initComponents()


} // END class Bildbetrachter
