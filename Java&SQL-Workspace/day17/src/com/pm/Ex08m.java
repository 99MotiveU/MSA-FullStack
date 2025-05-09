package com.pm;

//�޸��� �����
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Ex08m extends Frame {

	private TextArea textArea;
	private FileDialog openDialog, saveDialog;

	public Ex08m() {
		setTitle("�޸���");
		setSize(600, 400);
		setLocationRelativeTo(null);

		textArea = new TextArea();
		add(textArea, BorderLayout.CENTER);

		createMenu();

		openDialog = new FileDialog(this, "���� ����", FileDialog.LOAD);
		saveDialog = new FileDialog(this, "���� ����", FileDialog.SAVE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setVisible(true);
	}

	private void createMenu() {
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("����");
		Menu hpMenu = new Menu("Help");
		MenuItem newFile = new MenuItem("������");
		MenuItem openFile = new MenuItem("����");
		MenuItem saveFile = new MenuItem("����");
		MenuItem saveAsFile = new MenuItem("�ٸ��̸����� ����");
		MenuItem exit = new MenuItem("����");
		MenuItem about = new MenuItem("about");

		newFile.addActionListener(e -> textArea.setText(""));
		newFile.addActionListener(e -> newFile());
		openFile.addActionListener(e -> openFile());
		saveFile.addActionListener(e -> saveFile(false));
		saveAsFile.addActionListener(e -> saveFile(true));
		exit.addActionListener(e -> dispose());
		about.addActionListener(e -> about());

		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.addSeparator();
		fileMenu.add(saveFile);
		fileMenu.add(saveAsFile);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		hpMenu.add(about);

		menuBar.add(fileMenu);
//		menuBar.add(new Menu("����"));
		menuBar.add(hpMenu);
		setMenuBar(menuBar);
	}// create menu end
//������ method �����

	private void newFile() {
		System.out.println("������ �����");
		
		
		
		
		
	}

	private void about() {
		
		System.out.println("���� ���� �޸���");
		
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
				System.out.println("������ ������ �� �����ϴ�.");
			}
		}
	}// savefile end

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
				System.out.println("������ �� �� �����ϴ�.");
			}
		}
	}// openfile end

	public static void main(String[] args) {
		new Ex08m();
	}// main end

}// ex08m end
