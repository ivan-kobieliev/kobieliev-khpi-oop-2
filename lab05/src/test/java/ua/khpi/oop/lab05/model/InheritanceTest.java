package ua.khpi.oop.lab05.model;

public class InheritanceTest {
    public static void main(String[] args) {
        ActionCamera camera = new ActionCamera(
                "TestBrand",
                "TestModel",
                0.2,
                1500,
                12,
                true,
                true,
                5
        );

        System.out.println(camera);
    }
}