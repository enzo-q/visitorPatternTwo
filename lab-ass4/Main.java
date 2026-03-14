import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Create our shopping cart of furniture elements
        List<Furniture> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Chair(5.0));
        shoppingCart.add(new Table(30.0));
        shoppingCart.add(new Sofa(2.5)); // 2.5 cubic meters

        // 2. Create our visitor (Customer lives 40km away)
        ShippingCostVisitor standardShipping = new ShippingCostCalculator(40.0);

        // 3. Calculate total shipping cost
        double totalShippingCost = 0.0;
        
        System.out.println("--- Processing Shopping Cart Shipping ---");
        for (Furniture item : shoppingCart) {
            // Double Dispatch happening here:
            // 1. We call accept() on the specific Furniture item at runtime.
            // 2. Inside accept(), the item calls the specific visit() method on the Visitor.
            totalShippingCost += item.accept(standardShipping);
        }

        System.out.println("---------------------------------------");
        System.out.printf("Total Shipping Cost: $%.2f%n", totalShippingCost);
    }
}