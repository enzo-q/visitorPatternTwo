public class Table implements Furniture {
    private double weight;

    public Table(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double accept(ShippingCostVisitor visitor) {
        return visitor.visit(this);
    }
}