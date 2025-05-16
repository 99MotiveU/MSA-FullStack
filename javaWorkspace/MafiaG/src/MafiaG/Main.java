package MafiaG;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI().showLoginUI());
        System.out.println("Classpath: " + System.getProperty("java.class.path"));
    }
}
