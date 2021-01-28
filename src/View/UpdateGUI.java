package View;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateGUI extends JFrame {
    private JLabel headerupdate = new JLabel("Update Password");
    private JLabel carinama = new JLabel("Masukkan nama ");
    private JTextField txtnamaupdate = new JTextField();
    private JLabel passbaru = new JLabel("Masukkan Password Baru ");
    private JTextField txtpudatepass = new JTextField();
    private JButton btnselesaiupdate = new JButton(" Selesai ");
    private JButton btnbackupdate = new JButton(" << Kembali ");
    String nama,password;
    int index =0;
    public UpdateGUI(){
        Update();
    }
    
    public void Update(){
        setSize(300 , 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerupdate.setBounds(20, 20, 250, 35);
        headerupdate.setFont(new Font("GeoSlab703 Md BT", Font.BOLD, 30));
        carinama.setBounds(50, 60, 150, 15);
        txtnamaupdate.setBounds(50, 80, 190, 25);
        passbaru.setBounds(50, 110, 150, 25);
        txtpudatepass.setBounds(50, 130, 190, 25);
        btnselesaiupdate.setBounds(80,170,120,30);
        btnbackupdate.setBounds(80,210,120,30);

        btnbackupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    try{
                    GUI awal = new GUI();
                    dispose();
                    awal.setVisible(true);
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                    }  
                 }
            });

            btnselesaiupdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                        try{
                        int mengupdate = AllObjectController.user.update(txtnamaupdate.getText(),txtpudatepass.getText());
                        if(mengupdate == 1){
                        JOptionPane.showMessageDialog(null, "Update sukses ", "info", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }catch(Exception e) {
                            JOptionPane.showMessageDialog(null, "Gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                        }  
                     }
                });

        add(carinama); add(headerupdate); add(txtnamaupdate); add(passbaru);
        add(txtpudatepass); add(btnselesaiupdate); add(btnbackupdate);
    }
}
