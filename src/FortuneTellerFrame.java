import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class FortuneTellerFrame extends JFrame
{
    private JTextArea fortuneArea;
    private JButton readButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private Random rand;
    private int lastIndex = -1;

    public FortuneTellerFrame()
    {
        super("Fortune Teller");

        rand = new Random();
        fortunes = new ArrayList<>();
        loadFortunes();
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JLabel titleLabel = createTitleLabel();
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout( new BorderLayout());
        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setEditable(false);
        fortuneArea.setFont(new Font("Serif", Font.PLAIN, 18));

        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        middlePanel.add(scrollPane, BorderLayout.CENTER);
        add(middlePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        readButton = new JButton("Read My Fourtune!");
        quitButton = new JButton("Quit");

        Font buttonFont = new Font("SansSerif", Font.BOLD, 16);
        readButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        readButton.addActionListener(e -> showRandomFortune());
        quitButton.addActionListener(e -> System.exit(0));

    }

    private JLabel createTitleLabel()
    {
        ImageIcon icon = new ImageIcon("fortune.png");
        JLabel label = new JLabel ("Fortune Teller", icon, JLabel.CENTER);
        Font titleFont = new Font("Serif", Font.BOLD, 36);
        label.setFont(titleFont);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        return label;
    }

    private void loadFortunes()
    {
        fortunes.add("You will ace your next programming lab.");
        fortunes.add("A surprise bug will teach you something new.");
        fortunes.add("Coffee will power your next great idea.");
        fortunes.add("You will forget a semicolon, but find it quickly.");
        fortunes.add("Debugging will be easier than you expect today.");
        fortunes.add("Your code will compile on the first try… maybe.");
        fortunes.add("A group project will actually go smoothly.");
        fortunes.add("You will discover a new favorite shortcut key.");
        fortunes.add("Your next commit message will be legendary.");
        fortunes.add("You will finally understand that confusing error.");
        fortunes.add("Stack Overflow will save you at least once.");
        fortunes.add("You will remember to push to GitHub this time.");
    }

    private void showRandomFortune()
    {
        if(fortunes.isEmpty())
        {
            return;
        }
        int index;
        do
        {
            index= rand.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        String fortune = fortunes.get(index);
        fortuneArea.append(fortunes.get(index));

        fortuneArea.append(fortune+ "\n");
    }

}
