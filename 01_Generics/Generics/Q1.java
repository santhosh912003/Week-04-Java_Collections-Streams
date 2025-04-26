import java.util.*;

class Q1{
  public static void main(String[] args){
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Displaying Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nDisplaying Groceries:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nDisplaying Furniture:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
  }
}

class Storage<T extends WarehouseItem>{
  private List<T> items;
  
  
  public Storage(){
    items = new ArrayList<>();
  }
  
  public void addItem(T item){
    items.add(item);
  }
  
  public List<T> getItems(){
    return items;
  }
}


class WarehouseUtils{
  public static void displayItems(List<? extends WarehouseItem> items){
    for(WarehouseItem item :  items) {
      System.out.println(item.getCategory() + ": "+ item.getName());
    }
  }
}


abstract class WarehouseItem{
  private String name;
  
  public WarehouseItem(String name){
    this.name = name;
  }
  
  public String getName(){
    return name;
  }
  
  public abstract String getCategory();
}




class Electronics extends WarehouseItem{
  public Electronics(String name){
    super(name);
  }
  
  @Override
  public String getCategory(){
    return "Electronics";
  }
}

class Groceries extends WarehouseItem{
  public Groceries(String name){
    super(name);
  }
  
  @Override
  public String getCategory(){
    return "Groceries";
  }
}

class Furniture extends WarehouseItem{
  public Furniture(String name){
    super(name);
  }
  
  @Override
  public String getCategory(){
    return "Furniture";
  }
}