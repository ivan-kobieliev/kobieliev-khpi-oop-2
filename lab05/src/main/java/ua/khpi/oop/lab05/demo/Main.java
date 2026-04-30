package ua.khpi.oop.lab05.demo;

import ua.khpi.oop.lab05.model.ActionCamera;
import ua.khpi.oop.lab05.model.Camera;
import ua.khpi.oop.lab05.model.Device;
import ua.khpi.oop.lab05.model.PortableDevice;
import ua.khpi.oop.lab05.model.Tablet;

public class Main {
    public static void main(String[] args) {
        Device device = new Device("Apple", "iPhone");
        PortableDevice portableDevice = new PortableDevice("Nintendo", "Switch", 0.8, 5000);
        Camera camera = new Camera("Sony", "A7", 0.5, 3000, 24, true);
        ActionCamera actionCamera = new ActionCamera("GoPro", "HERO 13", 0.15, 1720, 27, false, true, 10);
        Tablet tablet = new Tablet("Apple", "iPad", 0.48, 7600, 10.9, true);

        System.out.println(device);
        System.out.println(portableDevice);
        System.out.println(camera);
        System.out.println(actionCamera);
        System.out.println(tablet);
    }
}