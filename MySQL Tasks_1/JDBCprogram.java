// MySQL task 2nd One

import java.sql.*;
public class JDBCprogram {
public static void main(String[] args) throws SQLException {
 
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employeedb?user=rootuser&password=rootuser@123$");
        String query1 = "create table employee (" +
                "empcode int not null unique,\n" +
                "empname varchar(255),\n" +
                "empage varchar(255),\n" +
                "esalary long)";
        PreparedStatement ps1 = connection.prepareStatement(query1);
        ps1.execute();

        String query2 = "insert into employee (empcode, empname, empage, esalary) values " +
                "(101, 'Jenny', 25, 10000)," +
                "(102, 'Jacky', 30, 20000), " +
                "(103, 'Joe', 20, 40000), " +
                "(104, 'John', 40, 80000), " +
                "(105, 'Shameer', 25, 90000);";

        PreparedStatement ps2 = connection.prepareStatement(query2);
        ps2.execute();
        String query3 = "select * from employee;";
        PreparedStatement ps3= connection.prepareStatement(query3);
        ps3.execute();
        ResultSet resultSet = ps3.executeQuery();

        System.out.println(resultSet.getMetaData().getColumnName(1) + " " + resultSet.getMetaData().getColumnName(2)
                + " " + resultSet.getMetaData().getColumnName(3) + " " + resultSet.getMetaData().getColumnName(4) );

        while(resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " \t" + resultSet.getString(2)
                    + " \t" + resultSet.getString(3) + " \t" + resultSet.getString(4) );
        }
    }
}


// Output

//    empcode  empname  empage   esalary
//    101 	Jenny 	25 	10000
//    102 	Jacky 	30 	20000
//    103 	Joe 	20 	40000
//    104 	John 	40 	80000
//    105 	Shameer 25 	90000