# REPORT.md

## Variant
- тема: Перетворення температур
- номер: 6

## Project overview
У роботі реалізовано Java-проєкт із використанням JNI (Java Native Interface) та CI (Continuous Integration).

Проєкт демонструє:

- взаємодію Java та native C++ коду;
- створення JNI wrapper-класу;
- генерацію JNI header-файлів;
- збірку native-бібліотеки;
- автоматизоване тестування;
- CI pipeline через GitHub Actions.

## Implemented classes
У роботі реалізовано класи:

- TemperatureConverter — Java-реалізація перетворення температур;
- NativeTemperatureConverter — JNI wrapper для native C++ реалізації;
- Main — демонстраційний клас запуску;
- TemperatureConverterTest — модульні тести Java та native реалізацій.

## JNI usage
У роботі використано JNI для виклику native C++ коду з Java.

Реалізовано:

- оголошення native-методу;
- завантаження native-бібліотеки через `System.loadLibrary()`;
- генерацію JNI header-файлу через `javac -h`;
- реалізацію native-функції у C++;
- компіляцію shared library через `clang++`;
- взаємодію Java та C++ через JNI API.

## Native implementation
У native C++ реалізації використано:

- `JNIEXPORT`
- `JNICALL`
- `jdouble`
- JNI header-файл
- shared library (`.dll` / `.so`)

Native-функція реалізує:

- перетворення Celsius у Fahrenheit;
- повернення результату назад у Java-код.

## Testing
У роботі використано `JUnit 5`.

Реалізовано:

- тестування Java-реалізації;
- тестування native-реалізації;
- перевірку однаковості результатів Java та JNI;
- тестування граничних значень;
- автоматичний запуск тестів через Maven.

## CI usage
У роботі використано GitHub Actions для автоматизованої збірки та тестування.

CI pipeline виконує:

- отримання репозиторію;
- встановлення JDK;
- генерацію JNI header-файлів;
- збірку native C++ бібліотеки;
- запуск модульних тестів;
- перевірку працездатності проєкту після push/pull request.

## Demo scenario
У класі Main продемонстровано:

- створення Java-конвертера температур;
- виклик native C++ реалізації через JNI;
- перетворення Celsius у Fahrenheit;
- виведення результату в консоль.

У тестах продемонстровано:

- перевірку Java-реалізації;
- перевірку JNI-реалізації;
- порівняння результатів;
- тестування граничних значень.