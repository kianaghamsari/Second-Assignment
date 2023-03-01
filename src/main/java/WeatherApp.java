import org.json.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    // Copy your API-KEY here
    public final static String apiKey = "d8d54b5d3b3b4aa1858224623232702";

    public static void main(String[] args) {
        // Getting city name
        String city = JOptionPane.showInputDialog(null, "Enter the city name");
        WeatherInfo weatherInfo = getWeatherData(city);
        // Displaying WeatherInfo
        JOptionPane.showMessageDialog(null, weatherInfo);
    }

    /**
     * Retrieves weather data for the specified city.
     *
     * @param city the name of the city for which weather data should be retrieved
     * @return a string representation of the weather data, or null if an error occurred
     */
    public static WeatherInfo getWeatherData(String city) {
        try {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();

            // Creating WeatherInfo object from the response.
            WeatherInfo weatherInfo = new WeatherInfo();

            JSONObject object = new JSONObject(stringBuilder.toString());
            JSONObject current = object.getJSONObject("current");

            weatherInfo.humidity = current.getInt("humidity");
            weatherInfo.temperature = current.getDouble("temp_c");
            weatherInfo.wind_speed = current.getDouble("wind_kph");
            weatherInfo.wind_direction = current.getString("wind_dir");

            return weatherInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
