import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import javax.jws.soap.SOAPBinding;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserCredential uc = UserInteraction.getCredentialFromUser();
        Connection c = null;
        boolean repeat = true;
        try {
            c = DriverManager.getConnection("jdbc:mysql://" + uc.ip + ":" + uc.port + "/" + uc.database, uc.user, uc.password);

        } catch (SQLException e1) {
            System.out.println("EROARE!!!");
            System.out.println(e1.getMessage());
            System.out.println(e1);
        }
        while (repeat) {
            String query = UserInteraction.getQuery();
            if (query.contains("select")) {

                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery(query);
                    UserInteraction.showResult(rs);
                } catch (
                        Exception e2) {
                    System.out.println("Eroare!");
                    System.out.println("Ai introdus un query gresit!");
                    System.out.println(e2);

                }
            } else {
                Statement statement = c.createStatement();
                statement.execute(query);
                System.out.println("Done!");
            }
        }
    }
}
