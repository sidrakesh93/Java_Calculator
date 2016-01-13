import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorWindow {

	private JFrame frame;
	private String op = "none";
	private int result = 0;
	private int curr = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorWindow window = new CalculatorWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorWindow() {
		initialize();
	}
	
	ActionListener clickNumActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton jb = (JButton)arg0.getSource();
			
			if(op == "none")
			{
				resultArea.append(jb.getText());
				result = Integer.valueOf(resultArea.getText());
			}
			else
			{
				currArea.append(jb.getText());
				curr = Integer.valueOf(currArea.getText());
			}
		}
	};
	
	ActionListener clickOpActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String type = ((JButton)arg0.getSource()).getText();

			if(op != "none")
			{
				if(op == "+")
				{
					result += curr;
				}
				else if(op == "-")
				{
					result -= curr;
				}
			}
			
			resultArea.setText(result + " " + type);
			op = type;
			currArea.setText("");
		}
	};

	private JTextArea resultArea;
	private JTextArea currArea;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 285, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		resultArea = new JTextArea();
		resultArea.setEditable(false);
		resultArea.setFont(new Font("Serif", Font.PLAIN, 25));
		resultArea.setBounds(10, 11, 251, 49);
		frame.getContentPane().add(resultArea);
		
		currArea = new JTextArea();
		currArea.setEditable(false);
		currArea.setFont(new Font("Serif", Font.PLAIN, 25));
		currArea.setBounds(10, 71, 251, 49);
		frame.getContentPane().add(currArea);
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(clickNumActionListener);
		button_1.setBounds(10, 142, 50, 49);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(clickNumActionListener);
		button_2.setBounds(72, 142, 50, 49);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(clickNumActionListener);
		button_3.setBounds(132, 142, 50, 49);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(clickNumActionListener);
		button_4.setBounds(10, 202, 50, 49);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(clickNumActionListener);
		button_5.setBounds(72, 202, 50, 49);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(clickNumActionListener);
		button_6.setBounds(132, 202, 50, 49);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(clickNumActionListener);
		button_7.setBounds(10, 262, 50, 49);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addActionListener(clickNumActionListener);
		button_8.setBounds(72, 262, 50, 49);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(clickNumActionListener);
		button_9.setBounds(132, 262, 50, 49);
		frame.getContentPane().add(button_9);
		
		JButton button_0 = new JButton("0");
		button_0.addActionListener(clickNumActionListener);
		button_0.setBounds(72, 322, 50, 49);
		frame.getContentPane().add(button_0);
		
		JButton button_plus = new JButton("+");
		button_plus.addActionListener(clickOpActionListener);
		button_plus.setBounds(211, 142, 50, 49);
		frame.getContentPane().add(button_plus);
		
		JButton button_minus = new JButton("-");
		button_minus.addActionListener(clickOpActionListener);
		button_minus.setBounds(211, 202, 50, 49);
		frame.getContentPane().add(button_minus);
		
		JButton button_equals = new JButton("=");
		button_equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(op == "+")
				{
					result += curr;
				}
				else if(op == "-")
				{
					result -= curr;
				}
				
				resultArea.setText(result + "");
				op = "none";
				currArea.setText("");
			}
		});
		
		button_equals.setBounds(211, 262, 50, 109);
		frame.getContentPane().add(button_equals);
		
		JButton AC_button = new JButton("AC");
		AC_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = 0;
				curr = 0;
				resultArea.setText("");
				currArea.setText("");
				op = "none";
			}
		});
		AC_button.setBounds(132, 322, 50, 49);
		frame.getContentPane().add(AC_button);
		
		JButton del_button = new JButton("<");
		del_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				if(op == "none")
				{
					result /= 10;
					
					if(result > 0)
						resultArea.setText(result + "");
					else
						resultArea.setText("");
				}
				else
				{
					curr /= 10;
					
					if(curr > 0)
						currArea.setText(curr + "");
					else
						currArea.setText("");
				}
			}
		});
		del_button.setBounds(10, 322, 50, 49);
		frame.getContentPane().add(del_button);
	}
}
