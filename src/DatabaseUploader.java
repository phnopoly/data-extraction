import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DatabaseUploader {
    private final String STATEMENT = "SELECT * FROM macros";

    private Connection conn;
    private Statement stmt;

    public DatabaseUploader() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdatabase", "root", null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeCommand(int p1, double p2, String p3, String p4, String p5, String p6) throws SQLException {
        //here sonoo is database name, root is username and password

        // the mysql insert statement
        // *Query has changed due to change in data
        String query = " insert into macros (id, score, grade, askQuestions, textingInClass, lateInClass)"
                + " values (?, ?, ?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, p1);
        preparedStmt.setDouble(2, p2);
        preparedStmt.setString(3, p3);
        preparedStmt.setString(4, p4);
        preparedStmt.setString(5, p5);
        preparedStmt.setString(6, p6);
        preparedStmt.execute();

        //---------------------------------------------------------------------
        /*
        ResultSet rs = conn.createStatement().executeQuery(STATEMENT);
        while (rs.next())
            System.out.println(rs.getInt(1)
                    + "  " + rs.getDouble(2)
                    + "  " + rs.getString(3)
                    + "  " + rs.getString(4)
                    + "  " + rs.getString(5)
                    + "  " + rs.getString(6));
        */
        //---------------------------------------------------------------------
    }

    public String getSTATEMENT() {
        return STATEMENT;
    }

    public Connection getConn() { return conn; }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}

