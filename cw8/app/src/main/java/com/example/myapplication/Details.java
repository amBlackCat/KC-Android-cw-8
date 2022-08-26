package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalis);

        Bundle bundle = getIntent().getExtras();
        Items deliveredItems = (Items) bundle.getSerializable("item");


        ImageView imgView = findViewById(R.id.item_img_view);
        TextView nameview = findViewById(R.id.item_name_view);
        TextView itemPrice = findViewById(R.id.item_price_view);
        TextView itemAboutView = findViewById(R.id.item_about_view);

        imgView.setImageResource(deliveredItems.getItemImg());
        nameview.setText(deliveredItems.getItemName());
        itemPrice.setText(String.valueOf(deliveredItems.getItemPrice()));


    }
}