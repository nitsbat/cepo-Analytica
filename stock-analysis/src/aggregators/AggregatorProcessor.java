package aggregators;

import fileprocessors.StockFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AggregatorProcessor<T extends Aggregator> {
  private T abc;
  private String filename;

  public AggregatorProcessor(T abc, String filename) {
    super();
    this.abc = abc;
    this.filename = filename;
  }

  public double runAggregator(int i) throws IOException {
    StockFileReader reader =
        new StockFileReader("table.csv");
    List<String> filedata = reader.readFileData();
    List<Double> resultNumber = this.fetchColumnFromIndex(filedata, i);
    for (Double number : resultNumber)
        abc.add(number);
    return abc.calculate();
  }

  private List<Double> fetchColumnFromIndex(List<String> filedata, int index) {
    List<String> stringList = new ArrayList<>();
    List<Double> doubleList = new ArrayList<>();
    List<Double> result = new ArrayList<>();
    for (String value : filedata) {
      stringList = this.convertCommaStringToList(value);
      doubleList = this.convertListToDoubleList(stringList);
      result.add(doubleList.get(index - 1));
    }
    return result;
  }

  private List<Double> convertListToDoubleList(List<String> stringList) {
    List<Double> doubleList = new ArrayList<>();
    for (String string : stringList) {
      doubleList.add(Double.parseDouble(string));
    }
    return doubleList;
  }

  private List<String> convertCommaStringToList(String value) {
    List<String> stringList = new ArrayList<>();
    int startIndex = 0;
    for (int i = 0; i < value.length(); i++) {
      if (value.charAt(i) == ',') {
        String temp = value.substring(startIndex, i);
        stringList.add(temp);
        startIndex = i + 1;
      }
    }
    return stringList;
  }

  private void fetchCell(String val, int index) {
    int count = 1;
  }
}
