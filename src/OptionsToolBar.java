import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by sir.viters on 27.11.2016.
 */
class OptionsToolBar {
    static JToolBar createOptionsToolBar() {
        JToolBar optionsToolBar = new JToolBar() {{
            setFloatable(false);
        }};
        populateMenu(optionsToolBar);
        return optionsToolBar;
    }

    private static void populateMenu(JToolBar jToolBar) {
        jToolBar.addSeparator();
        jToolBar.add(createBoldButton());
        jToolBar.add(createItalicButton());
        jToolBar.add(createUnderlineButton());
        jToolBar.add(createStrikeThroughButton());
        jToolBar.addSeparator();
        jToolBar.add(createSuperscriptButton());
        jToolBar.add(createSubscriptButton());
        jToolBar.addSeparator();

        jToolBar.addSeparator();
    }

    private static JButton createBoldButton() {
        return OptionsButton.createButton(
                "B",
                e -> FormatTextEditor.formatSelectedText(
                        attributeSet -> StyleConstants.isBold(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setBold(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createItalicButton() {
        return OptionsButton.createButton(
                "I",
                e -> FormatTextEditor.formatSelectedText(
                        attributeSet -> StyleConstants.isItalic(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setItalic(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createUnderlineButton() {
        return OptionsButton.createButton(
                "U",
                e -> FormatTextEditor.formatSelectedText(
                        attributeSet -> StyleConstants.isUnderline(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setUnderline(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createStrikeThroughButton() {
        return OptionsButton.createButton(
                "-S-",
                e -> FormatTextEditor.formatSelectedText(
                        attributeSet -> StyleConstants.isStrikeThrough(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setStrikeThrough(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createSuperscriptButton() {
        return OptionsButton.createButton(
                "Superscript",
                e -> FormatTextEditor.formatSelectedText(
                        attributeSet -> StyleConstants.isSuperscript(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setSuperscript(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createSubscriptButton() {
        return OptionsButton.createButton(
                "Subscript",
                e -> FormatTextEditor.formatSelectedText(
                        attributeSet -> StyleConstants.isSubscript(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setSubscript(mutableAttributeSet, formatPredicate)
                ));
    }

    private static class OptionsButton {
        static JButton createButton(String label, ActionListener actionListener) {
            JButton button = new JButton(label) {{
                setFocusable(false);
                setBorder(new EmptyBorder(5, 10, 5, 10));
                setFont(new Font("", 2, 13));
            }};
            button.addActionListener(actionListener);
            return button;
        }
    }
}
