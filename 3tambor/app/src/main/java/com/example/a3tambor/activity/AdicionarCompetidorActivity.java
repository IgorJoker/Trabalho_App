package com.example.a3tambor.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a3tambor.R;
import com.example.a3tambor.adapter.CompetidorAdapter;
import com.example.a3tambor.helper.CompetidorDao;
import com.example.a3tambor.helper.RecyclerItemClickListener;
import com.example.a3tambor.model.Competidor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdicionarCompetidorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CompetidorAdapter competidorAdapter;
    private List<Competidor> listaCompetidor = new ArrayList<>();
    private Competidor competidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_competidor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Competidor competidor = listaCompetidor.get(position);

                Intent intent = new Intent(AdicionarCompetidorActivity.this, AdicionarCompetidor.class);
                intent.putExtra("competidor", (Serializable) competidor);

                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                competidor = listaCompetidor.get(position);

                AlertDialog.Builder dialog = new AlertDialog.Builder(AdicionarCompetidorActivity.this);

                dialog.setTitle("Confirmar exclusão");
                dialog.setMessage("Desejar excluir o competidor: " + competidor.getNomeCompetidor() + "?");

                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        CompetidorDao competidorDao = new CompetidorDao( getApplicationContext() );
                        if ( competidorDao.deletar(competidor) ){

                            carregarListaCompetidor();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao deletar competidor!",
                                    Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(getApplicationContext(),
                                    "Erro ao deletar competidor!",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                dialog.setNegativeButton("Não", null);

                dialog.create();
                dialog.show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarCompetidor.class);
                startActivity(intent);
            }
        });
    }

    public void carregarListaCompetidor(){


        CompetidorDao competidorDao = new CompetidorDao( getApplicationContext() );
        listaCompetidor = competidorDao.listar();

        competidorAdapter = new CompetidorAdapter( listaCompetidor );

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(competidorAdapter);

    }

    @Override
    protected void onStart() {
        carregarListaCompetidor();
        super.onStart();
    }

}
