package dao;

import model.Pessoa;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    public void inserir(Pessoa p) throws SQLException {
        String sql = "INSERT INTO Pessoa (Jogo) VALUES (?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdade());
            ps.executeUpdate();
        }
    }

    public List<Pessoa> listar() throws SQLException {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pessoa";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Pessoa(rs.getInt("Cod"), rs.getInt("Idade")));
            }
        }
        return lista;
    }

    public void atualizar(Pessoa p) throws SQLException {
        String sql = "UPDATE Pessoa SET Idade=? WHERE Cod=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdade());
            ps.setInt(2, p.getCod());
            ps.executeUpdate();
        }
    }

    public void excluir(int Cod) throws SQLException {
        String sql = "DELETE FROM Pessoa WHERE Cod=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, Cod);
            ps.executeUpdate();
        }
    }
}

