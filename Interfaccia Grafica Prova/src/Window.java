import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Window extends JFrame implements ActionListener,KeyListener{
	private static final long serialVersionUID = 1L;
	private JButton B1, B2;
	private JTextField User;
	private JPasswordField Pass;
	
	
	public Window() {
		super("Window");
		B1 = new JButton("Annulla");
		B1.addActionListener(this);
		B2 = new JButton("Conferma");
		B2.addActionListener(this);
		User = new JTextField();
		Pass = new JPasswordField();
		Pass.addKeyListener(this);
	
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,2)); 
		p1.add(new JLabel("Username"));
		p1.add(User);
		p1.add(new JLabel("Password"));
		p1.add(Pass);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,2)); 
		p3.add(B1); 
		p3.add(B2);
		
		JPanel p4 = new JPanel(new BorderLayout());
		p4.add(p1, BorderLayout.CENTER);
		p4.add(p3, BorderLayout.PAGE_END);
		
		setContentPane(p4);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(350,120);
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == B1) {
			User.setText("");
			Pass.setText("");
			System.out.println("Annullato");
		}
		
		if(e.getSource() == B2) {
			boolean conti = true;
			if(User.getText().length() == 0 || Pass.getText().length() == 0) {
				JOptionPane.showMessageDialog(this,
						"Inserire Username e Password",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				System.out.println("Error");
				conti = false;
			}
			if(conti == true) {
				System.out.println("Username: " + User.getText() + "\tPassword: " + Pass.getText());
				System.out.println("Confermato");
				dispose();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			boolean conti = true;
			if(User.getText().length() == 0 || Pass.getText().length() == 0) {
				JOptionPane.showMessageDialog(this,
						"Inserire Username e Password",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				System.out.println("Error");
				conti = false;
		}
			if(conti == true) {
				System.out.println("Username: " + User.getText() + "\tPassword: " + Pass.getText());
				System.out.println("Confermato");
				dispose();
			}	
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	public static void main(String[] args) {
		new Window();
	}
}
