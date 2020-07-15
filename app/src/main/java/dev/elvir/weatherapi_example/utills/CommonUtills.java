package dev.elvir.weatherapi_example.utills;

public class CommonUtills {
    public static String getDurationBreakdown(long millis) {
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d", hour, minute, second);


        return time;
    }
}
