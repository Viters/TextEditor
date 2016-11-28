import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.IOException;
import java.util.function.Function;

/**
 * Created by sir.viters on 27.11.2016.
 */
public class FormatTextEditor {

    static JTextPane createFormatTextEditor() {
        return new JTextPane() {{
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setEditorKit(new HTMLEditorKit());
        }};
    }

    static void formatSelectedText(int startPos, int selectLength, Function<String, String> transition) {
        try {
            HTMLEditorKit kit = (HTMLEditorKit) Editor.textEditor.getEditorKit();
            HTMLDocument doc = (HTMLDocument) Editor.textEditor.getStyledDocument();
            String selectedText = doc.getText(startPos, selectLength);
            String formattedText = transition.apply(selectedText);
            doc.remove(startPos, selectLength);
            kit.insertHTML(doc, startPos, formattedText, 0, 0, null);
        } catch (BadLocationException | IOException e) {
            e.printStackTrace();
        }
    }
}
