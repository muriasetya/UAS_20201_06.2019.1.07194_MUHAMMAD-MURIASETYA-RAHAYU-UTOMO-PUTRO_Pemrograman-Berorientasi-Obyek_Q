package Controller;

import Entity.PenggunaEntity;
import Entity.TabunganPintarEntity;

public class PenggunaController implements ControllerInterfaces {
    int indexLogin=0;
    AllObjectModel AllObject = new AllObjectModel();
    public PenggunaController() {
    }
    public PenggunaEntity PenggunaEntity(){
        return AllObject.penggunaModel.showDataPengguna(indexLogin);
    }
    public int hapusnama(String nama){
        return AllObject.penggunaModel.hapusnama(nama);
    }
    public int update(String nama,String password){
        return AllObject.penggunaModel.update(nama,password);
    }
    public void InsertDataPengguna(String nama, String password,String jeniskelamin, String npm){
        PenggunaEntity penggunaModel = new PenggunaEntity(nama, password, jeniskelamin, npm);
        AllObject.penggunaModel.InsertDataPengguna(penggunaModel);
    }
    public void InsertDataTabunganPintar(int jangkawaktuterkumpul, int target, int menabung, int skalamenabung){
        TabunganPintarEntity tabunganModel = new TabunganPintarEntity(jangkawaktuterkumpul, target, menabung, skalamenabung);
        AllObject.tabunganModel.InsertDataTabunganPintar(tabunganModel);
    }
    public int GetArrayListPenggunaSize(){
        return AllObject.penggunaModel.GetArrayListPenggunaSize();
    }
    public PenggunaEntity costumer(int index){
        return AllObject.penggunaModel.costumer(index);
    }
    public boolean GetArrayListDataPenggunaIsEmpty(){
        return AllObject.penggunaModel.GetArrayListDataPenggunaIsEmpty();
    }
    public TabunganPintarEntity muriasetya07194_TabunganPintar(int indeks){
        return AllObject.tabunganModel.muriasetya07194_TabunganPintar(indeks);
    }

    @Override
    public int login(String password,String npm) {
        return AllObject.penggunaModel.CekData(password,npm);
    }
}
