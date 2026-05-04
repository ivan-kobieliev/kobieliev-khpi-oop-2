# REPORT

## Variant
- тема: Система планування подорожей
- номер: 6

## Interface justification
- Reservable: інтерфейс описує можливість резервування об’єкта (наприклад, готелю або квитка). Це окрема роль, яка не залежить від конкретного класу і може застосовуватись до різних об’єктів.
- Payable: інтерфейс описує можливість виконання оплати. Дана поведінка також є незалежною та може реалізовуватись різними класами предметної області.

## Contracts and implementations
- first interface: Reservable
- implementing classes: HotelBooking, TrainTicket
- second interface: Payable
- implementing classes: HotelBooking, TrainTicket, MuseumPass

## Multiple interface implementation
- class implementing more than one interface: HotelBooking, TrainTicket
- why this is meaningful: ці класи одночасно реалізують дві незалежні ролі — резервування та оплату, що відповідає реальній логіці системи планування подорожей (спочатку виконується резервування, потім оплата).

## Client code
- where interface types are used:
  у класі Main створені масиви типів Reservable[] та Payable[], через які відбувається обробка різних об’єктів через інтерфейси.
  також один об’єкт HotelBooking використовується через два інтерфейсні посилання: Reservable та Payable.

## Additional task
- short conclusion about a possible interface-based redesign:
  у попередніх моделях, побудованих на основі успадкування, частину функціональності можна було б винести в інтерфейси. Це дозволяє зробити модель більш гнучкою та уникнути жорсткої ієрархії класів, оскільки об’єкти реалізують лише потрібні їм можливості.

## Final conclusion
- what the model demonstrates about interface-based design:
  дана модель демонструє, що використання інтерфейсів дозволяє описати незалежні можливості об’єктів без створення спільного суперкласу. Це підвищує гнучкість системи та спрощує роботу з різними типами об’єктів через єдині контракти.