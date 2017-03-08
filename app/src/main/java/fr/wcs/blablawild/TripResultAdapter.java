package fr.wcs.blablawild;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import wcs.fr.blablawild.R;



    public class TripResultAdapter extends BaseAdapter {
        private Context context; //context
        private ArrayList<TripResultModel> items; //data source of the list adapter

        //public constructor
        public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size(); //returns total of items in the list
        }

        @Override
        public Object getItem(int position) {
            return items.get(position); //returns list item at the specified position
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).
                        inflate(R.layout.trip_item, parent, false);
            }

            // get current item to be displayed
            TripResultModel currentItem = (TripResultModel) getItem(position);

            // get the TextView for item name and item description
            TextView textViewmFirstname = (TextView)
                    convertView.findViewById(R.id.textViewFirstname);
            TextView textViewmDate = (TextView)
                    convertView.findViewById(R.id.textViewDepartureTime);
            TextView textViewmPrice = (TextView)
                    convertView.findViewById(R.id.textViewPrice);

            //sets the text for item name and item description from the current item object
            textViewmFirstname.setText(currentItem.getmFirstname());
            textViewmDate.setText(currentItem.getmDate().toString());
            textViewmPrice.setText(Integer.toString(currentItem.getmPrice()));

            // returns the view for the current row
            return convertView;
        }
    }





