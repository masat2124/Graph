package graph;

import java.awt.*;
import java.awt.event.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_view extends Frame implements ActionListener, WindowListener{
	
	private Panel p1 = new Panel();
	private Panel p2 = new Panel();
	private Button bBar = new Button("BarChart");
	private Button bLine = new Button("LineChart");
	private DefaultCategoryDataset data = new DefaultCategoryDataset();
	private ChartPanel cpanel;

	public Graph_view() throws HeadlessException {
		super();
		addWindowListener(this);
		setTitle("Graph");
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(p1);
		add(p2);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(bBar);
		p1.add(bLine);
		bBar.addActionListener(this);
		bLine.addActionListener(this);

		data.addValue(300, "USA", "2005");
		data.addValue(500, "USA", "2006");
		data.addValue(120, "USA", "2007");
		data.addValue(200, "China", "2005");
		data.addValue(400, "China", "2006");
		data.addValue(320, "China", "2007");
	    JFreeChart chart = ChartFactory.createLineChart("Import Volume","Year","Ton",data,PlotOrientation.VERTICAL,true,false,false);

	    cpanel = new ChartPanel(chart);
	    p2.add(cpanel, BorderLayout.CENTER);
	}

	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == bBar || e.getSource() == bLine) {
		    JFreeChart chart = (e.getSource() == bBar) ?
		  	      ChartFactory.createBarChart("Import Volume","Year","Ton",data,PlotOrientation.VERTICAL,true,false,false) :
		  	      ChartFactory.createLineChart("Import Volume","Year","Ton",data,PlotOrientation.VERTICAL,true,false,false);
		  	p2.remove(cpanel);
		    cpanel = new ChartPanel(chart);
		    p2.add(cpanel, BorderLayout.CENTER);
		    p2.revalidate();
		    p2.repaint();
		}
	}

}