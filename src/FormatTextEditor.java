import rtf.AdvancedRTFDocument;
import rtf.AdvancedRTFEditorKit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by sir.viters on 27.11.2016.
 */
public class FormatTextEditor {

    static JTextPane createFormatTextEditor(UndoManager manager) {
        return new JTextPane() {{
            setDocument(new AdvancedRTFDocument());
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setFont(new Font("", 0, 14));
            setForeground(mapColorStringToColorObject("Midnight Blue"));
            setEditorKit(new AdvancedRTFEditorKit());
            getDocument().addUndoableEditListener(manager);
        }};
    }

    static AdvancedRTFEditorKit.StyledTextAction createNewFormatAction(final FormatPredicate formatPredicate, final FormatTransformation formatTransformation) {
        return new AdvancedRTFEditorKit.StyledTextAction("format") {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JEditorPane editor = getEditor(e);
                if (editor != null) {
                    final AdvancedRTFEditorKit kit = (AdvancedRTFEditorKit) editor.getEditorKit();
                    MutableAttributeSet attr = kit.getInputAttributes();
                    final boolean shouldFormat = (formatPredicate.check(attr)) ? false : true;
                    SimpleAttributeSet sas = new SimpleAttributeSet();
                    formatTransformation.transform(sas, shouldFormat);
                    setCharacterAttributes(editor, sas, false);
                }
            }
        };
    }

    static AdvancedRTFEditorKit.StyledTextAction createFontSizeAction(final int difference) {
        return new AdvancedRTFEditorKit.StyledTextAction("font-size-relative") {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JEditorPane editor = getEditor(e);
                if (editor != null) {
                    final AdvancedRTFEditorKit kit = (AdvancedRTFEditorKit) editor.getEditorKit();
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
