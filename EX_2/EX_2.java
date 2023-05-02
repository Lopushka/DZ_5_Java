package EX_2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class EX_2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, String> map2 = new HashMap<>();
        int DV;
        String DK;
        map2.put("Иванов", "Иван");
        map2.put("Петрова", "Светлана");
        map2.put("Белова", "Кристина");
        map2.put("Мусина", "Анна");
        map2.put("Крутова", "Анна");
        map2.put("Юрин", "Иван");
        map2.put("Лыков", "Петр");
        map2.put("Чернов", "Павел");
        map2.put("Чернышов", "Петр");
        map2.put("Федорова", "Мария");
        map2.put("Светлова", "Марина");
        map2.put("Савина", "Мария");
        map2.put("Рыкова", "Мария");
        map2.put("Лугова", "Марина");
        map2.put("Владимирова", "Анна");
        map2.put("Мечников", "Иван");
        map2.put("Петин", "Петр");
        map2.put("Ежов", "Иван");
        for (String name : map2.values()) {
            if (!map1.containsKey(name)) {
                if (Collections.frequency(map2.values(), name) > 1) {
                    map1.put(name, Collections.frequency(map2.values(), name));
                }
            }
        }
        ArrayList<Integer> sortV = new ArrayList<Integer>(map1.values());
        ArrayList<String> sortK = new ArrayList<String>(map1.keySet());
        for (int i = 0; i < sortV.size(); i++) {
            for (int j = 1; j < sortV.size(); j++) {
                if (sortV.get(j) > sortV.get(j-1)) {
                    DV = sortV.get(j-1);
                    sortV.set((j-1),sortV.get(j));
                    sortV.set((j),DV);
                    DK = sortK.get(j-1);
                    sortK.set((j-1),sortK.get(j));
                    sortK.set((j),DK);
                }
            }
        }
        for (int i = 0; i < sortV.size(); i++) {
            System.out.println(sortK.get(i) + " кол-во повторов = "+ sortV.get(i));
        }
        
    }
}
