import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

/**
 * Created by drewhoo on 10/19/16.
 */
public class BorderTest {
    public static ArrayList<JComponent> createFields(){
        ArrayList<JComponent> cmpnt = new ArrayList<>();
        JComponent txt1 = new JTextField("Hello!", 20);
        JComponent txt2 = new JTextField("Hello!", 20);
        JComponent txt3 = new JTextField("Hello!", 20);
        JComponent txt4 = new JTextField("Hello!", 20);
        JComponent txt5 = new JTextField("Hello!", 20);
        JComponent txt6 = new JTextArea("Hello!\na\nab\nabc", 3, 20);
        JComponent txt7 = new JTextArea("Hello!\na\nab\nabc", 3, 20);

        JComponent[] temp = {txt1, txt2, txt3, txt4, txt5, txt7, txt6};
        cmpnt.addAll(Arrays.asList(temp));
        return cmpnt;
    }

    public static ArrayList<Border> createBorders(){
        ArrayList<Border> borders = new ArrayList<>();

        Border red = new LineBorder(Color.red, 5);
        Border green = new LineBorder(Color.green, 5);
        Border blue = new LineBorder(Color.blue, 5);
        Border greenBorder = new TitledBorder(green, "A Green Border");
        Border redBorder = new TitledBorder(red, "A Red Border");
        Border redGreen = new CompoundBorder(red, green);

        Border ba = new CompoundBorder(red , green);
        Border bb = new CompoundBorder(ba, blue);
        Border bc = new CompoundBorder(greenBorder, red);
        Border bd = new TitledBorder(redGreen, "A Red-Green Border");
        Border be = new CompoundBorder(greenBorder, redBorder);
        Border bf = new TitledBorder(redGreen, "A Bordered Scroll Pane");

        Border[] temp = {ba, bb, bc, bd, be, bf, redBorder, blue};
        borders.addAll(Arrays.asList(temp));
        return borders;
    }

    public static void display(JFrame frame){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(650, 300);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();


        ArrayList<JComponent> fields = createFields();
        ArrayList<Border> borders = createBorders();

        int counter = 0;
        for (JComponent jc : fields){
            if(counter == 5){
                JScrollPane sp = new JScrollPane(jc);
                sp.setBorder(borders.get(counter));
                sp.createVerticalScrollBar();
                sp.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
                panel.add(sp);
            } else if (counter == 6){
                jc.setBorder(borders.get(counter + 1));
                JScrollPane sp = new JScrollPane(jc);
                sp.setBorder(borders.get(counter));
                sp.createVerticalScrollBar();
                sp.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
                panel.add(sp);
            } else {
                jc.setBorder(borders.get(counter));
                panel.add(jc);
            }
            counter++;
        }
        frame.setContentPane(panel);
        display(frame);
    }
}
