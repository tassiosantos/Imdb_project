import java.util.ArrayList;
import java.util.List;

public class Ator {
    //entity
    private String nomeAtor;
    private Integer identificadorAtor;
    private Integer identificadorUltimoAtor = 0;

    public Ator(String nomeAtor) {
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

    public class AtorRepository {
        private List<Ator> atorBanco;

        public AtorRepository() {
            this.atorBanco = new ArrayList<>();
        }

        public void adicionarAtor(Ator ator) {
            this.atorBanco.add(ator);
        }

        public Ator buscarAtor(Integer identificadorAtor, String nomeAtor) {
            for (Ator ator : atorBanco) {
                if (ator.getIdentificadorAtor().equals(identificadorAtor) && ator.getNomeAtor().equals(nomeAtor)) {
                    return ator;
                }
            }
            return null;
        }

        public List<Ator> listarAtor() {
            return new ArrayList<>(atorBanco);
        }
    }

    // Atores Service

    public class AtorService {
        private AtorRepository atorRepository;

        public AtorService(AtorRepository atorRepository) {
            this.atorRepository = atorRepository;
        }

        public void addAtores(Ator ator){
            atorRepository.adicionarAtor(ator);
        }

        public List<Ator> listarAtor(){
            return atorRepository.listarAtor();
        }
    }

}
