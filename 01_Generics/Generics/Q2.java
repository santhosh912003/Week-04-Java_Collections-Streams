import java.util.*;


public class Q2 {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 500, new BookCategory("Education"));
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 299, new ClothingCategory("Men"));
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000, new GadgetCategory("Electronics"));

        ProductUtils.applyDiscount(book, 10);
        ProductUtils.applyDiscount(shirt, 20);
        ProductUtils.applyDiscount(phone, 5);

        Catalog catalog = new Catalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        catalog.showCatalog();
    }
}
class Catalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void showCatalog() {
        for (Product<? extends Category> p : products) {
            System.out.println(p.getName() + " | " +
                p.getCategory().getCategoryName() + " | $" + p.getPrice());
        }
    }
}





class Product<T extends Category>{
  private String name;
  private double price; 
  private T category;
  
  public Product(String name, double price, T category){
    this.name = name;
    this.price = price;
    this.category = category;
  }
  
  public void applyDiscount(double percent){
    price = price -  (price * percent / 100);
  }
  
  public String getName() {
    return name;
  }
  public double getPrice(){ 
    return price;
  }
  public T getCategory(){
    return category;
  } 
  
}


class ProductUtils{
  public static <T extends Product<?>> void applyDiscount(T product, double percent){
    product.applyDiscount(percent);
  }
}





interface Category{
  String getCategoryName();
}

class BookCategory implements Category{
  private String genre;
  
  public BookCategory(String genre){
    this.genre = genre;
  }
  
  public String getCategoryName(){
    return "Book - "+ genre;
  }
}

class ClothingCategory implements Category{
  private String genre;
  
  public ClothingCategory(String genre){
    this.genre = genre;
  }
  
  public String getCategoryName(){
    return "Clothing - "+ genre;
  }
}

class GadgetCategory implements Category{
  private String genre;
  
  public GadgetCategory(String genre){
    this.genre = genre;
  }
  
  public String getCategoryName(){
    return "Gadget - "+ genre;
  }
}

