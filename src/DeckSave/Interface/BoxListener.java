package DeckSave.Interface;

import DeckSave.DeckC.Deck;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BoxListener implements ItemListener {
    Deck[] decks;
    JComboBox box;
    JTextArea area;
    CopyListener copyListener;
    DeleteListener deleteListener;

    public void setDeleteListener(DeleteListener deleteListener) {
        this.deleteListener = deleteListener;
    }

    public void setCopyListener(CopyListener copyListener) {
        this.copyListener = copyListener;
    }

    public void setArea(JTextArea area) {
        this.area = area;
    }

    public void setBox(JComboBox box) {
        this.box = box;
    }

    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }



    @Override
    public void itemStateChanged(ItemEvent e) {
        int index = box.getSelectedIndex() - 1 ;
        System.out.println("index:"+index);
        area.setText(decks[index].getDeckCode());
        System.out.println(decks[index].getDeckCode());
        copyListener.setDeckCode(decks[index].getDeckCode());
        deleteListener.setDeckCodeSlim(decks[index].getDeckCodeSlim());
        deleteListener.setDeckName(decks[index].getDeckName());
    }
}
