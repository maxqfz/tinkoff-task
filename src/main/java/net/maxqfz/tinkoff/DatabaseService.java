package net.maxqfz.tinkoff;

import net.maxqfz.tinkoff.model.ApplicationModel;

import java.sql.*;

public class DatabaseService {
    static private Statement statement;

    static public void init() throws SQLException {
        statement = DriverManager.getConnection("jdbc:h2:~/testDb", "", "").createStatement();

        TinkoffApplication.log("Creating tables for demo data...");

        //Deleting table if exists and creating a new one
        statement.execute("DROP TABLE Applications IF EXISTS");
        statement.execute("CREATE TABLE Applications(CONTACT_ID bigint, APPLICATION_ID bigint, " +
                "DT_CREATED DATE, PRODUCT_NAME VARCHAR(255))");

        //Adding data to database
        TinkoffApplication.log("Inserting demo data...");
        statement.execute("INSERT INTO Applications(CONTACT_ID, APPLICATION_ID, " +
                "DT_CREATED, PRODUCT_NAME) VALUES (1, 1, '2017-05-04', 'WrongProduct')");
        statement.execute("INSERT INTO Applications(CONTACT_ID, APPLICATION_ID, " +
                "DT_CREATED, PRODUCT_NAME) VALUES (1, 2, '2017-05-09', 'RightProduct')");
        statement.execute("INSERT INTO Applications(CONTACT_ID, APPLICATION_ID, " +
                "DT_CREATED, PRODUCT_NAME) VALUES (1, 3, '2017-05-03', 'WrongProduct')");
        statement.execute("INSERT INTO Applications(CONTACT_ID, APPLICATION_ID, " +
                "DT_CREATED, PRODUCT_NAME) VALUES (2, 1, '2017-01-01', 'RightProduct')");
        statement.execute("INSERT INTO Applications(CONTACT_ID, APPLICATION_ID, " +
                "DT_CREATED, PRODUCT_NAME) VALUES (3, 1, '2017-04-14', 'WrongProduct')");
        statement.execute("INSERT INTO Applications(CONTACT_ID, APPLICATION_ID, " +
                "DT_CREATED, PRODUCT_NAME) VALUES (3, 2, '2017-05-04', 'RightProduct')");
    }

    static public ApplicationModel getLastApplicationByContact_Id(long contact_Id) throws SQLException
    {
        TinkoffApplication.log("Querying for application record where CONTACT_ID = " + contact_Id);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Applications WHERE CONTACT_ID = "
                + contact_Id + " ORDER BY DT_CREATED DESC");
        resultSet.next();
        return new ApplicationModel(resultSet.getLong("CONTACT_ID"), resultSet.getLong("APPLICATION_ID"),
                resultSet.getDate("DT_CREATED").toLocalDate(), resultSet.getString("PRODUCT_NAME"));
    }
}
