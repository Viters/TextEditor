import jiconfont.icons.FontAwesome;
import rtf.AdvancedRTFDocument;

import javax.swing.*;
import java.io.*;

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
                switch (shouldSavePrompt()) {
                    case 2:
                        return;
                    case 0:
                        saveFileAction();
                    case 1:
                        SwingUtilities.invokeLater(() -> Editor.textEditor.setText(""));
                }
            });
        }};
    }

    private static JMenuItem createOpenButton() {
        return new JMenuItem("Open") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FOLDER_OPEN));
            addActionListener(e -> {
                switch (shouldSavePrompt()) {
                    case 2:
                        return;
                    case 0:
                        saveFileAction();
                    case 1:
                        openFileAction();
                }
            });
        }};
    }

    private static JMenuItem createSaveButton() {
        return new JMenuItem("Save") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FLOPPY_O));
            addActionListener(e -> {
                saveFileAction();
            });
        }};
    }

    private static JMenuItem createSaveAsButton() {
        return new JMenuItem("Save As...") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FLOPPY_O));
            addActionListener(e -> {
                saveFileAction();
            });
        }};
    }

    private static JMenuItem createExitButton() {
        return new JMenuItem("Exit") {{
            setIcon(Editor.buildStandardFont(FontAwesome.TIMES));
            addActionListener(e -> {
                switch (shouldSavePrompt()) {
                    case 2:
                        return;
                    case 0:
                        saveFileAction();
                    case 1:
                        System.exit(0);
                }
            });
        }};
    }

    private static JMenuItem createUndoButton() {
        return new JMenuItem("Undo") {{
            setIcon(Editor.buildStandardFont(FontAwesome.UNDO));
            addActionListener(e -> {
                if (Editor.undoManager.canUndo())
                    Editor.undoManager.undo();
            });
        }};
    }

    private static JMenuItem createRedoButton() {
        return new JMenuItem("Redo") {{
            setIcon(Editor.buildStandardFont(FontAwesome.REPEAT));
            addActionListener(e -> {
                if (Editor.undoManager.canRedo())
                    Editor.undoManager.redo();
            });
        }};
    }

    private static JMenuItem createCopyButton() {
        return new JMenuItem("Copy") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FILES_O));
            addActionListener(e -> {
                // TODO: 04.12.2016  kopiowanie
            });
        }};
    }

    private static JMenuItem createCutButton() {
        return new JMenuItem("Cut") {{
            setIcon(Editor.buildStandardFont(FontAwesome.SCISSORS));
            addActionListener(e -> {
                // TODO: 04.12.2016  wycinanie
            });
        }};
    }

    private static JMenuItem createPasteButton() {
        return new JMenuItem("Paste") {{
            setIcon(Editor.buildStandardFont(FontAwesome.CLIPBOARD));
            addActionListener(e -> {
                // TODO: 04.12.2016  wklejanie
            });
        }};
    }

    private static JMenuItem createAboutButton() {
        return new JMenuItem("About") {{
            setIcon(Editor.buildStandardFont(FontAwesome.FILE_TEXT_O));
            addActionListener(e -> {
                JOptionPane.showMessageDialog(Editor.textEditor,
                        "Writer 2016.1\n\n" +
                                "Simple RTF editor written for Java class\n\n" +
                                "GitHub:\n" +
                                "https://github.com/Viters/TextEditor",
                        "About Writer", JOptionPane.INFORMATION_MESSAGE);
            });
        }};
    }

    private static JMenuItem createLicensingButton() {
        return new JMenuItem("Licensing") {{
            setIcon(Editor.buildStandardFont(FontAwesome.COPYRIGHT));
            addActionListener(e -> {
                JOptionPane.showMessageDialog(Editor.textEditor,
                        "The MIT License (MIT)\n" +
                                "Copyright (c) 2016 Łukasz Szcześniak",
                        "Copyright", JOptionPane.INFORMATION_MESSAGE);
            });
        }};
    }

    private static void saveFileAction() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(Editor.textEditor) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = fileChooser.getSelectedFile();
        try(FileWriter fileWriter = new FileWriter(file)) {
            Editor.textEditor.write(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openFileAction() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(Editor.textEditor) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File file = fileChooser.getSelectedFile();
        final AdvancedRTFDocument doc = (AdvancedRTFDocument) Editor.textEditor.getDocument();
        try(InputStream inputStream = new FileInputStream(file)) {
            Editor.textEditor.setText("");
            Editor.textEditor.read(inputStream, doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int shouldSavePrompt() {
        if (Editor.textEditor.getDocument().getLength() == 0)
            return 1;
        else
            return JOptionPane.showConfirmDialog(Editor.textEditor, "Do you want to save current document?");
    }
}
