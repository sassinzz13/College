import java.awt.*;
import java.awt.event.*;

public class MenuSample extends Frame{

    MenuSample(){
        Frame f = new Frame();
/*Label l1 = new Label("Are you sure?");
Button b1 = new Button("Yes");
Button b2 = new Button("No");
Panel p1 = new Panel();
p1.add(b1);
p1.add(b2);
p1.add(l1);
f.add(p1, BorderLayout.SOUTH);
p1.setVisible(false);
*/

        f.setVisible(true);
        f.setSize(400,300);
        f.setTitle("Menu Sample");
        f.setLayout(new FlowLayout());

        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
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

//MenuItem yesMenuItem = new MenuItem("Yes");
//MenuItem noMenuItem = new MenuItem("No");

        mb.add(fileMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(arithmeticMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);



        exitMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                yesno y = new yesno();
                y.setSize(400,300);
                y.setVisible(true);
                y.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        y.setVisible(false);
                    }
                });
            }
        });




        arithmeticMenu.add(addMenuItem);
        arithmeticMenu.add(subMenuItem);
        arithmeticMenu.add(multMenuItem);
        arithmeticMenu.add(divMenuItem);
        arithmeticMenu.add(cbm);

        mb.add(editMenu);
        mb.add(viewMenu);

        f.setMenuBar(mb);
    }




    public static void main(String[] args){
        new MenuSample();
    }
}
