import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel3 extends JPanel implements ActionListener {

	int Xbound, Ybound, Xsize, Ysize;

	JTextField notename = new JTextField();
	JButton buttonforsubmit = new JButton("Create");

	Panel3() {

		Xbound = 0;
		Ybound = 0;
		Xsize = 500;
		Ysize = 260;
		setBounds(Xbound, Ybound, Xsize, Ysize);
		setLayout(null);
		notename.setBounds(100, 30, 150, 30);
		buttonforsubmit.setBounds(260, 30, 100, 30);
		buttonforsubmit.addActionListener(this);
		add(notename);
		add(buttonforsubmit);
		setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonforsubmit) {
			if (Frame.listofnotes.containsKey(notename.getText())) {
				JOptionPane.showMessageDialog(null, "There is one note named that.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				Frame.listofnotes.put(notename.getText(), notename.getText() + ".txt");
				Frame.panel1.note.setText("");
				Frame.panel1.date.setText("");
				Frame.panel1.write(notename.getText() + ".txt", Frame.panel1.note.getText());
				Frame.panel2.mylist.addElement(notename.getText());
				Frame.panel1.tittleofnote.setText(notename.getText());
				Frame.panel3.notename.setText("");
				Frame.panel3.setVisible(false);
				Frame.panel1.setVisible(true);
			}
		}
	}

}
