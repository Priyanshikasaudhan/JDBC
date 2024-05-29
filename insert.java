import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
    public static void main(String[] args) throws SQLException {
        //first 3 line connect with jdbc
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "prishu";
        String query = "INSERT INTO employee(id,name,job_title,salary) values (4,'Sanskrati','Software',10000);";
        try {
            //load drive file.
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            //connect database with java file
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Establish successfully");
            Statement stmt = con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);
            if (rowsaffected >0 ){
                System.out.println("Insertion successfully " + rowsaffected + " row(s) affected");
            }else {
                System.out.println("Insertion failed");
            }
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully!!!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

