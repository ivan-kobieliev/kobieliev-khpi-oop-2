# Лабораторна робота №16

### Варіант №6
Перетворення температур

---

## Опис роботи

У роботі реалізовано Java-застосунок із використанням JNI (Java Native Interface) та автоматизованого CI-процесу.

Програма:
- реалізує перетворення температури з Celsius у Fahrenheit;
- містить Java-реалізацію обчислення;
- містить native C++ реалізацію через JNI;
- використовує `System.loadLibrary()` для підключення native-бібліотеки;
- генерує JNI header-файл через `javac -h`;
- компілює native C++ бібліотеку через `clang++`;
- використовує `JUnit 5` для модульного тестування;
- перевіряє однаковість результатів Java та native реалізацій;
- тестує граничні значення температур;
- використовує GitHub Actions для автоматизованої збірки та тестування;
- автоматично збирає native-бібліотеку та запускає тести у CI середовищі.

---

## Створені класи

### Java implementation
- TemperatureConverter

### JNI implementation
- NativeTemperatureConverter

### Demo
- Main

### Test
- TemperatureConverterTest

---

## Native files

### C++ implementation
- temperature_converter.cpp

### JNI headers
- ua_khpi_oop_lab16_NativeTemperatureConverter.h

### CI configuration
- ci.yml

---

## Приклад роботи програми

```text
25 Celsius = 77.0 Fahrenheit
```

---

## Приклад виконання тестів

```text
4 tests passed

javaImplementationConvertsCelsiusToFahrenheit()
nativeImplementationConvertsCelsiusToFahrenheit()
javaAndNativeResultsAreEqual()
boundaryValueMinusFortyIsEqual()
```

---

## Структура проєкту

```text
lab16
├── .github
│   └── workflows
│       └── ci.yml
├── native
│   └── temperature_converter.cpp
├── native-headers
│   └── ua_khpi_oop_lab16_NativeTemperatureConverter.h
├── src
│   ├── main
│   │   └── java
│   │       └── ua/khpi/oop/lab16
│   │           ├── Main.java
│   │           ├── NativeTemperatureConverter.java
│   │           └── TemperatureConverter.java
│   └── test
│       └── java
│           └── ua/khpi/oop/lab16
│               └── TemperatureConverterTest.java
├── pom.xml
├── REPORT.md
└── README.md
```
