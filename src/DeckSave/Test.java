package DeckSave;

import DeckSave.DeckC.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException {
        Deck deck;

 //       Scanner sc = new Scanner(System.in);

 //       String DeckCode = sc.next();


        deck = DeckAnalysis.fromFile("D://¯ʯ����.txt");
//        deck = DeckAnalysis.fromString(DeckCode);

        DBController dbc = new DBController("jdbc:mysql://localhost:3306/DeckManager?useSSL=true","root","S1828275470");

        Connection con = dbc.connectionToDB();




        //��������
 //       DeckController.insertDeck(con,deck);
        //��������
       DeckController.selectDeck(con,"��ħ����");
    }

}
