package app;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
	


public class Program extends JFrame implements ActionListener {

	public static void main(String[] args) {
		RandomNumberGenerator rng = new RandomNumberGenerator(1);
		

        // ============================================================
        // ============================================================
        // WINDOW APP
        JFrame frame = new JFrame("Backpack");
        frame.setSize(400,500);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Please enter the capacity:");
        JTextField textfield = new JTextField(10);
        JButton calculate = new JButton("Calculate");
        panel.add(label);
        panel.add(textfield);
        panel.add(calculate);
        calculate.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		textArea.append(getString(Integer.parseInt(textfield.getText())));
        	}
        });
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO
	}

public static String getString(Integer Capacity) {
	
	RandomNumberGenerator rng = new RandomNumberGenerator(1);
	
	// tworzenie list
	List<Integer> index = new ArrayList<Integer>();
	List<Integer> values = new ArrayList<Integer>();
	List<Integer> weights = new ArrayList<Integer>();
	
	for(int i=0; i<10; i++)
	{
 		index.add(i);
 		values.add(rng.nextInt(1, 29));
 		weights.add(rng.nextInt(1, 29));
	}
	String StrIndex =  "Index:   ";
	String StrValues = "Values:  ";
	String StrWeights ="Weights: ";
    for (int i : index) 
    {
        StrIndex = StrIndex + i + "  ";
    }

    for (int v : values) 
    {
        StrValues = StrValues + v + " ";

    }
    for (int w : weights) 
    {
        StrWeights = StrWeights + w + " ";
    }
    Backpack b1 = new Backpack(Capacity);
    b1.Load(index, values, weights);

    String StrFinalCapacity = "Chosen capacity: " + b1.Capacity;
    String StrFinalWeight = "Backpack weight: " + b1.Load_weights;
    String StrFinalValue = "Backpack value: " + b1.Load_value;

    String FullText = StrIndex + "\n" + StrValues + "\n" + StrWeights
    		+ "\n" + StrFinalCapacity +  "\n" + StrFinalWeight
    		+ "\n" + StrFinalValue + "\n" + "\n";
	return FullText;
}
}
