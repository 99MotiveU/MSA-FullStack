package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
	
	static {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}


	private static final String URL = "jdbc:mysql://172.30.1.21:3306/mafiag";
	private static final String USER = "dbeaver_user";
	public static String PASSWORD = "0000";

	// 로그인
	public static String checkLogin(String id, String password) {
		String sql = "SELECT * FROM member WHERE member_id = ? AND password = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("nickname");
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 아이디 찾기
	public static String findMemberIdByEmail(String email) {
		String sql = "SELECT member_id FROM member WHERE email = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 비밀번호 찾기
	public static boolean findPasswordByEmailAndId(String id, String email) {
		String sql = "SELECT * FROM member WHERE member_id = ? AND email = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, email);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// ID 중복 확인
	public static boolean isIdDuplicate(String id) {
		String sql = "SELECT COUNT(*) FROM member WHERE member_id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 닉네임 중복 확인
	public static boolean isNicknameDuplicate(String nickname) {
		String sql = "SELECT COUNT(*) FROM member WHERE nickname = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nickname);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 이메일 중복 확인
	public static boolean isEmailDuplicate(String email) {
		String sql = "SELECT COUNT(*) FROM member WHERE email = ?";
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 회원 가입 처리
	public static boolean insertNewMember(String id, String password, String nickname, String email) {
		String sql = "INSERT INTO member (member_id, password, email, nickname) VALUES (?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, nickname);

			int rows = pstmt.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 유저의 현재 점수 가져오기
	public static int getUserScore(String username) {
		int score = 0;
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(
					 "SELECT score FROM member WHERE member_id = ?")) {

			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				score = rs.getInt("score");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return score;
	}

	// 게임 종료 후 점수 반영 (내부적으로 member_id 사용하도록 수정)
    public static void updateScoresAfterGame(List<String> winners, List<String> participants) {
        // winners 리스트에는 승리한 사람들의 '닉네임'이 포함됨 (Gemini 포함 가능)
        // participants 리스트에는 Gemini를 제외한 실제 플레이어들의 '닉네임'이 포함됨

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Gemini 승리 여부 확인 (winners 리스트에 Gemini 닉네임이 있는지 확인)
            // 서버에서 Gemini 닉네임을 어떻게 관리하는지 확인 필요 (예: "Gemini" 또는 "익명1")
            // 여기서는 "Gemini" 문자열로 가정
            boolean geminiWins = winners.contains("Gemini"); // 서버에서 Gemini 닉네임 확인 필요

            System.out.println("[DB] 점수 업데이트 시작. Gemini 승리 여부: " + geminiWins);
            System.out.println("[DB] 승자 목록(`): " + winners);
            System.out.println("[DB] 참가자 목록(닉네임): " + participants);


            // 참가자(플레이어)들 점수 업데이트
            for (String playerNickname : participants) {
                // 참가자 닉네임으로 member_id 조회
                String memberId = getMemberIdFromNickname(playerNickname);

                // member_id가 유효하지 않으면(null이면) 해당 플레이어는 건너뜀
                if (memberId == null) {
                    System.err.println("[DB] 플레이어 '" + playerNickname + "'의 member_id를 찾을 수 없어 점수 업데이트를 건너<0xEB><0x8A>니다.");
                    continue;
                }

                int scoreChange = 0; // 점수 변동량

                // 점수 계산 로직 (사용자가 마지막으로 제공한 DatabaseManager 코드 기준)
                if (geminiWins) {
                    // Gemini가 승리한 경우: 모든 참가자에게 -2점 부여
                    scoreChange = -2;
                } else {
                    // 플레이어가 승리한 경우:
                    if (winners.contains(playerNickname)) { // 현재 플레이어가 승자 목록에 있는지 확인
                        // 동점자 승리 시 +5점
                        scoreChange = 5;
                    } else {
                        // 승자가 아니면(패배자) -2점
                        scoreChange = -2;
                    }
                }

                // 점수 업데이트 SQL (WHERE 절을 member_id 기준으로 변경)
                String sql = "UPDATE member SET score = score + ? WHERE member_id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, scoreChange);
                    pstmt.setString(2, memberId); // 조회한 member_id 사용
                    int updatedRows = pstmt.executeUpdate();

                    if (updatedRows > 0) {
                        System.out.println("[DB] 점수 업데이트 성공: Nick=" + playerNickname + ", ID=" + memberId + ", 변경=" + scoreChange);
                    } else {
                        System.err.println("[DB 경고] 점수 업데이트 실패 (업데이트된 행 없음): Nick=" + playerNickname + ", ID=" + memberId);
                    }

                } catch (SQLException e) {
                     System.err.println("[DB 오류] 점수 업데이트 실행 중 오류: Nick=" + playerNickname + ", ID=" + memberId);
                     e.printStackTrace();
                }
            } // end of participant loop

            System.out.println("[DB] 모든 참가자 점수 업데이트 완료.");

        } catch (SQLException e) {
            System.err.println("[DB 오류] DB 연결 또는 주요 로직 처리 중 오류 발생");
            e.printStackTrace();
        }
    } // end of updateScoresAfterGame


	// 로그아웃 처리
//	public static void logoutUser(String username) {
//		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			 PreparedStatement pstmt = conn.prepareStatement(
//					 "UPDATE member SET last_login = NOW() WHERE member_id = ?")) {
//
//			pstmt.setString(1, username);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	// 랭킹 상위 유저 n명 가져오기
	public static List<UserScore> getTopRankers(int limit) {
		List<UserScore> rankers = new ArrayList<>();
		String sql = "SELECT nickname, score FROM member ORDER BY score DESC LIMIT ?";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, limit);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("nickname");
				int score = rs.getInt("score");
				rankers.add(new UserScore(name, score));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rankers;
	}
	
    // === 새로운 메소드: 닉네임으로 member_id 찾기 ===
    public static String getMemberIdFromNickname(String nickname) {
        // Gemini 또는 닉네임이 없는 경우 처리 (필요에 따라)
        if (nickname == null || nickname.startsWith("익명") || nickname.equals("Gemini")) {
             // Gemini나 익명 유저는 member 테이블에 ID가 없을 수 있으므로 null 반환 또는 예외 처리
             return null;
        }

        String sql = "SELECT member_id FROM member WHERE nickname = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nickname);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("member_id");
            } else {
                // 해당 닉네임의 사용자를 찾을 수 없는 경우
                System.err.println("[DB 경고] 닉네임 '" + nickname + "'에 해당하는 member_id를 찾을 수 없습니다.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("[DB 오류] 닉네임으로 member_id 조회 중 오류 발생: " + nickname);
            e.printStackTrace();
            return null;
        }
    }
    
 // --- ❗ 새로운 메소드: 나의 랭킹 조회 (member_id 기준) ❗ ---
    public static int getMyRank(String memberId) {
        // memberId가 null이거나 유효하지 않은 경우 기본값 반환 (예: -1 또는 0)
        if (memberId == null || memberId.isEmpty()) {
             System.err.println("[DB 경고] getMyRank: 유효하지 않은 memberId 입니다.");
             return -1;
        }

        // 자신의 점수보다 높은 점수를 가진 사람의 수를 세어 랭킹 계산 (+1)
        // 동점자 처리가 필요하면 더 복잡한 쿼리 또는 로직 필요
        String sql = "SELECT COUNT(*) + 1 AS myRank FROM member WHERE score > (SELECT score FROM member WHERE member_id = ?)";
        int rank = -1; // 기본값 -1 (오류 또는 사용자 없음)

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, memberId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                rank = rs.getInt("myRank");
            } else {
                // 이 경우는 보통 발생하지 않음 (COUNT(*)는 항상 행을 반환)
                System.err.println("[DB 경고] getMyRank: 랭킹 조회 중 예외 상황 발생 (member_id: " + memberId + ")");
            }
            // 만약 member_id = ? 에 해당하는 유저가 없다면 score 비교가 불가하여 SQLException 발생 가능성 있음
            // -> try-catch 로 처리됨

        } catch (SQLException e) {
            // member_id에 해당하는 유저가 없거나 DB 오류 발생 시
            if (e.getMessage().contains("Subquery returns more than 1 row")) {
                 System.err.println("[DB 오류] getMyRank: member_id '" + memberId + "'에 해당하는 사용자가 없거나 score가 null일 수 있습니다.");
            } else {
                 System.err.println("[DB 오류] getMyRank 실행 중 오류 발생: member_id=" + memberId);
                 e.printStackTrace();
            }
            rank = -1; // 오류 발생 시 -1 반환
        }
        return rank; // 조회된 랭킹 또는 오류 시 -1 반환
    }
}