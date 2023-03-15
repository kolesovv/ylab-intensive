package io.ylab.university.lesson2.task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnilsValidatorImpl implements SnilsValidator {

  @Override
  public boolean validate(String snils) {

    boolean result = false;
    int sum = 0;
    Pattern pattern = Pattern.compile("\\d{11}");
    Matcher matcher = pattern.matcher(snils);
    if (matcher.matches()) {
      for (int i = 0; i < 9; i++) {
        int digit = Character.getNumericValue(snils.charAt(i));
        sum += digit * (9 - i);
      }

      int checkDigit = 0;
      if (sum < 100) {
        checkDigit = sum;
      }
      else if (sum > 101) {
        checkDigit = sum % 101;
        if (checkDigit == 100) {
          checkDigit = 0;
        }
      }

      int controlDigit = Integer.parseInt(snils.substring(9));
      if (checkDigit == controlDigit) {
        result = true;
      }
    }

    return result;
  }
}
