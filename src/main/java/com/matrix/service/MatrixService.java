package com.matrix.service;

import static com.matrix.utils.FormatText.formatText;

import java.util.ArrayList;
import java.util.List;

public class MatrixService {

  private List<List<String>> matrix = new ArrayList<>();

  /**
   * Show matrix values
   */
  public void showMatrixValues() {
    StringBuilder matrixText = new StringBuilder();
    matrix.forEach(rowMatrix -> matrixText.append(formatText(rowMatrix.toString()) + "\n"));
    System.out.print(matrixText);
  }

  /**
   * Show inverted matrix (Lines will be columns)
   */
  public void showInvertedMatrix() {
    final int firstRow = 0;
    StringBuilder matrixText = new StringBuilder();

    List<String> invertedRow = new ArrayList<>();
    List<List<String>> invertedMatrix = new ArrayList<>();

    int columnCount = 0;
    int rowCount = 0;
    while (columnCount < matrix.get(firstRow).size()) {
      while (rowCount < matrix.size()) {
        invertedRow.add(matrix.get(rowCount).get(columnCount));
        rowCount++;
      }

      invertedMatrix.add(invertedRow);
      columnCount++;
      rowCount = 0;
      invertedRow = new ArrayList<>();
    }

    invertedMatrix.forEach(rowMatrix -> matrixText.append(formatText(rowMatrix.toString()) + "\n"));
    System.out.print(matrixText);
  }

  /**
   * Show matrix in a row
   */
  public void showFlattenedMatrix() {
    System.out.println(formatText(matrix.toString()));
  }

  /**
   * Show the sum of values of matrix
   */
  public void showSumValuesMatrix() {
    List<Integer> sumByRow = new ArrayList<>();
    matrix.forEach(rowAux ->
        sumByRow.add(
            rowAux.stream().map(Integer::parseInt).reduce(0, (subtotal, value) -> subtotal + value))
    );

    System.out.println(sumByRow.stream().reduce(0, (subtotal, value) -> subtotal + value));
  }

  /**
   * Show the result of multiplied values of matrix
   */
  public void showMultipliedValuesMatrix() {
    List<Integer> multiplyByRow = new ArrayList<>();
    matrix.forEach(rowAux ->
        multiplyByRow.add(
            rowAux.stream().map(Integer::parseInt).reduce(1, (subtotal, value) -> subtotal * value))
    );

    System.out.println(multiplyByRow.stream().reduce(1, (subtotal, value) -> subtotal * value));
  }

  /**
   * Set matrix to do functions
   *
   * @param matrix
   */
  public void setMatrix(List<List<String>> matrix) {
    this.matrix = matrix;
  }


}
