package james_gosling.projects.armymvvm_java.db.entitys;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//"ali" , "64" , "muslim" , "archer" , "324"
@Entity(tableName = "soldier_table")
public class Soldier{
    @PrimaryKey(autoGenerate = true)
    private int id;
    String name;
    String age;
    String faction;
    String troop;
    String power;

    public Soldier(String name, String age, String faction, String troop, String power) {
        this.name = name;
        this.age = age;
        this.faction = faction;
        this.troop = troop;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getTroop() {
        return troop;
    }

    public void setTroop(String troop) {
        this.troop = troop;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}