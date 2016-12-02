import javax.swing.*;

/**
 * Created by sir.viters on 26.11.2016.
 */
public class Main {
    static Editor frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new Editor();
            frame.setTitle("Code");
            frame.setSize(800, 1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
