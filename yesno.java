import java.awt.*;
import java.awt.event.*;

class yesno extends Frame{

    yesno(){
        Label l1 = new Label("Are you sure?");
        Button b1 = new Button("Yes");
        Button b2 = new Button("No");
        Panel p1 = new Panel();
        p1.add(b1);
        p1.add(b2);
        add(p1, BorderLayout.SOUTH);
        add(l1, BorderLayout.NORTH);

        setVisible(true);
        setSize(400,300);
        setTitle("YESNO");

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });

    }

    public static void main(String[] args){
        new yesno();
    }
}