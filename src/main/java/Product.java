import javax.swing.*;
import java.awt.*;

public class Product extends JPanel {
    private String name;
    private String image;
    private double price;

    public Product(String name, String image, double price) {
        this.name = name;
        this.image = image;
        this.price = price;

        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Зображення товару (припускається, що воно представлене у вигляді URL)
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel, BorderLayout.CENTER);

        // Інформація про товар (назва та ціна)
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.add(new JLabel(name));
        infoPanel.add(new JLabel("$" + price));

        add(infoPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product Example");
            frame.setSize(300, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Product product = new Product("Sample Product", "https://example.com/product.jpg", 19.99);
            frame.add(product);

            frame.setVisible(true);
        });
    }
}