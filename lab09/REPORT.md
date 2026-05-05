# REPORT.md

## Variant
- тема: Ігровий профіль
- номер: 6

## Model overview
У роботі реалізовано класи:

- Player — описує гравця;
- GameItem — описує ігровий предмет;
- Achievement — описує досягнення;
- ProfileEntry<TEntity, TMeta> — узагальнений клас для зв’язку сутності з метаданими.

## Generic usage
У роботі використано узагальнення (generics):

- створено generic-клас ProfileEntry<TEntity, TMeta>;
- реалізовано generic-метод findBest(List<T>);
- використано обмеження параметра типу T extends Comparable<T>.

Це дозволяє працювати з різними типами даних у єдиному узагальненому коді.

## Demo scenario
У класі Main продемонстровано:
- створення об’єктів Player, GameItem, Achievement;
- використання generic-класу ProfileEntry з різними типами;
- виклик generic-методу findBest для списків різних типів;
- роботу обмежень типів через Comparable.