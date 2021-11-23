package com.example.idnp_lab09;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavoritos extends Fragment {
    List<Ruta> rutas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favoritos, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerFavoritos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        rutas = new ArrayList<Ruta>();
        rutas.add(new Ruta("COTUM", "A", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("COTUM", "B", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("COTUM", "D", "5:00 AM - 9:00 PM"));

        ListAdapter listAdapter = new ListAdapter(rutas, getContext(), new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Ruta item) {
                //moveToDescription(item);
            }
        });
        recyclerView.setAdapter(listAdapter);

        return rootView;
    }
}