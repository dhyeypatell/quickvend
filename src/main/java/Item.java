public class Item {
  private String code;
  private String name;
  private String type;
  private double price;
  private int stock;

  public Item(String code, String name, int typeIndex, double price, int stock) {
    StringBuilder errors = new StringBuilder();

    if (!Utils.isCodeValid(code)) {
      errors.append(Messages.getMessage("invalidCode")).append(" ");
    }

    if (!Utils.isNameValid(name)) {
      errors.append(Messages.getMessage("invalidName")).append(" ");
    }

    if (!ItemTypes.doesTypeExist(typeIndex)) {
      errors.append(Messages.getMessage("invalidType")).append(" ");
    }

    if (!Utils.isPriceValid(price)) {
      errors.append(Messages.getMessage("invalidPrice")).append(" ");
    }

    if (!Utils.isStockValid(stock, typeIndex)) {
      errors.append(Messages.getMessage("invalidStock")).append(" ");
    }

    if (!errors.isEmpty()) {
      throw new IllegalArgumentException(errors.toString().trim());
    }

    this.code = code;
    this.name = name;
    this.type = ItemTypes.getTypeByIndex(typeIndex);
    this.price = price;
    this.stock = stock;
  }

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public double getPrice() {
    return this.price;
  }

  public int getStock() {
    return this.stock;
  }

  public boolean setCode(String code) {
    if (!Utils.isCodeValid(code)) {
      return false;
    }

    this.code = code;
    return true;
  }

  public boolean setName(String name) {
    if (!Utils.isNameValid(name)) {
      return false;
    }

    this.name = name;
    return true;
  }

  public boolean setType(int index) {
    if (!ItemTypes.doesTypeExist(index)) {
      return false;
    }

    this.type = ItemTypes.getTypeByIndex(index);
    return true;
  }

  public boolean setPrice(double price) {
    if (!Utils.isPriceValid(price)) {
      return false;
    }

    this.price = Math.round(price * 100) / 100.0;
    return true;
  }

  public boolean setStock(int stock) {
    if (!Utils.isStockValid(stock, type)) {
      return false;
    }

    this.stock = stock;
    return true;
  }

  @Override
  public String toString() {
    return String.format("%s: %-10s $%-5.2f (%d left)", code, name, price, stock);
  }
}
