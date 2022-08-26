package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;



public class itemAdapter extends ArrayAdapter {

    List<Items> itemsList;

    public itemAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        itemsList = objects;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_row, parent, false);

        Items currentItem = itemsList.get(position);



        TextView itemNameView = view.findViewById(R.id.itemNameView);
        TextView itemPriceView = view.findViewById(R.id.itemPriceView);
        ImageView itemImgView = view.findViewById(R.id.itemImg);


        itemNameView.setText(currentItem.getItemName());
        itemPriceView.setText(String.valueOf(currentItem.getItemPrice()));
        itemImgView.setImageResource(currentItem.getItemImg());

        ImageView deleteBtn = view.findViewById(R.id.imageView);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
             Items removeItem = itemsList.get(position);
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setMessage("Are you sure you want to delete that ?")
                        .setTitle("Confirmation").setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                itemsList.remove(removeItem);
                                notifyDataSetChanged();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                builder.show();


            }
        });




        return view;




    }









}
