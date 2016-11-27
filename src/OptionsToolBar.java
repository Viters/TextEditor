import javax.swing.*;

/**
 * Created by sir.viters on 27.11.2016.
 */
class OptionsToolBar{
    static JToolBar createOptionsToolBar() {
        JToolBar optionsToolBar = new JToolBar() {{
            setFloatable(false);
        }};
        createButtons(optionsToolBar);
        return optionsToolBar;
    }

    private static void createButtons(JToolBar jToolBar) {
        jToolBar.addSeparator();
        jToolBar.add("Bold", new OptionsButton("B"));
        jToolBar.add("Italic", new OptionsButton("I"));
        jToolBar.add("Underline", new OptionsButton("U"));
        jToolBar.addSeparator();
        jToolBar.add("Quote", new OptionsButton("Quote"));
        jToolBar.add("Code", new OptionsButton("Code"));
        jToolBar.addSeparator();
        jToolBar.add("UnorderedList", new OptionsButton("UL"));
        jToolBar.add("OrderedList", new OptionsButton("OL"));
        jToolBar.addSeparator();
        jToolBar.add("FontBigger", new OptionsButton("Font+"));
        jToolBar.add("FontSmaller", new OptionsButton("Font-"));
        jToolBar.addSeparator();
    }
}
