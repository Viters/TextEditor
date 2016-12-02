import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;

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

    static void formatText(final int selectStart, final int selectLength, final FormatPredicate formatPredicate, final FormatTransformation formatTransformation) {
        final StyledDocument doc = Editor.textEditor.getStyledDocument();
        final StyledEditorKit kit = (StyledEditorKit) Editor.textEditor.getEditorKit();
        final AttributeSet attributeSet = kit.getInputAttributes();
        final boolean shouldBeFormatted = !formatPredicate.check(attributeSet);
        SwingUtilities.invokeLater(() -> {
            MutableAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            formatTransformation.transform(simpleAttributeSet, shouldBeFormatted);
            doc.setCharacterAttributes(selectStart, selectLength, simpleAttributeSet, true);
        });
    }

    static void formatSelectedText(final FormatPredicate formatPredicate, final FormatTransformation formatTransformation) {
        final int selectStart = Editor.textEditor.getSelectionStart();
        final int selectLength = Editor.textEditor.getSelectedText().length();
        formatText(selectStart, selectLength, formatPredicate, formatTransformation);
    }

    interface FormatPredicate {
        boolean check(AttributeSet attributeSet);
    }

    interface FormatTransformation {
        void transform(MutableAttributeSet mutableAttributeSet, boolean formatPredicate);
    }
}
