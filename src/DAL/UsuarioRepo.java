package DAL;
import Domain.Models.CreateUserDTO;
import Domain.Models.UpdateUserDTO;
import Domain.Models.Usuario;
import Domain.Models.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepo {
    private final Connection _conn;

    public UsuarioRepo(Connection conn){
        _conn = conn;
    }

    public void AddUser(CreateUserDTO usuario) throws SQLException{
        String sql = ("INSERT INTO usuario " +
                "(nome, email, matricula, senha, num_contato)" +
                "VALUES (?,?,?,?,?)");

        try (PreparedStatement statement = _conn.prepareStatement(sql)){
            statement.setString(1, usuario.Nome);
            statement.setString(2, usuario.Email);
            statement.setString(3, usuario.Matricula);
            statement.setString(4, usuario.Senha);
            statement.setString(5, usuario.NumContato);
            statement.executeUpdate();
        }
    }

    public void AddUsersWithTransaction(CreateUserDTO usuario) throws SQLException {
        String sql = ("INSERT INTO usuario " +
                "(nome, email, matricula, senha, num_contato)" +
                "VALUES (?,?,?,?,?)");
        try (PreparedStatement statement = _conn.prepareStatement(sql))
        {
            _conn.setAutoCommit(false);

            System.out.println("começou:" + java.time.LocalTime.now());

            for(int i = 0; i < 10000; i++){
                statement.setString(1, usuario.Nome);
                statement.setString(2, usuario.Email);
                statement.setString(3, usuario.Matricula);
                statement.setString(4, usuario.Senha);
                statement.setString(5, usuario.NumContato);
                statement.addBatch();
            }
            statement.executeBatch();
            _conn.commit();

            System.out.println("terminou:" + java.time.LocalTime.now());
        }
        catch (SQLException e){
            _conn.rollback();
            throw e;
        } finally {
            _conn.setAutoCommit(true);
        }
    }

    public UsuarioDTO GetUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try(PreparedStatement statement = _conn.prepareStatement(sql)){
            statement.setInt(1, userId);
            try(ResultSet res = statement.executeQuery()){
                if(res.next()){

                    Usuario usuario = new Usuario();

                    usuario.Id = res.getInt("id");
                    usuario.Nome = res.getString("nome");
                    usuario.Email = res.getString("email");
                    usuario.Senha = "";
                    usuario.NumContato = res.getString("num_contato");

                    return new UsuarioDTO(usuario);
                }
                else{
                    return null;
                }
            }
        }
    }

    public void UpdateUser(int userId, UpdateUserDTO novoUsuario) throws SQLException{
        String sql = "UPDATE usuario " +
                "SET nome = ?, email = ?, num_contato = ? " +
                "WHERE id = ?";
        try(PreparedStatement statement = _conn.prepareStatement(sql)){
            statement.setString(1, novoUsuario.Nome);
            statement.setString(2, novoUsuario.Email);
            statement.setString(3, novoUsuario.NumContato);
            statement.setInt(4, userId);
            statement.executeUpdate();
        }
    }

    public void DeleteUserById(int userId) throws SQLException{
        String sql = "DELETE FROM usuario WHERE id = ?";

        try(PreparedStatement statement = _conn.prepareStatement(sql)){
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }
}


/*    create table usuario (
        id int auto_increment primary key,
        nome varchar(60) NOT NULL,
    email varchar(255) NOT NULL,
    matricula varchar(20) NOT NULL,
    senha varchar(255) NOT NULL,
    num_contato varchar(30) NOT NULL,
    data_criacao timestamp default CURRENT_TIMESTAMP
        );*/
