package io.ryszardp.migrations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class FromCsvToSql {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/board_games?verifyServerCertificate=false&allowPublicKeyRetrieval=true&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        String csvFilePath = "src/main/resources/nastolki.csv";
        int batchSize = 20;
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO nastolki_by (title, price, age, gamers_countity, link) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String title = data[0];
                String price = data[1];
                String age = data[2];
                String gamers_countity = data[3];
                String link = data[4];

                statement.setString(1, title);
                statement.setString(2, price);
                statement.setString(3, age);
                statement.setString(4, gamers_countity);
                statement.setString(5, link);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            lineReader.close();

            // execute the remaining queries
            statement.executeBatch();

            connection.commit();
            connection.close();

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
