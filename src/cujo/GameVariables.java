/*
 * The big parent class! GameVariables
 * is to keep track of stats like
 * time and weather conditions.
 */

package cujo;

public abstract class GameVariables {
    private int day;
    private int hour;
    
    private String weather;
    private int weatherNumber;
    
    private String weatherMod;
    private int weatherModNumber;

    // Start at day 1 with everything at default settings
    public GameVariables() {
        this.day = 1;
        this.hour = 0;
        
        this.weatherNumber = 0;
        this.weatherModNumber = 0;
    }
    

    public int getDay() {
        return day;
    }


    public void setDay(int day) {
        this.day = day;
    }


    public int getHour() {
        return hour;
    }


    public void setHour(int hour) {
        this.hour = hour;
    }

    // May need to be tweaked for something better....
    // If we are on day 1, just use warm weather
    // but when we pass to the next day, change the weather.
    public String getWeather() {
        if (getDay() != 1) 
        {
            weatherNumber = (int) Math.random() * 3;
            if (weatherNumber == 0) {
                weather = "Warm";
            }
            else if (weatherNumber == 1)
            {
                weather = "Cool";
            }
            else if(weatherNumber == 2)
            {
                weather = "Hot";
            }
            else if(weatherNumber == 3)
            {
                weather = "Very Hot";
            }
        }
        else
        {
            weatherNumber = 0;
            weather = "Warm";
        }

        return weather;
    }

    
    public void setWeather(String weather) {
        this.weather = weather;
    }

    // Same as Weather...
    // May need to be tweaked for something better....
    // If we are on day 1, just use Clear Sky
    // but when we pass to the next day, change the weather.
    public String getWeatherMod() {
                if (getDay() != 1) 
        {
            weatherModNumber = (int) Math.random() * 3;
            if (weatherModNumber == 0) {
                weatherMod = "Clear Sky";
            }
            else if (weatherModNumber == 1)
            {
                weatherMod = "Rain";
            }
            else if(weatherModNumber == 2)
            {
                weatherMod = "Windy";
            }
            else if(weatherModNumber == 3)
            {
                weatherMod = "Storming";
            }
        }
        else
        {
            weatherModNumber = 0;
            weatherMod = "Clear Sky";
        }
        return weatherMod;
    }

    public void setWeatherMod(String weatherMod) {
        this.weatherMod = weatherMod;
    }
}
