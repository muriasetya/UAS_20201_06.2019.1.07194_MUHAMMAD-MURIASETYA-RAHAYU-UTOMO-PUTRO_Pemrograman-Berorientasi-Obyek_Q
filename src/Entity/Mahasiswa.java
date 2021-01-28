package Entity;

public abstract class Mahasiswa {
    protected String npm,nama,jeniskelamin;

    public Mahasiswa(String npm, String nama, String jeniskelamin){
        this.npm = npm;
        this.nama = nama;
        this.jeniskelamin = jeniskelamin;
    }

    public Mahasiswa(){  
    }
    public abstract String getNpm();

    public String getnama() {
        return nama;
    }
    public String getjeniskelamin() {
        return jeniskelamin;
    }
    public void setNpm(String npm) {
        this.npm = npm;
    }
    public void setnama(String nama) {
        this.nama = nama;
    }
    public void setjeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }
}


