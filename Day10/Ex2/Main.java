package Ex2;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
  public static void main(String[] args) throws ParseException {
    String name = "Ho Van Cuong";
    String dob = "20-11-1991";
    double fee = 2000;
    Locale localeEn = new Locale("en", "US");
    System.out.println("-------------- Display in English --------------");
    display(localeEn, name, dob, fee);
    System.out.println("-------------- Display in Vietnam ---------------");
    Locale localeVI = new Locale("vi", "VN");
    display(localeVI, name, dob, fee);

  }

  public static void display(Locale locale, String name, String dob, double fee) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = simpleDateFormat.parse(dob);
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
    ResourceBundle labels = ResourceBundle.getBundle("i18n", locale);
    String showName = String.format("%s%s", labels.getString("show_name"), name);
    System.out.println(showName);
    String showDob = String.format("%s%s", labels.getString("show_dob"), dateFormat.format(date));
    System.out.println(showDob);
    String showFee = String.format("%s %s", labels.getString("show_fee"), numberFormat.format(fee));
    System.out.println(showFee);
  }
}
