public class ShippingCostCalculator implements ShippingCostVisitor {
    private double deliveryDistanceKm;

    public ShippingCostCalculator(double deliveryDistanceKm) {
        this.deliveryDistanceKm = deliveryDistanceKm;
    }

    @Override
    public double visit(Chair chair) {
        // Chairs have a simple flat rate
        System.out.println("Calculating flat-rate shipping for a Chair.");
        return 15.00; 
    }

    @Override
    public double visit(Table table) {
        // Tables are based on a base rate + weight
        System.out.println("Calculating weight-based shipping for a Table.");
        return 20.00 + (table.getWeight() * 0.50);
    }

    @Override
    public double visit(Sofa sofa) {
        // Sofas are bulky and require distance-based calculation + volume factor
        System.out.println("Calculating distance and volume-based shipping for a bulky Sofa.");
        return 50.00 + (this.deliveryDistanceKm * 1.25) + (sofa.getVolume() * 5.00);
    }
}