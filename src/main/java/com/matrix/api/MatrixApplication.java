package com.matrix.api;

import com.matrix.service.MatrixService;
import com.matrix.service.MatrixValidate;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatrixApplication {

  public static void main(String[] args) throws FileNotFoundException {
    MatrixValidate matrixValidate = new MatrixValidate();
    MatrixService matrixService = new MatrixService();

    Scanner sc = new Scanner(System.in);
    sc.useDelimiter("\n");

    List<String> row;
    List<List<String>> matrix = new ArrayList<>();

    while (sc.hasNext()) {
      row = Arrays.stream(sc.next().split(",")).collect(Collectors.toList());
      matrix.add(row);
    }

    matrixValidate.setMatrix(matrix);
    if (matrixValidate.isEmpty()) {
      System.out.println("The file is empty. Please insert a valid matrix.");
      return;
    }

    if (!matrixValidate.isOnlyNumbers()) {
      System.out.println(
          "There is a character different than a number. Please use only numbers in matrix.");
      return;
    }

    if (!matrixValidate.isSquareMatrix()) {
      System.out.println("Matrix is invalid. Please insert a square matrix.");
    }

    if (!matrixValidate.isMatrix()) {
      System.out.println(
          "The file contains a invalid matrix. It must be the same number of columns in each row.");
      return;
    }

    matrixService.setMatrix(matrix);
    formatOutput();
    matrixService.showMatrixValues();
    formatOutput();
    matrixService.showInvertedMatrix();
    formatOutput();
    matrixService.showFlattenedMatrix();
    formatOutput();
    matrixService.showSumValuesMatrix();
    formatOutput();
    matrixService.showMultipliedValuesMatrix();
    formatOutput();

    sc.close();
  }

  /**
   * Separates validate items
   */
  private static void formatOutput() {
    System.out.println("----");
  }
}
