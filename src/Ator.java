import java.util.ArrayList;
import java.util.List;

public class Ator extends Artista {
    //entity
    private Integer identificadorAtor;
    private Integer identificadorUltimoAtor = 0;

    public Ator() {
        super();
    }

    ;

    public Ator(String nomeAtor, String dataNascimento) {
        this.nome = nomeAtor;
        this.anoNascimento = dataNascimento;
        this.identificadorAtor = ++identificadorUltimoAtor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeAtor) {
        this.nome = nomeAtor;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getIdentificadorAtor() {
        return identificadorAtor;
    }

    public void setIdentificadorAtor(Integer identificadorAtor) {
        this.identificadorAtor = identificadorAtor;
    }

    @Override
    public String imprimir() {
        return ("ID: " + identificadorAtor + "\nNome: " + nome + "\nAno de nascimento: " + anoNascimento);
    }

    // Repository

    public static class AtorRepository {
        private List<Ator> atorBanco;
        private Integer identificadorUltimoAtor;

        public AtorRepository() {
            this.atorBanco = new ArrayList<>();
            this.identificadorUltimoAtor = 1;
        }

        public void adicionarAtor(Ator ator) {
            ator.setIdentificadorAtor(identificadorUltimoAtor.intValue());
            identificadorUltimoAtor += 1;
            this.atorBanco.add(ator);
        }

        public Ator buscarAtor(Integer identificadorAtor, String nomeAtor) {
            for (Ator ator : atorBanco) {
                if (ator.getIdentificadorAtor().equals(identificadorAtor) && ator.getNome().equals(nomeAtor)) {
                    return ator;
                }
            }
            return null;
        }

        public ArrayList<Ator> listarAtor() {
            return new ArrayList<>(atorBanco);
        }
    }

    // Atores Service

    public static class AtorService {
        private static AtorRepository atorRepository = new AtorRepository();

        public AtorService(AtorRepository atorRepository) {
            this.atorRepository = atorRepository;
        }

        public static void addAtores(Ator ator) {
            atorRepository.adicionarAtor(ator);
        }

        public static ArrayList<Ator> listarAtor() {
            return atorRepository.listarAtor();
        }

        public static Ator buscarAtorById(int idAtor) {
            for (Ator ator : atorRepository.listarAtor()) {
                if (ator.getIdentificadorAtor() == idAtor) {
                    return ator;
                }
            }
            return null;
        }

    }

}
