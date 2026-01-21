import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Panel2 extends JPanel implements ActionListener {

	int Xbound, Ybound, Xsize, Ysize;
	static int rowcounter = 0;

	static DefaultListModel<String> mylist;
	static JList<String> list;

	JLabel newnote;
	JScrollPane scroll;
	JButton select;
	JButton delete;
	JButton newnoteaddbutton;

	Panel2() {

		Xbound = 0;
		Ybound = 0;
		Xsize = 500;
		Ysize = 260;
		setBounds(Xbound, Ybound, Xsize, Ysize);
		setLayout(null);
		mylist = new DefaultListModel<>();
		list = new JList<>(mylist);
		scroll = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(130, 30, 150, 80);
		add(scroll);
		setVisible(true);
		select = new JButton("Select");
		delete = new JButton("Delete");
		select.setBounds(290, 30, 80, 30);
		delete.setBounds(290, 80, 80, 30);
		select.addActionListener(this);
		delete.addActionListener(this);
		add(select);
		add(delete);
		newnote = new JLabel("New Note --->", SwingConstants.CENTER);
		newnote.setBounds(200, 120, 80, 30);
		add(newnote);
		newnoteaddbutton = new JButton("Add");
		newnoteaddbutton.setBounds(290, 130, 80, 30);
		newnoteaddbutton.addActionListener(this);
		add(newnoteaddbutton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (list.getSelectedIndex() != -1) {
			if (e.getSource() == select) {
				Frame.panel1.note.setText("");
				Frame.panel1.date.setText("");
				Frame.panel1.readandapplytext(Frame.listofnotes.get(list.getSelectedValue()), Frame.panel1.note);
		
				if (Frame.listoftittleshasdate.contains(list.getSelectedValue() + "date.txt")) {				
					Frame.panel1.readandapplytext(list.getSelectedValue() + "date.txt", Frame.panel1.date);
				}
				Frame.panel1.tittleofnote.setText(list.getSelectedValue());
				Frame.panel2.setVisible(false);
				Frame.panel1.setVisible(true);
			}
			if (e.getSource() == delete) {
				File directory = new File("C:\\Users\\Administrator\\eclipse-workspace\\NotePad" + "\\"
						+ list.getSelectedValue() + ".txt");
				directory.delete();
				mylist.removeElement(list.getSelectedValue());
				if(Frame.listoftittleshasdate.contains(list.getSelectedValue() + "date.txt")) {
					File directory2 = new File("C:\\Users\\Administrator\\eclipse-workspace\\NotePad" + "\\"
							+ list.getSelectedValue() + "date.txt");
					directory2.delete();
					Frame.listoftittleshasdate.remove(list.getSelectedValue() + "date.txt");
				}
			}
		}

		if (e.getSource() == newnoteaddbutton) {
			Frame.panel2.setVisible(false);
			Frame.panel3.setVisible(true);
		}
	}
}
