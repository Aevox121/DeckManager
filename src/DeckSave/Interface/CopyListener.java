package DeckSave.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyListener implements ActionListener {
    String DeckCode;


    public void setDeckCode(String deckCode) {
        DeckCode = deckCode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringSelection stsel = new StringSelection(DeckCode);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel,stsel);
    }
}
