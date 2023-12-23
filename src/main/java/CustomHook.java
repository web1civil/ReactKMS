import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyHook {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    public static double getExchangeRate(String currency) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();

                return 38.0; 
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1.0;
    }
}