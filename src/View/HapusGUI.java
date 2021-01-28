package View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class HapusGUI extends JFrame{
    
    private JLabel headerhapus = new JLabel("Hapus Data");
    private JTextField txtnamahapus = new JTextField();
    private JButton btnselesaihapus = new JButton(" Selesai ");
    private JButton btnbackhapus = new JButton(" << Kembali ");
    private JLabel namadihapus = new JLabel("Masukkan nama yang akan dihapus");
    String name;
    public HapusGUI(){
        Hapus();
    }
    public void Hapus(){
        setSize(300 , 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerhapus.setBounds(20, 20, 250, 35);
        headerhapus.setFont(new Font("GeoSlab703 Md BT", Font.BOLD, 30));
        namadihapus.setBounds(50, 60, 150, 15);
        txtnamahapus.setBounds(50, 80, 190, 25);
        btnselesaihapus.setBounds(80,170,120,30);
        btnbackhapus.setBounds(80,210,120,30);

        btnbackhapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    try{
                    GUI awal = new GUI();
                    dispose();
                    awal.setVisible(true);
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                    }  
                 }
            });

            btnselesaihapus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                        try{
                        name = txtnamahapus.getText();
                        int menghapus = AllObjectController.user.hapusnama(txtnamahapus.getText());
                        if(menghapus == 1){
                            JOptionPane.showMessageDialog(null, "Hapus sukses ", "Yeay", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                        }                      
                        }catch(Exception e) {
                            JOptionPane.showMessageDialog(null, "gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                        }  
                     }
                });
        add(headerhapus); add(namadihapus); add(txtnamahapus);
        add(btnselesaihapus); add(btnbackhapus);
    }
}
