package View;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenggunaGUI extends JFrame {
    private JLabel datauser = new JLabel("Data Pengguna");
    private JTextArea datausertabungan = new JTextArea();
    private JTextArea datausertabungan2 = new JTextArea();
    private JButton btnhapus = new JButton(" hapus ");
    private JButton btnupdate = new JButton(" update ");
    private JButton btnback = new JButton(" << Kembali ");
    public PenggunaGUI() {
        init();
    }

    public void init(){
        setSize(500 , 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        datauser.setBounds(30,20,400,40);
        datauser.setFont(new Font("GeoSlab703 Md BT", Font.BOLD, 30));
        datausertabungan.setBounds(30,60,250,200);
        datausertabungan.setText(datauser());

        datausertabungan2.setBounds(30, 300, 250, 100);
        datausertabungan2.setText(datauser2());

        btnupdate.setBounds(320,110,120,30);
        btnhapus.setBounds(320,170,120,30);
        btnback.setBounds(320,230,120,30);

        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    try{
                    JOptionPane.showMessageDialog(null, "Kembali awal" , "info", JOptionPane.INFORMATION_MESSAGE);
                    GUI awal = new GUI();
                    dispose();
                    awal.setVisible(true);
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                    }  
                 }
            });

            btnupdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                        try{
                        UpdateGUI updatewindow = new UpdateGUI();
                        dispose();
                        updatewindow.setVisible(true);
                        }catch(Exception e) {
                            JOptionPane.showMessageDialog(null, "Gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                        }  
                     }
                });

                btnhapus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                            try{
                            HapusGUI windowhapus = new HapusGUI();
                            dispose();
                            windowhapus.setVisible(true);
                            }catch(Exception e) {
                                JOptionPane.showMessageDialog(null, "Gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                            }  
                         }
                    });


        add(datauser); add(datausertabungan); add(btnback);
        add(btnhapus); add(btnupdate); add(datausertabungan2);

    }
    String datauser(){
        for(int a=0;a<AllObjectController.user.GetArrayListPenggunaSize();a++){
        String text = "nama = "+AllObjectController.user.costumer(a).getnama()+"\n"               
                    + "Password = "+AllObjectController.user.costumer(a).getpassword()+"\n"
                    + "Jenis Kelamin = "+AllObjectController.user.costumer(a).getjeniskelamin()+"\n"
                    + "NPM = "+AllObjectController.user.costumer(a).getNpm()+"\n";
        return text;
    }
    return null;
}
String datauser2(){
    for(int b=0;b<AllObjectController.user.GetArrayListPenggunaSize();b++){
    String text2 = "Nominal Menabung = "+AllObjectController.user.muriasetya07194_TabunganPintar(b).getmenabung()+"\n"
                + "Target Menabung = "+AllObjectController.user.muriasetya07194_TabunganPintar(b).gettarget()+"\n";
    return text2;
}
return null;
}
}

