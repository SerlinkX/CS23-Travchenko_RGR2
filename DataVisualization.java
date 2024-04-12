import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class DataVisualization extends Application {

    @Override
    public void start(Stage stage) {
        // Define the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        yAxis.setLabel("f(x)");

        // Create the line chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Experimental Data");

        // Create a series for the data
        XYChart.Series series = new XYChart.Series();
        series.setName("f(x) = exp(-x^2) * sin(x)");

        // Generate experimental data and add it to the series
        double x = 1.5;
        while (x <= 6.5) {
            double y = Math.exp(-x * x) * Math.sin(x);
            series.getData().add(new XYChart.Data(x, y));
            x += 0.05;
        }

        // Add the series to the chart
        lineChart.getData().add(series);

        // Create the scene and add the chart to it
        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}