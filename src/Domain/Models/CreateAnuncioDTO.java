package Domain.Models;

import java.math.BigDecimal;

public class CreateAnuncioDTO {
    public String Nome;
    public String Descricao;
    public BigDecimal Preco;
    public int SubCategoria;
    public int UserId;
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
