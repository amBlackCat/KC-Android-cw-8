package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Items> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView itemNameView = findViewById(R.id.itemNameView);
        TextView itemPriceView = findViewById(R.id.itemPriceView);


        // // // // // // // // // // // // // // // // // // // // // //



        Items item1 = new Items("Cheese", 2.0, R.drawable.cheese);

        Items item2 = new Items("Chocolate", 4.5, R.drawable.chocolate);

        Items item3 = new Items("Coffee", 2.9, R.drawable.coffee);

        Items item4 = new Items("Donut", 1.9, R.drawable.donut);

        Items item5 = new Items("Honey", 2.1, R.drawable.honey);

        // // // // // // // // //// // // // // // // // // // // // //


        item.add(item1);
        item.add(item2);
        item.add(item3);
        item.add(item4);
        item.add(item5);


        itemAdapter itemAdapter = new itemAdapter(this,0, item);


        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(itemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Items currentItem = item.get(i);
                Intent intent = new Intent(MainActivity.this,Details.class);

                intent.putExtra("item", currentItem);
                startActivity(intent);
            }
        });




    }
}