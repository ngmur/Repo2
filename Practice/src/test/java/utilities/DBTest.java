package utilities;

import dbModels.UserProfile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import utilities.db.DBUtils2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
@AfterClass
public static void tearDown(){
    DBUtils2.close();
}

    //Get User profiles FROM DB and map to beans using custom constructor
    @Test
    public void getUserProfiles() throws SQLException {
    DBUtils2.open("digitalbank");
        ResultSet rs = DBUtils2.queryToRs("SELECT * FROM digitalbank.user_profile;");
        while (rs.next()){
            System.out.println(new UserProfile(rs));
        }
    }
    @Test
    public void truncate(){
    DBUtils2.truncateTable("Test.my_table");
    }

    @Test
    public void update(){
    String email = "newjaneemal@gmail.com";
    int id = 1;
    String query = "SELECT email FROM Test.my_table WHERE id = ?";
    String updateStatement = "UPDATE Test.my_table SET email = ? WHERE + ?;";
    //UPDATE RECORD
        DBUtils2.executeStatement(updateStatement,email,id);
        //VALIDATE RECORD WAS UPDATED
        Assert.assertEquals(
                DBUtils2.query(query,id).ToListOfMaps().get(0).get("email"),email
        );


    }

@Test
    public void delete(){
    DBUtils2.deleteRecord("Test.my_table","id","1");
}
@Test
    public void insertWithQuery(){
    DBUtils2.executeStatement(
            "INSERT INTO Test.my_table VALUE (null,'Jack','Doe',null)");

}
@Test
    public void paramInsert(){
    DBUtils2.executeStatement("INSERT INTO Test.my_table VALUE (?,?,?,?)",
            null,"james","bond","james@gmial.com");


}
@Test
    public void insertProfile(){
    UserProfile userProfile = new UserProfile();
    userProfile.setId(999);
    userProfile.setDob("1964-05-18 02-13-23");
    userProfile.setEmail_address("email@gmail.com");
    userProfile.setSsn("123-45-5645");
    userProfile.insert();
}
}
