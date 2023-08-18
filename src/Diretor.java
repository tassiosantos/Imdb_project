import java.util.ArrayList;
import java.util.List;

public class Diretor {
    private String nomeDiretor;
    private Integer idDiretor;
//    private Integer anoDiretor;
    private String anoDiretor;

    private Integer idUltimoDiretor = 0;

    public Diretor(){}

    public Diretor (String nomeDiretor, String anoDiretor){
        this.nomeDiretor = nomeDiretor;
        this.idDiretor = ++idDiretor;
        this.anoDiretor = anoDiretor;
    }
    public String getNomeDiretor(){
        return nomeDiretor;
    }
    public void setNomeDiretor (String nomeDiretor){
        this.nomeDiretor = nomeDiretor;
    }

//    public void setAnoDiretor (Integer anoDiretor){
//        this.anoDiretor = anoDiretor;
//    }
    public void setAnoDiretor(String anoDiretor){this.anoDiretor = anoDiretor;}

    public Integer getIdDiretor(){
        return idDiretor;
    }

    public void setIdDiretor(Integer idDiretor) {
        this.idDiretor = idDiretor;
    }
    //Repositório
    public static class DiretorRepository{
        private List<Diretor> diretorList;

        public DiretorRepository(){
            this.diretorList = new ArrayList<>();
        }
        public void addDiretor(Diretor diretor){
            this.diretorList.add(diretor);
        }

        public Diretor buscarDiretor(Integer idDiretor, String nomeDiretor){
            for (Diretor diretor : diretorList){
                if ((diretor.getIdDiretor()).equals(idDiretor) && diretor.getNomeDiretor().equalsIgnoreCase(nomeDiretor)){
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
