package DeckSave.Interface;

import DeckSave.DeckC.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SelectListener implements ActionListener {
    JTextField textField;
    JTextArea showArea;
    JButton[] buttons;
    JPanel panel;
    CopyListener copyListener;
    int lastButtons = 0;

    public void setJTextField(JTextField text) {
        textField = text;
    }


    public void setJTextArea(JTextArea area) {
        showArea = area;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0;i < lastButtons;i++){
            panel.remove(buttons[i]);
        }
        showArea.setText("");
        Deck[] decks = null;
        String str = textField.getText();
        int x = 300;
        int y = 50;
        int width = 150;
        int height = 20;
        showArea.setLineWrap(true);
        try {
            decks = DeckFace.select(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        lastButtons = decks.length;
        buttons = new JButton[decks.length];
        for(int i = 0;i < decks.length;i++){
            showArea.append(decks[i].getDeckName());
            showArea.append(decks[i].getProfession());
            showArea.append(decks[i].getStandard()+"\n");
            showArea.append(decks[i].getDeckCode());
            showArea.append("--------------------------------------------------------------------------------------\n");
        }
        for(int i = 0;i < buttons.length;i++){
            buttons[i] = new JButton(decks[i].getDeckName());
            buttons[i].setBounds(x,y+i*40,width,height);
            copyListener = new CopyListener();
            copyListener.setDeckCode(decks[i].getDeckCode());
            buttons[i].addActionListener(copyListener);
            panel.add(buttons[i]);
            panel.repaint();
        }


    }


}
