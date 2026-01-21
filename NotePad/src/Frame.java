import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;

public class Frame extends JFrame {

	int Xbound, Ybound, Xsize, Ysize;

	static Panel1 panel1 = new Panel1();
	static Panel2 panel2 = new Panel2();
	static Panel3 panel3 = new Panel3();

	static HashMap<String, String> listofnotes = new HashMap<>();
	static ArrayList<String> listoftittleshasdate = new ArrayList<>();

	Frame() {

		Xbound = 700;
		Ybound = 300;
		Xsize = 500;
		Ysize = 260;
		setBounds(Xbound, Ybound, Xsize, Ysize);
		setLayout(null);
		addfiles();
		applyfiles();
		add(panel1);
		add(panel2);
		add(panel3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	static void addfiles() {
		File directory = new File("C:\\Users\\Administrator\\eclipse-workspace\\NotePad");
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isFile() && file.getName().endsWith(".txt")) {
				if (file.getName().endsWith("date.txt")) {
					listoftittleshasdate.add(file.getName());
				} else {
					String fileName = file.getName();
					String key = fileName.substring(0, fileName.lastIndexOf('.'));
					listofnotes.put(key, fileName);
				}

			}

		}
	}

	static void applyfiles() {
		if (Frame.listofnotes != null) {
			for (String filename : Frame.listofnotes.keySet()) {
				panel2.mylist.addElement(filename);
			}
			for (String filename : listoftittleshasdate) {
				Frame.panel1.readandapplytext(filename, Frame.panel1.date);
			}
		}
	}
}
