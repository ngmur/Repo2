package utilities.db;

import org.junit.Assert;
import utilities.ConfigReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//JDBC - java database connectivity
//1.Create connection
//2.Create statement
//3.Execute queries
//4.Close connection - it is important to close a connection
// to a DB to avoid resource leak.
//JDBC workflow:
//1. Create a connection with DriverManager.getConnection();
//You need to provide JDBC link
// JDBC link consist of:
// - driver type(mysql,oracle etc..);
//- Database server (host:port)
//-database name (optional)
//-credentials (properties as key -value pairs)
//2. Create statement with connection.createStatement();
//3.Execute query by statement.executeQuery(); -> that returns a result set.
//4.Process ResultSet
//5. close the connection.close();

public class DBUtils {
    private static Connection connection;
    private static Statement statement;
    private static final String JDBC_URL = ConfigReader.getProperty("jdbc_url");

    public static void open() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(JDBC_URL);
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Can't establish connection to DB");
        }
    }

    public static void close() {
        try {
            if (statement != null) statement.close();
            if (statement != null) connection.close();
            connection = null;
            statement = null;
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Can't close connection to DB");
        }////it is a good practice to close ResultSet,statement,connection.
        //However, if connection is closed statement and ResultSet associated with
        //this connection are automatically closed.
    }
//Resource leak

   // public static void main(String[] args) {
  //      DBUtils.open();
  //      ResultSet rs = DBUtils.query("SELECT * FROM account;");
     //  List<String> columns = DBUtils.getColumnNames(rs);
      // List<Map<String,Object>> table = DBUtils.convertResultSet(rs);
    //   table.forEach(System.out::println);
      // columns.forEach(System.out::println);
       // double expectedPaymentAmount = 0.0;
       // for(Map<String,Object> map : table){
        //    if(map.get("account_number").toString().equals("486130005")){
         //       double actualPaymentAmount = (double) map.get("payment_amount");
           //     Assert.assertEquals(expectedPaymentAmount,actualPaymentAmount);
           // }
       // }
    //    }


    //Get Column names by using Result Set metadata
    public static List<String> getColumnNames(ResultSet rs) {
        List<String> columnNames = new ArrayList<>();
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail(e.getLocalizedMessage());
        }
        return  columnNames;
    }
    public static ResultSet query(String query){
      //  if(connection ==null)
            open();
        try{
            return statement.executeQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
            Assert.fail("Not able to execute a query");
        }
        return null;
    }
    //Key - column name, value - data in that column
    public static List<Map<String,Object>> convertResultSet(ResultSet rs) {
        List<Map<String, Object>> table = new ArrayList<>();
        List<String> columnNames = getColumnNames(rs);
        //Populate table from result set
        //Iterate through each Row
        while (true) {
            //Map is created for each row
            Map<String, Object> row = new HashMap<>();
            try {
                if (!rs.next()) break;
                //Iterate through each column in order to populate the map
                for (String columnName : columnNames) {
                    row.put(columnName, rs.getObject(columnName));
                }
            } catch (SQLException e) {

        }
    }
        return table;
    }

    public static void main(String[] args) {
        ResultSet rs = DBUtils.query("SELECT id FROM account WHERE name = '300';");
        List<Map<String,Object>> table = DBUtils.convertResultSet(rs);
        String s = String.valueOf(table.get(0).get("id"));
        System.out.println(s);
        table.forEach(System.out::println);
    }

    }


