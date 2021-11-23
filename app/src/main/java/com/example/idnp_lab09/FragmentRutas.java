package com.example.idnp_lab09;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentRutas extends Fragment {
    List<Ruta> rutas;

    ListAdapter listAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rutas, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerRutas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        rutas = new ArrayList<Ruta>();
        rutas.add(new Ruta("Canario", "A", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("Cotaspa", "B", "5:00 AM - 7:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "D", "4:00 AM - 8:00 PM"));
        rutas.add(new Ruta("Cotaspa", "A", "6:00 AM - 8:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "B", "5:00 AM - 9:00 PM"));
        rutas.add(new Ruta("Canario", "C", "6:00 AM - 11:00 PM"));
        rutas.add(new Ruta("Cotaspa", "A", "7:00 AM - 9:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "B", "6:00 AM - 10:00 PM"));
        rutas.add(new Ruta("3 de Octubre", "D", "7:00 AM - 11:00 PM"));

        listAdapter = new ListAdapter(rutas, getContext());



        getParentFragmentManager().setFragmentResultListener("buscar", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String filtro =result.getString("filtro");
                Toast.makeText(getContext(), "filtro", Toast.LENGTH_SHORT).show();

                listAdapter.getFilter().filter(filtro);

            }
        });
        recyclerView.setAdapter(listAdapter);




        return rootView;
    }


}