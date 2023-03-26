package io.ylab.university.lesson3.task1.util;

import java.util.HashMap;
import java.util.Map;

public final class Alphabet {

  private static final Map<Character, String> storage = new HashMap<>();

  static {
    storage.put('А', "A");
    storage.put('Б', "B");
    storage.put('В', "V");
    storage.put('Г', "G");
    storage.put('Д', "D");
    storage.put('Е', "E");
    storage.put('Ё', "E");
    storage.put('Ж', "ZH");
    storage.put('З', "Z");
    storage.put('И', "I");
    storage.put('Й', "I");
    storage.put('К', "K");
    storage.put('Л', "L");
    storage.put('М', "M");
    storage.put('Н', "N");
    storage.put('О', "O");
    storage.put('П', "P");
    storage.put('Р', "R");
    storage.put('С', "S");
    storage.put('Т', "T");
    storage.put('У', "U");
    storage.put('Ф', "F");
    storage.put('Х', "KH");
    storage.put('Ц', "TS");
    storage.put('Ч', "CH");
    storage.put('Ш', "SH");
    storage.put('Щ', "SHCH");
    storage.put('Ы', "Y");
    storage.put('Ь', "-");
    storage.put('Ъ', "IE");
    storage.put('Э', "E");
    storage.put('Ю', "IU");
    storage.put('Я', "IA");
  }

  private Alphabet() {

  }

  public static String getTranslated(Character ch) {

    return storage.get(ch);
  }

  public static boolean isExist(Character ch) {

    return storage.containsKey(ch);
  }
}
