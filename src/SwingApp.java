import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JOptionPane;
import DawidBeans.MySuperBean;
import java.awt.Color;

/**
 Simple harness for testing GUI code.

 <P>To use this class, edit the code to suit your needs.
*/
public final class SwingApp {

  /**
   Build and display minimal GUI.

   <P>The GUI has a label and an OK button.
   The OK button launches a simple message dialog.
   No menu is included.
  */
  public static void main(String... aArgs){
	SwingApp app = new SwingApp();
    app.buildAndDisplayGui();
  }

  // PRIVATE

  private void buildAndDisplayGui(){
    JFrame frame = new JFrame("Test Frame");
    buildContent(frame);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(350, 500);
    frame.setVisible(true);
  }

  private void buildContent(JFrame aFrame){
    JPanel panel = new JPanel();
    panel.add(new JLabel("Hello"));
    JButton ok = new JButton("OK");
    ok.addActionListener(new ShowDialog(aFrame));
    panel.add(ok);
    aFrame.getContentPane().add(panel);

    MySuperBean mySuperBean = new MySuperBean();
    mySuperBean.setText("Hello!");
    mySuperBean.setPossitionX(20);
    mySuperBean.setPossitionY(70);
    panel.add(mySuperBean);

    MySuperBean mySuperBean_1 = new MySuperBean();
    mySuperBean_1.setPossitionY(70);
    mySuperBean_1.setTextColor(Color.BLACK);
    mySuperBean_1.setText("I'm beans");
    mySuperBean_1.setForeground(Color.BLACK);
    mySuperBean_1.setBackground(Color.ORANGE);
    panel.add(mySuperBean_1);

    MySuperBean mySuperBean_2 = new MySuperBean();
    mySuperBean_2.setText("I'm bean too");
    panel.add(mySuperBean_2);
  }

  private static final class ShowDialog implements ActionListener {
    /** Defining the dialog's owner JFrame is highly recommended. */
    ShowDialog(JFrame aFrame){
      fFrame = aFrame;
    }
    @Override public void actionPerformed(ActionEvent aEvent) {
      JOptionPane.showMessageDialog(fFrame, "This is a dialog");
    }
    private JFrame fFrame;
  }
}
