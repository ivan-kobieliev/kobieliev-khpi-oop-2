package ua.khpi.oop.lab05.model;

public final class ActionCamera extends Camera {
    private boolean waterproof;
    private int maxDepth;

    public ActionCamera(String manufacturer, String model,
                        double weight, int batteryCapacity,
                        int megapixels, boolean hasOpticalZoom,
                        boolean waterproof, int maxDepth) {

        super(manufacturer, model, weight, batteryCapacity, megapixels, hasOpticalZoom);

        if (maxDepth < 0) {
            throw new IllegalArgumentException("Глибина не може бути від’ємною");
        }

        this.waterproof = waterproof;
        this.maxDepth = maxDepth;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    @Override
    public String toString() {
        return "ActionCamera[%s, водонепроникна=%s, максГлибина=%d м]"
                .formatted(super.toString(), waterproof, maxDepth);
    }
}