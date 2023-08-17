import java.util.ArrayList;
import java.util.List;

public class Diretor {
    private String nomeDiretor;
    private Integer idDiretor;
    private Integer anoDiretor;
    private Integer idUltimoDiretor = 0;

    public Diretor (String nomeDiretor){
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

    public void setAnoDiretor (Integer anoDiretor){
        this.anoDiretor = anoDiretor;
    }

    public Integer getIdDiretor(){
        return idDiretor;
    }

    public void setIdDiretor(Integer idDiretor) {
        this.idDiretor = idDiretor;
    }
    //Repositório
    public class DiretorRepository{
        private List<Diretor> diretorList;

        public DiretorRepository(){
            this.diretorList = ArrayList<>();
        }
        public void addDiretor(Diretor diretor){
            this.diretorList.add(diretor);
        }

        public Diretor buscarDiretor(Integer idDiretor, String nomeDiretor){
            for (Diretor diretor : diretorList){
                if (diretor.getIdDiretor()).equals(idDiretor) && diretor.getNomeDiretor().equalsIgnoreCase(nomeDiretor)){
            return diretor;
                }
            }
            return null;
        }
        public List<Diretor> listarDiretor(){
            return new ArrayList<>(diretorList);
        }
        //Service
        public class DiretorService{
            private DiretorRepository diretorRepository;

            public DiretorService (DiretorRepository diretorRepository){
                this.diretorRepository = diretorRepository;
            }

            public void addDiretor (Diretor diretor){
                diretorRepository.addDiretor(diretor);
            }
            public List<Diretor> listarDiretor(){
                return diretorRepository.listarDiretor();
            }
        }

    }
}
