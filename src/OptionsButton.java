import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by sir.viters on 26.11.2016.
 */
class OptionsButton {
    static JButton createButton(String label) {
        return new JButton(label) {{
            setFocusable(false);
            setBorder(new EmptyBorder(5, 10, 5, 10));
        }};
    }
}
