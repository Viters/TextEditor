import javafx.scene.text.TextAlignment;
import jiconfont.icons.FontAwesome;
import rtf.AdvancedRTFEditorKit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
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
        jToolBar.add(createBoldButton());
        jToolBar.add(createItalicButton());
        jToolBar.add(createUnderlineButton());
        jToolBar.add(createStrikeThroughButton());
        jToolBar.addSeparator();
        jToolBar.add(createSuperscriptButton());
        jToolBar.add(createSubscriptButton());
        jToolBar.addSeparator();
        jToolBar.add(createAlignLeftButton());
        jToolBar.add(createAlignCenterButton());
        jToolBar.add(createAlignRightButton());
        jToolBar.add(createAlignJustifyButton());
        jToolBar.addSeparator();
        jToolBar.add(createFontEnlargeButton());
        jToolBar.add(createFontLessenButton());
        jToolBar.addSeparator();
        jToolBar.add(createFontSetSizeDropdown());
        jToolBar.addSeparator();
        jToolBar.add(createFontColorDropdown());
        jToolBar.addSeparator();
        jToolBar.add(createFontFamilyDropdown());
    }

    private static JButton createBoldButton() {
        return OptionsButton.createButton(
                FontAwesome.BOLD,
                new AdvancedRTFEditorKit.BoldAction()
        );
    }

    private static JButton createItalicButton() {
        return OptionsButton.createButton(
                FontAwesome.ITALIC,
                new AdvancedRTFEditorKit.ItalicAction()
        );
    }

    private static JButton createUnderlineButton() {
        return OptionsButton.createButton(
                FontAwesome.UNDERLINE,
                new AdvancedRTFEditorKit.UnderlineAction()
        );
    }

    private static JButton createStrikeThroughButton() {
        return OptionsButton.createButton(
                FontAwesome.STRIKETHROUGH,
                FormatTextEditor.createNewFormatAction(
                        attributeSet -> StyleConstants.isStrikeThrough(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setStrikeThrough(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createSuperscriptButton() {
        return OptionsButton.createButton(
                FontAwesome.SUPERSCRIPT,
                FormatTextEditor.createNewFormatAction(
                        attributeSet -> StyleConstants.isSuperscript(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setSuperscript(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createSubscriptButton() {
        return OptionsButton.createButton(
                FontAwesome.SUBSCRIPT,
                FormatTextEditor.createNewFormatAction(
                        attributeSet -> StyleConstants.isSubscript(attributeSet),
                        (mutableAttributeSet, formatPredicate) -> StyleConstants.setSubscript(mutableAttributeSet, formatPredicate)
                ));
    }

    private static JButton createFontEnlargeButton() {
        return OptionsButton.createButton(
                FontAwesome.EXPAND,
                FormatTextEditor.createFontSizeAction(1)
        );
    }

    private static JButton createFontLessenButton() {
        return OptionsButton.createButton(
                FontAwesome.COMPRESS,
                FormatTextEditor.createFontSizeAction(-1)
        );
    }

    private static JComboBox<Integer> createFontSetSizeDropdown() {
        Integer[] fontSizes = {8, 10, 12, 14, 16, 20, 24, 28, 32, 48, 64};
        return new JComboBox<Integer>(fontSizes) {{
            setMaximumSize(new Dimension(60, 30));
            setFocusable(false);
            setSelectedIndex(3);
            addActionListener(new AdvancedRTFEditorKit.StyledTextAction("font-size-absolute") {
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

    private static JButton createAlignLeftButton() {
        return OptionsButton.createButton(
                FontAwesome.ALIGN_LEFT,
                new AdvancedRTFEditorKit.AlignmentAction("", TextAlignment.LEFT.ordinal())
        );
    }

    private static JButton createAlignCenterButton() {
        return OptionsButton.createButton(
                FontAwesome.ALIGN_CENTER,
                new AdvancedRTFEditorKit.AlignmentAction("", TextAlignment.CENTER.ordinal())
        );
    }

    private static JButton createAlignRightButton() {
        return OptionsButton.createButton(
                FontAwesome.ALIGN_RIGHT,
                new AdvancedRTFEditorKit.AlignmentAction("", TextAlignment.RIGHT.ordinal())
        );
    }

    private static JButton createAlignJustifyButton() {
        return OptionsButton.createButton(
                FontAwesome.ALIGN_JUSTIFY,
                new AdvancedRTFEditorKit.AlignmentAction("", TextAlignment.JUSTIFY.ordinal())
        );
    }

    private static JComboBox<String> createFontColorDropdown() {
        String[] colors = {"Midnight Blue", "Asbestos", "Wisteria", "Belizehole",
                "Pomegranate", "Pumpkin", "Nephritis", "Greensea"};
        return new JComboBox<String>(colors) {{
            setMaximumSize(new Dimension(100, 30));
            setFocusable(false);
            addActionListener(new AdvancedRTFEditorKit.StyledTextAction("font-color") {
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

    private static JComboBox<String> createFontFamilyDropdown() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        return new JComboBox<String>(fonts) {{
            setMaximumSize(new Dimension(160, 30));
            setFocusable(false);
            setSelectedItem(Editor.textEditor.getFont().getFamily());
            addActionListener(new AdvancedRTFEditorKit.StyledTextAction("font-family") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JComboBox cb = (JComboBox) e.getSource();
                    String fontFamily = (String) cb.getSelectedItem();
                    final JEditorPane editor = getEditor(e);
                    if (editor != null) {
                        SimpleAttributeSet sas = new SimpleAttributeSet();
                        StyleConstants.setFontFamily(sas, fontFamily);
                        setCharacterAttributes(editor, sas, false);
                    }
                }
            });
        }};
    }


    private static class OptionsButton {
        static JButton createButton(FontAwesome fa, ActionListener actionListener) {
            JButton button = new JButton(Editor.buildStandardFont(fa)) {{
                setFocusable(false);
                setBorder(new EmptyBorder(5, 10, 5, 10));
            }};
            button.addActionListener(actionListener);
            return button;
        }
    }
}
