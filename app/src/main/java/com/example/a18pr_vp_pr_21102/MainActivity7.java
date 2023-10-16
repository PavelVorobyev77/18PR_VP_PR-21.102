package com.example.a18pr_vp_pr_21102;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    ArrayList<product> products = new ArrayList<product>();
    box_adapter boxAdapter;
    Button btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        btnPrev = findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(v -> {prev();});

// создаем адаптер
        fillData();
        boxAdapter = new box_adapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    public void prev(){
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new product("Product " + i, i * 1000,
                    R.drawable.ic_launcher_foreground, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Товары в корзине:";
        for (product p : boxAdapter.getBox()) {
            if (p.box)
                result += "\n" + p.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}