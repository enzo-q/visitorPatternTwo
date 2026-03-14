public class Sofa implements Furniture {
    private double volume; // Sofas are bulky, so volume matters more

    public Sofa(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public double accept(ShippingCostVisitor visitor) {
        return visitor.visit(this);
    }
}