
import javax.swing.*;
import java.awt.*;

public class BMSDashboard extends JFrame {

    JLabel voltageLabel, currentLabel;
    JLabel temperatureLabel, socLabel, statusLabel;

    public BMSDashboard() {
        setTitle("Battery Management System Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBackground(new Color(230, 240, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(
                20, 30, 20, 30));

        JLabel title = new JLabel(
                "BATTERY MANAGEMENT SYSTEM",
                SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        voltageLabel = new JLabel("Voltage: 12.6 V");
        currentLabel = new JLabel("Current: 2.5 A");
        temperatureLabel = new JLabel("Temperature: 30 °C");
        socLabel = new JLabel("Battery Charge (SOC): 85%");
        statusLabel = new JLabel("Status: NORMAL");

        Font font = new Font("Arial", Font.PLAIN, 18);

        voltageLabel.setFont(font);
        currentLabel.setFont(font);
        temperatureLabel.setFont(font);
        socLabel.setFont(font);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        statusLabel.setForeground(new Color(0, 130, 0));

        panel.add(title);
        panel.add(voltageLabel);
        panel.add(currentLabel);
        panel.add(temperatureLabel);
        panel.add(socLabel);
        panel.add(statusLabel);

        add(panel);

        JButton updateButton = new JButton("Update Battery Data");
        add(updateButton, BorderLayout.SOUTH);

        updateButton.addActionListener(e -> updateBattery());

        setVisible(true);
    }

    private void updateBattery() {
        double voltage = 12.4 + Math.random() * 0.4;
        double current = Math.random() * 5;
        double temperature = 25 + Math.random() * 20;
        int soc = (int) (50 + Math.random() * 50);

        voltageLabel.setText(
                String.format("Voltage: %.2f V", voltage));
        currentLabel.setText(
                String.format("Current: %.2f A", current));
        temperatureLabel.setText(
                String.format("Temperature: %.1f °C", temperature));
        socLabel.setText("Battery Charge (SOC): " + soc + "%");

        if (temperature > 40 || voltage < 12.0) {
            statusLabel.setText("Status: WARNING");
            statusLabel.setForeground(Color.RED);
        } else {
            statusLabel.setText("Status: NORMAL");
            statusLabel.setForeground(new Color(0, 130, 0));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BMSDashboard::new);
    }
}

