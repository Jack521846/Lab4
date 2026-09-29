import javax.swing.*;

public class FortuneTellerViewer
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
          FortuneTellerFrame frame = new FortuneTellerFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          java.awt.Toolkit kit = java.awt.Toolkit.getDefaultToolkit();
          java.awt.Dimension screenSize = kit.getScreenSize();
          int width = (int) (screenSize.width * 0.75);
          int height = (int) (screenSize.height * 0.75);
          frame.setSize(width, height);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
        });

    }
}
