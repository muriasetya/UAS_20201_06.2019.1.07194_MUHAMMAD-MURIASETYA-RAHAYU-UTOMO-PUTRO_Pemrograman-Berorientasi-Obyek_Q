package Model;

import Entity.PenggunaEntity;
import java.util.ArrayList;

public class PenggunaModel implements ModelInterfaces {
    private ArrayList<PenggunaEntity> DataPenggunaEntityArrayList;

    public PenggunaModel() {
        DataPenggunaEntityArrayList= new ArrayList<PenggunaEntity>();
    }
        
    
    @Override
    public int CekData(String password,String npm){
        int loop=0;
        if(DataPenggunaEntityArrayList.isEmpty()){
            loop=-1;
        }else{
            for(int a=0;a<DataPenggunaEntityArrayList.size();a++){
                if(DataPenggunaEntityArrayList.get(a).getpassword().equals(password)&&DataPenggunaEntityArrayList.get(a).getNpm().equals(npm)){
                    loop=a;
                    break;
                }else{
                    loop=-2;
                }
            }
        }
        return loop;
    }
     
     public int hapusnama(String nama){
        int Status;
        if(carinama(nama)!=-1){     
            DataPenggunaEntityArrayList.remove(carinama(nama));
                Status=1;
        }else{
            Status=0;
        }
        return Status;
   }
     
     public int update(String nama,String password){
        int Status;
        if(carinama(nama)!=-1){     
            DataPenggunaEntityArrayList.get(carinama(nama)).setpassword(password);
                Status=1;
        }else{
            Status=0;
        }
        return Status;
    }
     
      private int carinama(String nama){
       int indeks=-1;
       
       for(int a=0;a<DataPenggunaEntityArrayList.size();a++){
           if(nama.equals(DataPenggunaEntityArrayList.get(a).getnama())){
               indeks=a;
               break;
           }
       }
       return indeks;
   }
      public void InsertDataPengguna(PenggunaEntity muriasetya07194_dataPenggunaEntity){
          DataPenggunaEntityArrayList.add(muriasetya07194_dataPenggunaEntity);
      }
      public int GetArrayListPenggunaSize(){
        return DataPenggunaEntityArrayList.size();
      }
      public PenggunaEntity costumer(int index){
          return DataPenggunaEntityArrayList.get(index);
      }
      public boolean GetArrayListDataPenggunaIsEmpty(){
          return DataPenggunaEntityArrayList.isEmpty();
      }
      public PenggunaEntity showDataPengguna(int indexLogin){
          return DataPenggunaEntityArrayList.get(indexLogin);
      }
}
