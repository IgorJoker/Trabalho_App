package com.example.a3tambor.helper;

import com.example.a3tambor.model.Competidor;

import java.util.List;

public interface ICompetidorDAO {
    public boolean salvar(Competidor competidor);
    public boolean atualizar(Competidor competidor);
    public boolean deletar(Competidor competidor);
    public List<Competidor> listar();
}
