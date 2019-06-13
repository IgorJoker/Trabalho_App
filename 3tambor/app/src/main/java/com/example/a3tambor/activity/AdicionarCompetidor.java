package com.example.a3tambor.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.a3tambor.R;
import com.example.a3tambor.helper.CompetidorDao;
import com.example.a3tambor.model.Competidor;

public class AdicionarCompetidor extends AppCompatActivity {

    private TextInputEditText editCompetidor;
    private Competidor competidorAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competidor);

        editCompetidor = findViewById(R.id.textCompetidor);

        competidorAtual = (Competidor) getIntent().getSerializableExtra("competidor");

        if ( competidorAtual != null ){
            editCompetidor.setText( competidorAtual.getNomeCompetidor() );
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_competidor, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.itemSalvar:

                CompetidorDao competidorDao = new CompetidorDao( getApplicationContext() );

                if ( competidorAtual != null ){

                    String nomeCompetidor = editCompetidor.getText().toString();
                    if (!nomeCompetidor.isEmpty() ){

                        Competidor competidor = new Competidor();
                        competidor.setNomeCompetidor( nomeCompetidor );
                        competidor.setId( competidorAtual.getId() );


                        if ( competidorDao.atualizar( competidor )){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao atualizar competidor!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao atualizar competidor!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {//salvar

                    String nomeCompetidor = editCompetidor.getText().toString();
                    if (!nomeCompetidor.isEmpty() ){
                        Competidor competidor = new Competidor();
                        competidor.setNomeCompetidor( nomeCompetidor );

                        if ( competidorDao.salvar( competidor ) ){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao salvar cmpoetidor!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao salvar competidor!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }






                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
