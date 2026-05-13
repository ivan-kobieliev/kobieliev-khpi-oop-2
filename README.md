# Lab 10: Collections Framework

## Variant
Номер 6: Інтернет-магазин

This project demonstrates the implementation of a custom generic container and iterator in Java.

## Project Structure

- `src/main/java/ua/khpi/oop/lab10/model/` - Domain model classes
    - `Product.java` - Product entity
    - `CartItem.java` - Shopping cart item entity
    - `Order.java` - Order entity
    - `StoreContainer.java` - Generic container with custom iterator
- `src/main/java/ua/khpi/oop/lab10/demo/` - Demonstration classes
    - `Main.java` - Main class demonstrating container usage
- `src/test/java/` - Unit tests

## Key Features Demonstrated

1. **Generic Container**: `StoreContainer<T>` - stores objects of different types
2. **Custom Iterator**: internal iterator implementation for sequential access
3. **Iterable Support**: support for `for-each` iteration
4. **Dynamic Array Growth**: automatic resizing of the internal array
5. **Type Safety**: generic programming prevents unsafe casts

## Running the Project

```bash
# Compile and run
mvn clean compile exec:java -Dexec.mainClass="ua.khpi.oop.lab10.demo.Main"

# Run tests
mvn test
```

## Example Output

```
Cart size: 3
Cart capacity: 10

Access by index:
CartItem{product=Product{name='Laptop', price=35000.0}, quantity=1}
CartItem{product=Product{name='Mouse', price=700.0}, quantity=2}

Iteration with iterator:
- CartItem{product=Product{name='Laptop', price=35000.0}, quantity=1}
- CartItem{product=Product{name='Mouse', price=700.0}, quantity=2}
- CartItem{product=Product{name='Keyboard', price=1500.0}, quantity=1}

Iteration with for-each:
- CartItem{product=Product{name='Laptop', price=35000.0}, quantity=1}
- CartItem{product=Product{name='Mouse', price=700.0}, quantity=2}
- CartItem{product=Product{name='Keyboard', price=1500.0}, quantity=1}

Removing item at index 1:
Removed: CartItem{product=Product{name='Mouse', price=700.0}, quantity=2}

Cart after removal:
- CartItem{product=Product{name='Laptop', price=35000.0}, quantity=1}
- CartItem{product=Product{name='Keyboard', price=1500.0}, quantity=1}

Generic container with String:
- First message
- Second message
```