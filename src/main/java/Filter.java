
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartExample extends JFrame {

    private CatalogPanel catalogPanel;

    public ShoppingCartExample() {
        setTitle("Онлайн каталог товарів");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        catalogPanel = new CatalogPanel();
        add(catalogPanel, BorderLayout.CENTER);

        FilterPanel filterPanel = new FilterPanel(catalogPanel); // Передаем ссылку на CatalogPanel
        add(filterPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCartExample());
    }

    class Product extends JPanel {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;

            initUI();
        }

        private void initUI() {
            setLayout(new BorderLayout());

            JLabel nameLabel = new JLabel(name);
            add(nameLabel, BorderLayout.CENTER);

            JLabel priceLabel = new JLabel("$" + price);
            add(priceLabel, BorderLayout.SOUTH);

            JButton addToCartButton = new JButton("Додати до кошика");
            addToCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(Product.this, "Товар " + name + " додано до кошика!");
                }
            });

            add(addToCartButton, BorderLayout.NORTH);
        }

        public String getCategory() {
            return category;
        }
    }
public class CatalogPanel extends JPanel {
    private List<Product> products;
    private CurrencyHook currencyHook = new CurrencyHook();

    public CatalogPanel() {
        setLayout(new FlowLayout());

        products = new ArrayList<>(); // Используйте поле класса, а не локальную переменную
        products.add(new Product("Товар 1", "https://example.com/product1.jpg", 29.99, currencyHook));
        products.add(new Product("Товар 2", "https://example.com/product2.jpg", 39.99, currencyHook));
        products.add(new Product("Товар 3", "https://example.com/product3.jpg", 49.99, currencyHook));

        updateUI(); // Вызов метода для инициализации интерфейса
    }

    public void filterByCategory(String category) {
        removeAll();
        for (Product product : products) {
            if (category.equals("Всі") || category.equals(product.getCategory())) {
                add(product);
            }
        }
        revalidate();
        repaint();
    }

    private void updateUI() {
        for (Product product : products) {
            add(product);
        }
    }
}

    public class FilterPanel extends JPanel {
        private JComboBox<String> categoryComboBox;

        public FilterPanel(CatalogPanel catalogPanel) {
            setLayout(new FlowLayout());

            categoryComboBox = new JComboBox<>();
            categoryComboBox.addItem("Всі");
            categoryComboBox.addItem("Електроніка");
            categoryComboBox.addItem("Одяг");

            categoryComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedCategory = (String) categoryComboBox.getSelectedItem();
                    catalogPanel.filterByCategory(selectedCategory);
                }
            });

            add(new JLabel("Обрати категорію: "));
            add(categoryComboBox);
        }
    }
}