package locadora;
import java.util.Scanner;
public class Produto {
    private int numeroDeIdentificacao;
    private int idadeDeCensura;
    private String titulo;
    private int raridade; //1- Lançamento 2- comum 3- acervo
    private int quantidadeDisponivel;
    private int quantidadeAlugada;
    public static Produto[] produto = new Produto[1500];
    public static  int qntProdutos = 0;
    Scanner str = new Scanner (System.in);
    Scanner ler = new Scanner (System.in);
    
    protected void cadastra(Produto p){
        
        System.out.print("Informe o Nunmero de Identificação ");
        p.numeroDeIdentificacao=ler.nextInt();
        
        System.out.print("Informe a idade de Censura ");
        p.idadeDeCensura=ler.nextInt();
        
        System.out.print("Informe o Título da midia: ");
        p.titulo=str.nextLine();
        
        System.out.println("Informe a categoria: ");
        System.out.println("1- Lançamento");
        System.out.println("2- Comum");
        System.out.print("3- Acervo ");
        p.raridade=ler.nextInt();
        
        System.out.println("Quantas copias dessa midia temos no estoque? ");
        p.quantidadeDisponivel=ler.nextInt();
        produto[qntProdutos]=p;
        qntProdutos++;
        
    }
    public void aluga(int cod){
        for(int i=0; i<qntProdutos;i++){
            if(produto[i].numeroDeIdentificacao==cod){
                produto[i].quantidadeAlugada++;
                produto[i].quantidadeDisponivel--;               
            }
        }
    }
    
    public void devolve(int cod){
        for(int i=0; i<qntProdutos;i++){
            if(produto[i].numeroDeIdentificacao==cod){
                produto[i].quantidadeAlugada--;
                produto[i].quantidadeDisponivel++;               
            }
        }
    }
    public boolean verificaDisponibilidade(int num){
        boolean f=false;
        for(int i=0; i<qntProdutos;i++){
            if(produto[i].numeroDeIdentificacao==num){
                if(produto[i].quantidadeDisponivel>0){
                    f=true;
                }
            }
        }
        return f;
    }

    /**
        return f;
    }

    /**
     *
     * @param p
     * @param num
     */
    protected void pesquisaMidia(int num){
        boolean b=false;
        int c=0;
        for(int i=0;i<qntProdutos;i++){
            if (produto[i].numeroDeIdentificacao == num) {
                b=true;
                c=i;
                break;
            } 
        }
        if(b==true){
            System.out.println("---------------------------------------------");
            System.out.println("Midia encontrada!!! ");
            System.out.println(produto[c].titulo);
            System.out.println("Copias Alugadas: " + produto[c].quantidadeAlugada);
            System.out.println("Copias Disponiveis: " + produto[c].getQuantidadeDeCopias());
            System.out.println("----------------------------------------------");
        }
        else{
            System.out.println("Midia não encontrada :( ");
        }
    }
    
    String getInfo(){
       return "Título da Midia: " + this.titulo + " \nNumero de Identificação: " + this.numeroDeIdentificacao+ " \nIdade de Censura: " + this.idadeDeCensura+ " \nQuantidade de Copias Disponiveis: " + this.quantidadeDisponivel+ " \nQuantidade de Copias Alugadas: " + this.quantidadeAlugada+ " \nCategoria de Raridade: " + this.raridade;
    }
    protected int getNumeroDeIdentificacao(){
        return this.numeroDeIdentificacao;
    }
    protected void setNumeroDeIdentificacao(int numero){
        this.numeroDeIdentificacao=numero;
    }
    protected int getIdadeDeCensura(){
        return this.idadeDeCensura;
    }
    protected void setIdadeDeCensura(int idade){
        this.idadeDeCensura=idade;
    }
    protected String getTitulo(){
        return this.titulo;
    }
    protected void setTitulo(String titulo){
        this.titulo=titulo;
    }
    protected int getRaridade(){
        return this.raridade;
    }
    protected void setRaridade(int raridade){
        this.raridade=raridade;
    }
    protected int getQuantidadeDeCopias(){
        return this.quantidadeDisponivel;
    }
    protected void setQuantidadeDeCopias(int qtd){
        this.quantidadeDisponivel=qtd;
    }
    protected int getQuantidadeAlugada(){
        return this.quantidadeAlugada;
    }
     protected void setQuantidadeAlugada(int qtd){
        this.quantidadeDisponivel=qtd;
    }
     
     public String getTitulo(int cod){
         for(int i=0;i<qntProdutos;i++){
             if(produto[i].numeroDeIdentificacao==cod){
                 return produto[i].titulo;
             }
         }
         return "a";
    }
      
}

