package com.example.recyclerview.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerItemClickListener;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilme = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        //Listagem de filmes
        this.criarFilmes();


        // Configurar Adapter
        Adapter adapter = new Adapter(listaFilme);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {


                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilme.get(position);
                                Toast.makeText(
                                        getApplicationContext()
                                        , "Item pressionado" + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilme.get(position);
                                Toast.makeText(
                                        getApplicationContext()
                                        , "Click longo" + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );


    }

    public void criarFilmes() {
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2021");
        this.listaFilme.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("Liga da Justiça", "Ficção", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("Capitão América - Guerra Civil", "Aventura", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("It: A Coisa", "Terror", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("Pica-Pau:O Filme", "Comédia", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("It: A Coisa", "Terror", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("A Bela e a Fera", "Romance", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("Meu Malvado favorito 3", "Comédia", "2021");
        this.listaFilme.add(filme);
        filme = new Filme("Carros 3", "Comédia", "2021");
        this.listaFilme.add(filme);

    }
}
