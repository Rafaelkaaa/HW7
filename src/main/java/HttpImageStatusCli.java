import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus() {
        Scanner scanner = new Scanner(System.in);
        int userEntered = scanner.nextInt();
        try {
            new HttpStatusImageDownloader().downloadStatusImage(userEntered);
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
            scanner.close();
        }
    }
}
