package Entity;

public class PenggunaEntity extends Mahasiswa {

    private String password;

    public PenggunaEntity(String nama, String password, String jeniskelamin, String npm) {
        super(npm, nama, jeniskelamin);
        this.password = password;
    }
    
    public PenggunaEntity(){     
    }
    
    @Override
    public String getNpm() {
        return npm;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
}
