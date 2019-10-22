package io.aikosoft.heroapp;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Comparator;
import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {

    private List<Hero> heroes;

    HeroAdapter(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(heroes.get(position));
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortByName() {
        heroes.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero hero, Hero t1) {
                return hero.name.compareTo(t1.name);
            }
        });
        notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortByAge() {
        heroes.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero hero, Hero t1) {
                return hero.age - t1.age;
            }
        });
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, age, power;

        ViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.tv_name);
            age = view.findViewById(R.id.tv_age);
            power = view.findViewById(R.id.tv_power_type);

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Intent intent = new Intent(view.getContext(), HeroActivity.class);
                    intent.putExtra("hero", heroes.get(getAdapterPosition()));
                    view.getContext().startActivity(intent);
                    return true;
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), heroes.get(getAdapterPosition()).name, Toast.LENGTH_SHORT).show();
                }
            });
        }

        void bind(Hero hero) {
            name.setText(hero.name);
            age.setText(String.valueOf(hero.age));
            power.setText(hero.powerType);
        }
    }
}
