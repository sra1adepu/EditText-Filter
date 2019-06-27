package com.logicshore.edittextfilter;

/**
 * Created by admin on 26-02-2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Clipcodes on 18/10/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    Context cont;
    LayoutInflater layinf;
    List<PeopleName> peoplelist;
    ArrayList<PeopleName> peoplearray;

    public ListViewAdapter(Context con, List<PeopleName> people){
        cont = con;
        peoplelist = people;
        this.layinf = LayoutInflater.from(cont);
        this.peoplearray = new ArrayList<PeopleName>();
        this.peoplearray.addAll(people);
    }

    public class ViewHolder {
        TextView textView;
    }

    @Override
    public int getCount() {
        return peoplelist.size();
    }

    @Override
    public PeopleName getItem(int position) {
        return peoplelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = layinf.inflate(R.layout.model_item, null);
            holder.textView = (TextView)convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.textView.setText(peoplelist.get(position).getName());


        return convertView;
    }

    public void myFilter(String name){
        name = name.toLowerCase(Locale.getDefault());
        peoplelist.clear();
        if (name.length() == 0){
            peoplelist.addAll(peoplearray);
        } else {
            for (PeopleName PL : peoplearray){
                if (PL.getName().toLowerCase(Locale.getDefault()).contains(name)){
                    peoplelist.add(PL);
                }
            }
        }
        notifyDataSetChanged();
    }
    
//       public Filter getFilter() {

//         return new Filter() {
//             @Override
//             protected FilterResults performFiltering(CharSequence charSequence) {

//                 String charString = charSequence.toString().replaceAll(" ", "").toLowerCase();

//                 if (charString.isEmpty()) {

//                     mFilteredList = aiModelList;
//                 } else {
//                     ArrayList<PharmacyModel> filteredList = new ArrayList<>();
//                     for (PharmacyModel androidVersion : aiModelList) {
//                         if (androidVersion.getPharmacyName().replaceAll(" ", "").toLowerCase().contains(charString) || androidVersion.getLicenseId().replaceAll(" ", "").toLowerCase().contains(charString) || androidVersion.getAddress().replaceAll(" ", "").toLowerCase().contains(charString)) {
//                             filteredList.add(androidVersion);
//                         }
//                     }
//                     mFilteredList = filteredList;
//                 }
//                 FilterResults filterResults = new FilterResults();
//                 filterResults.values = mFilteredList;
//                 return filterResults;
//             }

//             @Override
//             protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                 mFilteredList = (ArrayList<PharmacyModel>) filterResults.values;
//                 notifyDataSetChanged();
//             }
//         };
    }
}
