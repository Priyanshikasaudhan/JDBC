import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updation {
    public static void main(String[] args) {
        //first 3 line connect with jdbc
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "prishu";
        String query =  "update employee set job_title = 'Blog' , salary = 120000000\n"+
        "where id = 3;";
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
                System.out.println("Update successfully " + rowsaffected + " row(s) affected");
            }else {
                System.out.println("Update failed");
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
