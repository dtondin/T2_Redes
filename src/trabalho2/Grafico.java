package trabalho2;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Douglas, Patricia, Priscila
 */
public class Grafico extends ApplicationFrame {

    public Grafico(String titulo, String tituloGrafico, int inX, int inY, int outX, int outY) {
        super(titulo);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                tituloGrafico,
                "Tempo",
                "Valor",
                createDataset(inX, inY, outX, outY),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(4.0f));
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
    }

    private XYDataset createDataset(int inX, int inY, int outX, int outY) {
        final XYSeries in = new XYSeries("In");
        in.add(inX, inY);
        final XYSeries out = new XYSeries("Out");
        out.add(outX, outY);
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(in);
        dataset.addSeries(out);
        return dataset;
    }

}
