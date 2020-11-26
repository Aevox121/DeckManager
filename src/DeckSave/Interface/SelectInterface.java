package DeckSave.Interface;

import javax.swing.*;
import java.awt.*;

public class SelectInterface extends JPanel {
    JTextField selectField;//输入框
    JButton selectButton;//查找
    JTextArea showArea;
    SelectListener listener;

    SelectInterface(){
        setLayout(null);
        selectField = new JTextField();
        selectButton = new JButton("查找");
        showArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(showArea);
        selectField.setBounds(0,10,200,20);
        selectButton.setBounds(210,10,70,20);
        scrollPane.setBounds(0,40,280,460);
        listener = new SelectListener();
        listener.setJTextField(selectField);
        listener.setJTextArea(showArea);
        listener.setPanel(this);
        add(selectField);
        add(selectButton);
        add(scrollPane);
        selectField.addActionListener(listener);
        selectButton.addActionListener(listener);
    }
}
