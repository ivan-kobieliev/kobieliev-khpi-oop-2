package ua.khpi.oop.lab16;

public class Main {

    public static void main(String[] args) {

        TemperatureConverter javaConverter =
                new TemperatureConverter();

        double result =
                javaConverter.celsiusToFahrenheit(25);

        System.out.println("25 Celsius = "
                + result + " Fahrenheit");
    }

}