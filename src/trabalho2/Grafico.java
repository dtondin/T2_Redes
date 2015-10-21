package trabalho2;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Douglas, Patricia, Priscila, Tamires
 */
public class Grafico {

    ChartPanel chartPanel = null;
    JFrame frame = null;

    public void criaGrafico(String titulo, String tituloGrafico, ArrayList<PontoGrafico> lista) {
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                tituloGrafico,
                "Tempo",
                "Valor",
                createDataset(lista),
                PlotOrientation.VERTICAL,
                true, true, false);

        if (chartPanel == null) {
            chartPanel = new ChartPanel(xylineChart);
        } else {
            chartPanel.setChart(xylineChart);
        }

        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(4.0f));
        plot.setRenderer(renderer);

        if (frame == null) {
            frame = new JFrame(titulo);
            frame.setTitle(tituloGrafico);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout(0, 5));
            frame.add(chartPanel, BorderLayout.CENTER);
        } else {
            frame.add(chartPanel, BorderLayout.CENTER);
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private XYDataset createDataset(ArrayList<PontoGrafico> lista) {
        final XYSeries in = new XYSeries("In");
        final XYSeries out = new XYSeries("Out");

        for (int i = 0; i < lista.size(); i++) {
            in.add(lista.get(i).getInX(), lista.get(i).getInY());
            out.add(lista.get(i).getOutX(), lista.get(i).getOutY());
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(in);
        dataset.addSeries(out);
        return dataset;
    }

}
