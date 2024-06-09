package DAL;

import Domain.Models.AnuncioDTO;
import Domain.Models.CreateAnuncioDTO;
import Domain.Models.Usuario;
import Domain.Models.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnuncioRepo {
    private final Connection _conn;

    public AnuncioRepo(Connection conn){
        _conn = conn;
    }

    public void AddAnuncio(CreateAnuncioDTO novoAnuncio) throws SQLException {
        String sql = "INSERT INTO anuncio (nome,descricao,preco,aprovado,vendido,usuario_id,subcategoria_id) " +
                "values (?,?,?,?,?,?,?)";

        try (PreparedStatement statement = _conn.prepareStatement(sql)){
            _conn.setAutoCommit(false);

            System.out.println("começou:" + java.time.LocalTime.now());

            for(int i = 0; i < 10000; i++){
                statement.setString(1, novoAnuncio.Nome);
                statement.setString(2, novoAnuncio.Descricao);
                statement.setBigDecimal(3, novoAnuncio.Preco);
                statement.setBoolean(4, true);
                statement.setBoolean(5, false);
                statement.setInt(6, novoAnuncio.UserId);
                statement.setInt(7, novoAnuncio.SubCategoria);
                statement.addBatch();
            }
            statement.executeBatch();
            _conn.commit();

            System.out.println("terminou:" + java.time.LocalTime.now());
        } catch (SQLException e){
            _conn.rollback();
            throw e;
        } finally {
            _conn.setAutoCommit(true);
        }
    }

    public List<AnuncioDTO> GetAnunciosPorSubCategoria(int subCategoria) throws SQLException {
        String sql = "SELECT * FROM anuncio WHERE subcategoria_id = ?";
        List<AnuncioDTO> anuncios = new ArrayList<>();

        try (PreparedStatement statement = _conn.prepareStatement(sql)) {

            statement.setInt(1, subCategoria);
            try (ResultSet res = statement.executeQuery()) {
                while (res.next()) {

                    AnuncioDTO anuncio = new AnuncioDTO();

                    anuncio.Id = (res.getInt("id"));
                    anuncio.Nome = (res.getString("nome"));
                    anuncio.Descricao = (res.getString("descricao"));
                    anuncio.Preco = (res.getBigDecimal("preco"));
                    anuncio.DataPostagem = (res.getTimestamp("data_postagem"));
                    anuncio.SubCategoria = (res.getInt("subcategoria_id"));
                    anuncios.add(anuncio);
                }
            }
        }

        return anuncios;
    }
}

/*Columns:
        id int AI PK
        nome varchar(60)
        descricao varchar(255)
        preco decimal(10,2)
        aprovado tinyint(1)
        vendido tinyint(1)
        data_postagem timestamp
        subcategoria_id int*/
