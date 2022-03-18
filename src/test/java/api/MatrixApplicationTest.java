package api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.matrix.api.MatrixApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MatrixApplicationTest {

  MatrixApplication application = new MatrixApplication();

  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void shouldReadFile() throws IOException {
    File csvFile = new File("matrix_test.csv");
    System.setIn(new FileInputStream(csvFile));

    application.main(null);

    assertEquals(buildOutputTest(), outputStreamCaptor.toString());
  }

  private String buildOutputTest() {
    StringBuilder output = new StringBuilder();

    output.append("----\r\n");
    output.append("1,2\n");
    output.append("3,4\n");
    output.append("----\r\n");
    output.append("1,3\n");
    output.append("2,4\n");
    output.append("----\r\n");
    output.append("1,2,3,4\r\n");
    output.append("----\r\n");
    output.append("10\r\n");
    output.append("----\r\n");
    output.append("24\r\n");
    output.append("----\r\n");

    return output.toString();
  }
}
