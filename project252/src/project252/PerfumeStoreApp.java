/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252;

/**
 *
 * @author hp
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfumeStoreApp {
    public static void main(String[] args) {
        StoreFacade storeFacade = new StoreFacade();
        new WelcomeScreen(storeFacade);
    }
}

// واجهة البداية
class WelcomeScreen extends JFrame {
    private StoreFacade storeFacade;

    public WelcomeScreen(StoreFacade storeFacade) {
        this.storeFacade = storeFacade;

        setTitle("Welcome");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // لون الخلفية
        getContentPane().setBackground(Color.decode("#f5edf0"));

        // إضافة صورة
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\CPIT252\\project252\\src\\project252\\Beige and Cream Illustrative Beauty Lounge Logo (1).png");
        Image image = icon.getImage().getScaledInstance(320, 320, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        // نص الترحيب
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(Color.decode("#f5edf0"));
        JLabel welcomeLabel = new JLabel("Welcome to Perfume Store", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.BLACK);
        textPanel.add(welcomeLabel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        // زر الدخول
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#f5edf0"));
        JButton enterButton = new JButton("Enter Main Page");
        enterButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        enterButton.setBackground(Color.decode("#ba8cbe"));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFocusPainted(false);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HomeScreen(storeFacade);
            }
        });
        buttonPanel.add(enterButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

// واجهة اختيار العطر وإظهار إعدادات التكوين
class HomeScreen extends JFrame {
    private StoreFacade storeFacade;

    public HomeScreen(StoreFacade storeFacade) {
        this.storeFacade = storeFacade;

        setTitle("Home");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        getContentPane().setBackground(Color.decode("#f5edf0"));
        
       

        JLabel titleLabel = new JLabel("Choose Perfume:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        titleLabel.setForeground(new Color(51, 51, 51));

        JButton chanelButton = new JButton("Chanel");
        JButton diorButton = new JButton("Dior");
        JButton marcButton = new JButton("Marc");

        Color buttonColor = Color.decode("#ba8cbe");
        chanelButton.setBackground(buttonColor);
        diorButton.setBackground(buttonColor);
        marcButton.setBackground(buttonColor);

        chanelButton.setForeground(Color.WHITE);
        diorButton.setForeground(Color.WHITE);
        marcButton.setForeground(Color.WHITE);

        chanelButton.addActionListener(e -> openDetailScreen("chanel"));
        diorButton.addActionListener(e -> openDetailScreen("dior"));
        marcButton.addActionListener(e -> openDetailScreen("marc"));

        
        add(titleLabel);
        add(chanelButton);
        add(diorButton);
        add(marcButton);
 // عرض إعدادات التكوين
        String currency = storeFacade.getCurrency();
        String region = storeFacade.getRegion();
        JLabel configLabel = new JLabel("Currency: " + currency + " | Region: " + region, SwingConstants.CENTER);
        configLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        configLabel.setForeground(new Color(51, 51, 51));
        add(configLabel);
        setVisible(true);
    }

    private void openDetailScreen(String perfumeType) {
        perfume selectedPerfume = storeFacade.createProduct(perfumeType);
        dispose();
        new DetailScreen(storeFacade, selectedPerfume);
    }
}

// واجهة تفاصيل العطر والدفع
class DetailScreen extends JFrame {
    private JTextField discountCodeField;
    private JComboBox<String> paymentMethodCombo;
    private JLabel finalPriceLabel;
    private StoreFacade storeFacade;
    private perfume selectedPerfume;

    public DetailScreen(StoreFacade storeFacade, perfume selectedPerfume) {
        this.storeFacade = storeFacade;
        this.selectedPerfume = selectedPerfume;

        setTitle("Perfume Details");
        setSize(360, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        getContentPane().setBackground(Color.decode("#f5edf0"));

        JLabel perfumeLabel = new JLabel(selectedPerfume.getName() + ": " + selectedPerfume.getDescription());
        perfumeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        perfumeLabel.setForeground(new Color(51, 51, 51));

        JLabel discountInfoLabel = new JLabel("Use discount code: DISCOUNT10");
        discountInfoLabel.setFont(new Font("Times New Roman", Font.ITALIC, 12));
        discountInfoLabel.setForeground(new Color(153, 0, 0));

        JLabel priceLabel = new JLabel("Price: " + selectedPerfume.getPrice() + " SAR");
        priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        priceLabel.setForeground(new Color(102, 51, 0));

        discountCodeField = new JTextField();
        paymentMethodCombo = new JComboBox<>(new String[]{"PayPal", "Credit Card"});
        finalPriceLabel = new JLabel("Final Price: ");
        finalPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        finalPriceLabel.setForeground(new Color(0, 102, 51));

        JButton payButton = new JButton("Pay");
        payButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        payButton.setBackground(Color.decode("#ba8cbe"));
        payButton.setForeground(Color.WHITE);
        payButton.setFocusPainted(false);
        payButton.addActionListener(e -> processPayment());

        add(perfumeLabel);
        add(discountInfoLabel);
        add(priceLabel);
        add(discountCodeField);
        add(paymentMethodCombo);
        add(payButton);
        add(finalPriceLabel);

        setVisible(true);
    }

    private void processPayment() {
        double finalPrice = storeFacade.applyDiscount(selectedPerfume, "DISCOUNT10".equalsIgnoreCase(discountCodeField.getText()) ? 0.1 : 0.0).getPrice();
        int paymentChoice = paymentMethodCombo.getSelectedIndex() + 1;
        String paymentResult = storeFacade.processPayment(finalPrice, paymentChoice);
        finalPriceLabel.setText("Final Price: " + finalPrice + " SAR - " + paymentResult);
    }
}
