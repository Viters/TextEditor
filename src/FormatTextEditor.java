import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;

/**
 * Created by sir.viters on 27.11.2016.
 */
public class FormatTextEditor {

    static JTextPane createFormatTextEditor() {
        return new JTextPane() {{
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setEditorKit(new StyledEditorKit());
        }};
    }

    static void formatText(int startPos, int selectLength, FormatPredicate formatPredicate, FormatTransformation formatTransformation) {
        StyledDocument doc = Editor.textEditor.getStyledDocument();
        StyledEditorKit kit = (StyledEditorKit) Editor.textEditor.getEditorKit();
        AttributeSet attributeSet = kit.getInputAttributes();
        boolean shouldBeFormatted = !formatPredicate.check(attributeSet);
        SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
        formatTransformation.transform(simpleAttributeSet, shouldBeFormatted);

        EventQueue.invokeLater(() -> {
            doc.setCharacterAttributes(startPos, selectLength, simpleAttributeSet, false);
        });
    }

    static void formatSelectedText(FormatPredicate formatPredicate, FormatTransformation formatTransformation) {
        int selectStart = Editor.textEditor.getSelectionStart();
        int selectLength = Editor.textEditor.getSelectedText().length();
        formatText(selectStart, selectLength, formatPredicate, formatTransformation);
    }

    interface FormatPredicate {
        boolean check(AttributeSet attributeSet);
    }

    interface FormatTransformation {
        void transform(MutableAttributeSet mutableAttributeSet, boolean formatPredicate);
    }
}
