package main;

import dao.PessoaDAO;
import dao.Defesas_de_Torres_JogadosDAO;
import dao.FaseDAO;
import model.Pessoa;
import model.Defesas_de_Torres_Jogados;
import model.Fase;

import java.util.List;

public class Exec {
    public static void main(String[] args) {
        PessoaDAO pessDAO = new PessoaDAO();
        Defesas_de_Torres_JogadosDAO dtjDAO = new Defesas_de_Torres_JogadosDAO();
        FaseDAO fDAO = new FaseDAO();

        try {
            
        	dtjDAO.inserir(new Defesas_de_Torres_Jogados("PV",8));
            
            System.out.println("Defesas de Torres Jogados cadastrados:");
            List<Defesas_de_Torres_Jogados> Defesas_de_Torres_Jogados = dtjDAO.listar();
            Defesas_de_Torres_Jogados.forEach(td -> System.out.println(td.getJogo() + " - " + td.getCod_Pessoa()));
            


            System.out.println("\nPessoas cadastradas:");
            List<Pessoa> Pessoas = pessDAO.listar();
            Pessoas.forEach(p -> System.out.println(p.getCod() + " - " + p.getIdade()));
            
            
            
            System.out.println("\nFases cadastrados:");
            List<Fase> Fase = fDAO.listar();
            Fase.forEach(fa -> System.out.println(fa.getNumero_da_fase() + " - " + fa.getVidas_iniciais() + " - " + fa.getRodadas() + " - " + fa.getMoedas_iniciais() + " - " + fa.getNumero_da_Fase_Liberada()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

