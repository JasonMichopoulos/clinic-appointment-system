package gui;

import Utils.DateFormatter;
import Utils.Validations;
import entities.Patient;
import enums.Gender;
import enums.LoginStatus;
import enums.RegisterStatus;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.w3c.dom.Text;
import services.PatientServices;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;


public class loginWindow  {

    // Login Fields
    private JTextField amkaField;
    private JTextField patientPhoneField;
    private JTextField doctorsNameField;
    private JTextField doctorsPhoneField;

    //Register Fields
    private JTextField nameRegisterField;
    private JTextField surnameRegisterField;
    private JTextField fathersNameRegisterField;
    private JTextField phoneNumberRegisterField;
    private JTextField amkaPatientRegisterField;
    private JTextField emergencyCallRegisterField;
    private JComboBox<Gender> genderRegisterComboBox;
    private JTextField addressRegisterField;
    private JTextArea notesRegisterAreaField;


    public loginWindow(){
        JFrame frame = new JFrame("Login");
        frame.setName("Login/Register Window");
        frame.setSize(300,300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(Box.createVerticalGlue());
        panel.add(loginButton(frame));
        panel.add(Box.createVerticalStrut(20));
        panel.add(registerButton(frame));
        panel.add(Box.createVerticalGlue());
        panel.add(ExitButton(frame));

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private JButton loginButton(JFrame frame){
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setFocusable(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setFont(new Font("SansSerif", Font.PLAIN,20));
        loginButton.addActionListener(e -> {
            loginDialog(frame);
        });
        return loginButton;
    }

    private JButton registerButton(JFrame frame){
        JButton registerButton = new JButton("Register");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setFocusable(false);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setFont(new Font("SansSerif", Font.PLAIN,20));
        registerButton.addActionListener(e -> {
            registerDialog(frame);
        });
        return registerButton;
    }

    private JButton ExitButton(JFrame frame){
        JButton exitButton = new JButton("EXIT");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setFocusable(false);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.setFont(new Font("SansSerif",Font.PLAIN,20));
        exitButton.addActionListener(e -> {
            frame.dispose();
        });
        return exitButton;
    }

    private JDialog loginDialog(JFrame frame){
        JDialog dialog = new JDialog(frame,"Login",true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(frame);
        dialog.setSize(300,300);
        dialog.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        amkaField = TextField();
        patientPhoneField = TextField();

        panel.add(Box.createVerticalGlue());
        panel.add(Label("AMKA"));
        panel.add(amkaField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Label("Phone Number"));
        panel.add(patientPhoneField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(okayButton(frame));
        panel.add(Box.createVerticalGlue());

        panel.add(loginForDoctorsButton(frame));
        panel.add(Box.createVerticalStrut(5));
        panel.add(closeDialogButton(dialog));

        dialog.setContentPane(panel);
        dialog.setVisible(true);
        return dialog;
    }

    private JDialog registerDialog(JFrame frame){
        JDialog dialog = new JDialog(frame,"Register",true);
        dialog.setSize(300,800);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(frame);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        nameRegisterField = TextField();
        surnameRegisterField = TextField();
        fathersNameRegisterField = TextField();
        phoneNumberRegisterField = TextField();
        amkaPatientRegisterField = TextField();
        emergencyCallRegisterField = TextField();
        genderRegisterComboBox = new JComboBox<Gender>(Gender.values());
        UtilDateModel model = new UtilDateModel();
        model.setSelected(false);
        JDatePanelImpl datePanel = new JDatePanelImpl(model,new Properties());
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateFormatter());
        addressRegisterField = TextField();
        notesRegisterAreaField = new JTextArea();
        notesRegisterAreaField.setLineWrap(true);
        notesRegisterAreaField.setWrapStyleWord(true);

        JButton sumbitButton = new JButton("Sumbit");
        sumbitButton.setFocusable(false);
        sumbitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sumbitButton.setFont(new Font("SansSerif",Font.PLAIN,15));
        sumbitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(Label("Name*"));
        panel.add(nameRegisterField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Surname*"));
        panel.add(surnameRegisterField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Father's Name"));
        panel.add(fathersNameRegisterField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Phone Number*"));
        panel.add(phoneNumberRegisterField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("AMKA*"));
        panel.add(amkaPatientRegisterField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Emergency call"));
        panel.add(emergencyCallRegisterField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Gender*"));
        panel.add(genderRegisterComboBox);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Birth date*"));
        panel.add(datePicker);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Address"));
        panel.add(addressRegisterField);
        panel.add(Box.createVerticalStrut(10));

        panel.add(Label("Notes"));
        panel.add(new JScrollPane(notesRegisterAreaField));
        panel.add(Box.createVerticalStrut(10));

        panel.add(sumbitButton);

        sumbitButton.addActionListener(e -> {
            String name = nameRegisterField.getText();
            String surname = surnameRegisterField.getText();
            String fathersName = fathersNameRegisterField.getText();
            String phoneNumber = phoneNumberRegisterField.getText();
            String amka = amkaPatientRegisterField.getText();
            String emerg_call = emergencyCallRegisterField.getText();
            Gender gender = (Gender) genderRegisterComboBox.getSelectedItem();
            Date selectedDate = (Date) datePicker.getModel().getValue();
            LocalDate localDate=null;
            if(selectedDate!=null){
                localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            String address = addressRegisterField.getText();
            String notes = notesRegisterAreaField.getText();
            String[] required_fields = new String[]{
                    name.trim(),
                    surname.trim(),
                    phoneNumber.trim(),
                    amka.trim()
            };
            String[] non_required_fields = new String[]{
                    fathersName.trim(),
                    emerg_call.trim(),
                    address.trim(),
                    notes.trim()
            };
            for(int i=0;i<non_required_fields.length;i++){
                if(Validations.isBlank(non_required_fields[i])){
                    non_required_fields[i]=null;
                }
                else {
                    non_required_fields[i] = non_required_fields[i].trim();
                }
            }
            for (String requiredField : required_fields) {
                if (Validations.isBlank(requiredField)) {
                    JOptionPane.showMessageDialog(
                            dialog,
                            "Complete the blanks with *",
                            "Blanks not filled",
                            JOptionPane.ERROR_MESSAGE,
                            null
                    );
                    return;
                }
            }
            if(localDate==null || !Validations.validDate(localDate)){
                JOptionPane.showMessageDialog(
                        dialog,
                        "Birth not given or birth > time now",
                        "Invalid date",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }
            if(!Validations.validAMKA(amka)){
                JOptionPane.showMessageDialog(
                        frame,
                        "AMKA invalid",
                        "Invalid info",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }
            if(!Validations.validPhone(phoneNumber)){
                JOptionPane.showMessageDialog(
                        frame,
                        "Phone invalid",
                        "Invalid info",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }


            Patient patient = new Patient(
                    name.trim(),
                    surname.trim(),
                    phoneNumber.trim(),
                    fathersName.trim(),
                    amka.trim(),
                    emerg_call.trim(),
                    gender,
                    localDate,
                    address.trim(),
                    notes.trim()
            );

            RegisterStatus registerStatus = PatientServices.registerPatient(patient);
            if(registerStatus==RegisterStatus.WRONG_AMKA){
                JOptionPane.showMessageDialog(
                        dialog,
                        RegisterStatus.WRONG_AMKA.getDesc(),
                        "invalid info",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }
            if(registerStatus==RegisterStatus.WRONG_PHONE){
                JOptionPane.showMessageDialog(
                        dialog,
                        RegisterStatus.WRONG_PHONE.getDesc(),
                        "invalid info",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }
            if(registerStatus==RegisterStatus.SUCCESSFULL){
                JOptionPane.showMessageDialog(
                        dialog,
                        RegisterStatus.SUCCESSFULL.getDesc(),
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                );
                JOptionPane.showMessageDialog(
                        dialog,
                        "Patient: \n" +
                                name + "\n" +
                                surname + "\n" +
                                phoneNumber + "\n" +
                                fathersName + "\n" +
                                amka + "\n" +
                                emerg_call + "\n" +
                                gender + "\n" +
                                localDate + "\n" +
                                address + "\n" +
                                notes + "\n",
                        "Patient info",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                );
                dialog.dispose();
            }



        });

        dialog.setContentPane(panel);
        dialog.setVisible(true);
        return dialog;
    }

    private JDialog loginForDoctorsDialog(JFrame frame){
        JDialog dialog = new JDialog(frame,"Login for doctors",true);
        dialog.setSize(300,300);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(frame);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        doctorsNameField = TextField();
        doctorsPhoneField = TextField();

        panel.add(Box.createVerticalGlue());
        panel.add(Label("Name"));
        panel.add(doctorsNameField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Label("Phone"));
        panel.add(doctorsPhoneField);
        panel.add(Box.createVerticalGlue());
        panel.add(Box.createVerticalStrut(10));
        panel.add(closeDialogButton(dialog));

        dialog.setContentPane(panel);
        dialog.setVisible(true);
        return dialog;
    }

    private JButton okayButton(JFrame frame){
        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okButton.setFont(new Font("SansSerif",Font.PLAIN,20));
        okButton.setFocusable(false);
        okButton.addActionListener(e -> {
            String amka_patient = amkaField.getText();
            String phone_patient = patientPhoneField.getText();
            if(Validations.isBlank(amka_patient) || Validations.isBlank(phone_patient)) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Fill the blanks",
                        "Empty blanks",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }
            amka_patient = amka_patient.trim();
            phone_patient = phone_patient.trim();

            LoginStatus loggin = PatientServices.loginPatient(amka_patient,phone_patient);
            if(loggin == LoginStatus.AMKA_NOT_FOUND){
                JOptionPane.showMessageDialog(
                        frame,
                        LoginStatus.AMKA_NOT_FOUND.getDesc(),
                        "AMKA",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }
            if (loggin == LoginStatus.PHONE_NOT_FOUND){
                JOptionPane.showMessageDialog(
                        frame,
                        LoginStatus.PHONE_NOT_FOUND.getDesc(),
                        "PHONE",
                        JOptionPane.ERROR_MESSAGE,
                        null
                );
                return;
            }
            if(loggin == LoginStatus.SUCCESSFULL){
                JOptionPane.showMessageDialog(
                        frame,
                        LoginStatus.SUCCESSFULL.getDesc() + " " + amka_patient,
                        "SUCCESSFULL",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                );
            }
        });
        return okButton;
    }


    private JButton loginForDoctorsButton(JFrame frame){
        JButton button = new JButton("Login for doctors");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("SansSerif",Font.PLAIN,15));
        button.setFocusable(false);
        button.addActionListener(e -> {
            Component source = (Component) e.getSource();
            Window window = SwingUtilities.getWindowAncestor(source);
            window.dispose();
            loginForDoctorsDialog(frame);

        });
        return button;
    }

    private JButton closeDialogButton(JDialog dialog){
        JButton button = new JButton("Close");
        button.setFocusable(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("SansSerif",Font.PLAIN,15));
        button.addActionListener(e ->{
            dialog.dispose();
        });
        return button;
    }

    private JLabel Label(String text){
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif",Font.PLAIN,20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;

    }

    private JTextField TextField(){
        JTextField field = new JTextField();
        field.setFont(new Font("SansSerif",Font.PLAIN,20));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        field.setPreferredSize(new Dimension(150,field.getPreferredSize().height));
        field.setMaximumSize(new Dimension(150,25));
        return field;
    }
}
