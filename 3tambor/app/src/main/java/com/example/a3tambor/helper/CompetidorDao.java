package com.example.a3tambor.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.a3tambor.model.Competidor;

import java.util.ArrayList;
import java.util.List;

public class CompetidorDao implements ICompetidorDAO {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;


    public CompetidorDao(Context context ) {

        DbHelper db = new DbHelper( context );
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

    }

    @Override
    public boolean salvar(Competidor competidor) {
        ContentValues cv = new ContentValues();
        cv.put("nome", competidor.getNomeCompetidor());

        try{
            escreve.insert(DbHelper.TABELA_COMPETIDOR, null, cv);
            Log.i("RESULTADO", "Competidor salvo  com sucesso");
        } catch (Exception e){
            Log.i("RESULTADO", "Erro ao salvar competidor");
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Competidor competidor) {

        ContentValues cv = new ContentValues();
        cv.put("nome", competidor.getNomeCompetidor() );


        try{
            String[] args = { competidor.getId().toString() };
            escreve.update(DbHelper.TABELA_COMPETIDOR, cv, "id=?", args );
            Log.i("RESULTADO", "Sucesso ao atualizar competidor");

        }catch (Exception e){
            Log.i("RESULTADO", "Erro ao atualizar competidor");
            return false;

        }
        return true;
    }

    @Override
    public boolean deletar(Competidor competidor) {

        try{
            String[] args = { competidor.getId().toString() };
            escreve.delete(DbHelper.TABELA_COMPETIDOR, "id=?", args );
            Log.i("RESULTADO", "Sucesso ao remover competidor");

        }catch (Exception e){
            Log.i("RESULTADO", "Erro ao remover competidor");
            return false;

        }

        return true;
    }

    @Override
    public List<Competidor> listar() {

        List<Competidor> competidores = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.TABELA_COMPETIDOR + ";";
        Cursor c = le.rawQuery(sql, null);


        while (c.moveToNext() ){

            Competidor competidor = new Competidor();

            Long id = c.getLong(c.getColumnIndex("id") );
            String nomeCompetidor = c.getString(c.getColumnIndex("nome") );

            competidor.setId( id );
            competidor.setNomeCompetidor( nomeCompetidor );

            competidores.add( competidor );

        }
        return competidores;
    }
}

