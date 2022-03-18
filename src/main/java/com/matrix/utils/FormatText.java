package com.matrix.utils;

public class FormatText {
  public static String formatText(String text) {
    text = text.replaceAll("[\\[\\]]", "");
    text = text.replaceAll(" ", "");
    return text;
  }
}
