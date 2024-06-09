package Domain.Models;

public class UsuarioDTO {
    public int Id;
    public String Nome;
    public String Email;
    public String Matricula;
    public String NumContato;
    public UsuarioDTO(Usuario usuario){
        Id = usuario.Id;
        Nome = usuario.Nome;
        Email = usuario.Email;
        Matricula = usuario.Matricula;
        NumContato = usuario.NumContato;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Email='" + Email + '\'' +
                ", Matricula='" + Matricula + '\'' +
                ", NumContato='" + NumContato + '\'' +
                '}';
    }
}
