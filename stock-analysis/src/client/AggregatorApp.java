package client;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;

import java.io.IOException;

public class AggregatorApp {

  public static void main(String[] args) throws IOException {

    /**
     * You'll need to uncomment the below code. You'll notice it does not compile!
     *
     * <p>There are 2 objectives in this assignment.
     *
     * <p>1). Make sure the code compiles correctly after you uncomment it below. 2). Make sure it
     * runs as explained in the assignment video!
     *
     * <p>-->> YOUR WORK SHOULD BE DONE IN THE AggregatorProcessor CLASS.
     */
    MaxAggregator agg = new MaxAggregator();
    AggregatorProcessor<MaxAggregator> aggsProcessor =
        new AggregatorProcessor<MaxAggregator>(agg, "table.csv");
    double value = aggsProcessor.runAggregator(1);
    System.out.println(value);
  }
}
