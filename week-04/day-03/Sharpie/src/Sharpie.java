import sun.security.provider.SHA;

/**
 * Created by Andi on 4/3/2017.
 */
public class Sharpie {
  String color;
  double width;
  double inkAmount;

  public Sharpie(String color, double width) {
    this.color = color;
    this.width = width;
    inkAmount = 100;
  }

  public void use() {
    inkAmount -= 1;
  }
}
