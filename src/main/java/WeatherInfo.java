public class WeatherInfo {
    int humidity;
    double temperature;
    double wind_speed;
    String wind_direction;

    // Display direction in a more readable way
    public static String getCompleteDirectionName(String directionName) {
        switch (directionName) {
            case "N":
                return "North";
            case "NNE":
                return "North-Northeast";
            case "NE":
                return "Northeast";
            case "ENE":
                return "East-Northeast";
            case "E":
                return "East";
            case "ESE":
                return "East-Southeast";
            case "SE":
                return "Southeast";
            case "SSE":
                return "South-Southeast";
            case "S":
                return "South";
            case "SSW":
                return "South-Southwest";
            case "SW":
                return "Southwest";
            case "WSW":
                return "West-Southwest";
            case "W":
                return "West";
            case "WNW":
                return "West-Northwest";
            case "NW":
                return "Northwest";
            case "NNW":
                return "North-Northwest";
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Humidity: " + humidity +
                "\nTemperature: " + temperature + "c" +
                "\nWind Speed: " + wind_speed + "kph" +
                "\nWind Direction: " + getCompleteDirectionName(wind_direction);
    }
}