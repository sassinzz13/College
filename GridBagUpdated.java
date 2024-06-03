

import java.awt.*;
import java.awt.event.*;
import java.awt.GridBagLayout;

public class GridBagUpdated extends Frame{
    GridBagUpdated(){
        Frame frame = new Frame("GridBagLayout");

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        frame.setLayout(layout);


        gbc.insets = new Insets(2,2,2,2);

        //button 1
        Button b1 = new Button("1 row; 3 cols");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        gbc.ipadx = 0;
        frame.add(b1,gbc);

        //button 2
        Button b2 = new Button("1 col; 3 rows");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.ipady = 0;
        gbc.ipadx = 0;
        frame.add(b2,gbc);

        //button 3
        Button b3 = new Button("2 col; 2 rows");
        b3.setBackground(Color.RED);
        b3.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipady = 20;
        gbc.ipadx = 80;
        frame.add(b3,gbc);

        gbc.insets = new Insets(2,2,2,2);

        //button 4
        Button b4 = new Button("1 col; 3 rows;");
        b4.setBackground(Color.RED);
        b4.setForeground(Color.WHITE);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weighty = 0;
        gbc.ipadx = 0;
        frame.add(b4,gbc);

        //button 5
        Button b5 = new Button("3 cols; 1 row;");
        b5.setBackground(Color.RED);
        b5.setForeground(Color.WHITE);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        gbc.ipadx = 0;
        frame.add(b5,gbc);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Minesweeper m = new Minesweeper();
            }
        });

        MenuBar mb = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu viewMenu = new Menu("View");
        Menu arithmeticMenu = new Menu("Operations");
        Menu exitMenu = new Menu("Exit");
        MenuItem openMenuItem = new MenuItem("Open", new MenuShortcut(KeyEvent.VK_O));
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_E));
        MenuItem addMenuItem = new MenuItem("Add");
        MenuItem subMenuItem = new MenuItem("Subtract");
        MenuItem multMenuItem = new MenuItem("Multiply");
        MenuItem divMenuItem = new MenuItem("Divide");
        CheckboxMenuItem cbm = new CheckboxMenuItem("Check1");

        mb.add(fileMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(arithmeticMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        arithmeticMenu.add(addMenuItem);
        arithmeticMenu.add(subMenuItem);
        arithmeticMenu.add(multMenuItem);
        arithmeticMenu.add(divMenuItem);
        arithmeticMenu.add(cbm);

        mb.add(editMenu);
        mb.add(viewMenu);

        frame.setMenuBar(mb);

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yesno y = new yesno();
                y.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        y.setVisible(false);
                    }
                });
            }
        });

        frame.setSize(800,800);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new GridBagUpdated();

    }
}