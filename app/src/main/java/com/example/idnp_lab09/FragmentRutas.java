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

public class FragmentRutas extends Fragment {
    List<Ruta> rutas;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rutas, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerRutas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        rutas = new ArrayList<Ruta>();
        rutas.add(new Ruta("3 de Octubre", "A", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "B", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "D", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "A", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "B", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "D", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "A", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "B", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "D", "5:00 AM - 9:00 PM"));

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