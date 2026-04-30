package ua.khpi.oop.lab05.demo;

import org.openjdk.jol.info.ClassLayout;
import ua.khpi.oop.lab05.model.ActionCamera;

public class Lab05JolDemo {
    public static void main(String[] args) {
        ActionCamera actionCamera = new ActionCamera(
                "GoPro",
                "HERO 13",
                0.15,
                1720,
                27,
                false,
                true,
                10
        );

        System.out.println(ClassLayout.parseInstance(actionCamera).toPrintable());
    }
}