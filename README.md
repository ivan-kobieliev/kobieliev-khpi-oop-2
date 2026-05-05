# Lab 09: Generics

## Variant
Номер 6: Ігровий профіль

This project demonstrates the use of generics in Java through a game profile model.

## Project Structure

- `src/main/java/ua/khpi/oop/lab09/model/` - Domain model classes
    - `Player.java` - Player entity
    - `GameItem.java` - Game item entity
    - `Achievement.java` - Achievement entity
    - `ProfileEntry.java` - Generic profile entry class
- `src/main/java/ua/khpi/oop/lab09/demo/` - Demonstration classes
    - `Main.java` - Main class with generic method example
- `src/test/java/` - Unit tests

## Key Features Demonstrated

1. **Generic Class**: `ProfileEntry<TEntity, TMeta>` - associates game entities with metadata
2. **Generic Method**: `findBest(List<T>)` with type bounds (`T extends Comparable<T>`)
3. **Type Safety**: compile-time type checking prevents unsafe casts
4. **Code Reusability**: generic components work with different types

## Running the Project

```bash
# Compile and run
mvn clean compile exec:java -Dexec.mainClass="ua.khpi.oop.lab09.demo.Main"

# Run tests
mvn test
```

## Example Output

```
Player entry: ProfileEntry{entity=Player{name='Shadow', level=25}, metadata=Active profile}
Item entry: ProfileEntry{entity=GameItem{name='Dragon Sword', power=80}, metadata=80}
Achievement entry: ProfileEntry{entity=Achievement{title='First Victory', completed=true}, metadata=true}
Best score: 3100
Best rank: Silver
```