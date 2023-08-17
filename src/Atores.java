import java.util.List;

public class Atores {
    private String nomeAtor;
    private Integer identificadorAtor;
    private Integer identificadorUltimoAtor=0;

    public Atores(String nomeAtor) {
        this.nomeAtor = nomeAtor;
        this.identificadorAtor = ++identificadorUltimoAtor;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public Integer getIdentificadorAtor() {
        return identificadorAtor;
    }

    public void setIdentificadorAtor(Integer identificadorAtor) {
        this.identificadorAtor = identificadorAtor;
    }
}
