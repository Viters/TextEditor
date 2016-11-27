import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by sir.viters on 26.11.2016.
 */
class OptionsButton extends JButton {
    OptionsButton(String text) {
        super(text);
        setup();
    }

    private void setup() {
        setFocusable(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
