import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.event.ActionEvent;

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

    static StyledEditorKit.StyledTextAction createNewFormatAction(final FormatPredicate formatPredicate, final FormatTransformation formatTransformation) {
        return new StyledEditorKit.StyledTextAction("strike-through") {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JEditorPane editor = getEditor(e);
                if (editor != null) {
                    final StyledEditorKit kit = getStyledEditorKit(editor);
                    MutableAttributeSet attr = kit.getInputAttributes();
                    final boolean shouldFormat = (formatPredicate.check(attr)) ? false : true;
                    SimpleAttributeSet sas = new SimpleAttributeSet();
                    formatTransformation.transform(sas, shouldFormat);
                    setCharacterAttributes(editor, sas, false);
                }
            }
        };
    }

    interface FormatPredicate {
        boolean check(AttributeSet attributeSet);
    }

    interface FormatTransformation {
        void transform(MutableAttributeSet mutableAttributeSet, boolean formatPredicate);
    }
}
