import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcGUI{
    //variables
    private static double a = 0;
    private static double b = 0;
    private static double c = 0;
    private static String prop;
    private static String field;
    static JTextField ans = new JTextField("");

    //main and methods
    public static void main(String[] args)
    {
        //variables

        //lets add some buttons
        JPanel p = new JPanel();
        GridLayout grid = new GridLayout(5, 3);
        //add a dial-pad
        String no[] = {"1", "2", "3",
                "4", "5", "6",
                "7", "8", "9",
                "0", "+", "-",
                "%", "*", "="};
        JButton[] buttons = new JButton[no.length];
        p.setLayout(grid);
        for(int i = 0; i < no.length; i++){
            buttons[i] = new JButton(no[i]);
        }
        for(int i = 0; i < no.length; i++) {
            p.add(buttons[i]);
        }

        //lets create our text field!
        setText("");

        //set up listeners
        class Listen1 implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource() instanceof JButton){
                    String text = ((JButton) e.getSource()).getText();
                    if (text.equals("+") || text.equals("-") ||
                            text.equals("*") || text.equals("%")) {
                        if(a != 0){
                            JOptionPane.showMessageDialog(null, "Please re-enter second term and press =");
                        }
                        else {
                            if(ans.getText().equals(""))
                                JOptionPane.showMessageDialog(null, "Please enter a value");
                            else
                                a = Double.parseDouble(ans.getText());
                            prop = text;
                            ans.setText("");
                        }
                    } else if(text.equals("=")) {
                        if(ans.getText().equals(""))
                            JOptionPane.showMessageDialog(null, "Please enter a value");
                        else {
                            b = Double.parseDouble(ans.getText());
                            ans.setText("");
                            Calculate.calc();
                            c = Calculate.getC();
                            ans.setText(Double.toString(c));
                            a = 0;
                            b = 0;
                        }
                    }
                    else {
                        if (ans.getText().equals(Double.toString(c))) {
                            ans.setText("");
                            ans.setText(ans.getText() + text);
                        }
                        else
                            ans.setText(ans.getText() + text);
                    }
            }
            }
        }

        //lets grab whats in our text field
        field = ans.getText();

        //lets "listen" to out buttons
        ActionListener listen = new Listen1();
        for(int i = 0; i < no.length; i++){
            buttons[i].addActionListener(listen);
        }

        //lets try building a window
        JFrame calc = new JFrame("Calculator");
        calc.add(ans, BorderLayout.NORTH);
        calc.add(p, BorderLayout.CENTER);
        calc.setSize(200, 250);
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }

    public static JTextField setText(String text){
        ans.setText(text);
        ans.setPreferredSize(new Dimension(200, 30));
        ans.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return ans;
    }

    public static double getA(){return a;}
    public static double getB(){return b;}
    public static String getP(){return prop;}
    public static String getF(){return field;}
}
