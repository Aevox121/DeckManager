package DeckSave.Interface;

import DeckSave.DeckC.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SelectListener implements ActionListener {
    JTextField textField;//输入文本框，用于输入关键词
    JTextArea showArea;//显示结果区
    JPanel panel;//接入外部容器
    BoxListener boxListener;//复制监听器
    JComboBox<String> copyBox;//下拉列表，显示搜索出的所有结果
    JButton cleanButton;//迫于无奈的选择，加了一个刷新下拉列表的按钮
    CleanListener cleanListener;//刷新下拉列表的监听器
    Boolean isBox;
    JButton copyButton;//复制按钮
    CopyListener copyListener;//复制监听器
    JButton deleteButton;
    DeleteListener deleteListener;



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

        Deck[] decks = null;//初始化套牌数组
        showArea.setText("");//清空显示区
        isBox = false;
        String str = textField.getText();//获取输入的数据

        //文本区自动换行
        showArea.setLineWrap(true);

        //套牌名数组，给下拉列表提供数据
        String[] deckName;

        //定义清空按钮区的按钮
        cleanButton = new JButton("刷新");


        //把搜索关键词发送给套牌管理类，获取返回的所有套牌，存在数组里
        try {
            decks = DeckFace.select(str);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //初始化套牌名字数组，长度和套牌数组一致
        deckName = new String[decks.length];

        copyBox = new JComboBox<>();
        copyBox.addItem("下拉查看所有结果-->");
        //初始化套牌名字数组的每一个元素并赋值
        for(int i = 0;i < decks.length;i++){

            deckName[i] = new String();
            deckName[i] = decks[i].getDeckName();
            copyBox.addItem(deckName[i]);
        }

        //给下拉列表填入新的元素
        /*
        DefaultComboBoxModel model = new DefaultComboBoxModel(deckName);
        copyBox = new JComboBox<>(model);
        copyBox.setModel(new DefaultComboBoxModel(deckName));
         */

        isBox = true;
        //设定下拉列表的属性
        copyBox.setBounds(300,80,160,20);
        panel.add(copyBox);
        //注册监听器，设定监听器的属性
        boxListener = new BoxListener();
        copyBox.addItemListener(boxListener);
        boxListener.setBox(copyBox);
        boxListener.setArea(showArea);
        boxListener.setDecks(decks);

        //设置复制按钮
        copyButton = new JButton("复制");
        copyButton.setBounds(300,46,160,20);
        copyListener = new CopyListener();
        boxListener.setCopyListener(copyListener);
        copyButton.addActionListener(copyListener);
        panel.add(copyButton);

        //设置删除按钮
        deleteButton = new JButton("删除");
        deleteButton.setBounds(390,10,70,20);
        deleteButton.setBackground(Color.RED);
        deleteListener = new DeleteListener();
        boxListener.setDeleteListener(deleteListener);
        deleteButton.addActionListener(deleteListener);
        panel.add(deleteButton);

        //清空按钮区的监听器注册
        cleanListener = new CleanListener();
        cleanButton.setBounds(300,10,70,20);
        cleanListener.setPanel(panel);
        cleanListener.setBox(copyBox);
        cleanListener.setCleanButton(cleanButton);
        cleanListener.setCopyButton(copyButton);
        cleanListener.setDeleteButton(deleteButton);
        panel.add(cleanButton);
        cleanButton.addActionListener(cleanListener);



        //刷新容器
        panel.updateUI();


    }



}
