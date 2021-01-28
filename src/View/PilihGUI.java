package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilihGUI extends JFrame{
    private JButton btnViewData = new JButton(" view ");
    private JButton btnMenabung = new JButton(" Menabung ");
    public PilihGUI() {
        pilih();
    }
    public void pilih(){
        setSize(300 , 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnViewData.setBounds(80,170,120,30);
        btnMenabung.setBounds(80,210,120,30);

        btnViewData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    try{
                    PenggunaGUI pemgguna = new PenggunaGUI();
                    dispose();
                    pemgguna.setVisible(true);
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                    }  
                 }
            });

            btnMenabung.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                        try{
                        MenabungGUI menabung = new MenabungGUI();
                        dispose();
                        menabung.setVisible(true);
                        }catch(Exception e) {
                            JOptionPane.showMessageDialog(null, "Gagal", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                        }  
                     }
                });
        
        add(btnViewData);
        add(btnMenabung);
    }
    
}
