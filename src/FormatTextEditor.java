import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by sir.viters on 27.11.2016.
 */
public class FormatTextEditor {

    static JTextPane createFormatTextEditor() {
        return new JTextPane() {{
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setFont(new Font("", 0, 14));
            setForeground(mapColorStringToColorObject("Midnight Blue"));
            setBackground(mapColorStringToColorObject("Clouds"));
            setEditorKit(new StyledEditorKit());
        }};
    }

    static StyledEditorKit.StyledTextAction createNewFormatAction(final FormatPredicate formatPredicate, final FormatTransformation formatTransformation) {
        return new StyledEditorKit.StyledTextAction("format") {
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

    static StyledEditorKit.StyledTextAction createFontSizeAction(final int difference) {
        return new StyledEditorKit.StyledTextAction("font-size-relative") {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JEditorPane editor = getEditor(e);
                if (editor != null) {
                    final StyledEditorKit kit = getStyledEditorKit(editor);
                    AttributeSet attr = kit.getInputAttributes();
                    final int currentFontSize = StyleConstants.getFontSize(attr);
                    SimpleAttributeSet sas = new SimpleAttributeSet();
                    StyleConstants.setFontSize(sas, currentFontSize + difference);
                    setCharacterAttributes(editor, sas, false);
                }
            }
        };
    }

    static Color mapColorStringToColorObject(String colorName) {
        switch (colorName) {
            case "Midnight Blue":
                return new Color(44, 62, 80);
            case "Clouds":
                return new Color(236, 240, 241);
            case "Asbestos":
                return new Color(127, 140, 141);
            case "Wisteria":
                return new Color(142, 68, 173);
            case "Belizehole":
                return new Color(41, 128, 185);
            case "Pomegranate":
                return new Color(231, 76, 60);
            case "Pumpkin":
                return new Color(211, 84, 0);
            case "Nephritis":
                return new Color(39, 174, 96);
            case "Greensea":
                return new Color(26, 188, 156);
            default:
                return Color.BLACK;
        }
    }

    interface FormatPredicate {
        boolean check(AttributeSet attributeSet);
    }

    interface FormatTransformation {
        void transform(MutableAttributeSet mutableAttributeSet, boolean formatPredicate);
    }
}
