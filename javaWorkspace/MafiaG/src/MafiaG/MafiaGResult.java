package MafiaG;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DB.DatabaseManager; // DatabaseManager import 확인
import java.awt.*;
import java.awt.event.*;
import java.util.List; // java.util.List import 확인

public class MafiaGResult extends JFrame {
	private String username; // 실제 닉네임
	private List<String> winners; // 승리자 목록 (실제 닉네임 또는 "Gemini")
	private List<String> participants; // 참가자 목록 (실제 닉네임) - 현재 미사용

	// 생성자
	public MafiaGResult(String username, List<String> winners, List<String> participants) {
		this.username = username;
		this.winners = winners;
		this.participants = participants;

		// 승패 여부 판정
		boolean isGeminiWinner = winners != null && winners.contains("Gemini"); // null 체크 추가
		boolean isPlayerWinner = winners != null && this.username != null && winners.contains(this.username) && !isGeminiWinner;
		boolean isPlayerLoser = winners != null && this.username != null && !winners.contains(this.username) && !isGeminiWinner;

		// UI 설정
		setTitle("MafiaG - 게임 결과");
		ImageIcon frameIcon = new ImageIcon("src/img/logo.png"); // 경로 확인
		setIconImage(frameIcon.getImage());
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);

		// 그라데이션 배경 패널 설정
		GradientPanel contentPane = new GradientPanel();
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);

		// 중앙 패널 (결과 텍스트 + 이미지)
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setOpaque(false);

		// 결과 텍스트 설정
		String resultText = getResultText(isGeminiWinner, isPlayerWinner, isPlayerLoser);
		JLabel resultLabel = new JLabel(resultText, SwingConstants.CENTER);
		resultLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 55));
		resultLabel.setForeground(new Color(50, 130, 200));
		resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		resultLabel.setBorder(BorderFactory.createEmptyBorder(60, 0, 30, 0));

		// 결과 이미지 설정
		String imagePath = getImagePath(isGeminiWinner, isPlayerWinner, isPlayerLoser);
		ImageIcon resultIcon = new ImageIcon(imagePath); // 경로 확인
		Image img = resultIcon.getImage().getScaledInstance(640, 384, Image.SCALE_SMOOTH);
		JLabel imageLabel = new JLabel(new ImageIcon(img));
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		centerPanel.add(resultLabel);
		centerPanel.add(imageLabel);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		// 하단 버튼 패널 (종료 버튼만 포함)
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 중앙 정렬 FlowLayout 사용
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(new EmptyBorder(10, 50, 20, 50)); // 상하좌우 여백

		// 종료 버튼 생성 및 설정
		JButton quitButton = new JButton();
		ImageIcon quitIcon = new ImageIcon("src/img/quit_button.png"); // 경로 확인
		Image resizedQuit = quitIcon.getImage().getScaledInstance(150, 110, Image.SCALE_SMOOTH);
		quitButton.setIcon(new ImageIcon(resizedQuit));
		quitButton.setPreferredSize(new Dimension(150, 110));
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// 종료 버튼 액션 리스너 설정
		quitButton.addActionListener(e -> logoutAndExit());

		// --- ❗ "다시하기" 관련 코드 및 잘못된 블록 완전 삭제됨 ❗ ---

		buttonPanel.add(quitButton); // 종료 버튼만 패널에 추가
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		// 창 닫기(X) 버튼 이벤트 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				logoutAndExit(); // X 버튼 눌러도 로그아웃 처리
			}
		});

		setVisible(true); // 창 보이기
	} // --- 생성자 끝 ---

	// 게임 결과 텍스트 반환 메소드 (사용자 정의 텍스트 반영)
	private String getResultText(boolean isGeminiWinner, boolean isPlayerWinner, boolean isPlayerLoser) {
		if (isGeminiWinner) {
			return "Gemini 승리!";
		} else if (isPlayerWinner) {
			return "당신은 AI를 지배하는 자"; // 사용자 정의 승리 텍스트
		} else { // isPlayerLoser 또는 기타 경우
			return "Gemini가 되지 못하였습니다."; // 사용자 정의 패배 텍스트
		}
	}

	// 게임 결과 이미지 경로 반환 메소드 (사용자 정의 반영)
	private String getImagePath(boolean isGeminiWinner, boolean isPlayerWinner, boolean isPlayerLoser) {
		if (isPlayerWinner) { // 플레이어 승리 시
			return "src/img/victory.png";
		} else { // Gemini 승리 또는 플레이어 패배 시
			return "src/img/defeat.png";
		}
	}

	// 로그아웃 및 프로그램 종료 메소드
	private void logoutAndExit() {
		System.out.println("[MafiaGResult] 로그아웃 및 종료. 사용자: " + username);
        // DatabaseManager.logoutUser(username); // DB 로그아웃 호출 (주석 해제 필요시)
		JOptionPane.showMessageDialog(null, "게임이 종료되었습니다. 다음에 또 만나요!"); // 메시지 변경
		System.exit(0); // 프로그램 완전 종료
	}

	// 내부 클래스: 그라데이션 배경 패널 (변경 없음)
	class GradientPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			Color color1 = new Color(180, 210, 255);
			Color color2 = new Color(255, 200, 200);
			GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
			g2d.setPaint(gp);
			g2d.fillRect(0, 0, getWidth(), getHeight());
		}
	}

} // --- MafiaGResult 클래스 끝 ---