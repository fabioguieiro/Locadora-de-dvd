package locadora;
import java.util.Scanner;
public class Funcionario extends Pessoa{
    private String endereco;
    private String senha;
    private String nome;
    public static Funcionario[] funcionarios = new Funcionario[10];
    public static int qntFuncionarios=0;
    Scanner ler = new Scanner(System.in);
    protected boolean adm;
    
    protected void cadastra(boolean b){
        Funcionario f = new Funcionario();
        adm=b;
        
        System.out.print("Insira o nome ");
        f.nome=ler.nextLine();
        System.out.print("Insira o Telefone ");
        f.telefone=ler.nextLine();
        System.out.print("Informe seu endereco: ");
        f.endereco=ler.nextLine();
        String senha1 = "abc",senha2 = "bca";
        while (senha1.equals(senha2)==false){
        System.out.print("Escolha sua Senha ");
        senha1= ler.nextLine();
        System.out.print("Por favor digite sua senha novamente: ");
        senha2= ler.nextLine();
        if(senha1.equals(senha2)==false){
            System.out.println("Senhas não conferem, por favor tente novamente");
        }
        else {
            System.out.println("senha escolhida com sucesso");
            f.senha=senha1;
        }
        }
       funcionarios[qntFuncionarios]=f;
       qntFuncionarios++;
        System.out.println("FUNCIONARIO CADASTRADO COM SUCESSO");
    }
    
    protected String getEndereco(){
        return this.endereco;
    }
    public boolean login(String nome, String senha){
        boolean b = false;
        int a=0;
        for (int i=0;i<qntFuncionarios;i++){
            if(funcionarios[i].nome.contentEquals(nome)){
                a=i;
            }
        }
        if (funcionarios[a].senha.contentEquals(senha)) b=true;
        System.out.println(b);
        return b;
    }
    
    protected void setEndereco(String endereco){
        this.endereco=endereco;
    }
    
    protected void setSenha(String senha){
        this.senha=senha;
    }
}
