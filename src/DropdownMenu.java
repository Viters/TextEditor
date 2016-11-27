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
            add("New", new JMenuItem("New"));
            add("Open", new JMenuItem("Open"));
            add("Save", new JMenuItem("Save"));
            add("Save As...", new JMenuItem("Save As..."));
            add("Exit", new JMenuItem("Exit"));
        }};
    }

    private static JMenu createEditMenu() {
        return new JMenu("Edit") {{
            add("Undo", new JMenuItem("Undo"));
            add("Redo", new JMenuItem("Redo"));
            addSeparator();
            add("Copy", new JMenuItem("Copy"));
            add("Cut", new JMenuItem("Cut"));
            add("Paste", new JMenuItem("Paste"));
        }};
    }

    private static JMenu createHelpMenu() {
        return new JMenu("Help") {{
            add("About", new JMenuItem("About"));
            add("Licensing", new JMenuItem("Licensing"));
        }};
    }
}
