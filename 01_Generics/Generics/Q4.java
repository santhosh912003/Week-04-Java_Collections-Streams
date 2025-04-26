import java.util.*;

class Q4{
  public static void main(String[] args){
    List<Meal<? extends MealPlan>> plans = new ArrayList<>();
    
    plans.add(MealGenerator.generateMealPlan(new VegetarianMeal("Pannerr wrap")));
        plans.add(MealGenerator.generateMealPlan(new VeganMeal("Quinoa Bowl")));
        plans.add(MealGenerator.generateMealPlan(new KetoMeal("Avocado Omelette")));
        plans.add(MealGenerator.generateMealPlan(new HighProteinMeal("Grilled Chicken")));
        
      System.out.println("------YOUR PERSONALIZED MEAL PLAN-------------");
      for(Meal<? extends MealPlan> p:plans){
        p.showMeal();
        System.out.println("******************************************************");
      }
  }
}

interface MealPlan{
  void prepare();
  String getName();
}


class VegetarianMeal implements MealPlan{
  private String name;
  public VegetarianMeal(String name){
    this.name = name;
  }
  
  public void prepare(){
    System.out.println(name+": Includes dairy, no meat");
  }
  
  public String getName(){
    return name;
  }
}

class VeganMeal implements MealPlan{
  private String name;
  public VeganMeal (String name){
    this.name = name;
  }
  
  public void prepare(){
    System.out.println(name+": 100% plant-based");
  }
  
  public String getName(){
    return name;
  }
}


class KetoMeal implements MealPlan {
    private String name;
    public KetoMeal(String name) { this.name = name; }
    public void prepare() {
        System.out.println(name + ": Low carb, high fat.");
    }
    public String getName() { return name; }
}

class HighProteinMeal implements MealPlan {
    private String name;
    public HighProteinMeal(String name) { this.name = name; }
    public void prepare() {
        System.out.println(name + ": Rich in protein.");
    }
    public String getName() { return name; }
}


class Meal<T extends MealPlan>{
  private T meal;
  
  public Meal(T meal){
    this.meal = meal;
  }
  
  public void showMeal(){
    System.out.println("Meal: +"+ meal.getName());
    meal.prepare();
  }
  
  public T getMealPlan(){
    return meal;
  }
}

class MealGenerator{
  public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan){
    System.out.println("Generating meal: "+ mealPlan.getName());
    return new Meal<>(mealPlan);
  }
}