import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.Border;



public class GUI extends JFrame implements ActionListener {
    private static JFrame frameOne;
    private static JFrame frameTwo;
    private static JFrame frameThree;
    private static JFrame frameFour;
    private JPanel panelOne;
    private JPanel panelTwo;
    private JPanel panelThree;
    private JPanel panelFour;
    private JPanel panelFive;
    private JTextField referenceTextField;
    private JTextField checkedReferenceNumberTextField;
    private JTextField customerLastNameTextField;
    private JTextField baggageVolumeTextField;
    private JTextField baggaeWeightTextField;
    private JButton searchBtn;
    private JButton lastNameVerifyButton;
    private JButton extraChargeButton;
    private JLabel checkInErrorLabel;
    private JLabel lastNameErrorLabel;
    private JLabel extraChargeLabel;

    private JButton home;
    private JButton checkInButton;
    private JButton summary;
    private JLabel errorLabel;
    private JLabel ReferenceNumberLabel;

    private String enteredReferenceNumber;
    CheckInCounter checkInCounterObj = new CheckInCounter();
    private String extracharge = "";

    public void createWindowOne() {
        frameOne = new JFrame("Main Window");
        frameOne.setDefaultCloseOperation(frameOne.EXIT_ON_CLOSE);
        createPanelOne();
        frameOne.setSize(1000, 200);
        frameOne.setVisible(true);
        frameOne.setLayout(new BorderLayout());
        frameOne.setLocation(200, 200);
    }

    public void createWindowTwo() {
        frameTwo = new JFrame("Baggage");
        frameTwo.setDefaultCloseOperation(frameTwo.DISPOSE_ON_CLOSE);
        createPanelThree();
        frameTwo.setSize(1050, 200);
        frameTwo.setVisible(true);
        frameTwo.setLayout(new BorderLayout());
        frameTwo.setLocation(200, 200);


    }

    public void createWindowThree() {
        frameThree= new JFrame("Summary");
        frameThree.setDefaultCloseOperation(frameThree.DISPOSE_ON_CLOSE);
        createPanelFour();
        frameThree.setSize(500, 500);
        frameThree.setVisible(true);
        frameThree.setLayout(new BorderLayout());
        frameThree.setLocation(200, 200);

    }

    public void createSummaryWindow() {
        frameFour = new JFrame("Summary");
        frameFour.setDefaultCloseOperation(frameFour.DISPOSE_ON_CLOSE);
        createPanelFive();
        frameFour.setSize(700, 500);
        frameFour.setVisible(true);
        frameFour.setLayout(new BorderLayout());
        frameFour.setLocation(200, 200);

    }


    public void createPanelOne() {
        referenceTextField = new JTextField(16);
        referenceTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel labelOne = new JLabel("Reference Number");
        labelOne.setFont(new Font("Arial", Font.BOLD, 16));

        panelOne = new JPanel(new FlowLayout());
        panelOne.setBackground(new Color(230, 240, 250));
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panelOne.setBorder(padding);

        searchBtn = new JButton("Verify");
        searchBtn.setFont(new Font("Arial", Font.BOLD, 14));
        searchBtn.setBackground(new Color(100, 180, 250)); // Button color
        searchBtn.setForeground(Color.WHITE); // Text color
        searchBtn.setFocusPainted(false);
        searchBtn.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        panelOne.add(labelOne);
        panelOne.add(referenceTextField);
        panelOne.add(searchBtn);

        searchBtn.addActionListener(this);

        errorLabel = new JLabel("**** Invalid Reference Number **** Try again ****");
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setOpaque(true);
        errorLabel.setBackground(Color.RED);
        errorLabel.setForeground(Color.WHITE);
        errorLabel.setBorder(padding);
        errorLabel.setVisible(false);

        checkInErrorLabel = new JLabel("**** You Are Already Checked In ****");
        checkInErrorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        checkInErrorLabel.setOpaque(true);
        checkInErrorLabel.setBackground(Color.RED);
        checkInErrorLabel.setForeground(Color.WHITE);
        checkInErrorLabel.setBorder(padding);
        checkInErrorLabel.setVisible(false);

        panelOne.add(errorLabel);
        panelOne.add(checkInErrorLabel);

        frameOne.getContentPane().add(panelOne, BorderLayout.CENTER);
    }


