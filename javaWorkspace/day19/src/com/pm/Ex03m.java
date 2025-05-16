package com.pm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex03m extends JFrame implements ActionListener, Runnable {
    JButton start = new JButton("시작");

    JButton set[] = new JButton[12];
    ImageIcon icon1 = new ImageIcon("chil.jpg"); // chil.jpg 이미지 확인
    ImageIcon icon2 = new ImageIcon("hole.jpg"); // hole.jpg 이미지 확인
    JLabel score = new JLabel("Score : 0 ");
    JLabel time = new JLabel("시간 : 60");
    Container c = new Container();

    JPanel gpanel = new JPanel();
    JPanel jpscore = new JPanel();
    JPanel stex = new JPanel();

    int ran1 = 0, ran2 = 0, cnt = -1, n = 60;

    Ex03m() {
        setTitle("ChilGuy 잡기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setLayout(new BorderLayout(10, 10));
        time.setFont(new Font("Arial", Font.BOLD, 20));
        score.setFont(new Font("Arial", Font.BOLD, 20));

        c.add(time, BorderLayout.NORTH);
        c.add(gpanel, BorderLayout.CENTER);

        gpanel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < set.length; i++) {
            set[i] = new JButton();
            gpanel.add(set[i]);
            set[i].setIcon(icon2); // 초기에는 hole 이미지
            set[i].setBorderPainted(false);
            set[i].setFocusPainted(false);
            set[i].setBackground(Color.DARK_GRAY);
            set[i].addActionListener(this);
        }

        c.add(jpscore, BorderLayout.SOUTH);
        jpscore.setLayout(new GridLayout(1, 2));
        jpscore.add(score);

        jpscore.add(stex);
        stex.setLayout(new FlowLayout(FlowLayout.RIGHT));
        stex.add(start);

        gpanel.setBackground(Color.DARK_GRAY);
        stex.setBackground(Color.LIGHT_GRAY);
        jpscore.setBackground(Color.LIGHT_GRAY);
        c.setBackground(Color.LIGHT_GRAY);

        Start();

        setSize(500, 500);
        setVisible(true); // 창을 보이도록 설정
    }

    private void Start() {
        on();
        start.addActionListener(this);
    }

    @Override
    public void run() {
        while (n > 0) {
            try {
                Thread.sleep(1000);
                n--;
                time.setText("시간 : " + n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (n == 0) {
                time.setText("Game Over !!");
                off();
            } else {
                random();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            Thread th = new Thread(this);
            th.start();
            random();
        } else {
            for (int i = 0; i < set.length; i++) {
                if (e.getSource() == set[i] && set[i].getIcon() == icon1) {
                    cnt++;
                    score.setText("Score : " + cnt);
                    set[i].setIcon(icon2);
                }
            }
        }
    }

    private void random() {
        ran1 = (int) (Math.random() * set.length);
        ran2 = (int) (Math.random() * set.length);

        while (ran1 == ran2) {
            ran2 = (int) (Math.random() * set.length);
        }

        set[ran1].setIcon(icon1);
        set[ran2].setIcon(icon1);

        Timer timer = new Timer();
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                set[ran1].setIcon(icon2);
                set[ran2].setIcon(icon2);
            }
        }, 1000);
    }

    public void on() {
        for (int i = 0; i < set.length; i++) {
            set[i].setEnabled(true);
        }
    }

    public void off() {
        for (int i = 0; i < set.length; i++) {
            set[i].setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new Ex03m();
    }
}
