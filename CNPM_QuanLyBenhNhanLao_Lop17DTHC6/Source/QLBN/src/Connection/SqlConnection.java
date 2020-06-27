package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SqlConnection {

    Connection conn;

    public Connection getSQLServerConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLBN;user=TienNguyen;password=331212";
            try {
                conn = DriverManager.getConnection(dbURL);
            } catch (SQLException ex) {
                Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public ResultSet TruyVan(String sqlCommand) {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlCommand);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thuc thi truy van khong thanh cong:\n" + sqlCommand);
        }
        return rs;
    }

}
