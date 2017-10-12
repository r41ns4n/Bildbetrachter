package com.sabel;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bildbetrachter extends JFrame {

    private JPanel jPanelWest, jPanelSouth;
    private JButton jButtonPrev, jButtonNext;
    private ButtonGroup buttonGroup;
    private JRadioButton[] jRadios;
    private Icon[] jIcons;
    private JScrollPane jScrollPanePictures;
    private JLabel jLabelPictures;


    public Bildbetrachter() {
        super("Bilder");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        initEvents();
        this.setVisible(true);
    } // END Bildbetrachter()


    private void initComponents() {
        // GENERATE JFRAMES
        jPanelWest = new JPanel();
        // SET BUTTONS HORIZONTAL
        this.jPanelWest.setLayout(new BoxLayout(jPanelWest, BoxLayout.Y_AXIS));
        jPanelSouth = new JPanel();

        // GENERATE RADIOBUTTONS AND SET AS GROUP
        jRadios = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            jRadios[i] = new JRadioButton("Bild" + (i + 1));
            buttonGroup.add(jRadios[i]);
            jPanelWest.add(jRadios[i]);
        } // END IF

        // SET BUTTON
        jRadios[0].setSelected(true);

        // GENERATE BUTTONS AND ADD TO PANEL
        jButtonPrev = new JButton("Vorheriges Bild");
        jButtonNext = new JButton("Nächstes Bild");
        jPanelSouth.add(jButtonPrev);
        jPanelSouth.add(jButtonNext);

        // GENERATE ONE ICONS
        // Icon image1 = new ImageIcon("D:\\G I3A\\Anwendungsentwicklung\\bildbetrachter\\Bild1.jpg");
        // JLabel jLabelPicture1 = new JLabel(image1);
        // JScrollPane jScrollPanePicture1 = new JScrollPane(jLabelPicture1);

        // GENERATE ICON ARRAY
        jIcons = new Icon[4];
        String src = "D:\\G I3A\\Anwendungsentwicklung\\bildbetrachter\\Bild";
        for (int i = 0; i < jIcons.length; i++) {
            jIcons[i] = new ImageIcon(src + (i + 1) + ".jpg");
        } // END IF

        // START WHIT THE FIRST PICTURE
        jLabelPictures = new JLabel();
        jLabelPictures.setIcon(jIcons[0]);
        jScrollPanePictures = new JScrollPane(jLabelPictures);

        // ADD JPANELS TO FRAME
        this.add(jPanelWest, BorderLayout.WEST);
        this.add(jPanelSouth, BorderLayout.SOUTH);
        this.add(jScrollPanePictures, BorderLayout.CENTER);
    } // END void initComponents()


    private void initEvents() {
        for (int i = 0; i < jRadios.length; i++) {
            int picture = i;
            this.jRadios[picture].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jLabelPictures.setIcon(jIcons[picture]);
                } // END OVERRIDE jRadios[picture]
            });
        } // END FOR

    } // END void initEvents()

} // END class Bildbetrachter
