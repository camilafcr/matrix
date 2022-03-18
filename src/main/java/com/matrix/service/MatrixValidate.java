package com.matrix.service;

import static com.matrix.utils.FormatText.formatText;

import com.matrix.utils.FormatText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixValidate {

  private List<List<String>> matrix = new ArrayList<>();

  /**
   * Set matrix to validate
   *
   * @param matrix
   */
  public void setMatrix(List<List<String>> matrix) {
    this.matrix = matrix;
  }

  /**
   * Validates if matrix is empty
   *
   * @return boolean
   */
  public boolean isEmpty() {
    return matrix.isEmpty();
  }

  /**
   * Validates if there are only number in matrix
   *
   * @return boolean
   */
  public boolean isOnlyNumbers() {
    List<String> listNumbers = Arrays.stream(formatText(matrix.toString()).split(","))
        .collect(Collectors.toList());
    long valuesNotNumeric = listNumbers.stream().filter(e -> e.matches("[^\\d].*")).count();

    return valuesNotNumeric == 0;
  }

  /**
   * Validates if matrix is squared
   *
   * @return boolean
   */
  public boolean isSquareMatrix() {
    final int firstRow = 0;

    if (matrix.size() != matrix.get(firstRow).size()) {
      return false;
    }

    return true;
  }

  /**
   * Validates if matrix has the same column number
   *
   * @return true
   */
  public boolean isMatrix() {
    final int firstRow = 0;
    int columnsNumber = matrix.get(firstRow).size();
    boolean isMatrix = true;
    int row = 0;

    while (row < matrix.size()) {
      if (matrix.get(row).size() != columnsNumber) {
        isMatrix = false;
      }

      row++;
    }

    return isMatrix;
  }
}
