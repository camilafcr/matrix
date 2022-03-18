package service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.matrix.service.MatrixValidate;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MatrixValidateTest {

  private MatrixValidate matrixValidate = new MatrixValidate();
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void shouldValidateWhenMatrixIsEmpty() {
    matrixValidate.setMatrix(new ArrayList<>());
    assertTrue(matrixValidate.isEmpty());
  }

  @Test
  public void shouldValidateWhenMatrixIsNotEmpty() {
    matrixValidate.setMatrix(Arrays
        .asList(Arrays.asList("1", "2"), Arrays.asList("3", "4")));
    assertFalse(matrixValidate.isEmpty());
  }

  @Test
  public void shouldValidateWhenExistsCharacterDifferentThanNumber() {
    matrixValidate.setMatrix(Arrays
        .asList(Arrays.asList("1", "x"), Arrays.asList("3", "4")));
    assertFalse(matrixValidate.isOnlyNumbers());
  }

  @Test
  public void shouldValidateWhenNotExistsCharacterDifferentThanNumber() {
    matrixValidate.setMatrix(Arrays
        .asList(Arrays.asList("1", "2"), Arrays.asList("3", "4")));
    assertTrue(matrixValidate.isOnlyNumbers());
  }

  @Test
  public void shouldValidateWhenMatrixIsNotSquare() {
    matrixValidate.setMatrix(Arrays
        .asList(Arrays.asList("1", "2", "3"), Arrays.asList("3", "4")));
    assertFalse(matrixValidate.isSquareMatrix());
  }

  @Test
  public void shouldValidateWhenMatrixIsSquare() {
    matrixValidate.setMatrix(Arrays
        .asList(Arrays.asList("1", "2"), Arrays.asList("4", "5")));
    assertTrue(matrixValidate.isSquareMatrix());
  }

  @Test
  public void shouldValidateWhenIsMatrix() {
    matrixValidate.setMatrix(Arrays
        .asList(Arrays.asList("1", "2"), Arrays.asList("4", "5")));
    assertTrue(matrixValidate.isMatrix());
  }

  @Test
  public void shouldValidateWhenIsNotMatrix() {
    matrixValidate.setMatrix(Arrays
        .asList(Arrays.asList("1", "2"), Arrays.asList("4", "5", "6")));
    assertFalse(matrixValidate.isMatrix());
  }
}
