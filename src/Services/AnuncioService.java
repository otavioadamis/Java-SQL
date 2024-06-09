package Services;

import DAL.AnuncioRepo;
import DAL.UsuarioRepo;
import Domain.Models.AnuncioDTO;
import Domain.Models.CreateAnuncioDTO;
import Domain.Models.CreateUserDTO;

import java.sql.SQLException;
import java.util.List;

public class AnuncioService {
    private final AnuncioRepo _anuncioRepo;
    public AnuncioService(AnuncioRepo anuncioRepo){
        _anuncioRepo = anuncioRepo;
    }

    public void AddMultiplesAnunciosWithTransaction(CreateAnuncioDTO novoAnuncio) throws SQLException {
        _anuncioRepo.AddAnuncio(novoAnuncio);
    }

    public List<AnuncioDTO> GetAnunciosPorSubCategoria(int subCategoria) throws SQLException {
        return _anuncioRepo.GetAnunciosPorSubCategoria(subCategoria);
    }

}
