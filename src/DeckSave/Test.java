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


        deck = DeckAnalysis.fromFile("D://炉石套牌.txt");
//        deck = DeckAnalysis.fromString(DeckCode);

        DBController dbc = new DBController("jdbc:mysql://localhost:3306/DeckManager?useSSL=true","root","S1828275470");

        Connection con = dbc.connectionToDB();




        //导入套牌
 //       DeckController.insertDeck(con,deck);
        //导出套牌
       DeckController.selectDeck(con,"恶魔猎手");
    }

}
