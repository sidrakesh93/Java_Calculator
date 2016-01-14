import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorWindow {

	private JFrame frame;
	private JTextArea resultArea;
	private JTextArea currArea;
	
	private String prev_oper = "none";
	private int result = 0;
	private int curr = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            // Set System L&F
			        UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
					
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
			
			if(prev_oper == "none")
			{
				//write to result box
				resultArea.append(jb.getText());
				result = Integer.valueOf(resultArea.getText());
			}
			else
			{
				//write to current box
				currArea.append(jb.getText());
				curr = Integer.valueOf(currArea.getText());
			}
		}
	};
	
	ActionListener clickOpActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String type = ((JButton)arg0.getSource()).getText();

			if(prev_oper != "none")
			{
				if(prev_oper == "+")
				{
					result += curr;
				}
				else if(prev_oper == "-")
				{
					result -= curr;
				}
			}
			
			//set the result area
			resultArea.setText(result + " " + type);
			prev_oper = type;
			currArea.setText("");
		}
	};
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		init_frame();
		init_text_areas();
		init_num_buttons();		
		init_op_buttons();		
		init_equals_button();		
		init_ac_button();
		init_del_button();
	}
	
	/*Initialize the frame*/
	private void init_frame()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 279, 421);
		frame.setResizable(false);
		frame.setTitle("Calculator");
		
		ImageIcon img = new ImageIcon("src\\icon.png");
		frame.setIconImage(img.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	
	/*Initialize the text areas*/
	private void init_text_areas()
	{
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
	}
	
	/*Initialize the operator buttons*/
	private void init_op_buttons()
	{
		JButton button_plus = new JButton("+");
		button_plus.addActionListener(clickOpActionListener);
		button_plus.setBounds(211, 142, 50, 49);
		frame.getContentPane().add(button_plus);
		
		JButton button_minus = new JButton("-");
		button_minus.addActionListener(clickOpActionListener);
		button_minus.setBounds(211, 202, 50, 49);
		frame.getContentPane().add(button_minus);
	}
	
	/*Initialize the equals button*/
	private void init_equals_button()
	{
		JButton button_equals = new JButton("=");
		button_equals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(prev_oper == "+")
				{
					result += curr;
				}
				else if(prev_oper == "-")
				{
					result -= curr;
				}
				
				resultArea.setText(result + "");
				prev_oper = "none";
				currArea.setText("");
			}
		});
		
		button_equals.setBounds(211, 262, 50, 109);
		frame.getContentPane().add(button_equals);
	}
	
	/*Initialize the AC button*/
	private void init_ac_button()
	{
		JButton AC_button = new JButton("AC");
		AC_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result = 0;
				curr = 0;
				resultArea.setText("");
				currArea.setText("");
				prev_oper = "none";
			}
		});
		AC_button.setBounds(132, 322, 50, 49);
		frame.getContentPane().add(AC_button);
	}
	
	/*Initialize the delete button*/
	private void init_del_button()
	{
		JButton del_button = new JButton("<");
		del_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				if(prev_oper == "none")
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
	
	/*Initialize the number buttons*/
	private void init_num_buttons()
	{
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
	}
}
