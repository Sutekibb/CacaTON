package com.example.ihm2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> titles;
    private ArrayList<String> details;
    private LayoutInflater inflater;
    private boolean[] visibility; // Array para controlar la visibilidad de cada detalle

    public ReportAdapter(Context context, ArrayList<String> titles, ArrayList<String> details) {
        this.context = context;
        this.titles = titles;
        this.details = details;
        inflater = LayoutInflater.from(context);
        visibility = new boolean[titles.size()]; // Inicializa el array con la misma longitud que titles
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_report, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.reportTitle);
            holder.detail = convertView.findViewById(R.id.reportDetail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(titles.get(position));
        holder.detail.setText(details.get(position));

        // Controlar la visibilidad del detalle
        if (visibility[position]) {
            holder.detail.setVisibility(View.VISIBLE);
        } else {
            holder.detail.setVisibility(View.GONE);
        }

        return convertView;
    }

    public void toggleDetail(int position) {
        visibility[position] = !visibility[position]; // Cambia el estado de visibilidad
        notifyDataSetChanged(); // Notifica al adaptador para que se actualice la vista
    }

    static class ViewHolder {
        TextView title;
        TextView detail;
    }
}
