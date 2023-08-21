import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    Scanner scan = new Scanner(System.in);
    private Ator mainAtor;
    private Diretor mainDiretor;
    private ArrayList<Filme> filmes;

    public MenuController() {
        this.mainAtor = new Ator();
        this.mainDiretor = new Diretor();
        this.filmes = new ArrayList<>();

    }


    public void exibirMenuFilme() {
        System.out.println("1 - Exibir filmes cadastrados.");
        System.out.println("2 - Buscar filme por nome");
        System.out.println("3 - Cadastrar filme.");
    }

    public void exibirMenuAtor() {
        System.out.println("1 - Exibir atores cadastrados.");
        System.out.println("2 - Cadastrar ator.");
        System.out.println("3 - Incluir ator no elenco de um filme.");
    }

    public void exibirMenuDiretor() {
        System.out.println("1 - Exibir diretores cadastrados.");
        System.out.println("2 - Cadastrar diretor");
        System.out.println("3 - Registrar diretor em um filme.");
    }

    public void exibirMenuInicial() {
        System.out.println("Qual opção deseja seguir?");
        System.out.println("1 - Ator");
        System.out.println("2 - Diretor");
        System.out.println("3 - Filme");
    }

    public void exibirSimNao(){
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
    }

    public int selecionarEscolha() {
        int escolha = scan.nextInt();
        scan.nextLine();
        return escolha;
    }

    public void cadastrarAtor() {
        System.out.println("____________________________________________________");
        System.out.println("Digite o nome do ator");
        String nomeAtor = scan.nextLine();
        System.out.println("Digite o ano de nascimento do ator");
        String dataNascimento = scan.nextLine();
        Ator novoAtor = new Ator(nomeAtor, dataNascimento);
        Ator.AtorService.addAtores(novoAtor);
        System.out.println("Ator: " + novoAtor.getNome() + " cadastrado com sucesso.");
        System.out.println("____________________________________________________");
    }

    public void cadastrarDiretor() {
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

    public void cadastrarFilme() {
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


    public void vincularDiretor() {
        if(!filmes.isEmpty()) {
            if(!Diretor.DiretorService.listarDiretor().isEmpty()) {
                System.out.println("____________________________________________________");
                System.out.println("Digite o nome do filme que deseja incluir o diretor.");
                listarFilmes();
                String nomeFilme = scan.nextLine();
                if (verificarFilme(nomeFilme)) {
                    System.out.println("###############################");
                    ArrayList<Diretor> diretores = listarDiretor();
                    System.out.println("###############################");
                    if (!diretores.isEmpty()) {
                        System.out.println("Digite o ID do diretor que deseja vincular:");
                        Integer idDiretor = scan.nextInt();
                        scan.nextLine();
                        Diretor diretor = Diretor.DiretorService.buscarDiretorById(idDiretor);
                        if (diretor != null) {
                            for (Filme filme : this.filmes) {
                                if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                                    if (!filme.cadastrarDiretor(diretor)) {
                                        System.out.println("Filme já contém um diretor cadastrado.");
                                        System.out.println("____________________________________________________");
                                    } else {
                                        System.out.println("Diretor adicionado com sucesso.");
                                        System.out.println("____________________________________________________");
                                    }

                                }
                            }
                        } else {
                            System.out.println("Não existe diretor com esse ID.");
                        }
                    }

                }
            }else{
                System.out.println("Lista de diretor vazia.");
            }
        }else{
            System.out.println("Lista de filmes vazia.");
        }
    }

    public void vincularAtor() {
        if (!filmes.isEmpty()) {
            if(!Ator.AtorService.listarAtor().isEmpty()) {
                System.out.println("____________________________________________________");
                System.out.println("Lista de filmes cadastrados:");
                listarFilmes();
                System.out.println("Digite o nome do filme que deseja incluir o ator.");
                String nomeFilme = scan.nextLine();
                if (verificarFilme(nomeFilme)) {
                    System.out.println("###############################");
                    ArrayList<Ator> listaAtores = listarAtor();
                    System.out.println("###############################");
                    if (!listaAtores.isEmpty()) {
                        System.out.println("Digite o ID do ator que deseja vincular:");
                        Integer idAtor = scan.nextInt();
                        scan.nextLine();
                        Ator ator = Ator.AtorService.buscarAtorById(idAtor);
                        if (ator != null) {
                            for (Filme filme : this.filmes) {
                                if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                                    ArrayList<Ator> atores = filme.getAtores();
                                    if (!atores.isEmpty()) {
                                        boolean existeAtor = false;
                                        for (int i = 0; i < atores.size(); i++) {
                                            if (ator.getIdentificadorAtor() == atores.get(i).getIdentificadorAtor()) {
                                                System.out.println("Ator já cadastrado");
                                                existeAtor = true;
                                                break;
                                            }

                                        }
                                        if (!existeAtor) {
                                            filme.cadastrarAtor(ator);
                                            System.out.println(ator.getNome() + " cadastrado no elenco de: " + filme.getNome());
                                        }

                                    } else {
                                        filme.cadastrarAtor(ator);
                                    }

                                }
                            }
                        } else {
                            System.out.println("Não existe ator com esse ID.");
                        }
                    }
                }
            }else{
                System.out.println("Lista de atores vazia.");
            }
        } else {
            System.out.println("Lista de filmes vazia.");
        }
    }


    public ArrayList<Ator> listarAtor() {
        System.out.println("____________________________________________________");

        ArrayList<Ator> atores = Ator.AtorService.listarAtor();
        if (!atores.isEmpty()) {
            System.out.println("Lista de atores cadastrados:");
            for (Ator ator : atores) {
                System.out.println(ator.imprimir());
                System.out.println("_________________________________________");
            }
            System.out.println("____________________________________________________");
        } else {
            System.out.println("Lista de atores vazia.");
            System.out.println("____________________________________________________");
        }
        return atores;
    }

    public ArrayList<Diretor> listarDiretor() {
        System.out.println("____________________________________________________");

        ArrayList<Diretor> diretores = Diretor.DiretorService.listarDiretor();
        if (!diretores.isEmpty()) {
            System.out.println("Lista de diretores cadastrados");
            for (Diretor diretor : diretores) {
                System.out.println(diretor.imprimir());
                System.out.println("_________________________________________");
            }
            System.out.println("____________________________________________________");
        } else {
            System.out.println("Lista de diretores vazia");
            System.out.println("____________________________________________________");
        }
        return diretores;
    }

    public void listarFilmes() {
        if (!filmes.isEmpty()) {
            for (Filme filme : this.filmes) {
                System.out.println("____________________________________________________");
                System.out.println("Nome: " + filme.getNome());
                if (filme.getDiretor() != null) {
                    System.out.println("Diretor: " + filme.getDiretor().getNome());
                }
                if (!filme.getAtores().isEmpty()) {
                    System.out.println("Atores: ");
                    for (Ator ator : filme.getAtores()) {
                        System.out.println(" - " + ator.getNome());
                    }
                }
                System.out.println("____________________________________________________");
            }
        } else {
            System.out.println("____________________________________________________");
            System.out.println("Lista de filmes vazia.");
            System.out.println("____________________________________________________");
        }
    }

    public void buscarFilmesPorNome() {
        if (!filmes.isEmpty()) {
            System.out.println("Digite o nome do filme que deseja buscar:");
            String nomeFilme = scan.nextLine();
            System.out.println("Filmes contendo esse nome: ");
            ArrayList<Filme> filmesPorNome = listarFilmesPorNome(nomeFilme);
            if(filmesPorNome.isEmpty()){
                System.out.println("Não existe filme cadastrado com esse nome.");
            }
            System.out.println("____________________________________________________");
            buscarFilmeEspecifico(filmesPorNome);
        } else {
            System.out.println("Lista de filmes vazia.");

        }
    }


    public ArrayList<Filme> listarFilmesPorNome(String nomeFilme) {
        ArrayList<Filme> filmesBuscados = new ArrayList<>();
        for (Filme filme : this.filmes) {
            if (filme.getNome().toLowerCase().contains(nomeFilme.toLowerCase())) {
                filmesBuscados.add(filme);
                System.out.println(filme.getNome());
            }
        }
        return filmesBuscados;
    }

    public void buscarFilmeEspecifico(ArrayList<Filme> listaFilmes){
        System.out.println("Deseja detalhes de algum filme da lista?");
        exibirSimNao();
        int escolha = scan.nextInt();
        scan.nextLine();
        if(escolha == 1){
            System.out.println("Digite o nome do filme que deseja detalhes");
            String nomeFilme = scan.nextLine();
            boolean filmeExiste = false;
            Filme filmeEscolhido = null;
            for(Filme filme: listaFilmes){
                if(filme.getNome().equalsIgnoreCase(nomeFilme)){
                    filmeEscolhido = filme;
                    filmeExiste = true;
                }
            }
            if(filmeExiste){
                System.out.println("Informações sobre " + filmeEscolhido.getNome() + ":");
                System.out.println("____________________________________________________");
                System.out.println("Nome: " + filmeEscolhido.getNome() );
                System.out.println("Ano: " + filmeEscolhido.getData_lancamento());
                if (filmeEscolhido.getDiretor() != null) {
                    System.out.println("Diretor: " + filmeEscolhido.getDiretor().getNome());
                }
                if (!filmeEscolhido.getAtores().isEmpty()) {
                    System.out.println("Atores: ");
                    for (Ator ator : filmeEscolhido.getAtores()) {
                        System.out.println(" - " + ator.getNome());
                    }
                }
                System.out.println("Descrição: " + filmeEscolhido.getDescricao());
                System.out.println("Orçamento: " + filmeEscolhido.getOrcamento());
                System.out.println("____________________________________________________");
            }else{
                System.out.println("O filme não consta na lista acima.");
            }

        }else if(escolha == 2){
            System.out.println("Retornando ao menu inicial.");
        }else{
            System.out.println("Escolha inválida.");
        }
    }


    public boolean verificarFilme(String nomeFilme) {
        for (Filme filme : listarFilmesPorNome(nomeFilme)) {
            if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                return true;
            }
        }
        System.out.println("Esse nome não consta na lista de filmes cadastrada.");
        System.out.println("____________________________________________________");
        return false;
    }


}
