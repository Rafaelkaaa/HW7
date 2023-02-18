import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus() {
        try {
            Scanner scanner = new Scanner(System.in);
            int userEntered = scanner.nextInt();
            new HttpStatusImageDownloader().downloadStatusImage(userEntered);

        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        }
    }
}
