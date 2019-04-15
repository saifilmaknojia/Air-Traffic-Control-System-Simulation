
// Packages to import 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SwingUI {
	// frame
	JFrame f;
	// Table
	JTable j;

	// Constructor
	public static DefaultTableModel model;

	public SwingUI(int n) {
		// Frame initiallization
		f = new JFrame();

		// Frame Title
		f.setTitle("Air Traffic Controller ");
		String[][] data = new String[n][6];
		// Column Names
		String[] columnNames = { "Airplane Id", "Start Time", "Priority", "Current State", "Next State", "End Time" };

		for (int i = 0; i < n; i++) {
			data[i][0] = Integer.toString(i);
		}
		// Initializing the JTable

		model = new DefaultTableModel(data, columnNames);
		j = new JTable(model);
		// j.setBounds(400, 200, 400, 400);
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) j.getDefaultRenderer(Object.class);
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		// Frame Size
		f.setSize(1000, 300);
		// Frame Visible = true
		f.setVisible(true);
	}

	public static void updateGUIState(String curr_state, String next_state, int row) {
		model.setValueAt(curr_state, row, 3);
		model.setValueAt(next_state, row, 4);
	}

	public static void updateStartTimeAndPriority(String time, int priority, int row) {
		// System.out.println(time);
		model.setValueAt(time, row, 1);
		model.setValueAt(priority, row, 2);
	}

	public static void updateEndTime(Date time, int row) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		model.setValueAt(dateFormat.format(time), row, 5);
	}
}