    private void displayPanelTwo() {
        panelTwo = new JPanel(new FlowLayout());
        panelTwo.setBackground(new Color(230, 240, 250)); // Light blue background

        enteredReferenceNumber = referenceTextField.getText();

        checkedReferenceNumberTextField = new JTextField();
        checkedReferenceNumberTextField.setText(enteredReferenceNumber);
        checkedReferenceNumberTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        checkedReferenceNumberTextField.setEnabled(false);

        ReferenceNumberLabel = new JLabel("Reference Number");
        ReferenceNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panelTwo.add(ReferenceNumberLabel);
        panelTwo.add(checkedReferenceNumberTextField);
        checkInCounterObj.setCurrentReferenceNumber(enteredReferenceNumber);


        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panelTwo.add(lastNameLabel);

        customerLastNameTextField = new JTextField(20);
        customerLastNameTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        panelTwo.add(customerLastNameTextField);

        lastNameVerifyButton = new JButton("Check");
        lastNameVerifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        lastNameVerifyButton.setBackground(new Color(100, 180, 250)); // Button color
        lastNameVerifyButton.setForeground(Color.WHITE); // Text color
        lastNameVerifyButton.setFocusPainted(false);
        lastNameVerifyButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        lastNameVerifyButton.addActionListener(this);
        panelTwo.add(lastNameVerifyButton);

        lastNameErrorLabel = new JLabel("**** Invalid Last Name ****");
        lastNameErrorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lastNameErrorLabel.setOpaque(true);
        lastNameErrorLabel.setBackground(Color.red);
        lastNameErrorLabel.setForeground(Color.WHITE);
        lastNameErrorLabel.setVisible(false);
        panelTwo.add(lastNameErrorLabel);

        if (checkInCounterObj.isCheckin(enteredReferenceNumber)) {
            checkInErrorLabel.setVisible(true);
        } else if (checkInCounterObj.verifyReferenceNumber(enteredReferenceNumber)) {
            this.panelOne.setVisible(false);
            errorLabel.setVisible(false);
            this.panelTwo.setVisible(true);
            frameOne.getContentPane().add(panelTwo, BorderLayout.CENTER);
        } else {
            errorLabel.setVisible(true);
        }
    }



    public void createPanelThree() {
        panelThree = new JPanel(new FlowLayout());
        panelThree.setBackground(new Color(230, 240, 250)); // Light blue background

        JLabel volLabel = new JLabel("Volume of Baggage");
        volLabel.setFont(new Font("Arial", Font.BOLD, 16));
        baggageVolumeTextField = new JTextField(20);
        baggageVolumeTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel bagLabel = new JLabel("Baggage Weight");
        bagLabel.setFont(new Font("Arial", Font.BOLD, 16));
        baggaeWeightTextField = new JTextField(20);
        baggaeWeightTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        extraChargeButton = new JButton("Extra Charge");
        extraChargeButton.setFont(new Font("Arial", Font.BOLD, 14));
        extraChargeButton.setBackground(new Color(100, 180, 250));
        extraChargeButton.setForeground(Color.WHITE);
        extraChargeButton.setFocusPainted(false);
        extraChargeButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        extraChargeButton.addActionListener(this);

        extraChargeLabel = new JLabel();
        extraChargeLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        checkInButton = new JButton("Check-IN");
        checkInButton.setFont(new Font("Arial", Font.BOLD, 14));
        checkInButton.setBackground(new Color(100, 180, 250));
        checkInButton.setForeground(Color.WHITE);
        checkInButton.setFocusPainted(false);
        checkInButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        checkInButton.addActionListener(this);

        panelThree.add(volLabel);
        panelThree.add(baggageVolumeTextField);
        panelThree.add(bagLabel);
        panelThree.add(baggaeWeightTextField);
        panelThree.add(extraChargeButton);
        panelThree.add(extraChargeLabel);
        panelThree.add(checkInButton);

        frameTwo.getContentPane().add(panelThree, BorderLayout.WEST);
    }



