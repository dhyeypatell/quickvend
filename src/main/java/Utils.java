public class Utils {
  public static boolean isCodeValid(String code) {
    code = code.trim();
    return code.length() == 2 && code.matches("[A-Z0-9]+");
  }

  public static boolean isNameValid(String name) {
    name = name.trim();
    return name.length() <= 50 && name.matches("[a-zA-Z0-9 ]+");
  }

  public static boolean isPriceValid(double price) {
    int priceInCents = (int) Math.round(price * 100);
    return priceInCents > 0 && priceInCents % 25 == 0;
  }

  public static boolean isStockValid(int stock, String type) {
    return stock >= 0 && stock <= ItemTypes.getMaxStockByType(type);
  }
}
