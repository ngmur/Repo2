package utilities;

import org.apache.commons.dbutils.BeanProcessor;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetHandler {
    private ResultSet resultSet;
    private  BeanProcessor beanProcessor;

    public ResultSetHandler(ResultSet resultSet){
        this.resultSet = resultSet;
        this.beanProcessor = new BeanProcessor();

    }
    //T - Declares generic data type
    //In a way it postpones the Data type declaration
    public  <T> List<T> ToBeans( Class<T> beanClass){
        try{
            return beanProcessor.toBeanList(resultSet,beanClass);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public  List<Map<String, Object>> ToListOfMaps() {
        List<Map<String, Object>> table = new ArrayList<>();
        List<String> columnNames = getColumnNames();
        //Populate table from result set
        //Iterate through each Row
        while (true) {
            //Map is created for each row
            Map<String, Object> row = new HashMap<>();
            try {
                if (!resultSet.next()) break;
                //Iterate through each column in order to populate the map
                for (String columnName : columnNames) {
                    row.put(columnName, resultSet.getObject(columnName));
                }
            } catch (SQLException e) {

            }
        }
        return table;
    }
    private List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail(e.getLocalizedMessage());
        }
        return columnNames;
    }
}
