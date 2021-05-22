package ru.geekbrains.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapApp extends JFrame {
    private int x = 100;
    private int y = 100;
    private int size = 20;

    public MapApp() {
        setTitle("Карта");
        setBounds(600, 200, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setLayout(new BorderLayout());
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#008800"));
        add(mainPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 4));
        buttonsPanel.setPreferredSize(new Dimension(1, 40));
        add(buttonsPanel, BorderLayout.SOUTH);

        JPanel rectPanel = new JPanel();
        rectPanel.setBounds(x, y, size, size);
        rectPanel.setBackground(Color.WHITE);
        mainPanel.add(rectPanel);

        JButton buttonDown = new JButton("Down");
        buttonsPanel.add(buttonDown);
        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y += 10;
                rectPanel.setBounds(x, y, size, size);
            }
        });

        JButton buttonUp = new JButton("Up");
        buttonsPanel.add(buttonUp);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y -= 10;
                rectPanel.setBounds(x, y, size, size);
            }
        });

        JButton buttonLeft = new JButton("Left");
        buttonsPanel.add(buttonLeft);
        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x -= 10;
                rectPanel.setBounds(x, y, size, size);
            }
        });

        JButton buttonRight = new JButton("Right");
        buttonsPanel.add(buttonRight);
        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x += 10;
                rectPanel.setBounds(x, y, size, size);
            }
        });

        rectPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("CLICKED");
            }
        });

        setVisible(true);
    }
}
