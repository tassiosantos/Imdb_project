import java.util.ArrayList;
import java.util.List;

public class Ator {
    //entity
    private String nomeAtor;
    private String dataNascimento;
    private Integer identificadorAtor;
    private Integer identificadorUltimoAtor = 0;
    public Ator(){};
    public Ator(String nomeAtor, String dataNascimento) {
        this.nomeAtor = nomeAtor;
        this.dataNascimento = dataNascimento;
        this.identificadorAtor = ++identificadorUltimoAtor;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public String getDataNascimento(){ return dataNascimento;}

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdentificadorAtor() {
        return identificadorAtor;
    }

    public void setIdentificadorAtor(Integer identificadorAtor) {
        this.identificadorAtor = identificadorAtor;
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
                if (ator.getIdentificadorAtor().equals(identificadorAtor) && ator.getNomeAtor().equals(nomeAtor)) {
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

        public static void addAtores(Ator ator){
            atorRepository.adicionarAtor(ator);
        }

        public static ArrayList<Ator> listarAtor(){
            return atorRepository.listarAtor();
        }

        public static Ator buscarAtorById(int idAtor){
            for (Ator ator: atorRepository.listarAtor()){
                if(ator.getIdentificadorAtor() == idAtor){
                    return ator;
                }
            }
            return null;
        }


    }

}
