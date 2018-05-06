package com.rust.rustweather;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {

    // TODO: Declare the member variables here
    private double mTemperature;
    private String mCity;
    private String mIconName;
    private int mCondition;

    // TODO: Create a WeatherDataModel from a JSON:
    public static WeatherDataModel fromJSON(JSONObject JsonObject){
        try {
            WeatherDataModel weatherData = new WeatherDataModel();
            weatherData.mCity = JsonObject.getString("name");
            weatherData.mCondition = JsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherData.mIconName = updateWeatherIcon(weatherData.mCondition);

            double tempResult = JsonObject.getJSONObject("main").getDouble("temp") - 273.15;
//            int roundedValue = (int) (Math.rint(tempResult));
//            weatherData.mTemperature = Integer.toString(roundedValue);
        //    weatherData.mTemperature =  tempResult;
            weatherData.mTemperature = Math.round( tempResult * 100.0 ) / 100.0;
            return weatherData;
        }
        catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
//  TODO: Create icon switching conditions:
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    // TODO: Create getter methods for temperature, city, and icon name:


    public String getTemprature() {
        return (mTemperature +"°C");
    }

    public String getCity() {
        return mCity;
    }

    public String getIconName() {
        return mIconName;
    }
}
