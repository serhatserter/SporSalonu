package sp.Charts;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class CreateChartGelisim extends JFrame {
     
private int[] veri;
    
    public CreateChartGelisim(String appTitle, String chartTitle, int[] veri){
        this.veri = veri;
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset,chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(700,500));
        chartPanel.setLocation(640, 480);
        setContentPane(chartPanel);
    }


    
    private PieDataset createDataset(){
        DefaultPieDataset result = new  DefaultPieDataset();
        result.setValue("Yapılan %"+veri[0], veri[0]);
        result.setValue("Yapılmayan %"+veri[1], veri[1]);

        return  result;
        
    }
    
    private JFreeChart createChart (PieDataset dataset, String title){
        JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        return chart;
    }
}
