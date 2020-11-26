package DeckSave.Interface;

import DeckSave.DeckC.Deck;

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

    public void clipBoard(String str){
        StringSelection stsel = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel,stsel);
        JOptionPane.showMessageDialog(null,"已复制到剪切板","提示",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(DeckCode);
        clipBoard(DeckCode);
    }
}
