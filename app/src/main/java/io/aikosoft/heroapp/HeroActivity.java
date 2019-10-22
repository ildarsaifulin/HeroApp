package io.aikosoft.heroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class HeroActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        imageView = findViewById(R.id.image_hero);

        Hero hero = (Hero) getIntent().getSerializableExtra("hero");

        if (hero != null) {
            setTitle(hero.name);
            imageView.setImageDrawable(getDrawable(hero.image));
        }
    }
}
