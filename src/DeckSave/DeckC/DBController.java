package DeckSave.DeckC;
import java.sql.*;

public class DBController {
    private String Uri;
    private String User;
    private String PassWord;

    public DBController() {
    }

    public DBController(String uri, String user, String passWord) {
        Uri = uri;
        User = user;
        PassWord = passWord;
    }

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public Connection connectionToDB(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){ }
        try{
            con = DriverManager.getConnection(this.Uri,this.User,this.PassWord);
        }
        catch (SQLException e){}

        return con;
    }
}
