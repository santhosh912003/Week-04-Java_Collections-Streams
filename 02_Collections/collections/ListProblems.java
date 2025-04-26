import java.util.*;

class ListProblems{
  
  public static <T> List<T> reverseList(List<T> arr){
    List<T> brr = new ArrayList<>();
    
    for(int i=0;i<arr.size();i++){
      brr.add(arr.get(arr.size()-1-i));
    }
    return brr;
  }
  
  public static Map<String, Integer> frequencyOfElements(List<String> l){
    Map<String, Integer> freq = new HashMap<>();
    for(String s: l){
      freq.put(s,freq.getOrDefault(s,0));
    }
    
    return freq;
  }
  
  public static <T> List<T> rotateList(List<T> l, int k){
    int n = l.size();
    List<T> arr = new ArrayList<>();
    for(int i=k;i<n+k;i++){
      arr.add(l.get(i%n));
    }
    
    return arr;
  }
  
  public static <T> List<T> removeDuplicates(List<T> l){
    Set<T> set = new HashSet<>();
    List<T> arr = new ArrayList<>();
    for(T num : l){
      if(!set.contains(num)){
        set.add(num);
        arr.add(num);
      }
    }
    
    return arr;
  }
  
  public static <T> T nthFromEnd(LinkedList<T> l, int n){
    Iterator<T> ahead = l.iterator();
    Iterator<T> behind = l.iterator();
    
    for(int i=0;i<n;i++) {
      ahead.next();
    }
    
    while(ahead.hasNext()){
      ahead.next();
      behind.next();
    }
    
    return behind.next();
  }
  
  public  static void main(String[] args){
    System.out.println("Reverse: "+reverseList(Arrays.asList(1,2,3,4,5)));
    System.out.println("Frequency: "+ frequencyOfElements(Arrays.asList("apple","banana","orange")));
    System.out.println("Rotate: "+ rotateList(Arrays.asList(10,20,30,40,50),2));
    System.out.println("Remove Duplicates: "+ removeDuplicates(Arrays.asList(3,1,2,4,6,5)));
    LinkedList<String> ll = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
    System.out.println("Nth from end: "+nthFromEnd(ll,2));
    
  }
  
}