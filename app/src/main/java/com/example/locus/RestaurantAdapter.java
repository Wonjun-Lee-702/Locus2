package com.example.locus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<RestaurantListItem> {

    private Context rContext;
    private List<RestaurantListItem> restaurantList = new ArrayList<>();

    public RestaurantAdapter(Context context, ArrayList<RestaurantListItem> list) {
        super(context, 0 , list);
        rContext = context;
        restaurantList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(rContext).inflate(R.layout.restaurant_image_list_item,parent,false);

        RestaurantListItem currentRestaurant = restaurantList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.icon);
        image.setImageResource(currentRestaurant.getrImageDrawable());

        TextView name = (TextView) listItem.findViewById(R.id.name);
        name.setText(currentRestaurant.getrName());

        return listItem;
    }
}
