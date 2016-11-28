import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        jToolBar.addSeparator();
        jToolBar.add(createQuoteButton());
        jToolBar.add(createCodeButton());
        jToolBar.addSeparator();
        jToolBar.add(createUnorderedListButton());
        jToolBar.add(createOrderedListButton());
        jToolBar.addSeparator();
        jToolBar.add(createFontEnlargeButton());
        jToolBar.add(createFontLessenButton());
        jToolBar.addSeparator();
    }

    private static JButton createBoldButton() {
        return OptionsButton.createButton(
                "B",
                e -> {
                    FormatTextEditor.formatSelectedText(s -> "<b>" + s + "</b>");
                });
    }

    private static JButton createItalicButton() {
        return OptionsButton.createButton(
                "I",
                e -> {
                    FormatTextEditor.formatSelectedText(s -> "<i>" + s + "</i>");
                });
    }

    private static JButton createUnderlineButton() {
        return OptionsButton.createButton(
                "U",
                e -> {
                    FormatTextEditor.formatSelectedText(s -> "<u>" + s + "</u>");
                });
    }

    private static JButton createQuoteButton() {
        return OptionsButton.createButton(
                "Quote",
                e -> {
                    System.out.println("Quote!");
                });
    }

    private static JButton createCodeButton() {
        return OptionsButton.createButton(
                "Code",
                e -> {
                    System.out.println("Code!");
                });
    }

    private static JButton createUnorderedListButton() {
        return OptionsButton.createButton(
                "UL",
                e -> {
                    System.out.println("Unordered List!");
                });
    }

    private static JButton createOrderedListButton() {
        return OptionsButton.createButton(
                "OL",
                e -> {
                    System.out.println("Ordered List!");
                });
    }

    private static JButton createFontEnlargeButton() {
        return OptionsButton.createButton(
                "Font++",
                e -> {
                    System.out.println("Font Enlarge!");
                });
    }

    private static JButton createFontLessenButton() {
        return OptionsButton.createButton(
                "Font--",
                e -> {
                    System.out.println("Font Lessen!");
                });
    }

    private static class OptionsButton {
        static JButton createButton(String label, ActionListener actionListener) {
            JButton button = new JButton(label) {{
                setFocusable(false);
                setBorder(new EmptyBorder(5, 10, 5, 10));
            }};
            button.addActionListener(actionListener);
            return button;
        }
    }
}
