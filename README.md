# Lab 07: Interfaces

## Variant
Номер 6: Система планування подорожей

## Contracts
`Reservable`, `Payable`

## What is demonstrated
- інтерфейсно-орієнтоване проєктування;
- реалізація одного та кількох інтерфейсів у класах;
- використання одного класу через два різні інтерфейси;
- обробка об’єктів через типи інтерфейсів (Reservable[], Payable[]);
- базові модульні тести для перевірки контрактів і класів.

## Structure
- contracts: інтерфейси Reservable, Payable;
- model: HotelBooking, TrainTicket, MuseumPass;
- demo: Main (демонстрація роботи);
- test: модульні тести;
- docs: UML-діаграма.

## Tests
Тести знаходяться у `src/test/java` і перевіряють:
- роботу інтерфейсів через різні реалізації;
- коректність роботи класів (HotelBooking).