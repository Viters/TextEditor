import javax.swing.*;

/**
 * Created by sir.viters on 26.11.2016.
 */
public class Main {
    static Editor frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame = new Editor();
            frame.setTitle("Writer");
            frame.setSize(1000, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setIconImage(new ImageIcon("assets/logo.png").getImage());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
