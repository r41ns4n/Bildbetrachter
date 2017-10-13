package com.sabel;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bildbetrachter extends JFrame {

    private JPanel jPanelWest, jPanelSouth;
    private JButton jButtonPrev, jButtonNext;
    private ButtonGroup buttonGroup;
    private JRadioButton[] jRadios;
    private Icon[] jIcons;
    private JScrollPane jScrollPanePictures;
    private JLabel jLabelPictures;
    private int pictureNumber;
    private JDialog dialog;


    public Bildbetrachter() {
        super("Bilder");
        this.setSize(400, 400);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        initEvents();
        this.setVisible(true);
    } // END CONSTRUCTOR Bildbetrachter()


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
        String src = "D:\\G I3A\\Anwendungsentwicklung\\IntelliJ\\projects\\Bildbetrachter\\pics\\Bild";
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
        // ADD BUTTONS WITH ACTIONLISTENER
        for (int i = 0; i < jRadios.length; i++) {
            int picture = i;
            this.jRadios[picture].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jLabelPictures.setIcon(jIcons[picture]);
                } // END OVERRIDE jRadios[picture]
            });
        } // END FOR

        // ADD BUTTONNEXT WITH ACTIONLISTENER
        this.jButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pictureNumber < jIcons.length - 1) {
                    jLabelPictures.setIcon(jIcons[pictureNumber + 1]);
                    jRadios[pictureNumber + 1].setSelected(true);
                    ++pictureNumber;
                } else {
                    pictureNumber = 0;
                    jLabelPictures.setIcon(jIcons[pictureNumber]);
                    jRadios[pictureNumber].setSelected(true);
                }

            } // END OVERRIDE jButtonNext
        });

        // ADD BUTTONPREV WITH ACTIONLISTENER
        this.jButtonPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pictureNumber > 0) {
                    jLabelPictures.setIcon(jIcons[pictureNumber - 1]);
                    jRadios[pictureNumber - 1].setSelected(true);
                    pictureNumber--;
                } else {
                    pictureNumber = jIcons.length - 1;
                    jLabelPictures.setIcon(jIcons[pictureNumber]);
                    jRadios[pictureNumber].setSelected(true);
                }

            } // END OVERRIDE jButtonPrev
        });

        // ADD WINDOWCLOSE WITH ACTIONLISTENER
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });

    } // END void initEvents()


    // DIALOG METHOD TO CLOSE
    private void exit() {
        int result = JOptionPane.showConfirmDialog(null,
                "Möchten Sie das Programm jetzt beenden?",
                "Beenden bestätigen",
                JOptionPane.YES_NO_OPTION);

        switch (result) {
            case JOptionPane.YES_OPTION:
                System.exit(0);
        } // END SWITCH(RESULT)

    } // END void exit()

} // END class Bildbetrachter
