package MafiaG;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor; // Cursor 추가 (결과화면 코드 참고)
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
// import java.awt.List; // 삭제!
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList; // 추가!
import java.util.HashMap;
import java.util.List;    // 추가!
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer; // 추가!
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PlayUI extends JFrame implements ActionListener {
	static Socket sock;
	static BufferedWriter bw = null;
	static BufferedReader br = null;

	// --- 멤버 변수 선언 ---
	private DefaultListModel<String> participantModel;
	private RankingPanel rankingPanel;
	private JTextField chatInput;
	private JTextPane chatPane;
	private StyledDocument doc;
	private JButton startButton;
	private JComboBox<String> voteChoice;
	private JButton voteBtn;
	private JLabel timerLabel;
	private JPanel chatContainerCards;
	private CardLayout cardLayout;
	private String myColor = "";
	private boolean gameStarted = false;
	private String temporaryNickname = "";
    private String permanentNickname; // 실제 닉네임 저장
    private int myRank; // 나의 랭킹 저장
    private JLabel myRankLabel; // 랭킹 표시용 라벨
    // --- 멤버 변수 끝 ---

    private final Map<String, String> colorToNameMap = new HashMap<String, String>() {{
	    put("#FF6B6B", "빨강 유저"); put("#6BCB77", "초록 유저"); put("#4D96FF", "파랑 유저");
	    put("#FFC75F", "노랑 유저"); put("#A66DD4", "보라 유저"); put("#FF9671", "오렌지 유저");
	    put("#00C9A7", "청록 유저");
        // 필요시 Gemini 또는 fallback 색상 매핑 추가
	}};
	private final Map<String, String> nameToColorMap = new HashMap<>();


    // --- 생성자 수정: 랭킹 정보(rank)도 받도록 변경 ---
	public PlayUI(String permNick, int rank) {
        this.permanentNickname = permNick;
        this.myRank = rank;
        System.out.println("[PlayUI 생성] Nickname: " + this.permanentNickname + ", Rank: " + this.myRank);

		setTitle("MafiaG");
		setSize(1200, 800);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());

	    // --- 헤더 설정: 로고, 제목, 랭킹 라벨 포함 ---
	    JPanel header = new JPanel(new BorderLayout());
	    header.setBackground(new Color(238, 238, 238));
	    header.setBorder(new EmptyBorder(10, 20, 10, 20)); // 상하좌우 여백
	    

	    // 제목 (중앙)
	    JLabel titleLabel = new JLabel("MafiaG", SwingConstants.CENTER); // 중앙 정렬
	    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	    header.add(titleLabel, BorderLayout.CENTER);

        // --- 랭킹 표시 라벨 생성 및 추가 (오른쪽) ---
        myRankLabel = new JLabel(); // 라벨 생성 (텍스트는 아래에서 설정)
        myRankLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        myRankLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // 랭킹 텍스트 설정
        if (this.myRank > 0 && this.permanentNickname != null) {
            myRankLabel.setText(this.myRank + "위 " + this.permanentNickname + " 님");
        } else if (this.permanentNickname != null){
             myRankLabel.setText(this.permanentNickname + " 님 (랭크 정보 없음)");
        } else {
             myRankLabel.setText("사용자 정보 로딩 실패");
        }

        // 오른쪽에 배치하고 약간의 여백 추가
        JPanel rankPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // 오른쪽 정렬 패널
        rankPanel.setOpaque(false); // 패널 배경 투명
        rankPanel.add(myRankLabel);
        header.add(rankPanel, BorderLayout.EAST);
        // --- 랭킹 표시 끝 ---

	    add(header, BorderLayout.NORTH); // 최종 헤더를 프레임에 추가
	    // --- 헤더 설정 끝 ---

		setupUI(); // 나머지 UI 설정 (헤더 설정 제외됨)
		connectToServer(); // 서버 연결
		setLocationRelativeTo(null);

		// --- 윈도우 닫기 리스너 ---
		 addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                int result = JOptionPane.showConfirmDialog( PlayUI.this, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION );
	                if (result == JOptionPane.YES_OPTION) {
	                	System.out.println("정리 작업 시작");
	                    closeConnection(); // 연결 종료
	                    // sendToServer("{\"type\":\"quit\"}"); // 서버에 종료 알림 (선택적)
	                    dispose(); // 창 닫기
	                    System.exit(0); // 프로그램 완전 종료
	                }
	            }
	        });
	} 


    // --- setupUI 수정: 헤더 설정 부분을 생성자로 옮겼으므로 해당 코드 제거 ---
	private void setupUI() {
        // 헤더 관련 코드 제거됨!

		JPanel mainPanel = new JPanel(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);

		// --- 사이드바 설정 ---
		JPanel sidebar = new JPanel(new BorderLayout());
		sidebar.setPreferredSize(new Dimension(200, 0));
		sidebar.setBackground(new Color(240, 234, 255));

		JPanel sidebarContent = new JPanel(new BorderLayout());
		rankingPanel = new RankingPanel(); // 랭킹 패널
		sidebarContent.add(rankingPanel, BorderLayout.NORTH);

		participantModel = new DefaultListModel<>(); // 참여자 목록 모델
		JList<String> participantList = new JList<>(participantModel);
		JScrollPane participantScroll = new JScrollPane(participantList);
		participantScroll.setBorder(BorderFactory.createTitledBorder("참여자 명단"));
		sidebarContent.add(participantScroll, BorderLayout.CENTER);

		sidebar.add(sidebarContent, BorderLayout.CENTER);

		startButton = new JButton("Start"); // 시작 버튼
		startButton.setEnabled(true);
		startButton.setPreferredSize(new Dimension(200, 50));
		startButton.addActionListener(e -> {
			startButton.setEnabled(false); // 한번만 누르도록
			sendToServer("{\"type\":\"start\"}");
		});
		sidebar.add(startButton, BorderLayout.SOUTH);
		mainPanel.add(sidebar, BorderLayout.WEST);
		// --- 사이드바 설정 끝 ---


		// --- 채팅창 및 튜토리얼 (CardLayout) 설정 ---
		cardLayout = new CardLayout();
		chatContainerCards = new JPanel(cardLayout);

		// 튜토리얼 패널
		ImageIcon tutorialImage = new ImageIcon("src/img/TutorialImage.png"); // 경로 확인
		JLabel tutorialLabel = new JLabel(tutorialImage);
		tutorialLabel.setHorizontalAlignment(JLabel.CENTER);
		JPanel tutorialPanel = new JPanel(new BorderLayout());
		tutorialPanel.add(tutorialLabel, BorderLayout.CENTER);

		// 채팅 패널
		JPanel chatPanel = new JPanel(new BorderLayout()); // 이름 변경 chatContainer -> chatPanel
		chatPane = new JTextPane();
		chatPane.setEditable(false);
		doc = chatPane.getStyledDocument();
		JScrollPane chatScroll = new JScrollPane(chatPane);
		chatPanel.add(chatScroll, BorderLayout.CENTER); // 채팅 내용 부분

		JPanel inputPanel = new JPanel(new BorderLayout()); // 채팅 입력 부분
		chatInput = new JTextField();
		chatInput.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		chatInput.setEnabled(false); // 게임 시작 전 비활성화
		chatInput.setBackground(Color.LIGHT_GRAY);
		chatInput.addActionListener(this); // Enter 키 리스너
		inputPanel.add(chatInput, BorderLayout.CENTER);
		chatPanel.add(inputPanel, BorderLayout.SOUTH); // 채팅 입력 부분을 채팅 패널 하단에 추가

		// CardLayout에 패널들 추가
		chatContainerCards.add(tutorialPanel, "tutorial"); // 이름: "tutorial"
		chatContainerCards.add(chatPanel, "chat");       // 이름: "chat"

		mainPanel.add(chatContainerCards, BorderLayout.CENTER); // CardLayout 패널을 중앙에 추가
        // --- 채팅창 설정 끝 ---


        // --- 하단 투표 영역 설정 ---
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bottomPanel.setBorder(new EmptyBorder(5, 10, 5, 10)); // 여백 추가

		bottomPanel.add(new JLabel("투표 대상:"));
		voteChoice = new JComboBox<>(); // 투표 드롭다운
		voteChoice.setPreferredSize(new Dimension(150, 30));
		voteChoice.setEnabled(false); // 투표 시작 전 비활성화
		bottomPanel.add(voteChoice);

		voteBtn = new JButton("투표"); // 투표 버튼
		voteBtn.setEnabled(false); // 투표 시작 전 비활성화
		voteBtn.addActionListener(e -> { // 투표 버튼 액션
			String selectedLabel = (String) voteChoice.getSelectedItem();
			if (selectedLabel != null) {
				String selectedColor = nameToColorMap.get(selectedLabel); // 선택된 레이블로 색상 코드 찾기
				if (selectedColor != null) {
					System.out.println("[클라이언트] 투표 전송: " + selectedLabel + " (" + selectedColor + ")");
					sendToServer("{\"type\":\"vote\",\"target\":\"" + selectedColor + "\"}");
					// 투표 후 비활성화
					voteChoice.setEnabled(false);
					voteBtn.setEnabled(false);
				} else {
                     System.err.println("[클라이언트 오류] 선택된 투표 대상의 색상 코드를 찾을 수 없음: " + selectedLabel);
                }
			}
		});
		bottomPanel.add(voteBtn);

		timerLabel = new JLabel("남은 시간: 20초"); // 타이머 라벨
        timerLabel.setVisible(false); // 처음에는 숨김
		bottomPanel.add(timerLabel);

		mainPanel.add(bottomPanel, BorderLayout.SOUTH); // 하단 패널 추가
	} // --- setupUI 끝 ---

	public void actionPerformed(ActionEvent e) {
		String msg = chatInput.getText().trim();
		if (!msg.isEmpty()) {
			sendToServer("{\"type\":\"ANSWER_SUBMIT\",\"message\":\"" + msg + "\"}");
			appendAnonymousChat(myColor, msg); // 내 답변도 미리 출력
			chatInput.setText("");
		}
	}

	private void appendAnonymousChat(String colorCode, String msg) {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		try {
			StyleConstants.setForeground(attr, Color.decode(colorCode));
		} catch (NumberFormatException e) {
			StyleConstants.setForeground(attr, Color.GRAY);
		}
		StyleConstants.setFontSize(attr, 16);
		try {
			doc.insertString(doc.getLength(), msg + "\n", attr);
			doc.setParagraphAttributes(doc.getLength(), 1, attr, false);
			chatPane.setCaretPosition(doc.getLength());
		} catch (BadLocationException ex) {
			ex.printStackTrace();
		}
	}

	private void connectToServer() {
        try {
            sock = new Socket("172.30.1.22", 3579); // 서버 주소
            br = new BufferedReader(new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8));
            bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), StandardCharsets.UTF_8));

            Thread serverThread = new Thread(() -> {
                String line;
                try {
                    while ((line = br.readLine()) != null) {
                        String finalLine = line;
                        System.out.println("서버로부터: " + finalLine);

                        // 1. INIT 메시지 처리
                        if (finalLine.contains("\"type\":\"INIT\"")) {
                            myColor = extractValue(finalLine, "color");
                            temporaryNickname = extractValue(finalLine, "nickname");
                            System.out.println("[클라이언트] INIT 수신: TempNick=" + temporaryNickname + ", Color=" + myColor);
                            if (this.permanentNickname != null && !this.permanentNickname.isEmpty()) {
                                String escapedNickname = escapeJson(this.permanentNickname);
                                String identifyMsg = "{\"type\":\"IDENTIFY\",\"permNickname\":\"" + escapedNickname + "\"}";
                                sendToServer(identifyMsg);
                                System.out.println("[클라이언트] IDENTIFY 전송: " + identifyMsg);
                            } else { System.err.println("[클라이언트 경고] Permanent nickname이 없어 IDENTIFY 메시지를 보낼 수 없습니다."); }
                        }
                     // 2. 참가자 목록 (PARTICIPANTS) 메시지 처리 (표시 이름 결정 로직 추가)
                        else if (finalLine.contains("\"type\":\"PARTICIPANTS\"")) {
                            SwingUtilities.invokeLater(() -> {
                                System.out.println("[클라이언트] 참가자 목록 수신. 내 색상: " + myColor);
                                voteChoice.removeAllItems();
                                nameToColorMap.clear();
                                participantModel.clear(); // 참여자 리스트 모델 초기화

                                try {
                                    int listStartIndex = finalLine.indexOf("\"list\":[") + "\"list\":[".length();
                                    int listEndIndex = finalLine.lastIndexOf("]");
                                    if (listEndIndex > listStartIndex) {
                                        String listData = finalLine.substring(listStartIndex, listEndIndex);
                                        String[] entries = listData.split("\\}(?=\\s*,\\s*\\{)");
                                        for (String entry : entries) {
                                            String currentEntry = entry.trim();
                                            if (!currentEntry.startsWith("{")) currentEntry = "{" + currentEntry;
                                            if (!currentEntry.endsWith("}")) currentEntry = currentEntry + "}";

                                            String nickname = extractValue(currentEntry, "nickname"); // 서버가 보낸 이름 (실제/Gemini/임시)
                                            String color = extractValue(currentEntry, "color");
                                            System.out.println("  처리 중인 참가자: Received Nick=" + nickname + ", Color=" + color);

                                            if (color != null && !color.isEmpty() && nickname != null) {
                                                // 투표 드롭다운 레이블 생성 ("색상명 + 유저")
                                                String voteLabel = colorToNameMap.get(color);
                                                if (voteLabel == null) voteLabel = "알 수 없는 유저 (" + color.substring(1) + ")";

                                                // --- ❗ 참여자 명단(JList) 표시 이름 결정 ❗ ---
                                                String displayNickname;
                                                if (color.equals(myColor)) {
                                                    // 현재 클라이언트 본인이면, 저장된 permanentNickname 사용
                                                    displayNickname = (permanentNickname != null && !permanentNickname.isEmpty()) ? permanentNickname : nickname; // 내 실제 닉네임 우선
                                                    System.out.println("    참여자 목록: 본인 표시 -> " + displayNickname);
                                                } else {
                                                    // 다른 플레이어 또는 Gemini는 서버가 보내준 이름 사용
                                                    // (서버의 broadcastParticipants가 수정되었다면 이게 실제 닉네임 또는 "Gemini" 여야 함)
                                                    displayNickname = nickname;
                                                    System.out.println("    참여자 목록: 타인 표시 -> " + displayNickname);
                                                }
                                                participantModel.addElement(displayNickname); // <<--- 결정된 이름으로 추가
                                                // --- 참여자 명단 추가 끝 ---

                                                // 투표 드롭다운 추가 (자기 자신 제외)
                                                if (!color.equals(myColor)) {
                                                     System.out.println("    투표 목록에 추가: " + voteLabel);
                                                     voteChoice.addItem(voteLabel);
                                                     nameToColorMap.put(voteLabel, color);
                                                 } else { System.out.println("    투표 목록에서 제외 (본인): " + voteLabel); }

                                            } else { System.out.println("    잘못된 참가자 데이터 건너뜀: " + currentEntry); }
                                        }
                                    } else { System.out.println("[클라이언트] 참가자 목록 데이터가 비어있습니다."); }
                                } catch (Exception e) { System.err.println("[클라이언트] PARTICIPANTS 메시지 파싱 오류: " + finalLine); e.printStackTrace(); }
                            });
                        } // end of PARTICIPANTS handling
                        
                        // 3. QUESTION_PHASE 메시지 처리 (타이머 로그 추가 버전)
                        else if (finalLine.contains("\"type\":\"QUESTION_PHASE\"")) {
                            String question = extractValue(finalLine, "question");
                            SwingUtilities.invokeLater(() -> {
                                appendAnonymousChat("#444444", "❓ 질문: " + question);
                                chatInput.setEnabled(true); chatInput.setBackground(Color.WHITE); chatInput.requestFocus();
                                // 타이머 스레드 시작 (로그 포함 버전)
                                new Thread(() -> {
                                    System.out.println("[클라이언트 타이머] 스레드 시작!");
                                    SwingUtilities.invokeLater(() -> { System.out.println("  -> EDT: timerLabel 표시 시도"); timerLabel.setVisible(true); });
                                    for (int i = 20; i >= 0; i--) {
                                        final int sec = i;
                                        SwingUtilities.invokeLater(() -> { System.out.println("  -> EDT: timerLabel 텍스트 업데이트 실행 (" + sec + "초)"); try { timerLabel.setText("남은 시간: " + sec + "초"); } catch (Exception e) { System.err.println("  -> EDT: timerLabel 업데이트 중 오류 발생!"); e.printStackTrace(); } });
                                        try { Thread.sleep(1000); } catch (InterruptedException ex) { System.out.println("[클라이언트] 타이머 스레드 중단됨."); Thread.currentThread().interrupt(); break; }
                                    }
                                    SwingUtilities.invokeLater(() -> { System.out.println("[클라이언트 타이머] 시간 종료 처리."); timerLabel.setText("시간 종료"); chatInput.setEnabled(false); chatInput.setBackground(Color.LIGHT_GRAY); });
                                    System.out.println("[클라이언트 타이머] 스레드 종료.");
                                }).start();
                            });
                        }
                        // 4. chat 메시지 처리
                        else if (finalLine.contains("\"type\":\"chat\"")) {
                            String color = extractValue(finalLine, "color"); String msg = extractValue(finalLine, "message");
							SwingUtilities.invokeLater(() -> appendAnonymousChat(color, msg));
                        }
                        // 5. REVEAL_RESULT 메시지 처리 (로그 포함 버전)
                        else if (finalLine.contains("\"type\":\"REVEAL_RESULT\"")) {
                            SwingUtilities.invokeLater(() -> appendAnonymousChat("#444444", "💬 모든 답변이 공개되었습니다!"));
                            try {
                                int answersStartIndex = finalLine.indexOf("\"answers\":[") + "\"answers\":[".length(); int answersEndIndex = finalLine.lastIndexOf("]}");
                                if (answersEndIndex > answersStartIndex) {
                                    String answersData = finalLine.substring(answersStartIndex, answersEndIndex); String[] items = answersData.split("\\}(?=\\s*,\\s*\\{)");
                                    System.out.println("[클라이언트] Parsing REVEAL_RESULT answers:");
                                    for (String item : items) {
                                        String currentItem = item.trim(); if (!currentItem.startsWith("{")) currentItem = "{" + currentItem; if (!currentItem.endsWith("}")) currentItem = currentItem + "}";
                                        String color = extractValue(currentItem, "color"); String message = extractValue(currentItem, "message");
                                        System.out.println("  - Processing answer: Color=" + color + ", Msg=" + message.substring(0, Math.min(message.length(), 20)) + "...");
                                        if (color != null && !color.isEmpty() && message != null) {
                                            final String finalColor = color; final String finalMessage = message;
                                            SwingUtilities.invokeLater(() -> { System.out.println("    -> appendAnonymousChat 호출: Color=" + finalColor); appendAnonymousChat(finalColor, "💬 " + finalMessage); });
                                        } else { System.out.println("    -> Invalid data, skipping append."); }
                                    }
                                }
                            } catch (Exception ex) { System.err.println("[클라이언트] REVEAL_RESULT 메시지 파싱 중 오류: " + finalLine); ex.printStackTrace(); }
                        }
                        // 6. VOTE_PHASE 메시지 처리
                        else if (finalLine.contains("\"type\":\"VOTE_PHASE\"")) {
                            SwingUtilities.invokeLater(() -> {
                                appendAnonymousChat("#0000FF", "🗳️ 이제 투표할 시간입니다! 드롭다운에서 의심되는 유저를 선택하고 투표 버튼을 누르세요.");
								voteChoice.setEnabled(true); voteBtn.setEnabled(true); timerLabel.setVisible(false);
							});
                        }
                        // 7. GAME_START 메시지 처리
                        else if (finalLine.contains("\"type\":\"GAME_START\"")) {
                            System.out.println("[클라이언트] GAME_START 메시지 감지됨!");
                            SwingUtilities.invokeLater(() -> {
                                try {
                                    System.out.println("[클라이언트 EDT] 게임 시작 UI 업데이트 시작..."); gameStarted = true; startButton.setEnabled(false); startButton.setText("게임 진행 중...");
                                    System.out.println("[클라이언트 EDT] CardLayout 전환 시도..."); cardLayout.show(chatContainerCards, "chat"); System.out.println("[클라이언트 EDT] CardLayout 전환 완료.");
                                    appendAnonymousChat("#008000", "🎉 게임이 시작되었습니다! 첫 번째 질문을 기다려주세요...");
                                } catch (Exception e) { System.err.println("[클라이언트 EDT 오류] GAME_START UI 업데이트 중 오류:"); e.printStackTrace(); }
                            });
                        }
                        // 8. FINAL_RESULT 메시지 처리 (화면 전환 로직 포함)
                        else if (finalLine.contains("\"type\":\"FINAL_RESULT\"")) {
                            String displayMsg = extractValue(finalLine, "message");
                            List<String> winners = parseJsonList(finalLine, "winners");
                            List<String> participants = parseJsonList(finalLine, "participants");
                            System.out.println("[클라이언트] Parsed winners: " + winners); System.out.println("[클라이언트] Parsed participants: " + participants);
                            SwingUtilities.invokeLater(() -> {
                                System.out.println("[클라이언트] 최종 결과 수신 처리 시작 (EDT)"); appendAnonymousChat("#FF0000", displayMsg != null ? displayMsg : "게임 종료!");
                                chatInput.setEnabled(false); chatInput.setBackground(Color.LIGHT_GRAY); voteChoice.setEnabled(false); voteBtn.setEnabled(false); startButton.setEnabled(false); startButton.setText("게임 종료"); timerLabel.setText("게임 종료"); timerLabel.setVisible(true);
                                System.out.println("[클라이언트] 5초 후 결과 화면 전환 타이머 시작...");
                                // 5초 지연 타이머
                                Timer timer = new Timer(5000, new ActionListener() {
                                    @Override public void actionPerformed(ActionEvent e) {
                                        System.out.println("[클라이언트 타이머] 5초 경과, 결과 화면 전환 실행.");
                                        if (permanentNickname != null && winners != null && participants != null) {
                                            try {
                                                new MafiaGResult(permanentNickname, winners, participants); System.out.println("[클라이언트] MafiaGResult 창 생성 완료."); dispose(); System.out.println("[클라이언트] PlayUI 창 닫기 완료.");
                                            } catch (Exception ex) { System.err.println("[클라이언트 오류] MafiaGResult 생성 또는 PlayUI 닫기 중 오류 발생"); ex.printStackTrace(); JOptionPane.showMessageDialog(PlayUI.this, "결과 화면 전환 중 오류...", "오류", JOptionPane.ERROR_MESSAGE); closeConnection(); dispose(); System.exit(1); }
                                        } else { System.err.println("[클라이언트 오류] 결과 화면 전환 정보 부족."); JOptionPane.showMessageDialog(PlayUI.this, "결과 처리 중 오류...", "오류", JOptionPane.ERROR_MESSAGE); closeConnection(); dispose(); System.exit(1); }
                                    }
                                });
                                timer.setRepeats(false); timer.start(); // 타이머 시작
                            });
                        }
                        // 9. GAME_OVER 메시지 처리
                         else if (finalLine.contains("\"type\":\"GAME_OVER\"")) {
                            String msg = extractValue(finalLine, "message");
                             SwingUtilities.invokeLater(() -> {
                                 appendAnonymousChat("#FF8C00", msg); chatInput.setEnabled(false); /* ... UI 비활성화 ... */ timerLabel.setText("게임 종료됨"); timerLabel.setVisible(true);
                             });
                         }

                    } // end of while loop
                } catch (IOException e) { if (sock != null && sock.isClosed()) { System.out.println("[클라이언트] 소켓 연결 종료됨."); } else { System.err.println("[클라이언트] 서버 연결 끊김: " + e.getMessage()); /* ... 오류 처리 ... */ }
                } finally { System.out.println("[클라이언트] 서버 리스너 스레드 종료."); }
            });
            serverThread.setDaemon(true); serverThread.start();
        } catch (IOException e) { e.printStackTrace(); JOptionPane.showMessageDialog(this, "서버 연결 실패...", "오류", JOptionPane.ERROR_MESSAGE); System.exit(1); }
    } // --- connectToServer 끝 ---

	private void sendToServer(String message) {
		try {
			if (bw != null) {
				bw.write(message + "\n");
				bw.flush();
			}
		} catch (IOException ex) {
			System.out.println("서버로 메시지 전송 실패");
			closeConnection();
		}
	}

	private java.util.List<String> parseJsonList(String json, String key) {
		java.util.List<String> list = new java.util.ArrayList<>();
		try {
			String listKey = "\"" + key + "\":["; // 예: "\"winners\":["
			int startIndex = json.indexOf(listKey);
			if (startIndex == -1) {
				System.out.println("[parseJsonList] Key '" + key + "' not found in JSON.");
				return list;
			}

			startIndex += listKey.length(); // '[' 다음 위치
			int endIndex = json.indexOf("]", startIndex);
			if (endIndex == -1) {
				System.out.println("[parseJsonList] Closing ']' not found for key '" + key + "'.");
				return list;
			}

			String listContent = json.substring(startIndex, endIndex).trim();
			System.out.println("[parseJsonList] Content for key '" + key + "': [" + listContent + "]"); // 추출 내용 로그

			if (listContent.isEmpty())
				return list; // 빈 리스트면 종료

			// 콤마로 분리 (따옴표 안 콤마는 처리 못함 - 닉네임에 콤마 없다고 가정)
			String[] items = listContent.split(",");
			for (String item : items) {
				String trimmedItem = item.trim();
				// 앞뒤 따옴표 제거 및 unescape
				if (trimmedItem.startsWith("\"") && trimmedItem.endsWith("\"")) {
					String value = trimmedItem.substring(1, trimmedItem.length() - 1);
					value = value.replace("\\\"", "\"").replace("\\\\", "\\"); // 기본적인 unescape
					System.out.println("  -> Adding item: " + value); // 추가되는 항목 로그
					list.add(value);
				} else {
					System.out.println("  -> Invalid item format, skipping: " + trimmedItem); // 잘못된 형식 로그
				}
			}
		} catch (Exception e) {
			System.err.println("[클라이언트 오류] JSON 리스트 파싱 실패 - Key: " + key);
			e.printStackTrace();
		}
		return list;
	}

	private void closeConnection() {
		try {
			if (sock != null && !sock.isClosed()) {
				sock.shutdownInput(); // 👈 먼저 입력 스트림 닫기
				sock.shutdownOutput(); // 👈 출력도 명시적으로 종료
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("sock 닫기 실패: " + e.getMessage());
		}

		try {
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
			System.err.println("br 닫기 실패: " + e.getMessage());
		}

		try {
			if (bw != null) {
				bw.close();
			}
		} catch (IOException e) {
			System.err.println("bw 닫기 실패: " + e.getMessage());
		}
	}

	private String extractValue(String json, String key) {
		try {
			String pattern = "\"" + key + "\":\"";
			int start = json.indexOf(pattern) + pattern.length();
			int end = json.indexOf("\"", start);
			return json.substring(start, end);
		} catch (Exception e) {
			return "";
		}
	}

	// JSON 문자열에 포함될 수 있는 특수문자를 escape 처리
	private String escapeJson(String str) {
		if (str == null)
			return null;
		// 기본적인 escape 처리 (더 필요한 경우 추가)
		return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t",
				"\\t");
	}

}