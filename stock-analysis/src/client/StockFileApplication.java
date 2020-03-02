package client;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockFileApplication {

  public static void main(String args[]) throws IOException {
    StockFileReader fr = new StockFileReader("table.csv");

    List<HashMap<String, Double>> dataResult =
        populateStockFileData(fr.getHeaders(), fr.readFileData());
    StockFileData fileData = new StockFileData();
    fileData.addData(dataResult);
    fileData.printData();
    System.out.println(dataResult.size());
  }
  /**
   * Complete the method body so that it returns the given structure needed to populate the data
   * field in the StockFileData class.
   *
   * @param headers
   * @param lines
   * @return List
   */
  public static List<HashMap<String, Double>> populateStockFileData(
      List<String> headers, List<String> lines) {
    List<HashMap<String, Double>> dataResult = new ArrayList<>();

    for (int i = 0; i < lines.size(); i++) {
      HashMap<String, Double> stockValues = new HashMap<>();
      for (int j = 0; j < headers.size(); j++) {
        String line[] = lines.get(i).split(",");
        stockValues.put(headers.get(j), Double.parseDouble(line[j]));
      }

      dataResult.add(stockValues);
    }
    return dataResult;
    // Alternative Code using foreach and lambdas
    // return populatedList(headers, lines);
  }

  private static List<HashMap<String, Double>> populatedList(
      List<String> headers, List<String> lines) {

    List<HashMap<String, Double>> dataResult = new ArrayList<>();
    lines.forEach(
        line -> {
          String newLine = line;
          String list[] = newLine.split(",");
          HashMap<String, Double> stockValues = new HashMap<>();
          for (int i = 0; i < headers.size(); i++) {
            stockValues.put(headers.get(i), Double.parseDouble(list[i]));
          }
          dataResult.add(stockValues);
        });
    return dataResult;
  }
}
