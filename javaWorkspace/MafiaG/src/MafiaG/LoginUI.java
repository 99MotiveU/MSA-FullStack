package MafiaG;

import DB.UserScore;

import javax.swing.*;
import javax.swing.border.*;
import DB.DatabaseManager;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LoginUI {

	public void showLoginUI() {
		JFrame frame = new JFrame("MafiaG");
		ImageIcon icon = new ImageIcon("src/img/logo.png"); // 로고 경로
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 248));
		contentPane.setLayout(new GridBagLayout());

		RoundedPanel centerPanel = new RoundedPanel(20);
		centerPanel.setPreferredSize(new Dimension(400, 600));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setOpaque(false);

		JPanel logoPanel = new JPanel();
		logoPanel.setOpaque(false);
		logoPanel.setPreferredSize(new Dimension(400, 200));
		logoPanel.setLayout(new BorderLayout());

		ImageIcon logoIcon = new ImageIcon("src/img/logo.png");
		Image logoImage = logoIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
		JLabel logoLabel = new JLabel(new ImageIcon(logoImage), SwingConstants.CENTER);
		logoPanel.add(logoLabel, BorderLayout.CENTER);

		RoundedPanel rankingPanel = new RoundedPanel(10);
		rankingPanel.setLayout(new BoxLayout(rankingPanel, BoxLayout.Y_AXIS));
		rankingPanel.setBackground(new Color(227, 232, 236));
		rankingPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		rankingPanel.setPreferredSize(new Dimension(600, 150));
		rankingPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel rankingTitle = new JLabel("랭킹");
		rankingTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		rankingTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		rankingPanel.add(rankingTitle);
		rankingPanel.add(Box.createVerticalStrut(10));

		// 랭킹 동적 로딩
		Color[] rankColors = {
			new Color(255, 215, 000),  // 1등
			new Color(192, 192, 192),  // 2등
			new Color(205, 127, 50 )   // 3등
		};
		String[] emojis = {"🥇 ", "🥈 ", "🥉 "};

		List<UserScore> topRankers = DatabaseManager.getTopRankers(3);
		for (int i = 0; i < topRankers.size(); i++) {
			UserScore user = topRankers.get(i);
			String displayName = emojis[i] + " " + user.getName();
			String displayScore = user.getScore() + "점";
			rankingPanel.add(createRankingItem(displayName, displayScore, rankColors[i]));
		}

		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.setBorder(new EmptyBorder(10, 20, 0, 20));

		JTextField idField = new JTextField();
		JPasswordField pwField = new JPasswordField();

		Dimension inputSize = new Dimension(Integer.MAX_VALUE, 40);
		idField.setMaximumSize(inputSize);
		pwField.setMaximumSize(inputSize);
		idField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		pwField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		JButton loginBtn = new JButton("로그인");
		loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		loginBtn.setBackground(new Color(227, 232, 236));
		loginBtn.setPreferredSize(new Dimension(100, 40));
		loginBtn.setMaximumSize(new Dimension(100, 40));

		JPanel loginBtnPanel = new JPanel();
		loginBtnPanel.setLayout(new BoxLayout(loginBtnPanel, BoxLayout.Y_AXIS));
		loginBtnPanel.setOpaque(false);
		loginBtnPanel.add(Box.createVerticalGlue());
		loginBtnPanel.add(loginBtn);
		loginBtnPanel.add(Box.createVerticalGlue());

		JPanel inputWrapper = new JPanel(new BorderLayout());
		inputWrapper.setOpaque(false);
		inputWrapper.setPreferredSize(new Dimension(0, 90));

		JPanel inputPanel = new JPanel();
		inputPanel.setOpaque(false);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
		inputPanel.add(idField);
		inputPanel.add(Box.createVerticalStrut(5));
		inputPanel.add(pwField);

		inputWrapper.add(inputPanel, BorderLayout.CENTER);
		inputWrapper.add(loginBtnPanel, BorderLayout.EAST);

		loginPanel.add(inputWrapper);

		JLabel errorLabel = new JLabel("※ 아이디 또는 비밀번호를 확인하세요.");
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		loginPanel.add(errorLabel);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
		buttonPanel.setOpaque(false);
		JButton signupBtn = new JButton("회원가입");
		JButton findBtn = new JButton("계정 찾기");
		buttonPanel.add(signupBtn);
		buttonPanel.add(findBtn);
		loginPanel.add(buttonPanel);

		centerPanel.add(logoPanel);
		centerPanel.add(rankingPanel);
		centerPanel.add(Box.createVerticalStrut(10));
		centerPanel.add(loginPanel);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.insets = new Insets(30, 0, 0, 0);

		contentPane.add(centerPanel, gbc);

		frame.setContentPane(contentPane);
		frame.setVisible(true);

		// 로그인 버튼 클릭 시
		// 로그인 버튼 클릭 시
				loginBtn.addActionListener(e -> {
					String inputId = idField.getText();
					String inputPw = new String(pwField.getPassword());

		            // 1. 로그인 시도 및 실제 닉네임 확보
					String nickname = DatabaseManager.checkLogin(inputId, inputPw); // nickname 변수에 실제 닉네임 저장됨
					boolean success = nickname != null;

					System.out.println("로그인 시도: " + inputId + ", 성공 여부: " + success);

					if (success) {
						JOptionPane.showMessageDialog(frame, "로그인 성공!", "성공", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose(); // 현재 로그인 창 닫기

		                // --- ❗ 로그인 성공 후 member_id 및 랭킹 조회 추가 ❗ ---
		                String loggedInNickname = nickname; // 가독성을 위해 변수명 변경
		                String memberId = DatabaseManager.getMemberIdFromNickname(loggedInNickname); // 실제 닉네임으로 member_id 조회
		                int myRank = -1; // 기본 랭킹값
		                if (memberId != null) {
		                    myRank = DatabaseManager.getMyRank(memberId); // member_id로 랭킹 조회
		                    System.out.println("[LoginUI] 사용자 정보: ID=" + memberId + ", Nick=" + loggedInNickname + ", Rank=" + myRank);
		                } else {
		                     System.err.println("[LoginUI 오류] 로그인 성공했으나 member_id를 찾을 수 없음: " + loggedInNickname);
		                     // member_id가 없으면 랭킹 조회 불가
		                }
		                // --- 조회 끝 ---

		                // --- 서버 실행 로직 (절대 경로 및 작업 디렉토리 설정 권장 - 이전 답변 참고) ---
						try {
							System.out.println("서버 실행 시도");

							// 2. 서버 실행을 위한 클래스패스 설정 (libs 폴더 및 JAR 파일명 확인!)
		                    String jarFolderName = "libs"; // <-- 실제 폴더 이름 확인! (lib? libs?)
		                    String jarFileName = "mysql-connector-j-8.0.33.jar"; // <-- 실제 JAR 파일 이름 확인!
							String jdbcPath = jarFolderName + "/" + jarFileName;
							String separator = System.getProperty("path.separator");
							String classPath = "bin" + separator + jdbcPath;
		                    //    다른 라이브러리(okhttp, okio 등)도 서버에서 필요하면 여기에 추가
		                    //    String okhttpPath = "libs/okhttp-3.14.9.jar";
		                    //    String okioPath = "libs/okio-1.17.5.jar";
		                    //    classPath += separator + okhttpPath + separator + okioPath;

		                    System.out.println("  사용될 서버 클래스패스: " + classPath); // 설정값 로그 확인

							ProcessBuilder pb = new ProcessBuilder(
							    "java",
							    "-cp",
							    classPath, // 조합된 클래스패스 사용
							    "MafiaG.Server"
							);
							pb.inheritIO();
							pb.start();

							System.out.println("서버 실행 성공 (프로세스 시작됨)");
							Thread.sleep(1500); // 서버 부팅 대기

						} catch (IOException | InterruptedException ex) {
		                    ex.printStackTrace();
		                    JOptionPane.showMessageDialog(null, "서버 실행 중 오류 발생: " + ex.getMessage());
		                    if (ex instanceof InterruptedException) Thread.currentThread().interrupt();
		                    return; // 서버 실행 실패 시 PlayUI로 넘어가지 않음
						}
		                // --- 서버 실행 로직 끝 ---

						// --- PlayUI 호출 시 실제 닉네임과 랭킹 전달 ---
						final String finalNickname = loggedInNickname;
						final int finalRank = myRank;
						SwingUtilities.invokeLater(() -> {
		                    // PlayUI 생성자에 실제 닉네임과 랭킹 전달
							PlayUI playUI = new PlayUI(finalNickname, finalRank); // <<--- 생성자 파라미터 변경됨!
							playUI.setVisible(true);
						});
		                // --- PlayUI 호출 끝 ---

					} else {
						errorLabel.setVisible(true);
					}
				}); // end of loginBtn.addActionListener

		signupBtn.addActionListener(e -> {
			frame.dispose();
			new SignupUI(this::showLoginUI);
		});

		findBtn.addActionListener(e -> {
			frame.dispose();
			new FindAccountUI(this::showLoginUI);
		});
	}

	private static JPanel createRankingItem(String name, String score, Color bgColor) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(bgColor);
		panel.setBorder(new EmptyBorder(6, 10, 6, 10));
		panel.add(new JLabel(name), BorderLayout.WEST);
		panel.add(new JLabel(score, SwingConstants.RIGHT), BorderLayout.EAST);
		return panel;
	}

	static class RoundedPanel extends JPanel {
		private final int radius;

		public RoundedPanel(int radius) {
			this.radius = radius;
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
			g2.dispose();
			super.paintComponent(g);
		}
	}
}