package gui.doctordashboard;

import javax.swing.*;

public class DoctorDashBoard extends JFrame {

    public DoctorDashBoard(){
        setTitle("Doctor Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setName("DashBoard for Doctors");
        setSize(800,800);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("My appointments", new JPanel());
        tabbedPane.addTab("My patients",new JPanel());
        tabbedPane.addTab("Account",new JPanel());


        panel.add(tabbedPane);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
    }
}
