import java.util.*;

import ms.util.Countries;

import static ms.util.Println.*;

public class E18_MapOrder {
    public static void main(String[] args){
        Map<String,String> m1 = new HashMap<>(Countries.capitals(25));
        print(m1);
        String[] keys = m1.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        Map<String,String> m2 = new LinkedHashMap<>();
        for (String key : keys){
            m2.put(key,m1.get(key));
        }
        print(m2);
    }
}
