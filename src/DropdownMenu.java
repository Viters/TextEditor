import javax.swing.*;

/**
 * Created by sir.viters on 27.11.2016.
 */
class DropdownMenu {
    static JMenuBar createDropdownMenu() {
        return new JMenuBar() {{
            add(createFileMenu());
            add(createEditMenu());
            add(createHelpMenu());
        }};
    }

    private static JMenu createFileMenu() {
        return new JMenu("File") {{
            add(new JMenuItem("New"));
            add(new JMenuItem("Open"));
            add(new JMenuItem("Save"));
            add(new JMenuItem("Save As..."));
            add(new JMenuItem("Exit"));
        }};
    }

    private static JMenu createEditMenu() {
        return new JMenu("Edit") {{
            add(new JMenuItem("Undo"));
            add(new JMenuItem("Redo"));
            addSeparator();
            add(new JMenuItem("Copy"));
            add(new JMenuItem("Cut"));
            add(new JMenuItem("Paste"));
        }};
    }

    private static JMenu createHelpMenu() {
        return new JMenu("Help") {{
            add(new JMenuItem("About"));
            add(new JMenuItem("Licensing"));
        }};
    }
}
