import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url ="jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "prishu";
        String query = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded sucessfully");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            //connect database with java file
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Establish successfully");
            //statement for sql queries execute
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("=====================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job_title: "+job_title);
                System.out.println("Salary: "+salary);
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}