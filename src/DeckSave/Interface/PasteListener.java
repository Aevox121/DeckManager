package DeckSave.Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasteListener implements ActionListener {
    JTextArea inputArea;

    public void setInputArea(JTextArea inputArea) {
        this.inputArea = inputArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputArea.setText("");
        inputArea.paste();
    }
}
