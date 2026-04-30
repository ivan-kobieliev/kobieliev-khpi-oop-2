package ua.khpi.oop.lab05.model;

public class Camera extends PortableDevice {
    private int megapixels;
    private boolean hasOpticalZoom;

    public Camera(String manufacturer, String model,
                  double weight, int batteryCapacity,
                  int megapixels, boolean hasOpticalZoom) {

        super(manufacturer, model, weight, batteryCapacity);

        if (megapixels <= 0) {
            throw new IllegalArgumentException("Кількість мегапікселів має бути більше 0");
        }

        this.megapixels = megapixels;
        this.hasOpticalZoom = hasOpticalZoom;
    }

    public int getMegapixels() {
        return megapixels;
    }

    public boolean hasOpticalZoom() {
        return hasOpticalZoom;
    }

    @Override
    public String toString() {
        return "Camera[%s, МП=%d, оптичнийЗум=%s]"
                .formatted(super.toString(), megapixels, hasOpticalZoom);
    }
}