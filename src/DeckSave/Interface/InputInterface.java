package DeckSave.Interface;

import java.awt.*;
import javax.swing.*;
public class InputInterface extends JPanel{
    JTextArea inputArea;
    JButton insertButton;
    JButton pasteButton;
    JScrollPane scrollPane;
    InsertListener insertListener;
    InputListener inputListener;
    PasteListener pasteListener;
    InputInterface(){
        setLayout(null);
        inputArea = new JTextArea();
        insertButton = new JButton("导入套牌");
        pasteButton = new JButton("粘贴代码");
        scrollPane = new JScrollPane(inputArea);
        scrollPane.setBounds(0,0,350,570);
        pasteButton.setBounds(360,195,100,30);
        insertButton.setBounds(360,245,100,30);
        inputArea.setLineWrap(true);
        add(scrollPane);
        add(pasteButton);
        add(insertButton);
        inputListener = new InputListener();
        insertListener = new InsertListener();
        pasteListener = new PasteListener();
        inputListener.setInputArea(inputArea);
        inputListener.setPasteListener(insertListener);
        pasteListener.setInputArea(inputArea);
        (inputArea.getDocument()).addDocumentListener(inputListener);
        insertButton.addActionListener(insertListener);
        pasteButton.addActionListener(pasteListener);
        setVisible(true);

    }

}
