package gui.patientdashboard;

import gui.patientdashboard.tabPanels.DoctorsTab;

import javax.swing.*;

public class PatientDashBoard extends JFrame {

    public PatientDashBoard(){
        setTitle("Patient Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setName("DashBoard for Patients");
        setSize(800,800);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("New Appointment", new JPanel());
        tabbedPane.addTab("My appointments", new JPanel());
        tabbedPane.addTab("Doctors",new DoctorsTab());
        tabbedPane.addTab("Account",new JPanel());

        panel.add(tabbedPane);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
    }
}
