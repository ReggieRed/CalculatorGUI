import javax.swing.*;

public class Calculate {
    //variables
    private static String prop;
    private static double a = 0;
    private static double b = 0;
    private static double c = 0;

    public double setA(){a = CalcGUI.getA();
    return a;}
    public double setB(){b = CalcGUI.getB();
    return b;}
    public static double calc(){
        a = CalcGUI.getA();
        b = CalcGUI.getB();
        prop = CalcGUI.getP();
        if(prop.equals("+"))
            c = a + b;
        else if(prop.equals("-"))
            c = a - b;
        else if(prop.equals("*"))
            c = a * b;
        else if(prop.equals("%"))
            if(b == 0){
                JOptionPane.showMessageDialog(null, "Error: Division by zero");
                return b;
            }
            else
                c = a / b;
        return c;}
    public String getprop(){return prop;}
    public static double getC(){
        return c;
    }
}