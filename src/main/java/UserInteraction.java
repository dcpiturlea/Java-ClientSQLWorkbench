import java.sql.*;
import java.util.Scanner;

public class UserInteraction {

    public static UserCredential getCredentialFromUser() {
        UserCredential userCredential = new UserCredential();
        Scanner scanner = new Scanner(System.in);

        userCredential.ip = "104.248.84.92";
        System.out.println("Introduceti numarul portului:");
        userCredential.port = scanner.nextLine();
        System.out.println("Introduceti numele bazei de date:");
        userCredential.database = scanner.nextLine();
        System.out.println("Introduceti userul: ");
        userCredential.user = scanner.nextLine();
        System.out.println("Introduceti parola: ");
        userCredential.password = scanner.nextLine();

        return userCredential;
    }

    public static String getQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti un query: ");
        System.out.println("Daca introduceti STOP programul se va opri:  ");
        String queryIntrodus = scanner.nextLine();
        if(queryIntrodus.toUpperCase().contains("STOP")){
            System.exit(0);
        }
        return queryIntrodus;
    }

    public static void showResult(ResultSet rs) throws Exception {

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            System.out.printf("%20s", columnName);
        }
        System.out.println("");
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%20s", rs.getObject(i));

            }
            System.out.println("");
        }

    }
}
