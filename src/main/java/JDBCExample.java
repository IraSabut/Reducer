import java.sql.*;

public class JDBCExample {

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("jdbc:postgresql://127.0.0.1:5432/reducer");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/reducer","postgres", "postgres");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
       private static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL =
                "CREATE TABLE USERS ("
                        + "ID_USER SERIAL, "
                        + "USERNAME  VARCHAR(20) NOT NULL, "
                        + "PASSWORD  VARCHAR(20) NOT NULL, "
                        +"ROLE_ID INT,"
                        + "PRIMARY KEY (ID_USER) "
                        + ")";
           try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        try {
       /*    Connection dbConnection = null;
            Statement statement = null;
            String selectTableSQL = "SELECT ID_USER, USERNAME, PASSWORD,ALERT_ID, ROLE_ID from USERS";

            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");
                String password= rs.getString("PASSWORD");
                String role= rs.getString("ROLE_ID");

                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
                System.out.println("password: " + password);
                System.out.println("role: " + role);
            }

*/
           createDbUserTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
