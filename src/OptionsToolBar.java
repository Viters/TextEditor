import javax.swing.*;
import java.util.HashMap;

/**
 * Created by sir.viters on 27.11.2016.
 */
class OptionsToolBar {
    private static HashMap<String, JButton> buttons = new HashMap<String, JButton>() {{
        put("Bold", OptionsButton.createButton("B"));
        put("Italic", OptionsButton.createButton("I"));
        put("Underline", OptionsButton.createButton("U"));
        put("Quote", OptionsButton.createButton("Quote"));
        put("Code", OptionsButton.createButton("Code"));
        put("UnorderedList", OptionsButton.createButton("UL"));
        put("OrderedList", OptionsButton.createButton("OL"));
        put("FontEnlarge", OptionsButton.createButton("Font++"));
        put("FontLessen", OptionsButton.createButton("Font--"));
    }};

    static JToolBar createOptionsToolBar() {
        JToolBar optionsToolBar = new JToolBar() {{
            setFloatable(false);
        }};
        createButtons(optionsToolBar);
        addActionListeners();
        return optionsToolBar;
    }

    private static void createButtons(JToolBar jToolBar) {
        jToolBar.addSeparator();
        jToolBar.add(buttons.get("Bold"));
        jToolBar.add(buttons.get("Italic"));
        jToolBar.add(buttons.get("Underline"));
        jToolBar.addSeparator();
        jToolBar.add(buttons.get("Quote"));
        jToolBar.add(buttons.get("Code"));
        jToolBar.addSeparator();
        jToolBar.add(buttons.get("UnorderedList"));
        jToolBar.add(buttons.get("OrderedList"));
        jToolBar.addSeparator();
        jToolBar.add(buttons.get("FontEnlarge"));
        jToolBar.add(buttons.get("FontLessen"));
        jToolBar.addSeparator();
    }

    private static void addActionListeners() {
        addBoldActionListener();
        addItalicActionListener();
        addUnderlineActionListener();
        addQuoteActionListener();
        addCodeActionListener();
        addUnorderedListActionListener();
        addOrderedListActionListener();
        addFontEnlargeActionListener();
        addFontLessenActionListener();
    }

    private static void addBoldActionListener() {
        buttons.get("Bold").addActionListener(e -> {
            System.out.println("Bold");
        });
    }

    private static void addItalicActionListener() {
        buttons.get("Italic").addActionListener(e -> {
            System.out.println("Italic");
        });
    }

    private static void addUnderlineActionListener() {
        buttons.get("Underline").addActionListener(e -> {
            System.out.println("Underline");
        });
    }

    private static void addQuoteActionListener() {
        buttons.get("Quote").addActionListener(e -> {
            System.out.println("Quote");
        });
    }

    private static void addCodeActionListener() {
        buttons.get("Code").addActionListener(e -> {
            System.out.println("Code");
        });
    }

    private static void addUnorderedListActionListener() {
        buttons.get("UnorderedList").addActionListener(e -> {
            System.out.println("UnorderedList");
        });
    }

    private static void addOrderedListActionListener() {
        buttons.get("OrderedList").addActionListener(e -> {
            System.out.println("OrderedList");
        });
    }

    private static void addFontEnlargeActionListener() {
        buttons.get("FontEnlarge").addActionListener(e -> {
            System.out.println("FontEnlarge");
        });
    }

    private static void addFontLessenActionListener() {
        buttons.get("FontLessen").addActionListener(e -> {
            System.out.println("FontLessen");
        });
    }

}
