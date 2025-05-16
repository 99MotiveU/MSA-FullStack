package MafiaG;

import javax.swing.*;
import DB.UserScore;
import DB.DatabaseManager;
import java.awt.*;
import java.util.List;

public class RankingPanel extends JPanel {
    private JTextArea rankingArea;

    public RankingPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("랭킹"));

        rankingArea = new JTextArea();
        rankingArea.setEditable(false);
        rankingArea.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        add(new JScrollPane(rankingArea), BorderLayout.CENTER);

        loadRanking();  // ⭐ 랭킹 불러오기
    }

    private void loadRanking() {
        List<UserScore> topRankers = DatabaseManager.getTopRankers(3);  // DB에서 랭킹 불러오기
        StringBuilder sb = new StringBuilder();
        int rank = 1;
        for (UserScore user : topRankers) {
            sb.append(rank++).append("위: ")
              .append(user.getName()).append(" - ")
              .append(user.getScore()).append("점\n");
        }
        rankingArea.setText(sb.toString());
    }
}