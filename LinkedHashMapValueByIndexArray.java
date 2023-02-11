package task;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapValueByIndexArray {

     public static void main(String []args){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        
        map.put("Qatar", 98814);
        map.put("Luxembourg", 78670);
        map.put("Singapore", 64584);
        map.put("Norway", 54947);
        map.put("Brunei", 53431);
        map.put("United States", 53101);
        map.put("Hong Kong", 52722);
        map.put("Switzerland", 46430);
        
        Set<Map.Entry<String, Integer>> mapSet = map.entrySet();
        Map.Entry<String, Integer> elementAt5 = (Map.Entry<String, Integer>) mapSet.toArray()[1];
        
        System.out.println(elementAt5.getKey());
     }
}