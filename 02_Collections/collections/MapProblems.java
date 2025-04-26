import java.util.*;

class MapProblems{
  
  public static Map<String, Integer> wordFrequency(String text){
    Map<String, Integer> freq = new HashMap<>();
    text  = text.toLowerCase();
    String[] words = text.split("\\W+");
    for(String w : words){
      freq.put(w,freq.getOrDefault(w,0)+1);
    }    
    return freq;
  }
  
  public static <K,V>  Map<V, List<K>> invertMap(Map<K,V> map){
    Map<V, List<K>> inverted = new HashMap<>();
    for(Map.Entry<K,V> entry : map.entrySet()){
      V value = entry.getValue();
      K key = entry.getKey();
      inverted.computeIfAbsent(value, K -> new ArrayList<>()).add(key);
    }
    return inverted;
  }
  
  public static String keyWithMaxValue(Map<String, Integer> map){
    return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
  
  public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2){
    Map<String, Integer > merged = new HashMap<>(map1);
    for(Map.Entry<String, Integer> entry : map2.entrySet()){
      merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(),0)+ entry.getValue());
    }
    
    return merged;
    
  }
  
  static class Employee{
    String name;
    String department;
    
    Employee(String name, String department){
      this.name  = name;
      this.department = department;
    }
    
    @Override
    public String toString(){
      return name;
    }
  }
  
  public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees){
    
    Map<String , List<Employee>> grouped = new HashMap<>();
    for(Employee e: employees){
      grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
    }
    
    return grouped;
  }
  
    public static void main(String[] args) {
  
        String input = "Hello world, hello Java!";
        System.out.println("Word Frequency: " + wordFrequency(input));

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        System.out.println("Inverted Map: " + invertMap(map));

        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("A", 10);
        scoreMap.put("B", 20);
        scoreMap.put("C", 15);
        System.out.println("Max Value Key: " + keyWithMaxValue(scoreMap));

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        System.out.println("Merged Maps: " + mergeMaps(map1, map2));

 
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        System.out.println("Grouped by Department: " + groupByDepartment(employees));
    } 
}