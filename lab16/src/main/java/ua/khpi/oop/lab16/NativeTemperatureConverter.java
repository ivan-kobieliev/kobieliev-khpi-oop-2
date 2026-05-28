package ua.khpi.oop.lab16;

public class NativeTemperatureConverter {

    static {
        System.loadLibrary("temperatureconverter");
    }

    public native double celsiusToFahrenheit(double celsius);

}