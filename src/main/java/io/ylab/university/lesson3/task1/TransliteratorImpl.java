package io.ylab.university.lesson3.task1;

import io.ylab.university.lesson3.task1.util.Alphabet;

public class TransliteratorImpl implements Transliterator {

  @Override
  public String transliterate(String source) {

    StringBuilder sb = new StringBuilder();
    char[] chars = source.toCharArray();

    for (char aChar : chars) {

      if (Alphabet.isExist(aChar)) {
        sb.append(Alphabet.getTranslated(aChar));
      }
      else {
        sb.append(aChar);
      }
    }

    return sb.toString();
  }
}
