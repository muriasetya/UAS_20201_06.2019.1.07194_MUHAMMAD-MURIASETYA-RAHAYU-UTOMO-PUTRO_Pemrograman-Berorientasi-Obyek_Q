package View;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
   private JRadioButton laki = new JRadioButton("Laki-laki");
   private JRadioButton perempuan = new JRadioButton("Perempuan");
   private JTextField txtnama = new JTextField();
   private JTextField txtNPM = new JTextField();
   private JPasswordField txtpassword = new JPasswordField();
   private JTextField txtnama2 = new JTextField();
   private JTextField txtNPM2 = new JTextField();
   private JButton btnInsert = new JButton(" Daftar ");
   private JButton btnlogin = new JButton(" login ");
   private JLabel labelnama = new JLabel("Masukkan Nama : ");
   private JLabel labelNPM = new JLabel("Masukkan NPM : ");
   private JLabel labelpassword = new JLabel("Masukkan Password  : ");
   private JLabel sambutan = new JLabel("Sistem Informasi Tabungan Pintar");
   private JLabel header = new JLabel("Daftar Akun");
   private JLabel header2 = new JLabel("Login Akun");
   private JLabel labelnama2 = new JLabel("Masukkan Nama : ");
   private JLabel labelNPM2 = new JLabel("Masukkan NPM : ");
   private JLabel labelpassword2 = new JLabel("Masukkan Password  : ");;
   private JPasswordField txtpassword2 = new JPasswordField();
   boolean cekjeniskelamin;
    public GUI() {
        initComponent();
    }

    public void initComponent(){
        setSize(800 , 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Judul Program
        sambutan.setBounds(70, 30, 700, 40);
        sambutan.setFont(new Font("Lucida Handwriting", Font.BOLD, 30));

        // Pilih jenis kelamin
        laki.setBounds(30, 150, 90, 20);
        laki.setBackground(Color.getHSBColor(176, 75, 72));
        perempuan.setBounds(125, 150, 90, 20);
        perempuan.setBackground(Color.getHSBColor(176, 75, 72));

        laki.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if (laki.isSelected()){
                    perempuan.setSelected(false);
                    cekjeniskelamin=true;
                }
            }
        });

        perempuan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if (perempuan.isSelected()){
                    laki.setSelected(false);
                    cekjeniskelamin=false;
                }
            }
        });

        // Daftar User
        header.setBounds(40, 110, 200, 30);
        header.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
        labelnama.setBounds(30,180,150,15);
        txtnama.setBounds(30,200,190,25);

        labelpassword.setBounds(30,240,150,15);
        txtpassword.setBounds(30,260,190,25);

        labelNPM.setBounds(30,300,150,15);
        txtNPM.setBounds(30, 320, 190, 25);

        btnInsert.setBounds(30,380,120,30);

        // Login User
        header2.setBounds(560, 110, 200, 30);
        header2.setFont(new Font("Gill Sans MT", Font.BOLD, 20));
        labelpassword2.setBounds(550, 180, 150, 15);
        txtpassword2.setBounds(550, 200, 190, 25);

        labelNPM2.setBounds(550, 240, 150, 15);
        txtNPM2.setBounds(550, 260, 190, 25);

        btnlogin.setBounds(550, 380, 120, 30);

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                                   
                    String password = txtpassword2.getText();
                    String npm = txtNPM2.getText();
                    int data  = AllObjectController.user.login(password, npm);
                        if(IndexOutOfBoundsException()){
                            JOptionPane.showMessageDialog(null, "NPM atau Password salah ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            if (data >= 0 ){
                                AllObjectController.user.login(password, npm);
                                JOptionPane.showMessageDialog(null, "Selamat Datang ", "Login Sukses", JOptionPane.INFORMATION_MESSAGE);
                                PilihGUI costumerz = new PilihGUI();
                                dispose();
                                costumerz.setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(null, "NPM atau Password salah ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }  
                 }

            private boolean IndexOutOfBoundsException() {
                return AllObjectController.user.GetArrayListDataPenggunaIsEmpty();
            }
            });
                    
        
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (cekjeniskelamin==true){
                    String npm = txtNPM.getText();
                    String password = txtpassword.getText();
                    String nama = txtnama.getText();
                    String jeniskelamin = "Laki-Laki";
                    AllObjectController.user.InsertDataPengguna(nama, password, jeniskelamin, npm);
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "Login", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                    }else{
                    String npm = txtNPM.getText();
                    String password = txtpassword.getText();
                    String nama = txtnama.getText();
                    String jeniskelamin = "Perempuan";
                    AllObjectController.user.InsertDataPengguna(nama, password, jeniskelamin, npm);
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses", "Login", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Registrasi Gagal", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });

        add(labelnama); add(txtnama); add(txtpassword); add(labelpassword);
        add(labelNPM); add(txtNPM); add(labelNPM2); add(txtNPM2);
        add(labelnama2); add(txtnama2); add(labelpassword2); add(txtpassword2);
        add(laki); add(perempuan); add(sambutan); add(header);
        add(header2); add(btnInsert); add(btnlogin);
}
void kosong(){
    txtpassword.setText(null);
    txtNPM.setText(null);
    txtnama.setText(null);
}
}
