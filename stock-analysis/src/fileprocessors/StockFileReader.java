package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {

  String filePath = null;

  public StockFileReader(String filePath) {
    this.filePath = filePath;
  }

  public List<String> getHeaders() throws IOException {
    String line = readFirstLine(filePath);
    String[] header = line.split(",");
    List<String> values = new ArrayList<String>();
    values = Arrays.asList(header);
    return values;
  }

  static String readFirstLine(String path) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      return br.readLine();
    }
  }
  /**
   * Complete the body of this method.
   *
   * @return List
   * @throws IOException
   */
  public List<String> readFileData() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(filePath));
    br.readLine();
    return readWholeFile(br);
  }

  private List<String> readWholeFile(BufferedReader br) throws IOException {
    int i;
    String finalString = "";
    List<String> linesList = new ArrayList<>();
    while ((i = br.read()) != -1) {
      finalString += Character.toString((char) i);
      if (i == '\n') {
        linesList.add(finalString);
        finalString = "";
      }
    }

    return linesList;
  }

  private String readOneLine(BufferedReader br) throws IOException {
    int i;
    String a = "";

    while ((i = br.read()) != '\n') {
      a += Character.toString((char) i);
      ;
    }
    return a;
  }
}
