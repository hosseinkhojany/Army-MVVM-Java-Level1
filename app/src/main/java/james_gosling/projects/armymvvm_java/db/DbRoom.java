package james_gosling.projects.armymvvm_java.db;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import james_gosling.projects.armymvvm_java.db.dao.SoldierDao;
import james_gosling.projects.armymvvm_java.db.entitys.Soldier;

/* main database */
@Database(entities = {Soldier.class} , version = 1 , exportSchema = false)
public abstract class DbRoom extends RoomDatabase {

    public abstract SoldierDao soldierDao();

    private static DbRoom instance;

    public static synchronized DbRoom getInstance(Context context){

        if (instance == null){
            //create database on data/data/package-project/army.db
            instance = Room.databaseBuilder(context , DbRoom.class , "army").
                    fallbackToDestructiveMigration().
                    addCallback(new Callback(){
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            new FirstDatas(instance).execute();
                        }

                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            super.onOpen(db);
                        }
                    }).build();
        }

        return instance;
    }

    public static class FirstDatas extends AsyncTask<Void , Void , Void>{

        SoldierDao dao;
        public FirstDatas(DbRoom db){
            dao = db.soldierDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            dao.insertSoldier(new Soldier("ali" , "64" , "muslim" , "archer" , "324"));

            return null;
        }
    }

}
