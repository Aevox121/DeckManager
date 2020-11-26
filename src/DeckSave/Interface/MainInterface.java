package DeckSave.Interface;

import javax.swing.*;
import java.awt.*;


public class MainInterface extends JFrame {
    InputInterface input;
    SelectInterface select;
    JTabbedPane p;
    InsertListener listener;
    public MainInterface(){
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void init(){
        setLayout(new BorderLayout());
        setBounds(300,300,495,570);
        setTitle("炉石传说套牌管理器");
        listener = new InsertListener();
        p = new JTabbedPane();
        input = new InputInterface();
        select = new SelectInterface();
        p.add("导入套牌",input);
        p.add("查找套牌",select);
        add(p,BorderLayout.CENTER);


    }
}


