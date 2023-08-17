import java.util.ArrayList;
import java.util.List;

public class Atores {
    //entity
    private String nomeAtor;
    private Integer identificadorAtor;
    private Integer identificadorUltimoAtor = 0;

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

    // Repository

    public class AtoresRepository {
        private List<Atores> atoresBanco;

        public AtoresRepository() {
            this.atoresBanco = new ArrayList<>();
        }

        public void adicionarAtores(Atores atores) {
            this.atoresBanco.add(atores);
        }

        public Atores buscarAtores(Integer identificadorAtor, String nomeAtor) {
            for (Atores ator : atoresBanco) {
                if (ator.getIdentificadorAtor().equals(identificadorAtor) && ator.getNomeAtor().equals(nomeAtor)) {
                    return ator;
                }
            }
            return null;
        }

        public List<Atores> listarAtores() {
            return new ArrayList<>(atoresBanco);
        }
    }

    // Atores Service

    public class AtoresService {
        private AtoresRepository atoresRepository;

        public AtoresService(AtoresRepository atoresRepository) {
            this.atoresRepository = atoresRepository;
        }

        public void addAtores(Atores ator){
            atoresRepository.adicionarAtores(ator);
        }

        public List<Atores> listarAtores(){
            return atoresRepository.listarAtores();
        }
    }

}
