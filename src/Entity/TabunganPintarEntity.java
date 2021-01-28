package Entity;

public class TabunganPintarEntity {
    private int jangkawaktuterkumpul,target,menabung,skalamenabung;

    public TabunganPintarEntity(int jangkawaktuterkumpul, int target, int menabung, int skalamenabung) {
        this.jangkawaktuterkumpul = jangkawaktuterkumpul;
        this.target = target;
        this.menabung = menabung;
        this.skalamenabung = skalamenabung;
    }

    public TabunganPintarEntity() {
    }
    public int getjangkawaktuterkumpul() {
        return jangkawaktuterkumpul;
    }
    public int gettarget() {
        return target;
    }
    public int getmenabung() {
        return menabung;
    }
    public int getskalamenabung() {
        return skalamenabung;
    }
}
