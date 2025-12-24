package gui.patientdashboard.tabPanels;

import entities.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DoctorsTab extends JPanel {
    private List<Doctor> doctors;
    public DoctorsTab(JFrame frame){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        initUI(frame);
    }
    public void initUI(JFrame frame){


    }
}
