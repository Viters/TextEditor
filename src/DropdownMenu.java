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
            add(createNewButton());
            add(createOpenButton());
            add(createSaveButton());
            add(createSaveAsButton());
            addSeparator();
            add(createExitButton());
        }};
    }

    private static JMenu createEditMenu() {
        return new JMenu("Edit") {{
            add(createUndoButton());
            add(createRedoButton());
            addSeparator();
            add(createCopyButton());
            add(createCutButton());
            add(createPasteButton());
        }};
    }

    private static JMenu createHelpMenu() {
        return new JMenu("Help") {{
            add(createAboutButton());
            add(createLicensingButton());
        }};
    }

    private static JMenuItem createNewButton() {
        return new JMenuItem("New") {{
            addActionListener(e -> {
                System.out.println(Editor.textEditor.getText());
            });
        }};
    }

    private static JMenuItem createOpenButton() {
        return new JMenuItem("Open") {{
            addActionListener(e -> {
                System.out.println("Open!");
            });
        }};
    }

    private static JMenuItem createSaveButton() {
        return new JMenuItem("Save") {{
            addActionListener(e -> {
                System.out.println("Save!");
            });
        }};
    }

    private static JMenuItem createSaveAsButton() {
        return new JMenuItem("Save As...") {{
            addActionListener(e -> {
                System.out.println("SaveAs!");
            });
        }};
    }

    private static JMenuItem createExitButton() {
        return new JMenuItem("Exit") {{
            addActionListener(e -> {
                System.out.println("Exit!");
            });
        }};
    }

    private static JMenuItem createUndoButton() {
        return new JMenuItem("Undo") {{
            addActionListener(e -> {
                System.out.println("Undo!");
            });
        }};
    }

    private static JMenuItem createRedoButton() {
        return new JMenuItem("Redo") {{
            addActionListener(e -> {
                System.out.println("Redo!");
            });
        }};
    }

    private static JMenuItem createCopyButton() {
        return new JMenuItem("Copy") {{
            addActionListener(e -> {
                System.out.println("Copy!");
            });
        }};
    }

    private static JMenuItem createCutButton() {
        return new JMenuItem("Cut") {{
            addActionListener(e -> {
                System.out.println("Cut!");
            });
        }};
    }

    private static JMenuItem createPasteButton() {
        return new JMenuItem("Paste") {{
            addActionListener(e -> {
                System.out.println("Paste!");
            });
        }};
    }

    private static JMenuItem createAboutButton() {
        return new JMenuItem("About") {{
            addActionListener(e -> {
                System.out.println("About!");
            });
        }};
    }

    private static JMenuItem createLicensingButton() {
        return new JMenuItem("Licensing") {{
            addActionListener(e -> {
                System.out.println("Licensing!");
            });
        }};
    }
}
