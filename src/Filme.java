import java.util.ArrayList;

public class Filme {
   
   private Diretor diretor;
   private double orcamento;
   private ArrayList<Ator> atores;
   private String data_lancamento, descricao, nome;

   // Construtor vazio
   public Filme () {
      this.atores = new ArrayList<Ator>();
   }

   // Construtor quase completo sem atores
   public Filme (String nome, String descricao, String data_lancamento, Diretor diretor, double orcamento) {
      this.nome = nome;
      this.descricao = descricao;
      this.data_lancamento = data_lancamento;
      this.diretor = diretor;
      this.orcamento = orcamento;
      this.atores = new ArrayList<Ator>();
   }

   // Construtor quase completo sem diretor
   public Filme (String nome, String descricao, String data_lancamento, ArrayList<Ator> atores, double orcamento) {
      this.nome = nome;
      this.descricao = descricao;
      this.data_lancamento = data_lancamento;
      this.atores = atores;
      this.orcamento = orcamento;
   }

   // Construtor completo
   public Filme (String nome, String descricao, String data_lancamento, Diretor diretor, ArrayList<Ator> atores, double orcamento) {
      this.nome = nome;
      this.descricao = descricao;
      this.data_lancamento = data_lancamento;
      this.diretor = diretor;
      this.atores = atores;
      this.orcamento = orcamento;
   }

   // Getter do atributo atores
   public ArrayList<Ator> getAtores() {
      return atores;
   }

   // Setter do atributo atores
   public void setAtores(ArrayList<Ator> atores) {
      this.atores = atores;
   }

   // Getter do atributo data_lancamento
   public String getData_lancamento() {
      return data_lancamento;
   }

   // Setter do atributo data_lancamento
   public void setData_lancamento(String data_lancamento) {
      this.data_lancamento = data_lancamento;
   }

   // Getter do atributo descricao
   public String getDescricao() {
      return descricao;
   }

   // Setter do atributo descricao
   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   // Getter do atributo diretor
   public Diretor getDiretor() {
      return diretor;
   }

   // Setter do atributo diretor
   public void setDiretor(Diretor diretor) {
      this.diretor = diretor;
   }

   // Getter do atributo nome
   public String getNome() {
      return nome;
   }

   // Setter do atributo nome
   public void setNome(String nome) {
      this.nome = nome;
   }

   // Getter do atributo orcamento
   public double getOrcamento() {
      return orcamento;
   }

   // Setter do atributo orcamento
   public void setOrcamento(double orcamento) {
      this.orcamento = orcamento;
   }

   // Cadastrar diretor se ainda nao houver nenhum cadastrado
   public boolean cadastrarDiretor (Diretor diretor) {
      if (this.diretor!=null) {
         return false;
      }
      this.diretor = diretor;
      return true;
   }

   // Cadastrar ator
   public void cadastrarAtor (Ator ator) {
      this.atores.add(ator);
   }

}
