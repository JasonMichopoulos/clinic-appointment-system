package gui.patientdashboard.tabPanels;

import dao.DoctorDAO;
import entities.Doctor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DoctorsTab extends JPanel {
    private List<Doctor> doctors;
    private JTable table;
    private DoctorDAO ddao = new DoctorDAO();
    public DoctorsTab(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        table = initializeTable();
        table.setFillsViewportHeight(true);
        int desiredHeight = 150;
        table.setPreferredScrollableViewportSize(new Dimension(table.getPreferredScrollableViewportSize().width, desiredHeight));
        JScrollPane scrollPane = new JScrollPane(initializeTable());
        scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, desiredHeight));

        this.add(scrollPane);
        this.add(BookButton());
        this.add(SearchButton());
    }

    private JTable initializeTable(){
        doctors = ddao.findAll();
        String[] columnNames = {"ID", "First Name", "Last Name", "Phone Number", "Sector"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (Doctor doctor : doctors) {
            Object[] row = {
                    doctor.getId(),
                    doctor.getFirstName(),
                    doctor.getLastName(),
                    doctor.getPhoneNumber(),
                    doctor.getSector()
            };
            model.addRow(row);
        }
        table = new JTable(model);


        return table;
    }

    private JButton BookButton(){
        JButton button = new JButton("Book Your Appointment");
        button.setFocusable(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("SansSerif",Font.PLAIN,15));
        button.putClientProperty("JButton.buttonType","text");
        return button;
    }

    private JButton SearchButton(){
        JButton button = new JButton("Search For Doctor");
        button.setFocusable(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("SansSerif",Font.PLAIN,15));
        button.putClientProperty("JButton.buttonType","text");
        button.addActionListener(e -> {
            new SearchDoctorDialog();
        });
        return button;
    }





}
