package Model;
import Entity.TabunganPintarEntity;
import java.util.ArrayList;
public class TabunganPintarModel {
    protected ArrayList<TabunganPintarEntity> DataTabunganPintarEntityArrayList;
    public TabunganPintarModel() {
        DataTabunganPintarEntityArrayList= new ArrayList<TabunganPintarEntity>();
    }
    public void InsertDataTabunganPintar(TabunganPintarEntity DataTabunganPintarEntity){
        DataTabunganPintarEntityArrayList.add(DataTabunganPintarEntity);
    }
    public ArrayList <TabunganPintarEntity> tabungan(){
        return DataTabunganPintarEntityArrayList;
    }
    public TabunganPintarEntity muriasetya07194_TabunganPintar(int indeks){
        return DataTabunganPintarEntityArrayList.get(indeks);
    }   
}
