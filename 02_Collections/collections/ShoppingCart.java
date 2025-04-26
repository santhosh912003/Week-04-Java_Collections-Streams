import java.util.*;

class ShoppingCart {

    Map<String, Double> priceMap = new HashMap<>();
    Map<String, Double> cartOrder = new LinkedHashMap<>();
    TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    public void addProduct(String name, double price) {
        priceMap.put(name, price);
        cartOrder.put(name, price);
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(name);
    }

    public void showCartOrder() {
        System.out.println("\nCart Order:");
        for (String item : cartOrder.keySet()) {
            System.out.println(item + " - $" + cartOrder.get(item));
        }
    }

    public void showSortedByPrice() {
        System.out.println("\nItems Sorted by Price:");
        for (double price : sortedByPrice.keySet()) {
            for (String item : sortedByPrice.get(price)) {
                System.out.println(item + " - $" + price);
            }
        }
    }

    public void showPriceMap() {
        System.out.println("\nPrice Map:");
        for (String item : priceMap.keySet()) {
            System.out.println(item + " - $" + priceMap.get(item));
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Apple", 1.99);
        cart.addProduct("Banana", 0.99);
        cart.addProduct("Milk", 2.49);
        cart.addProduct("Bread", 1.99);

        cart.showCartOrder();
        cart.showPriceMap();
        cart.showSortedByPrice();
    }
}