    public void createPanelFour() {
        panelFour = new JPanel();
        panelFour.setBackground(new Color(230, 240, 250)); // Light blue background

        home = new JButton("Home");
        home.setFont(new Font("Arial", Font.BOLD, 14));
        home.setBackground(new Color(100, 180, 250));
        home.setForeground(Color.WHITE);
        home.setFocusPainted(false);
        home.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        home.addActionListener(this);

        summary = new JButton("Summary");
        summary.setFont(new Font("Arial", Font.BOLD, 14));
        summary.setBackground(new Color(100, 180, 250));
        summary.setForeground(Color.WHITE);
        summary.setFocusPainted(false);
        summary.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        summary.addActionListener(this);

        panelFour.add(home);
        panelFour.add(summary);

        frameThree.getContentPane().add(panelFour, BorderLayout.CENTER);
    }

    public void createPanelFive() {
        panelFive = new JPanel();
        panelFive.setLayout(new BoxLayout(panelFive, BoxLayout.Y_AXIS));
        panelFive.setBackground(new Color(230, 240, 250));

        JLabel[] labels = new JLabel[]{
                new JLabel("Total " + checkInCounterObj.totalPassengersCheckedIn + " Passengers Checked In"),
                new JLabel("Total " + checkInCounterObj.totalBaggageVolumeCheckedIn + " volume of baggage checked in"),
                new JLabel("Total " + checkInCounterObj.totalBaggageWeightCheckedIn + " weight of baggage checked in"),
                new JLabel("Total " + checkInCounterObj.totalExcessBaggageFeeCollected + " excess baggage fee collected"),
                new JLabel(checkInCounterObj.totalPassengersCheckedIn - checkInCounterObj.getMaxPassengers() > 0 ? "The number of passengers exceeds the limit by " + (checkInCounterObj.totalPassengersCheckedIn - checkInCounterObj.getMaxPassengers()) + " people" : "The total number of passengers does not exceed the limit."),
                new JLabel(checkInCounterObj.totalBaggageVolumeCheckedIn - checkInCounterObj.getMaxBaggageVolume() > 0 ? "The total volume of luggage exceeds the limit by " + (checkInCounterObj.totalBaggageVolumeCheckedIn - checkInCounterObj.getMaxBaggageVolume()) : "The total volume of luggage does not exceed the limit."),
                new JLabel(checkInCounterObj.totalBaggageWeightCheckedIn - checkInCounterObj.getMaxBaggageWeight() > 0 ? "The total weight of luggage exceeds the limit by " + (checkInCounterObj.totalBaggageWeightCheckedIn - checkInCounterObj.getMaxBaggageWeight()) : "The total weight of luggage does not exceed the limit.")
        };

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 16));
            panelFive.add(label);
            panelFive.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        frameFour.getContentPane().add(panelFive, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchBtn) {
            displayPanelTwo();
        }

        if (e.getSource() == lastNameVerifyButton) {
            if (!checkInCounterObj.checkLastName(enteredReferenceNumber.trim(), customerLastNameTextField.getText().trim())) {

                lastNameErrorLabel.setVisible(true);
            } else {
                lastNameErrorLabel.setVisible(false);
                customerLastNameTextField.setEnabled(false);
                lastNameVerifyButton.setVisible(false);
                createWindowTwo();
            }
        }
        if (e.getSource() == extraChargeButton) {
            extracharge = checkInCounterObj.calcExtraCharge(enteredReferenceNumber.trim(), baggaeWeightTextField.getText().trim(),
                    baggageVolumeTextField.getText().trim());
            extraChargeLabel.setText("Have to pay" + extracharge + " Pounds Extra ");
            extraChargeLabel.setVisible(true);
        }

        if (e.getSource() == checkInButton) {
            checkInCounterObj.totalPassengersCheckedIn++;
            frameTwo.getContentPane().removeAll();
            frameTwo.repaint();
            frameTwo.dispose();
            createWindowThree();
        }

        if (e.getSource() == home) {
            frameOne.dispose();
            createWindowOne();
            frameThree.dispose();
        }

        if(e.getSource()==summary) {
            createSummaryWindow();
        }
    }

}
