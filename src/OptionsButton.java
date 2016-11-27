import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

/**
 * Created by sir.viters on 26.11.2016.
 */
class OptionsButton {
    static JButton createButton(String label, ActionListener actionListener) {
        return new JButton(label) {{
            setFocusable(false);
            setBorder(new EmptyBorder(5, 10, 5, 10));
            addActionListener(actionListener);
        }};
    }
}
