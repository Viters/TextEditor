import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        jToolBar.add(createFontEnlargeButton());
        jToolBar.add(createFontLessenButton());
        jToolBar.add(createFontSetSizeDropdown());
        jToolBar.add(createFontColorDropdown());
        jToolBar.addSeparator();
    }

    private static JButton createBoldButton() {
        return OptionsButton.createButton(
                "B",
                new StyledEditorKit.BoldAction()
        );
    }

    private static JButton createItalicButton() {
        return OptionsButton.createButton(
                "I",
                new StyledEditorKit.ItalicAction()
        );
    }

    private static JButton createUnderlineButton() {
        return OptionsButton.createButton(
                "U",
                new StyledEditorKit.UnderlineAction()
        );
    }

    private static JButton createStrikeThroughButton() {
        return OptionsButton.createButton(
                "-S-",
                FormatTextEditor.createNewFormatAction(
                        attributeSet -> StyleConstants.isStrikeThrough(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setStrikeThrough(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createSuperscriptButton() {
        return OptionsButton.createButton(
                "^",
                FormatTextEditor.createNewFormatAction(
                        attributeSet -> StyleConstants.isSuperscript(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setSuperscript(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createSubscriptButton() {
        return OptionsButton.createButton(
                "_",
                FormatTextEditor.createNewFormatAction(
                        attributeSet -> StyleConstants.isSubscript(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setSubscript(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createFontEnlargeButton() {
        return OptionsButton.createButton(
                "F++",
                FormatTextEditor.createFontSizeAction(1)
        );
    }

    private static JButton createFontLessenButton() {
        return OptionsButton.createButton(
                "F--",
                FormatTextEditor.createFontSizeAction(-1)
        );
    }

    private static JComboBox<Integer> createFontSetSizeDropdown() {
        Integer[] fontSizes = {8, 10, 12, 14, 16, 20, 24, 28, 32, 48, 64};
        return new JComboBox<Integer>(fontSizes) {{
            setMaximumSize(new Dimension(60, 30));
            setFocusable(false);
            setBorder(new EmptyBorder(5, 10, 5, 10));
            setSelectedIndex(3);
            addActionListener(new StyledEditorKit.StyledTextAction("font-size-absolute") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    Integer fontSize = (Integer) cb.getSelectedItem();
                    final JEditorPane editor = getEditor(e);
                    if (editor != null) {
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                        StyleConstants.setFontSize(sas, fontSize);
                        setCharacterAttributes(editor, sas, false);
                    }
                }
            });
        }};
    }

    private static JComboBox<String> createFontColorDropdown() {
        String[] colors = {"Midnight Blue", "Asbestos", "Wisteria", "Belizehole",
                "Pomegranate", "Pumpkin", "Nephritis", "Greensea"};
        return new JComboBox<String>(colors) {{
            setMaximumSize(new Dimension(100, 30));
            setFocusable(false);
            setBorder(new EmptyBorder(5, 10, 5, 10));
            addActionListener(new StyledEditorKit.StyledTextAction("font-color") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String fontColor = (String) cb.getSelectedItem();
                    final JEditorPane editor = getEditor(e);
                    if (editor != null) {
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                        Color color = FormatTextEditor.mapColorStringToColorObject(fontColor);
                        StyleConstants.setForeground(sas, color);
                        setCharacterAttributes(editor, sas, false);
                    }
                }
            });
        }};
    }


    private static class OptionsButton {
        static JButton createButton(String label, ActionListener actionListener) {
            JButton button = new JButton(label) {{
                setFocusable(false);
                setBorder(new EmptyBorder(5, 10, 5, 10));
                setFont(new Font("", 1, 13));
            }};
            button.addActionListener(actionListener);
            return button;
        }
    }
}
