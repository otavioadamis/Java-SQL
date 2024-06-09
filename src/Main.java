import DAL.AnuncioRepo;
import DAL.UsuarioRepo;
import Domain.Models.CreateAnuncioDTO;
import Domain.Models.CreateUserDTO;
import Domain.Models.UpdateUserDTO;
import Domain.Models.Usuario;
import Services.AnuncioService;
import Services.UserService;

import java.math.BigDecimal;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
       try{
           Connection conn = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/bazar",
                   "root",
                   "1234"
           );

           UsuarioRepo usuarioRepo = new UsuarioRepo(conn);
           AnuncioRepo anuncioRepo = new AnuncioRepo(conn);

           UserService userService = new UserService(usuarioRepo);
           AnuncioService anuncioService = new AnuncioService(anuncioRepo);

           CreateUserDTO novoUsuario = new CreateUserDTO();

           novoUsuario.Nome = "UsuarioTeste";
           novoUsuario.Email = "UsuarioTeste@Teste";
           novoUsuario.Senha = "senhalegal";
           novoUsuario.Matricula = "12345678";
           novoUsuario.NumContato = "12345678";

           //Adicionar um usuario
           userService.AddOneUser(novoUsuario);

           /*
           //Adicionar varios usuarios sem transacao
           userService.AddMultiplesUsers(novoUsuario);*/

           /*
           //Adicionar varios usuarios com transacao
           userService.AddMultipleUsersWithTransaction(novoUsuario);*/

           /*
           //consultar um usuario e atualizar um usuario
           userService.GetUserDtoById();

           UpdateUserDTO usuarioAtualizado = new UpdateUserDTO();
           usuarioAtualizado.Nome = "USUARIO UPDATE";
           usuarioAtualizado.Email = "USUARIOUPDATE@UPDATE";
           usuarioAtualizado.NumContato = "51515151";

           userService.UpdateUser();
           userService.GetUserDtoById();*/

           //Adicionando anuncios, (uso de indice no anuncio-categoria)
/*           CreateAnuncioDTO novoAnuncio = new CreateAnuncioDTO();

           BigDecimal decimalFromString = new BigDecimal("123.45");

           novoAnuncio.Nome = "Teste";
           novoAnuncio.Descricao = "Teste";
           novoAnuncio.Preco = decimalFromString;
           novoAnuncio.UserId = 1;
           novoAnuncio.SubCategoria = 1;

           anuncioService.AddMultiplesAnunciosWithTransaction(novoAnuncio);

           System.out.println(anuncioService.GetAnunciosPorSubCategoria(1));*/

       } catch(SQLException e){
           e.printStackTrace();
       }
    }
}