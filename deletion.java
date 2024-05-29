import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deletion {
    public static void main(String[] args) {
        //first 3 line connect with jdbc
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "prishu";
        String query = "delete from employee where id = 4;";
        try {
            //load drive file.
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded sucessfully");
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
                System.out.println("Deletion successfull " + rowsaffected + " row(s) affected");
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
