package source;
import java.awt.*;
import java.awt.event.*;

public class Nokia3210 extends Frame {

    public static void main(String[] args) {
    	
        TextField tf1 = new TextField(20);
        TextField tf2 = new TextField(20);
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button b10 = new Button("0");
        Button b11 = new Button("#");

        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(4, 3));
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);
        p1.add(b8);
        p1.add(b9);
        p1.add(b10);
        p1.add(b11);

        Frame f = new Frame();
        f.add(tf1, BorderLayout.NORTH);
        f.add(tf2, BorderLayout.SOUTH);
        f.add(p1, BorderLayout.CENTER);
        f.setVisible(true);
        f.setSize(200, 200);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '1');
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '2');
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '3');
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '4');
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '5');
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '6');
            }
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '7');
            }
        });

        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '8');
            }
        });

        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '9');
            }
        });

        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '0');
            }
        });

        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText(tf1.getText() + '#');
                String entry = tf1.getText();
                int ctr = 0;

                for (int x = 0; x < entry.length() - 1; x++) {
                    ctr++;
                    if (entry.charAt(x) != entry.charAt(x + 1)) {
                        switch (entry.charAt(x)) {
                            case '1':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'A'); break;
                                    case 2: tf2.setText(tf2.getText() + 'B'); break;
                                    case 3: tf2.setText(tf2.getText() + 'C'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '2':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'D'); break;
                                    case 2: tf2.setText(tf2.getText() + 'E'); break;
                                    case 3: tf2.setText(tf2.getText() + 'F'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '3':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'G'); break;
                                    case 2: tf2.setText(tf2.getText() + 'H'); break;
                                    case 3: tf2.setText(tf2.getText() + 'I'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '4':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'J'); break;
                                    case 2: tf2.setText(tf2.getText() + 'K'); break;
                                    case 3: tf2.setText(tf2.getText() + 'L'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '5':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'M'); break;
                                    case 2: tf2.setText(tf2.getText() + 'N'); break;
                                    case 3: tf2.setText(tf2.getText() + 'O'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '6':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'P'); break;
                                    case 2: tf2.setText(tf2.getText() + 'Q'); break;
                                    case 3: tf2.setText(tf2.getText() + 'R'); break;
                                    case 4: tf2.setText(tf2.getText() + 'S'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '7':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'T'); break;
                                    case 2: tf2.setText(tf2.getText() + 'U'); break;
                                    case 3: tf2.setText(tf2.getText() + 'V'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '8':
                                switch (ctr) {
                                    case 1: tf2.setText(tf2.getText() + 'W'); break;
                                    case 2: tf2.setText(tf2.getText() + 'X'); break;
                                    case 3: tf2.setText(tf2.getText() + 'Y'); break;
                                    case 4: tf2.setText(tf2.getText() + 'Z'); break;
                                    default: tf2.setText("error");
                                }
                                break;
                            case '9':
                                tf2.setText(tf2.getText() + ' ');
                                ctr = 0;
                                break;
                            case '0':
                                ctr = 0;
                                break;
                        }
                        ctr = 0;
                    }
                }
            }
        });
    }
}
