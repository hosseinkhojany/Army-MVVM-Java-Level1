package james_gosling.projects.armymvvm_java.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import james_gosling.projects.armymvvm_java.db.entitys.Soldier;
import james_gosling.projects.armymvvm_java.respository.remote.LocalRespository;

public class ArmyViewModel extends AndroidViewModel {

    private LocalRespository localRespository;
    private LiveData<List<Soldier>> allSoldiers;

    public ArmyViewModel(@NonNull Application application){
        super(application);

        localRespository = new LocalRespository(application);

        allSoldiers = localRespository.getAllSoldier();


    }

    public void insert (Soldier soldier){
        localRespository.insert(soldier);
    }

    public void update (Soldier soldier){
        localRespository.update(soldier);
    }

    public void delete (Soldier soldier){
        localRespository.delete(soldier);
    }

    public LiveData<List<Soldier>> getAllSoldiers() {
        return allSoldiers;
    }
}
