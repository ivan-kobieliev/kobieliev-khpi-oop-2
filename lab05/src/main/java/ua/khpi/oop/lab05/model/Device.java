package ua.khpi.oop.lab05.model;

public class Device {
    private String manufacturer;
    private String model;

    public Device(String manufacturer, String model) {
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("Виробник не може бути порожнім");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Модель не може бути порожньою");
        }

        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Device[виробник=%s, модель=%s]".formatted(manufacturer, model);
    }
}