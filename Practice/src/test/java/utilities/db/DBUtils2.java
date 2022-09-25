package utilities.db;

import dbModels.UserProfile;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.ResultSetHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils2 {
    private static Connection connection;
    private static Statement statement;
    private static QueryRunner queryRunner = new QueryRunner();
    private static final String JDBC_URL = ConfigReader.getProperty("jdbc_url");
    public static void open() {
        open("");
    }

    public static void open(String database) {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(JDBC_URL.replace("{DB}",database));
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
        }
    }

    public static boolean executeStatement(String sqlStatement,Object...params){
        if (connection == null) open();
        try {
            if(params.length ==0) return statement.execute(sqlStatement);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            for (int i=0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }
            return preparedStatement.execute();

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean truncateTable(String tableName){
    String sqlStatement = "TRUNCATE Table" + tableName;
    return executeStatement(sqlStatement);
    }
public static boolean deleteRecord(String table,String column,String value){
        String statement = String.format("DELETE FROM %s WHERE %s = '%s'",table,
                column,value);
        return executeStatement(statement);
}
public static ResultSetHandler query(String query,Object... params){
        return new ResultSetHandler(queryToRs(query,params));
}
                                                        //VarArgs
    public static ResultSet queryToRs(String query, Object... params) {
         if(connection ==null) open();
        try {
            if(params.length==0) statement.executeQuery(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //replace "?" with params
            for(int i = 0;i<params.length;i++){
                preparedStatement.setObject(i+1,params[i]);
            }

            return  preparedStatement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Not able to execute a query");
        }
        return null;
    }


    /*public static void main(String[] args) {
       String query = "SELECT *\n" +
               "FROM user_profile\n" +
               "WHERE country = ?"+
             //  "OR country = ?"+
             //  "OR country=?";
                "AND dob <=?";
       ResultSet rs = DBUtils2.query(query,"US","2002-01-01 00:00:00");
      // DBUtils2.convertResultSet(rs).forEach(System.out::println);
       DBUtils2.convertResultSetToBeans(rs, UserProfile.class).forEach(System.out::println);
    }*/

   // public static void main(String[] args) {
        /*UserProfile fromDB = UserProfile.getById(5);
        UserProfile fromAPI = new UserProfile();
        Assert.assertEquals(fromDB,fromAPI);
        System.out.println(UserProfile.getById(7));*/


        /*String q = "UPDATE employees SET lastName = 'Lomko' WHERE employeeNumber = 1002;";
        DBUtils2.executeStatement(q);*/

    }




//POJO(Plain old java object)
//(Bean) is a model class that is used for converting other data structures
//in Java class for more convenient way to work with them
