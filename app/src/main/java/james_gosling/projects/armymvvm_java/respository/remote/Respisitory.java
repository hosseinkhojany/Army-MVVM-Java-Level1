package james_gosling.projects.armymvvm_java.respository.remote;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;
import james_gosling.projects.armymvvm_java.db.DbRoom;
import james_gosling.projects.armymvvm_java.db.dao.SoldierDao;
import james_gosling.projects.armymvvm_java.db.entitys.Soldier;

public class Respisitory {

    public static final String INSERT = "insert";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    private LiveData<List<Soldier>> allSoldiers;
    private SoldierDao soldierDao;
    public static Context context;

    public Respisitory(Application application){
        context = application.getApplicationContext();
        DbRoom dbRoom = DbRoom.getInstance(context);
        soldierDao = dbRoom.soldierDao();
        allSoldiers = soldierDao.getAll();
    }

    public void insert(Soldier soldier){
        new Respisitory.OperationTasker(soldierDao , INSERT).execute(soldier);
    }

    public void update(Soldier soldier){
        new Respisitory.OperationTasker(soldierDao , UPDATE).execute(soldier);
    }

    public void delete(Soldier soldier){
        new Respisitory.OperationTasker(soldierDao , DELETE).execute(soldier);
    }

    public LiveData<List<Soldier>> getAllSoldier(){
        return allSoldiers;
    }


    private static class OperationTasker extends AsyncTask<Soldier , Void , Void> {

        private SoldierDao soldierDao;
        private final String operation;
        public OperationTasker(SoldierDao soldierDao ,String operation) {
            this.soldierDao = soldierDao;
            this.operation = operation;

        }

        @Override
        protected Void doInBackground(Soldier... soldiers) {

            switch (operation){

                case INSERT:
                    soldierDao.insertSoldier(soldiers[0]);
                    break;

                case DELETE:
                    soldierDao.deleteSoldier(soldiers[0]);
                    break;

                case UPDATE:
                    soldierDao.updateSoldier(soldiers[0]);
                    break;

            }


            return null;
        }

    }


}
