package Domain.Models;
public class Usuario {
    public int Id;
    public String Nome;
    public String Email;
    public String Matricula;
    public String Senha;
    public String NumContato;
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
