#include "../native-headers/ua_khpi_oop_lab16_NativeTemperatureConverter.h"

JNIEXPORT jdouble JNICALL
Java_ua_khpi_oop_lab16_NativeTemperatureConverter_celsiusToFahrenheit(
        JNIEnv* env,
        jobject obj,
        jdouble celsius) {

    return (celsius * 9.0 / 5.0) + 32.0;
}