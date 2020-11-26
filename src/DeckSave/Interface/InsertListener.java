package DeckSave.Interface;

import DeckSave.DeckC.DeckFace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class InsertListener implements ActionListener {
    String str;
    JTextField textInput;
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            DeckFace.insert(str);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void setJTextField(JTextField text) {
        textInput = text;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
