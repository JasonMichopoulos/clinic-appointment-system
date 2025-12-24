package gui.patientdashboard.tabPanels;

import dao.DoctorDAO;
import entities.Doctor;

import javax.swing.*;
import java.awt.*;
import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;
import java.util.Objects;


public class SearchDoctorDialog extends JDialog {
    private JComboBox<String> comboBox;
    private DoctorDAO ddao = new DoctorDAO();
    public SearchDoctorDialog(){
        setTitle("Search Doctor");
        setName("Search Doctor");
        setSize(300,150);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(comboBox());
        panel.add(Box.createVerticalStrut(5));
        panel.add(doneButton());

        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton doneButton(){
        JButton button = new JButton("Done");
        button.setFocusable(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> {
            String selected_sector = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
            if(selected_sector.equalsIgnoreCase("OLA")){
                return;
            }

        });
        return button;
    }

    private JComboBox<String> comboBox(){
        comboBox = new JComboBox<>();
        String[] sectors = new String[]{
                "OLA",
                "Kardiologos",
                "Orthopedikos",
                "Gunekologos",
                "Pathologos",
                "Neurologos",
                "Orilas",
                "Xeirourgos",
                "Pediatros",
                "Ofthalmiatros"
        };
        for(String sector : sectors){
            comboBox.addItem(sector);
        }
        comboBox.setPreferredSize(new Dimension(comboBox.getPreferredSize().width,50));
        comboBox.setMaximumSize(new Dimension(200,50));

        return comboBox;
    }
}
