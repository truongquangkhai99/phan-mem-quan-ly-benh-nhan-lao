package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SqlConnection {
    Connection conn;
    
     public  Connection getSQLServerConnection(){    
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
//     //xử lý login
//      public List<User> dsUser(String username, String password){
//        List<User> rs = null;
//         try {
//            conn = this.getSQLServerConnection();
//            System.out.println("ket noi data thanh cong");
//             
//            rs = new ArrayList();
//            Statement statement = conn.createStatement();
//            String sql = "SELECT * FROM USER_LOGIN WHERE name  like '" + username + "' and pass like '" + password + "'";
//            //PreparedStatement statement = conn.prepareStatement(sql);
//            //statement.setString(1, username);
//            //statement.setString(2, password);
//            ResultSet resultSet = statement.executeQuery(sql);
//            
//            while(resultSet.next()){
//                User user = new User();
//                user.setUsername(resultSet.getString("name"));
//                user.setPassword(resultSet.getString("pass"));
//                
//                rs.add(user);             
//            }     
//         } catch (ClassNotFoundException ex) {
//             Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
//         } catch (SQLException ex) {
//             Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
//         }
//        return rs;
//    }
}
