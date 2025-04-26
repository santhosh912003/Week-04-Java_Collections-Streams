import java.util.*;

class SetProblems{
  
  public static <T> boolean areSetsEqual(Set<T> s1,Set<T> s2){
    return s1.equals(s2);
  }
  
  
  public static <T> Set<T> union(Set<T> a, Set<T> b){
    Set<T> result = new HashSet<>(a);
    result.addAll(b);
    return result;
  }
  
  public static <T> Set<T> intersection(Set<T> a, Set<T> b){
    Set<T> result = new HashSet<>(a);
    result.retainAll(b);
    return result;
  }
  
  
  public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b){
    Set<T> result = new HashSet<>(a);
    result.addAll(b);
    
    Set<T> common = new HashSet<>(a);
    common.retainAll(b);
    result.removeAll(common);
    
    return result;
  }
  
  
  public static List<Integer> convertSetToSortedList(Set<Integer> set){
    List<Integer> l = new ArrayList<>(set);
    Collections.sort(l);
    return l;
  }
  
  public static <T> boolean isSubset(Set<T> subset, Set<T> superset){
    return superset.containsAll(subset);
  }
  
  
  public static void main(String[] args){
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(3, 4, 5));
        Set<Integer> set4 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set5 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set6 = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        System.out.println("Sets Equal: " + areSetsEqual(set1, set2));
        System.out.println("Union: " + union(set1, set3));
        System.out.println("Intersection: " + intersection(set1, set3));
        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set3));
        System.out.println("Sorted List from Set: " + convertSetToSortedList(set6));
        System.out.println("Is Subset: " + isSubset(set4, set5));
  }
}