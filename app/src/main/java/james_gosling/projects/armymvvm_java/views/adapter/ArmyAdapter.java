package james_gosling.projects.armymvvm_java.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import james_gosling.projects.armymvvm_java.R;
import james_gosling.projects.armymvvm_java.db.entitys.Soldier;

public class ArmyAdapter extends RecyclerView.Adapter<ArmyAdapter.ArmyViewHolder> {

    private List<Soldier> soldiers = new ArrayList<>();
    onItemClickListener listener;

    @Override
    public void onBindViewHolder(@NonNull ArmyViewHolder holder, int position) {

        Soldier currentSoldier = soldiers.get(position);
        holder.name.setText(currentSoldier.getName());
        holder.age.setText(currentSoldier.getAge());
        holder.faction.setText(currentSoldier.getFaction());
        holder.troop.setText(currentSoldier.getTroop());
        holder.power.setProgress(Integer.valueOf(currentSoldier.getPower()));
        if (currentSoldier.getTroop().equals("dragon") ||
                currentSoldier.getTroop().equals("Dragon")){
            holder.soldier_img.setImageResource(R.drawable.ic_dragon);
        }else if(currentSoldier.getTroop().equals("knight")||
                currentSoldier.getTroop().equals("Knight")){
            holder.soldier_img.setImageResource(R.drawable.ic_knight);
        }else if(currentSoldier.getTroop().equals("merlin")||
                currentSoldier.getTroop().equals("Merlin")){
            holder.soldier_img.setImageResource(R.drawable.ic_merlin);

        }

    }

    @NonNull
    @Override
    public ArmyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_item,parent , false);
        return new ArmyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return soldiers.size();
    }

    public void setSoldiers(List<Soldier> soldiers)
    {
        this.soldiers = soldiers;
        notifyDataSetChanged();
    }

    public Soldier getCurrent(int position){
        return soldiers.get(position);
    }

    public class ArmyViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView age;
        private TextView faction;
        private TextView troop;
        ImageView soldier_img;
        private ProgressBar power;

        public ArmyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            soldier_img = itemView.findViewById(R.id.sol_img);
            age = itemView.findViewById(R.id.age);
            faction = itemView.findViewById(R.id.faction);
            troop = itemView.findViewById(R.id.troop);
            power = itemView.findViewById(R.id.power);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.onClick(soldiers.get(getAdapterPosition()));
                    }
                }
            });

        }
    }

    public interface onItemClickListener{
        void onClick(Soldier soldier);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener = listener;
    }

}
