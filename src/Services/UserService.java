package Services;
import DAL.UsuarioRepo;
import Domain.Models.CreateUserDTO;
import Domain.Models.UpdateUserDTO;
import Domain.Models.UsuarioDTO;

import java.sql.Date;
import java.sql.SQLException;

public class UserService {

    private final UsuarioRepo _userRepo;

    public UserService(UsuarioRepo userRepo){
        _userRepo = userRepo;
    }
    public void AddOneUser(CreateUserDTO usuario) throws SQLException {
        System.out.println("comecou: ");
        _userRepo.AddUser(usuario);
    }

    public void AddMultiplesUsers(CreateUserDTO usuario) throws SQLException{
        System.out.println("começou: " + java.time.LocalTime.now());
        for(int i = 0; i < 10000; i++){
            _userRepo.AddUser(usuario);
        }
        System.out.println("terminou:" + java.time.LocalTime.now());
    }

    public void AddMultipleUsersWithTransaction(CreateUserDTO usuario) throws SQLException{
        _userRepo.AddUsersWithTransaction(usuario);
    }

    public UsuarioDTO GetUserDtoById(int userId) throws SQLException{
        return _userRepo.GetUserById(userId);
    }

    public void UpdateUser(int userId, UpdateUserDTO novoUsuario) throws SQLException{
        _userRepo.UpdateUser(userId, novoUsuario);
    }

    public void DeleteUserById(int userId) throws SQLException {
        _userRepo.DeleteUserById(userId);
    }


}
