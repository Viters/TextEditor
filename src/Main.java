import javax.swing.*;
import java.awt.*;

/**
 * Created by sir.viters on 26.11.2016.
 */
public class Main {
    static Editor frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            frame = new Editor();
            frame.setTitle("Code");
            frame.setSize(800, 1000);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
