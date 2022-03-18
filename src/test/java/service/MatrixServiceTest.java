package service;

import static com.matrix.utils.FormatText.formatText;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.matrix.service.MatrixService;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MatrixServiceTest {

  private static MatrixService matrixService = new MatrixService();
  private static List<List<String>> matrix = Arrays
      .asList(Arrays.asList("1", "2", "3"), Arrays.asList("4", "5", "6"),
          Arrays.asList("7", "8", "9"));
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @BeforeAll
  public static void setMatrix() {
    matrixService.setMatrix(matrix);
  }

  @Test
  public void shouldShowMatrixValues() {
    StringBuilder matrixAux = new StringBuilder();
    matrixAux.append(matrix.get(0).toString() + "\n");
    matrixAux.append(matrix.get(1).toString() + "\n");
    matrixAux.append(matrix.get(2).toString() + "\n");

    matrixService.showMatrixValues();

    assertEquals(formatText(matrixAux.toString()), outputStreamCaptor.toString());
  }

  @Test
  public void shouldShowMatrixWithInvertedValues() {
    final List<List<Integer>> invertedMatrix = Arrays
        .asList(Arrays.asList(1, 4, 7), Arrays.asList(2, 5, 8), Arrays.asList(3, 6, 9));

    StringBuilder matrixAux = new StringBuilder();
    matrixAux.append(invertedMatrix.get(0).toString() + "\n");
    matrixAux.append(invertedMatrix.get(1).toString() + "\n");
    matrixAux.append(invertedMatrix.get(2).toString() + "\n");

    matrixService.showInvertedMatrix();

    assertEquals(formatText(matrixAux.toString()), outputStreamCaptor.toString());
  }

  @Test
  public void shouldShowFlattenedMatrix() {
    String matrixAux = "1,2,3,4,5,6,7,8,9";

    matrixService.showFlattenedMatrix();

    assertEquals(matrixAux, outputStreamCaptor.toString().replaceAll("\r\n", ""));
  }

  @Test
  public void shouldShowResultOfSumValuesFromMatrix() {
    matrixService.showSumValuesMatrix();

    assertEquals("45", outputStreamCaptor.toString().replaceAll("\r\n", ""));
  }

  @Test
  public void shouldShowResultOfMultiplyValuesFromMatrix() {
    matrixService.showMultipliedValuesMatrix();

    assertEquals("362880", outputStreamCaptor.toString().replaceAll("\r\n", ""));
  }
}
