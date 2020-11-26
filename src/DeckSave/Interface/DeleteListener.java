package DeckSave.Interface;

import DeckSave.DeckC.DeckController;
import DeckSave.DeckC.DeckFace;

import javax.sql.rowset.serial.SerialException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteListener implements ActionListener {
    String DeckCodeSlim;
    String DeckName;

    public void setDeckName(String deckName) {
        DeckName = deckName;
    }

    public void setDeckCodeSlim(String deckCodeSlim) {
        DeckCodeSlim = deckCodeSlim;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = JOptionPane.showConfirmDialog(null,"确认删除："+DeckName+"?","删除",JOptionPane.YES_NO_CANCEL_OPTION);
        if(n == JOptionPane.YES_OPTION){
            try{
                DeckFace.delete(DeckCodeSlim);
            }catch(SQLException ee){
                System.out.println(ee);
            }
        }else{

        }
    }
}
