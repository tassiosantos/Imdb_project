import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    private Ator mainAtor;
    private Diretor mainDiretor;

    private ArrayList<Filme> filmes;
    Scanner scan = new Scanner(System.in);
    public MenuController(){
        this.mainAtor = new Ator();
        this.mainDiretor = new Diretor();
        this.filmes = new ArrayList<>();

    }


    public void exibirMenuFilme(){
        System.out.println("1 - Exibir filmes cadastrados.");
        System.out.println("2 - Buscar filme por nome");
        System.out.println("3 - Cadastrar filme.");
    }

    public void exibirMenuAtor(){
        System.out.println("1 - Exibir atores cadastrados.");
        System.out.println("2 - Cadastrar ator.");
        System.out.println("3 - Incluir ator no elenco de um filme.");
    }

    public void exibirMenuDiretor(){
        System.out.println("1 - Exibir diretores cadastrados.");
        System.out.println("2 - Cadastrar diretor");
        System.out.printf("3 - Registrar diretor em um filme.");
    }

    public void exibirMenuInicial(){
        System.out.println("Qual opção deseja seguir?");
        System.out.println("1 - Ator");
        System.out.println("2 - Diretor");
        System.out.println("3 - Filme");
    }

    public int selecionarEscolha(){
        int escolha = scan.nextInt();
        scan.nextLine();
        return escolha;
    }
    public void cadastrarAtor(){
        System.out.println("____________________________________________________");
        System.out.println("Digite o nome do ator");
        String nomeAtor = scan.nextLine();
        System.out.println("Digite o ano de nascimento do ator");
        String dataNascimento = scan.nextLine();
        Ator novoAtor = new Ator(nomeAtor, dataNascimento);
        Ator.AtorService.addAtores(novoAtor);
        System.out.println("Ator: " + novoAtor.getNomeAtor() + " cadastrado com sucesso.");
        System.out.println("____________________________________________________");
    }

    public void cadastrarDiretor(){
        System.out.println("____________________________________________________");
        System.out.println("Digire o nome do diretor");
        String nomeDiretor = scan.nextLine();
        System.out.println("Digite o ano de nascimento do diretor");
        String dataNascimento = scan.next();
        Diretor novoDiretor = new Diretor(nomeDiretor, dataNascimento);
        Diretor.DiretorService.addDiretor(novoDiretor);
        System.out.println("Diretor:" + novoDiretor.getNome() + " cadastrado com sucesso.");
        System.out.println("____________________________________________________");
    }

    public void cadastrarFilme(){
        System.out.println("____________________________________________________");
        System.out.println("Digite o nome do filme:");
        String nomeFilme = scan.nextLine();
        System.out.println("Digite a descrição do filme:");
        String descricaoFilme = scan.nextLine();
        System.out.println("Digite a data de lançamento do filme:");
        String dataLancamento = scan.nextLine();
        System.out.println("Digite o orçamento do filme:");
        double orcamento = scan.nextDouble();
        Filme filme = new Filme();
        filme.setNome(nomeFilme);
        filme.setDescricao(descricaoFilme);
        filme.setData_lancamento(dataLancamento);
        filme.setOrcamento(orcamento);
        this.filmes.add(filme);
        System.out.println("Filme " + filme.getNome() + " cadastrado com sucesso.");
        System.out.println("____________________________________________________");
    }



    public void vincularDiretor(){
        System.out.println("____________________________________________________");
        System.out.println("Digite o nome do filme que deseja incluir o diretor.");
        listarFilmes();
        String nomeFilme = scan.nextLine();
        if(verificarFilme(nomeFilme)){
            System.out.println("Digite o ID do diretor que deseja vincular:");
            listarDiretor();
            Integer idDiretor = scan.nextInt();
            scan.nextLine();

            for (Filme filme: this.filmes) {
                if(filme.getNome().equalsIgnoreCase(nomeFilme)){
                    if(!filme.cadastrarDiretor(Diretor.DiretorService.buscarDiretorById(idDiretor))){
                        System.out.println("Filme já contém um diretor cadastrado.");
                        System.out.println("____________________________________________________");
                    }else{
                        System.out.println("Diretor adicionado com sucesso.");
                        System.out.println("____________________________________________________");
                    }

                }
            }
        }
    }

    public void vincularAtor(){
        if(!filmes.isEmpty()) {
            System.out.println("____________________________________________________");
            System.out.println("Digite o nome do filme que deseja incluir o ator.");
            listarFilmes();
            String nomeFilme = scan.nextLine();
            if (verificarFilme(nomeFilme)) {
                System.out.println("Digite o ID do ator que deseja vincular:");
                listarAtor();
                Integer idAtor = scan.nextInt();
                scan.nextLine();
                Ator ator = Ator.AtorService.buscarAtorById(idAtor);
                for (Filme filme : this.filmes) {
                    if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                        ArrayList<Ator> atores = filme.getAtores();
                        for (int i = 0; i < atores.size(); i++) {
                            if (ator.getIdentificadorAtor() == atores.get(i).getIdentificadorAtor()) {
                                System.out.println("Ator já cadastrado");
                                break;
                            }
                            if (i == atores.size() - 1) {
                                filme.cadastrarAtor(ator);
                            }
                        }

                    }
                }
            }
        }else{
            System.out.println("Lista de filmes vazia.");
        }
    }




    public void listarAtor(){
        System.out.println("____________________________________________________");

        ArrayList<Ator> atores = Ator.AtorService.listarAtor();
        if(!atores.isEmpty()) {
            System.out.println("Lista de atores cadastrados:");
            for (Ator ator : atores) {
                System.out.println("Id " + ator.getIdentificadorAtor() + " - " + ator.getNomeAtor());
            }
            System.out.println("____________________________________________________");
        }else{
            System.out.println("Lista de atores vazia.");
            System.out.println("____________________________________________________");
        }
    }

    public void listarDiretor(){
        System.out.println("____________________________________________________");

        ArrayList<Diretor> diretores = Diretor.DiretorService.listarDiretor();
        if(!diretores.isEmpty()) {
            System.out.println("Lista de diretores cadastrados");
            for (Diretor diretor : diretores) {
                System.out.println(diretor.imprimir());
                System.out.println("_________________________________________");
            }
            System.out.println("____________________________________________________");
        }else{
            System.out.println("Lista de diretores vazia");
            System.out.println("____________________________________________________");
        }
    }

    public void listarFilmes(){
        if(!filmes.isEmpty()) {
            for (Filme filme : this.filmes) {
                System.out.println("____________________________________________________");
                System.out.println("Nome: " + filme.getNome());
                if (filme.getDiretor() != null) {
                    System.out.println("Diretor: " + filme.getDiretor());
                }
                if (!filme.getAtores().isEmpty()) {
                    System.out.println("Atores: ");
                    for (Ator ator : filme.getAtores()) {
                        System.out.println(" - " + ator.getNomeAtor());
                    }
                }
                System.out.println("____________________________________________________");
            }
        }else{
            System.out.println("____________________________________________________");
            System.out.println("Lista de filmes vazia.");
            System.out.println("____________________________________________________");
        }
    }

    public ArrayList<Filme> buscarFilmesPorNome(){
        if(!filmes.isEmpty()) {
            System.out.println("____________________________________________________");
            System.out.println("Digite o nome do filme que deseja buscar:");
            String nomeFilme = scan.nextLine();
            System.out.println("Filmes contendo esse nome: ");
            return listarFilmesPorNome(nomeFilme);
        }else{
            System.out.println("Lista de filmes vazia.");
            return null;
        }
    }

    public ArrayList<Filme> listarFilmesPorNome(String nomeFilme){
            ArrayList<Filme> filmesBuscados = new ArrayList<>();
            for (Filme filme : this.filmes) {
                if (filme.getNome().toLowerCase().contains(nomeFilme.toLowerCase())) {
                    filmesBuscados.add(filme);
                    System.out.println(filme.getNome());
                }
            }
            System.out.println("____________________________________________________");
            return filmesBuscados;
    }



    public boolean verificarFilme(String nomeFilme){
        for(Filme filme: listarFilmesPorNome(nomeFilme)){
            if(filme.getNome().equalsIgnoreCase(nomeFilme)){
                return true;
            }
        }
        System.out.println("Esse nome não consta na lista de filmes cadastrada.");
        System.out.println("____________________________________________________");
        return false;
    }




}
