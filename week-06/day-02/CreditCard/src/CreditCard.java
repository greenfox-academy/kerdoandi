import java.util.Random;

public class CreditCard implements CreditCardy {
  String name;
  String CC;
  int CVV;
  static int cardHolderID = 0;

  public CreditCard() {
    generateCardHolderName();
    generateCCandCVV();
  }

  void generateCardHolderName() {
    this.name = "ABC".concat(String.valueOf(cardHolderID++));
  }

  void generateCCandCVV() {
    char[] numbers = "0123456789".toCharArray();
    char[] CCnumber = new char[18];
    Random random = new Random();
    for (int i = 0; i < 18; i++) {
      int index = random.nextInt(10);
      CCnumber[i] = numbers[index];
    }
    this.CC = new String(CCnumber);

    this.CVV = 0;
    for (int j = 0; j < CCnumber.length; j++) {
      this.CVV = this.CVV + Integer.parseInt(String.valueOf(CCnumber[j]));
    }
  }

  @Override
  public int getSumCVV() {
    return this.CVV;
  }

  @Override
  public String getNameCardholder() {
    return this.name;
  }

  @Override
  public String getCodeAccount() {
    return this.CC;
  }

  @Override
  public int cumeSumCVV(String codeAccount) {
    return 0;
  }

  @Override
  public String toString() {
    String tempformat = String.format("Name=%s CC#=%s CVV=%d", getNameCardholder(), getCodeAccount(), getSumCVV());
    return tempformat + " (validated)";
  }
}
