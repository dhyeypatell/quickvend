import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ItemTypes {
  private static final Map<String, Integer> MAX_STOCK = createMaxStock();
  private static final List<String> TYPE_LIST = new ArrayList<>(MAX_STOCK.keySet());

  private static Map<String, Integer> createMaxStock() {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("Candy", 25);
    map.put("Chips", 15);
    map.put("Chocolate Bars", 25);
    map.put("Drinks", 15);
    map.put("Gum", 25);
    map.put("Healthy Snacks", 20);
    map.put("Mints", 25);
    return map;
  }

  public static String getTypeByIndex(int index) {
    return TYPE_LIST.get(index);
  }

  public static int getMaxStockByType(String type) {
    return MAX_STOCK.get(type);
  }

  public static boolean doesTypeExist(int index) {
    return index >= 0 && index < TYPE_LIST.size();
  }

  public static void displayTypes() {
    for (int i = 0; i < TYPE_LIST.size(); i++) {
      String type = getTypeByIndex(i);
      System.out.println(i + " - " + type + " (Max: " + MAX_STOCK.get(type) + ")");
    }
  }
}
