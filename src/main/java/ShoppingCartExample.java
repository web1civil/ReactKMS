import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartExample extends JFrame {

    public ShoppingCartExample() {
        setTitle("Онлайн каталог товарів");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        CatalogPanel catalogPanel = new CatalogPanel();
        add(catalogPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCartExample());
    }
}

class Product extends JPanel {
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

        JLabel imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.add(new JLabel(name));
        infoPanel.add(new JLabel("$" + price));

        add(infoPanel, BorderLayout.SOUTH);

        JButton addToCartButton = new JButton("Додати до кошика");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Логіка для додавання товару до кошика
                JOptionPane.showMessageDialog(Product.this, "Товар " + name + " додано до кошика!");
            }
        });

        add(addToCartButton, BorderLayout.NORTH);
    }
}

class CatalogPanel extends JPanel {
    public CatalogPanel() {
        setLayout(new FlowLayout());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Товар 1", "https://example.com/product1.jpg", 29.99));
        products.add(new Product("Товар 2", "https://example.com/product2.jpg", 39.99));
        products.add(new Product("Товар 3", "https://example.com/product3.jpg", 49.99));

        for (Product product : products) {
            add(product);
        }
    }
}