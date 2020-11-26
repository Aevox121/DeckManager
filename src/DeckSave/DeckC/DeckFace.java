package DeckSave.DeckC;

import java.sql.Connection;
import java.sql.SQLException;

public class DeckFace {
    static Connection con;
    public static void connection(){
        DBController dbc = new DBController("jdbc:mysql://localhost:3306/DeckManager?useSSL=true","root","S1828275470");
        con = dbc.connectionToDB();
    }
    public static void input(String DeckCode) throws SQLException {
        connection();
        Deck deck;
        deck = DeckAnalysis.fromString(DeckCode);

        DeckController.insertDeck(con,deck);
    }
    public static Deck[] select(String mess) throws SQLException{
        connection();
        return DeckController.selectDeck(con,mess);
    }
}
