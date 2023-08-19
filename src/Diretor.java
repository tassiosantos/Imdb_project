import java.util.ArrayList;
import java.util.List;

public class Diretor extends Artista{

    private Integer idDiretor;
    private Integer idUltimoDiretor = 0;

    public Diretor(){
        super();
    }

    public Diretor (String nomeDiretor, String anoDiretor){
        this.nome = nomeDiretor;

        this.anoNascimento = anoDiretor;
    }
    public String getNome(){
        return this.nome;
    }

    public void setNome (String nomeDiretor){
        this.nome = nomeDiretor;
    }

    public void setAnoNascimento(String anoDiretor){this.anoNascimento = anoDiretor;}

    public Integer getIdDiretor(){
        return idDiretor;
    }

    public void setIdDiretor(Integer idDiretor) {
        this.idDiretor = idDiretor;
    }

    @Override
    public String imprimir() {
        return ("ID: " + idDiretor + "\nNome: " + nome + "\nAno de nascimento: " + anoNascimento);
    }

    //Repositório
    public static class DiretorRepository{
        private List<Diretor> diretorList;
        private int ultimoId;

        public DiretorRepository(){
            this.diretorList = new ArrayList<>();
            this.ultimoId = 1;
        }

        public void addDiretor(Diretor diretor){
            diretor.setIdDiretor(this.ultimoId);
            this.ultimoId++;
            this.diretorList.add(diretor);

        }

        public Diretor buscarDiretor(Integer idDiretor, String nomeDiretor){
            for (Diretor diretor : diretorList){
                if ((diretor.getIdDiretor()).equals(idDiretor) && diretor.getNome().equalsIgnoreCase(nomeDiretor)){
            return diretor;
                }
            }
            return null;
        }
        public ArrayList<Diretor> listarDiretor(){
            return new ArrayList<>(diretorList);
        }
        //Service

    }

    public static class DiretorService{
        private static DiretorRepository diretorRepository = new DiretorRepository();

        public DiretorService (DiretorRepository diretorRepository){
            this.diretorRepository = diretorRepository;
        }

        public static void addDiretor(Diretor diretor){
            diretorRepository.addDiretor(diretor);
        }
        public static ArrayList<Diretor> listarDiretor(){
            return diretorRepository.listarDiretor();
        }

        public static Diretor buscarDiretorById(int idDiretor){
            for (Diretor diretor: diretorRepository.listarDiretor()){
                if(diretor.getIdDiretor() == idDiretor){
                    return diretor;
                }
            }
            return null;
        }
    }
}
