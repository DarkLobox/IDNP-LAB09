package com.example.idnp_lab09;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {
    private List<Ruta> mRutas;
    private List<Ruta> allRutas;

    private LayoutInflater mInflater;
    private Context context;


    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List <Ruta> filterList = new ArrayList<>();
                if (constraint.toString().isEmpty()){
                    filterList.addAll( allRutas);
                }else{
                    for(Ruta r: allRutas){
                        if(r.getEmpresa().toLowerCase(Locale.ROOT).contains(constraint.toString().toLowerCase(Locale.ROOT))){
                            filterList.add(r);
                        }
                    }
                }
                FilterResults fr = new FilterResults();
                fr.values = filterList;

                return fr;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mRutas.clear();
                mRutas.addAll((Collection<? extends Ruta>) results.values);
                notifyDataSetChanged();
            }
        };
        return filter;
    }


    public  interface OnItemClickListener{
        void onItemClick(Ruta item);
    }

    public ListAdapter(List<Ruta> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mRutas = itemList;
        allRutas = new ArrayList<>(mRutas);

    }

    @Override
    public int getItemCount(){
        return mRutas.size();
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_rutas, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mRutas.get(position));
    }

    public void setItems(List<Ruta> items){
        mRutas = items;
        allRutas = new ArrayList<>(mRutas);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView empresa,ruta,horario;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            empresa = itemView.findViewById(R.id.textEmpresa);
            ruta = itemView.findViewById(R.id.textRuta);
            horario = itemView.findViewById(R.id.textHorario);

        }

        void bindData(final Ruta item){
            empresa.setText(item.getEmpresa());
            ruta.setText(item.getLetraRuta());
            horario.setText(item.getHorario());

        }
    }
}
