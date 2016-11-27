import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.IOException;

/**
 * Created by sir.viters on 26.11.2016.
 */
class Editor extends JFrame {
    private JPanel menusPanel;
    private JPanel textEditorPanel;

    Editor() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        initializeMenus();

        initializeTextPane();

        add(menusPanel, BorderLayout.NORTH);
        add(textEditorPanel, BorderLayout.CENTER);
    }

    private void initializeTextPane() {
        textEditorPanel = new JPanel(new BorderLayout());

        JTextPane textEditor = FormatTextEditor.createFormatTextEditor();
        JScrollPane scroll = new JScrollPane(textEditor);
        textEditorPanel.add(scroll);
        HTMLEditorKit kit = (HTMLEditorKit) textEditor.getEditorKit();
        HTMLDocument doc = (HTMLDocument) textEditor.getStyledDocument();



        try {
            kit.insertHTML(doc, doc.getLength(), "<b>", 0, 0, null);
        } catch (BadLocationException | IOException e) {
            e.printStackTrace();
        }

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
