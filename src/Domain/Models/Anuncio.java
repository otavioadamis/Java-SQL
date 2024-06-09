package Domain.Models;

import java.math.BigDecimal;

public class Anuncio {
    public int Id;
    public String Nome;
    public String Descricao;
    public BigDecimal Preco;
    public boolean Aprovado;
    public boolean Vendido;
    public int UserId;
    public int SubCategoriaId;
}

/*
Columns:
        id int AI PK
        nome varchar(60)
        descricao varchar(255)
        preco decimal(10,2)
        aprovado tinyint(1)
        vendido tinyint(1)
        data_postagem timestamp
        usuario_id int
        subcategoria_id int*/
