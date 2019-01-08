package locadora;
import java.util.Scanner;
public class Cliente extends Pessoa{
    Scanner ler = new Scanner (System.in);
    protected String CPF;
    protected int numeroDaLocacao;
    public static Cliente[] clientes= new Cliente[100]; 
    public static int qntClientes =0;
    public String[] dependentes = new String[5];
    
    protected void cadastra(){
        Cliente c = new Cliente();
        System.out.print("Insira o nome ");
        c.nome=ler.nextLine();
        System.out.print("Insira o Telefone ");
        c.telefone=ler.nextLine();
        System.out.print("Insira o CPF");
        c.CPF=ler.nextLine();
        c.numeroDaLocacao++;
        System.out.println("Cadastre seus Dependentes: ");
        for (int i=0;i<5;i++){
            String n;
            System.out.print("Insira o dependente numero "+(i+1)+" (Digite 'fim' para encerrar a lista de dependentes)  ");
            n=ler.nextLine();
            if(n.equals("fim")==true){
                break;
            }
            else{
                c.dependentes[i]=n;
            }
        }     
        clientes[qntClientes]= c;
        qntClientes++;
    }
     protected String getCPF(){
        return this.CPF;
    }
    protected void setCPF(String CPF){
        this.CPF=CPF;
    }
    protected int getNumeroDaLocacao(){
        return this.numeroDaLocacao;
    }
    protected void setNumeroDaLocacao(int num){
        this.numeroDaLocacao=num;
    }
    protected void getDependentes(){
        for (int i =0 ; i<5 ; i++){
            if(this.dependentes[i]==null){
                break;
            }
            System.out.println(this.dependentes[i]);
        }
    }
    
    public boolean verificaCliente(String n){
        boolean f=false;
        for(int i=0;i<qntClientes;i++){
            if((clientes[i].nome).equalsIgnoreCase(n)){
                    f=true;
                }
            }
         return f;
        }
    
    public boolean verificaDependente(String n,String u){
        boolean f; 
        int j=0;
        f=false;
        for(int i=0; i<qntClientes;i++){
            if(clientes[i].nome.equals(n)){
                while(clientes[i].dependentes[j]!=null){
                    if (clientes[i].dependentes[j].equals(u)) { 
                        f=true;
                    }
                    j++;
                }
            }    
        }
        return f;
    }
        
    }
    
    
