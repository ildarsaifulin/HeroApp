package io.aikosoft.heroapp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HeroAdapter(getHeroes());
        recyclerView.setAdapter(adapter);

    }

    List<Hero> getHeroes() {
        List<Hero> heroes = new ArrayList<>();

        heroes.add(new Hero("Superman", 36, "Lazer eyes", R.drawable.superman));
        heroes.add(new Hero("Dedpul", 17, "Bullets", R.drawable.dedpul));
        heroes.add(new Hero("Green man", 45, "Powerful ideas", R.drawable.freenman));
        heroes.add(new Hero("Ironman", 50, "Mega mind", R.drawable.ironman));
        heroes.add(new Hero("Spiderman", 17, "As a spider", R.drawable.spiderman));
        heroes.add(new Hero("Captain America", 40, "Very powerful", R.drawable.captain));
        heroes.add(new Hero("Batman", 50, "Can sometimes fly", R.drawable.batman));
        heroes.add(new Hero("Flash", 25, "Very fast runner", R.drawable.flash));
        heroes.add(new Hero("Thor", 37, "Thunder", R.drawable.thor));
        heroes.add(new Hero("Loki", 34, "Lier", R.drawable.loki));
        return heroes;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortByName(View view) {
        adapter.sortByName();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sortByAge(View view) {
        adapter.sortByAge();
    }
}
