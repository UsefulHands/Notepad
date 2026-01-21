import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Panel1 extends JPanel implements ActionListener {

	int Xbound, Ybound, Xsize, Ysize;

	JButton newnote;
	JButton mynotes;
	JButton clearall;
	JButton adddate;
	JButton save;
	JTextArea note;
	JScrollPane scroll;
	JLabel date;

	static JLabel tittleofnote;

	Panel1() {

		Xbound = 0;
		Ybound = 0;
		Xsize = 500;
		Ysize = 260;
		setBounds(Xbound, Ybound, Xsize, Ysize);
		setLayout(null);
		newnote = new JButton("New Note");
		mynotes = new JButton("My Notes");
		clearall = new JButton("Clear");
		adddate = new JButton("Add Date");
		save = new JButton("Save");
		tittleofnote = new JLabel("", SwingConstants.CENTER);
		note = new JTextArea();
		scroll = new JScrollPane(note, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		date = new JLabel();
		newnote.setBounds(380, 10, 100, 30);
		mynotes.setBounds(380, 50, 100, 30);
		clearall.setBounds(380, 90, 100, 30);
		adddate.setBounds(380, 130, 100, 30);
		save.setBounds(380, 170, 100, 30);
		tittleofnote.setBounds(20, 10, 100, 30);
		scroll.setBounds(20, 50, 340, 150);
		date.setBounds(130, 10, 200, 30);
		note.setLineWrap(true);
		newnote.addActionListener(this);
		mynotes.addActionListener(this);
		clearall.addActionListener(this);
		adddate.addActionListener(this);
		save.addActionListener(this);
		add(newnote);
		add(mynotes);
		add(clearall);
		add(adddate);
		add(save);
		add(tittleofnote);
		add(scroll);
		add(date);
		setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == newnote) {
			Frame.panel1.setVisible(false);
			Frame.panel2.setVisible(false);
			Frame.panel3.setVisible(true);
		}
		if (e.getSource() == mynotes) {
			Frame.panel1.setVisible(false);
			Frame.panel3.setVisible(false);
			Frame.panel2.setVisible(true);
		}
		if (e.getSource() == clearall) {
			note.setText("");
		}
		if (e.getSource() == adddate) {
			date.setText("Last Change :" + getDate());
			Frame.listoftittleshasdate.add(tittleofnote.getText()+"date.txt");
			write(tittleofnote.getText() + "date.txt", date.getText());
		}
		if (e.getSource() == save) {
			write(tittleofnote.getText() + ".txt", note.getText());
		}
	}

	void write(String filename, String whattowrite) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			String[] lines = whattowrite.split("\\n");

			for (String line : lines) {
				writer.write(line + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void readandapplytext(String filename, JTextArea wheretoread) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			StringBuilder text = new StringBuilder("");
			String line;
			while ((line = reader.readLine()) != null) {
				text.append(line + "\n");
			}
			wheretoread.setText(text.toString());
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void readandapplytext(String filename, JLabel wheretoread) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			StringBuilder text = new StringBuilder("");
			String line;
			while ((line = reader.readLine()) != null) {
				text.append(line + "\n");
			}
			wheretoread.setText(text.toString());
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String getDate() {
		Date today = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy--HH/mm");
		return format.format(today).toString();
	}

}
