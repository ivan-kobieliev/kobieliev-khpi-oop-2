package ua.khpi.oop.lab16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TemperatureConverterTest {

    private final TemperatureConverter javaConverter =
            new TemperatureConverter();

    private final NativeTemperatureConverter nativeConverter =
            new NativeTemperatureConverter();

    @Test
    void javaImplementationConvertsCelsiusToFahrenheit() {
        assertEquals(77.0,
                javaConverter.celsiusToFahrenheit(25.0), 0.0001);
    }

    @Test
    void nativeImplementationConvertsCelsiusToFahrenheit() {
        assertEquals(77.0,
                nativeConverter.celsiusToFahrenheit(25.0), 0.0001);
    }

    @Test
    void javaAndNativeResultsAreEqual() {
        double[] values = {
                -40.0,
                0.0,
                25.0,
                36.6,
                100.0
        };

        for (double value : values) {
            assertEquals(
                    javaConverter.celsiusToFahrenheit(value),
                    nativeConverter.celsiusToFahrenheit(value),
                    0.0001
            );
        }
    }

    @Test
    void boundaryValueMinusFortyIsEqual() {
        assertEquals(-40.0,
                javaConverter.celsiusToFahrenheit(-40.0), 0.0001);

        assertEquals(-40.0,
                nativeConverter.celsiusToFahrenheit(-40.0), 0.0001);
    }
}