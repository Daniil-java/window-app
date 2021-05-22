package ru.geekbrains.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private JTextField textField;

    private int randomNumber;

    private final int realAttemptsNumber = 3;
    private int fakeAttemptsNubmer = realAttemptsNumber;

    private String repeatButtom = "R";

    public GameWindow() {
        this.randomNumber = (int)(Math.random() * 10) + 1; // [1, 10]

        setTitle("Игра: Угадай число");
        setBounds(600, 300, 600, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setLayout(new BorderLayout());
        setResizable(false);

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        textField.setText("Программа загадала число от 1 до 10");
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        Font font = new Font("Arial", Font.PLAIN, 15);
        textField.setFont(font);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 15));
        add(buttonsPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(font);
            buttonsPanel.add(button);

            int buttonIndex = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fakeAttemptsNubmer--;
                    tryToAnswer(buttonIndex);
                }
            });
        }

        JButton button = new JButton(repeatButtom);
        button.setFont(font);
        buttonsPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toRepeat(repeatButtom);
            }
        });

        setVisible(true);
    }

    private void tryToAnswer(int answer) {
        if (fakeAttemptsNubmer <= 0) {
            textField.setText("Количество попыток закончилось. Вы можете перезапустить игру.");
            return;
        }
        if (answer == randomNumber) {
            textField.setText("Вы угадали!!! Ответ: " + randomNumber);
        } else if (answer > randomNumber) {
            textField.setText("Не угадали! Попыток осталось: " + fakeAttemptsNubmer + ". Загаданное число меньше, чем " + answer);
        } else {
            textField.setText("Не угадали! Попыток осталось: " + fakeAttemptsNubmer + ". Загаданное число больше, чем " + answer);
        }
    }

    private void toRepeat(String repeatButtom) {
        this.randomNumber = (int)(Math.random() * 10) + 1;
        textField.setText("Игра началась! Компьютер загадал новое число.");
        fakeAttemptsNubmer = realAttemptsNumber;
    }
}
