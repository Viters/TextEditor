import jiconfont.icons.FontAwesome;

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
            setIcon(Editor.buildStandardFont(FontAwesome.FILE_O));
            addActionListener(e -> {
                System.out.println(Editor.textEditor.getText());
            });
        }};
    }

    private static JMenuItem createOpenButton() {
        return new JMenuItem("Open") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FOLDER_OPEN));
            addActionListener(e -> {
                System.out.println("Open!");
            });
        }};
    }

    private static JMenuItem createSaveButton() {
        return new JMenuItem("Save") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FLOPPY_O));
            addActionListener(e -> {
                System.out.println("Save!");
            });
        }};
    }

    private static JMenuItem createSaveAsButton() {
        return new JMenuItem("Save As...") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FLOPPY_O));
            addActionListener(e -> {
                System.out.println("SaveAs!");
            });
        }};
    }

    private static JMenuItem createExitButton() {
        return new JMenuItem("Exit") {{
            setIcon(Editor.buildStandardFont(FontAwesome.TIMES));
            addActionListener(e -> {
                System.out.println("Exit!");
            });
        }};
    }

    private static JMenuItem createUndoButton() {
        return new JMenuItem("Undo") {{
            setIcon(Editor.buildStandardFont(FontAwesome.UNDO));
            addActionListener(e -> {
                System.out.println("Undo!");
            });
        }};
    }

    private static JMenuItem createRedoButton() {
        return new JMenuItem("Redo") {{
            setIcon(Editor.buildStandardFont(FontAwesome.REPEAT));
            addActionListener(e -> {
                System.out.println("Redo!");
            });
        }};
    }

    private static JMenuItem createCopyButton() {
        return new JMenuItem("Copy") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FILES_O));
            addActionListener(e -> {
                System.out.println("Copy!");
            });
        }};
    }

    private static JMenuItem createCutButton() {
        return new JMenuItem("Cut") {{
            setIcon(Editor.buildStandardFont(FontAwesome.SCISSORS));
            addActionListener(e -> {
                System.out.println("Cut!");
            });
        }};
    }

    private static JMenuItem createPasteButton() {
        return new JMenuItem("Paste") {{
            setIcon(Editor.buildStandardFont(FontAwesome.CLIPBOARD));
            addActionListener(e -> {
                System.out.println("Paste!");
            });
        }};
    }

    private static JMenuItem createAboutButton() {
        return new JMenuItem("About") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FILE_TEXT_O));
            addActionListener(e -> {
                System.out.println("About!");
            });
        }};
    }

    private static JMenuItem createLicensingButton() {
        return new JMenuItem("Licensing") {{
            setIcon(Editor.buildStandardFont(FontAwesome.COPYRIGHT));
            addActionListener(e -> {
                System.out.println("Licensing!");
            });
        }};
    }
}
