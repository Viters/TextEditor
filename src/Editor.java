import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.undo.UndoManager;
import java.awt.*;

/**
 * Created by sir.viters on 26.11.2016.
 */
class Editor extends JFrame {
    private JPanel menusPanel;
    private JPanel textEditorPanel;
    final static UndoManager undoManager = new UndoManager();
    final static JTextPane textEditor = FormatTextEditor.createFormatTextEditor(undoManager);

    Editor() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        IconFontSwing.register(FontAwesome.getIconFont());

        SwingUtilities.invokeLater(() -> {
            initializeMenus();
            initializeTextPanel();

            add(menusPanel, BorderLayout.NORTH);
            add(textEditorPanel, BorderLayout.CENTER);
        });
    }

    static Icon buildStandardFont(FontAwesome fa) {
        return IconFontSwing.buildIcon(fa, 14, FormatTextEditor.mapColorStringToColorObject("Midnight Blue"));
    }

    private void initializeTextPanel() {
        textEditorPanel = new JPanel(new BorderLayout());
        JScrollPane scroll = new JScrollPane(textEditor);
        textEditorPanel.add(scroll);
    }

    private void initializeMenus() {
        JPanel dropdownMenuPanel = new JPanel(new BorderLayout());
        JMenuBar dropdownMenu = DropdownMenu.createDropdownMenu();
        dropdownMenuPanel.add(dropdownMenu);

        JPanel formatBarPanel = new JPanel(new BorderLayout());
        formatBarPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        JToolBar formatBar = OptionsToolBar.createOptionsToolBar();
        formatBarPanel.add(formatBar);

        menusPanel = new JPanel(new BorderLayout());
        menusPanel.add(dropdownMenuPanel, BorderLayout.NORTH);
        menusPanel.add(formatBarPanel, BorderLayout.CENTER);
    }
}
