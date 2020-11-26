package DeckSave.Interface;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InputListener implements DocumentListener {
    JTextArea inputArea;
    InsertListener pasteListener;

    public void setPasteListener(InsertListener pasteListener) {
        this.pasteListener = pasteListener;
    }

    public void setInputArea(JTextArea inputArea) {
        this.inputArea = inputArea;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        String str = inputArea.getText();
        pasteListener.setStr(str);
    }

}
