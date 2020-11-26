package DeckSave.DeckC;

import javax.swing.*;
import java.sql.*;

public class DeckController {

    public static void insertDeck(Connection con, Deck deck) throws SQLException {
        Statement sql;
        String sqlStr = "insert into deck (DeckName,Profession,IsStandard,DeckCode,DeckCodeSlim) values" +
                "(\""+deck.getDeckName()+"\",\""+deck.getProfession()+"\",\""+deck.getStandard()+"\",\""+deck.getDeckCode()+"\",\""+deck.getDeckCodeSlim()+"\")";
        try{

            System.out.println("开始导入");
            sql = con.createStatement();
            int ok = sql.executeUpdate(sqlStr);
            con.close();
            JOptionPane.showMessageDialog(null,"导入成功","提示",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (SQLException e) {

            System.out.print("导入失败！！！");
            if (e.getMessage().contains("DeckNameRe")) {
                JOptionPane.showMessageDialog(null,"导入失败：卡组名已存在","提示",JOptionPane.WARNING_MESSAGE);
            }
            if (e.getMessage().contains("DeckCodeRe")) {
                JOptionPane.showMessageDialog(null,"导入失败：卡组重复","提示",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static Deck[] selectDeck(Connection con, String mess){
        PreparedStatement sql;
        ResultSet rs;
        ResultSet rs_num;
        int count = 0;
        int i = 0;

        String select_deckmess_sql = "select * from deck where DeckName like ? or Profession like ? or IsStandard like ?";
        String select_decknum_sql = "select count(*) from deck where DeckName like ? or Profession like ? or IsStandard like ?";
        try{
            System.out.println("开始查找");
            sql = con.prepareStatement(select_decknum_sql);
            sql.setString(1,"%"+mess+"%");
            sql.setString(2,"%"+mess+"%");
            sql.setString(3,"%"+mess+"%");
            rs_num = sql.executeQuery();
            rs_num.next();
            count = rs_num.getInt("count(*)");
            System.out.println(count);

        }catch(SQLException e){
            System.out.println(e);
        }
        try {
            sql = con.prepareStatement(select_deckmess_sql);
            sql.setString(1,"%"+mess+"%");
            sql.setString(2,"%"+mess+"%");
            sql.setString(3,"%"+mess+"%");
            rs = sql.executeQuery();
            Deck[] decks = new Deck[count];
            while(rs.next()){
                String DeckName = rs.getString("DeckName");
                String Profession = rs.getString("Profession");
                String IsStandard = rs.getString("IsStandard");
                String DeckCode = rs.getString("DeckCode");
                String DeckCodeSlim = DeckAnalysis.slim(DeckCode);

                decks[i] = new Deck(DeckName, Profession, IsStandard, DeckCode, DeckCodeSlim);
                System.out.println(i);
                i++;

                /*
                System.out.printf("%s",DeckName);
                System.out.printf("%s",Profession);
                System.out.printf("%s\n",IsStandard);
                System.out.printf("%s",DeckCode);
                System.out.println("-----------------------------------------------------------------------------");
            */
            }


            con.close();
            return decks;
        }
        catch(SQLException e){
            System.out.println("查找失败：" + e);
        }

        return null;
    }
}
