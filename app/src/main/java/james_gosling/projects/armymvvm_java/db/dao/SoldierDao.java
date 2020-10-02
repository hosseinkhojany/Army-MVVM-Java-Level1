package james_gosling.projects.armymvvm_java.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import james_gosling.projects.armymvvm_java.db.entitys.Soldier;

@Dao
public interface SoldierDao {

    @Update
    void updateSoldier(Soldier soldier);

    @Delete
    void deleteSoldier(Soldier soldier);

    @Query("DELETE FROM soldier_table")
    void deleteAll();

    @Query("SELECT * FROM soldier_table")
    LiveData<List<Soldier>> getAll();

    @Query("SELECT * FROM soldier_table WHERE id = :id")
    LiveData<Soldier> searchById(int id);

    @Query("SELECT * FROM soldier_table WHERE name = :name")
    LiveData<Soldier> searchByTitle(String name);

    //onConflict = OnConflictStrategy.IGNORE
    @Insert()
    void insertSoldier(Soldier soldier);

}
