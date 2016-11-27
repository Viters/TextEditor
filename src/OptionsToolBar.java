import javax.swing.*;

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
                    System.out.println("Bold!");
                });
    }

    private static JButton createItalicButton() {
        return OptionsButton.createButton(
                "I",
                e -> {
                    System.out.println("Italic!");
                });
    }

    private static JButton createUnderlineButton() {
        return OptionsButton.createButton(
                "U",
                e -> {
                    System.out.println("Underline!");
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
}
