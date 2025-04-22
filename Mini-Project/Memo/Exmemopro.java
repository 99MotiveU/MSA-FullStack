package com.am;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotepadAWT extends Frame {
    private TextArea textArea;
    private FileDialog openDialog, saveDialog;

    public NotepadAWT() {
        setTitle("메모장");
        setSize(600, 400);
        setLocationRelativeTo(null);

        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);

        createMenu();

        openDialog = new FileDialog(this, "파일 열기", FileDialog.LOAD);
        saveDialog = new FileDialog(this, "파일 저장", FileDialog.SAVE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void createMenu() {
        MenuBar menuBar = new MenuBar();

        // 파일 메뉴
        Menu fileMenu = new Menu("파일");
        MenuItem newFile = new MenuItem("새파일");
        MenuItem openFile = new MenuItem("열기");
        MenuItem saveFile = new MenuItem("저장");
        MenuItem saveAsFile = new MenuItem("다른 이름으로 저장");
        MenuItem exit = new MenuItem("종료");

        newFile.addActionListener(e -> textArea.setText(""));
        openFile.addActionListener(e -> openFile());
        saveFile.addActionListener(e -> saveFile(false));
        saveAsFile.addActionListener(e -> saveFile(true));
        exit.addActionListener(e -> dispose());

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.addSeparator();
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.addSeparator();
        fileMenu.add(exit);

        menuBar.add(fileMenu);
        menuBar.add(new Menu("보기"));

        setMenuBar(menuBar);
    }

    private void openFile() {
        openDialog.setVisible(true);
        String dir = openDialog.getDirectory();
        String file = openDialog.getFile();

        if (dir != null && file != null) {
            File selectedFile = new File(dir, file);
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                System.out.println("파일을 열 수 없습니다.");
            }
        }
    }

    private void saveFile(boolean saveAs) {
        if (saveAs || saveDialog.getFile() == null) {
            saveDialog.setVisible(true);
        }

        String dir = saveDialog.getDirectory();
        String file = saveDialog.getFile();

        if (dir != null && file != null) {
            File selectedFile = new File(dir, file);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile))) {
                bw.write(textArea.getText());
            } catch (IOException e) {
                System.out.println("파일을 저장할 수 없습니다.");
            }
        }
    }

    public static void main(String[] args) {
        new NotepadAWT();
    }
}
