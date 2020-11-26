package DeckSave.Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanListener implements ActionListener {
    JPanel panel;
    JComboBox box;
    JButton cleanButton;
    JButton copyButton;
    JButton deleteButton;

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public void setCopyButton(JButton copyButton) {
        this.copyButton = copyButton;
    }

    public void setCleanButton(JButton cleanButton) {
        this.cleanButton = cleanButton;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.remove(box);
        panel.remove(cleanButton);
        panel.remove(copyButton);
        panel.remove(deleteButton);
        panel.updateUI();
    }
}
