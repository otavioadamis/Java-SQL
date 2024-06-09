package Domain.Models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AnuncioDTO {
    public int Id;
    public String Nome;
    public String Descricao;
    public BigDecimal Preco;
    public Timestamp DataPostagem;
    public int SubCategoria;

    @Override
    public String toString() {
        return "AnuncioDTO{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Descricao='" + Descricao + '\'' +
                ", Preco=" + Preco +
                ", DataPostagem=" + DataPostagem +
                ", SubCategoria=" + SubCategoria +
                '}';
    }
}
