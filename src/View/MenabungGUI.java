package View;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MenabungGUI extends JFrame{
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Calendar calendar1 = Calendar.getInstance();
    private JLabel targetmenabung = new JLabel("Masukkan Target menabung");
    private JLabel nominalmenabung = new JLabel("Masukkan nominal menabung");
    private JTextField txttargetmenabung = new JTextField();
    private JTextField txtnominal = new JTextField();
    private JButton btnsubmit = new JButton(" SUBMIT ");
    private JRadioButton perhari = new JRadioButton("Perhari");
    private JRadioButton perbulan = new JRadioButton("Perbulan");
    private JTextArea tglterkumpul = new JTextArea();
    private JTextArea tglmasuk = new JTextArea();
    private JButton btnkembali = new JButton(" kembali ");
    int targetnabung,nominal,jangkawaktuterkumpul;
    public MenabungGUI() {
        menabung();
    }
    public void menabung(){
        setSize(350 , 370);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        targetmenabung.setBounds(40,20,400,40);
        txttargetmenabung.setBounds(40, 50, 250, 25);
        nominalmenabung.setBounds(40, 70, 400, 40);
        txtnominal.setBounds(40, 100, 250, 25);
        btnsubmit.setBounds(110,130,120,30);
        perhari.setBounds(40, 170, 90, 20);
        perhari.setBackground(Color.getHSBColor(176, 75, 72));;
        perbulan.setBounds(200, 170, 90, 20);
        perbulan.setBackground(Color.getHSBColor(176, 75, 72));
        tglmasuk.setBounds(40, 200, 250, 25);
        tglterkumpul.setBounds(40, 230, 250, 25);
        btnkembali.setBounds(110,270,120,30);

        btnkembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    try{
                    PenggunaGUI view = new PenggunaGUI();
                    dispose();
                    view.setVisible(true);
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "Gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                    }  
                 }
            });

        btnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    try{
                        nominal = Integer.parseInt( txtnominal.getText());
                        targetnabung = Integer.parseInt( txttargetmenabung.getText());
                        jangkawaktuterkumpul= targetnabung/nominal;
                       
                           if(targetnabung<=500000&&nominal<500000){
                       JOptionPane.showMessageDialog(null, "Anda disarankan menabung perhari ","information", JOptionPane.INFORMATION_MESSAGE);  
                    }else if(targetnabung>500000&&nominal<500000){
                           JOptionPane.showMessageDialog(null, "Anda disarankan menabung perhari ","information", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                           JOptionPane.showMessageDialog(null, "Anda disarankan menabung perbulan ","information", JOptionPane.INFORMATION_MESSAGE); 
                    }
                    }catch(Exception e) {
                        JOptionPane.showMessageDialog(null, "gagal ", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
                    }  
                 }
            });


        perhari.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                     if(perhari.isSelected()){
                         
                       perbulan.setSelected(false);
                       try{
                        nominal = Integer.parseInt( txtnominal.getText());
                        targetnabung = Integer.parseInt( txttargetmenabung.getText());
                        jangkawaktuterkumpul= targetnabung/nominal;
                       
                        if(targetnabung==jangkawaktuterkumpul*nominal){   
                            tglmasuk.setText(sdf.format(calendar1.getTime()));
                                 calendar1.add(Calendar.DATE, jangkawaktuterkumpul);
                                     tglterkumpul.setText(sdf.format(calendar1.getTime()));
                                     
                                     AllObjectController.user.InsertDataTabunganPintar(jangkawaktuterkumpul, targetnabung, nominal, nominal);                                
                        }else{
                                tglmasuk.setText(sdf.format(calendar1.getTime()));
                                 calendar1.add(Calendar.DATE, jangkawaktuterkumpul);
                                     tglterkumpul.setText(sdf.format(calendar1.getTime()));
                                     
                                     AllObjectController.user.InsertDataTabunganPintar(jangkawaktuterkumpul, targetnabung, nominal, nominal);             
                        }
                        
                       }catch(Exception exception){
                            JOptionPane.showMessageDialog(null, "Gagal ","information", JOptionPane.INFORMATION_MESSAGE); 
                       } 
                     }   
            }
        });
        
        perbulan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                     if(perbulan.isSelected()){
                         
                       perhari.setSelected(false);
                       try{          
                        nominal = Integer.parseInt( txtnominal.getText());
                        targetnabung = Integer.parseInt( txttargetmenabung.getText());
                        jangkawaktuterkumpul= targetnabung/nominal;
                       
                        if(targetnabung==jangkawaktuterkumpul*nominal){    
                                tglmasuk.setText(sdf.format(calendar1.getTime()));
                                     calendar1.add(Calendar.DATE, jangkawaktuterkumpul*12);
                                         tglterkumpul.setText(sdf.format(calendar1.getTime()));
                                         AllObjectController.user.InsertDataTabunganPintar(jangkawaktuterkumpul, targetnabung, nominal, nominal);
                        }else{
                                tglmasuk.setText(sdf.format(calendar1.getTime()));
                                 calendar1.add(Calendar.DATE, jangkawaktuterkumpul*12);
                                     tglterkumpul.setText(sdf.format(calendar1.getTime()));                          
                                     AllObjectController.user.InsertDataTabunganPintar(jangkawaktuterkumpul, targetnabung, nominal, nominal);
                        }
                        
                       }catch(Exception exception){
                            JOptionPane.showMessageDialog(null, "Gagal ","information", JOptionPane.INFORMATION_MESSAGE); 
                       } 
                     }   
            }
        });
        add(targetmenabung); add(txttargetmenabung); add(nominalmenabung); add(txtnominal);
        add(btnsubmit); add(perhari); add(perbulan); add(tglterkumpul);
        add(tglmasuk); add(btnkembali);
    }
}
