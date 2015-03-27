package com.example.android.sunshine.app;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    private static final String LIST_TAG = "list";

    private static final String TEMP_TAG = "temp";
    private static final String MAX_TAG = "max";
    private static final String MIN_TAG = "min";

    private static final String WEATHER_TAG = "weather";
    private static final String MAIN_TAG = "main";

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */

    public static double getMaxTemperatureForDay(String s, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        JSONObject joTemp = new JSONObject(s)
                .getJSONArray(LIST_TAG)
                .getJSONObject(dayIndex)
                .getJSONObject(TEMP_TAG);

        return joTemp.getDouble(MAX_TAG);
    }

    public static double getMinTemperatureForDay(String s, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        JSONObject joTemp = new JSONObject(s)
                .getJSONArray(LIST_TAG)
                .getJSONObject(dayIndex)
                .getJSONObject(TEMP_TAG);

        return joTemp.getDouble(MIN_TAG);
    }

    public static String getMainForDay(String s, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        JSONObject joTemp = new JSONObject(s)
                .getJSONArray(LIST_TAG)
                .getJSONObject(dayIndex)
                .getJSONArray(WEATHER_TAG)
                .getJSONObject(0);

        return joTemp.getString(MAIN_TAG);
    }

}
