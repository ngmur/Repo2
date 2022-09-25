package dbModels;

import lombok.Data;
import utilities.db.DBUtils;
import utilities.db.DBUtils2;

import java.sql.ResultSet;
import java.util.List;

/*SELECT T1.description AS transactionDescription, T1.amount AS transactionAmount,
T1.running_balance AS runningBalance, T1.transaction_date AS transactionDate,
T2.category AS transactionCategory, T2.name AS transactionName, T3.name AS transactionState
FROM account_transaction T1
JOIN transaction_type T2
ON T1.transaction_type_id = T2.id
JOIN transaction_state T3
ON T1.transaction_state_id = T3.id*/
@Data
public class Transaction {
    private String transactionDescription;
    private double transactionAmount;
    private double runningBalance;
    private String transactionDate;
    private String transactionCategory;
    private String transactionName;
    private String transactionState;
private static final String BASE_QUERY = "SELECT T1.description AS transactionDescription, " +
        "T1.amount AS transactionAmount,\n" +
        "T1.running_balance AS runningBalance, " +
        "T1.transaction_date AS transactionDate,\n" +
        "T2.category AS transactionCategory, T2.name AS transactionName, " +
        "T3.name AS transactionState\n" +
        "FROM account_transaction T1\n" +
        "JOIN transaction_type T2\n" +
        "ON T1.transaction_type_id = T2.id\n" +
        "JOIN transaction_state T3\n" +
        "ON T1.transaction_state_id = T3.id" +
        "WHERE T1.id = ?;";
    public static Transaction getById(int id) {
        String query = BASE_QUERY + "WHERE T1.id = ?;";
        List<Transaction> transactionList = DBUtils2.query(query,id).ToBeans( Transaction.class);
        if (transactionList.isEmpty()) return null;
        return transactionList.get(0);

    }

    public static List<Transaction> getByCategory(String category){
        String query = BASE_QUERY + "WHERE T1.id = ?;";
        return DBUtils2.query(query,category).ToBeans(Transaction.class);




    /*public static void main(String[] args){
        System.out.println(Transaction.getById(83));*/
    }
        /*Serialization
        Deserialization - is a process of conversion an any other data type into Java project*/
}

        /*Mapping
        We are mapping our result set to Java objects*/

/*Beans are not created specifically for database tables.
Beans are created for API response and it's easier to build the
right DB query in order to retrieve the same data. After Deserialization API
response to BEAN we can map our result set to the same type
of bean and do Object comparison.
Object.equals(01,02);
Assert.assertEquals(01,02);
In order to map our result set to Java beans names of the
columns and names of the variables should match
*/