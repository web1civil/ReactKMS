public class Product extends JPanel {
    private String name;
    private String image;
    private double price;
    private CurrencyHook currencyHook;

    public Product(String name, String image, double price, CurrencyHook currencyHook) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.currencyHook = currencyHook;

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