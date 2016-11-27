import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLEditorKit;

/**
 * Created by sir.viters on 27.11.2016.
 */
public class FormatTextEditor {

    static JTextPane createFormatTextEditor() {
        HTMLEditorKit kit = new HTMLEditorKit();
        JTextPane formatTextEditor = new JTextPane() {{
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setEditorKit(kit);
        }};
        return formatTextEditor;
    }
}
