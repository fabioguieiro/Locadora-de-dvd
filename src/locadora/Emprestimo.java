package locadora;
import java.util.Scanner;
public class Emprestimo {
    
    
    static Produto prod = new Produto();
    Emprestimo[] emprestimos = new Emprestimo[1000];
    int qntEmprestimos=0;
    protected String cliente;
    protected String midia;
    protected double custo;
    protected int qwe=0;
    protected int numMidia;
    protected int pagamento;
            
    CD cd = new CD();
    Game game = new Game();
    double preco=0;
    Scanner scan = new Scanner(System.in);
    Scanner nome = new Scanner (System.in);
    
    public void Aluga(){
        Emprestimo emp= new Emprestimo();
        int d1=1,d2=1,d3=1;
        Cliente cli = new Cliente();
        Funcionario fun = new Funcionario();
        DVD dvd = new DVD();
        String u="teste";
        String n= "a";
        String titulos="a";
        String nom="a";
        boolean d;
        boolean dep=false;
        boolean b;
        int r;
        int para=1;
        int menu=0;
        int cod=0;
        while (para>0){
            System.out.println("\n\nPara começar façamos o login:");
            System.out.print("Digite seu nome:  ");
            nom=nome.nextLine();
            System.out.print("Digite sua senha: ");
            String senha=nome.nextLine();
            boolean z=fun.login(nom,senha);
            if(z==false){
                System.out.println("Funcionario nao cadastrado !");
                return;
            }else{
                System.out.println("\n\nlogin efetuado com sucesso!\n");
            }
            System.out.println("por favor digite a data: ");
            System.out.print("Dia ");
            d1=scan.nextInt();
            System.out.print("mes ");
            d2=scan.nextInt();
            System.out.print("Ano ");
            d3=scan.nextInt();
            System.out.print("\n\nInforme o nome do cliente que vai alugar ");
            n=nome.nextLine();
            b = cli.verificaCliente(n);
        if(b==false){
            System.out.println("Desculpe, mas esse cliente nao consta no sistema");
            return;
        }
        
        else {
            System.out.println("Cliente encontrado!!");
            System.out.print("Digite 1 se o cliente vai alugar, ou 2 se um dependente vai alugar em seu nome: ");
            r= scan.nextInt();
            if(r==2){
                System.out.print("Entre com o nome do dependente ");
                 u = nome.nextLine();
                 d=cli.verificaDependente(n,u);
                if(d==false){
                    System.out.println("Desculpe, mas esse nome nao consta na lista de dependentes");
                    return;
                }else{
                    System.out.println("Dependente checado!!");
                    dep=true;
                }
            }
        }
        System.out.println("Qual produto o cliente deseja alugar ? ");
        System.out.println("1- DVD");
        System.out.println("2- CD");
        System.out.print("3- GAME  ");
        menu= scan.nextInt();
        if(menu==1) preco+=dvd.getPrec(cod);
        else if (menu==2) preco+=cd.getPrec(cod);
        else preco+=game.getPrec(cod);
        if(menu==1) titulos ="DVD";
        else if(menu==2) titulos ="CD";
        else titulos ="GAME";
        titulos +=" - "; 
        System.out.print("qual o codigo do produto que voce quer alugar? ");
        cod=scan.nextInt();
        boolean a= prod.verificaDisponibilidade(cod);
        
        if (a==true){
            System.out.println("Titulo disponivel\n\n");
            emp.numMidia=cod;
            titulos += prod.getTitulo(cod); 
            titulos += "\n";
            
            
            prod.aluga(cod);
        }
        else{ System.out.println("Me desculpe, alugamos todas as copias desse titulo");
        return;}
        
            System.out.println("Deseja Alugar mais alguma mídia? [1-sim//0-nao]");
            para = scan.nextInt();
            
        }
            System.out.print("Deseja Pagar Adiantado[1] ou na devolução do produto[2] ? ");
            int o = scan.nextInt();
            emp.pagamento=o;
            
            
            System.out.println("###############################################");
            System.out.println("\t\tCUPOM FISCAL\n\n");
            System.out.println("Cliente: "+n);
            if(dep==true) System.out.println("Dependente: "+u);
            System.out.println("Funcionario: "+nom); 
            System.out.println("Produto(s) Alugado(s): ");
            System.out.println(titulos);
            System.out.println("Data de Locação: "+d1+"/"+d2+"/"+d3+"");
            System.out.println("Data de Devolução: ");
            qwe=d1;
            emp.getPrazo(o, d1, d2);
            System.out.println("\n\nPreço:-------------------------------R$ "+preco);
            System.out.println("###############################################");
            emp.cliente=n;
            emp.midia=titulos;
            emp.custo=preco;
            emprestimos[qntEmprestimos]=emp;
            
            qntEmprestimos++;
    }
    
    public void devolve(String cliente){
        for (int i=0 ; i<qntEmprestimos; i++){
            if(emprestimos[i].cliente.equals(cliente)){
                System.out.print("Que dia é hoje? ");
                int dia = scan.nextInt();
                System.out.print("em que mes estamos? ");
                int mes = scan.nextInt();
                int pag = emprestimos[i].pagamento;
                int a =emprestimos[i].numMidia;
                prod.devolve(a);
                verificaMulta(dia,mes,pag);
            }
        }
    }
    public void verificaMulta(int dia, int mes, int pag){
        int b = this.qwe;
        if(b<dia){
                System.out.println("Voce nao tem multas");
        }else {
            int multa = b-dia;
            multa*=2;
            System.out.println("Sua multa: "+multa);
        }
        if(pag==1){
                
            }
        
        }
    
    public void pesquisa(String nome){
        for (int i=0;i<qntEmprestimos;i++){
            if(emprestimos[i].cliente.equals(nome)){
                exibeCliente(i);
            }
        }
    }
    
    public void exibeCliente(int a){
        System.out.println("\n\n-----------------------------------");
        System.out.println("Cliente: "+emprestimos[a].cliente);
        System.out.println("Titulo(s) "+emprestimos[a].midia);
        System.out.println("Preço "+emprestimos[a].custo);
        System.out.println("----------------------------------------\n\n");
    }
    public void getPrazo(int a,int dia, int mes){
        if (a==1){
            if((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)){
                if(dia ==31){
                    dia=2;
                    mes++;
                } else if(dia==30){
                    dia=1;
                    mes++;
                }else dia+=2;
            }else {
                if(dia==30){
                    dia=2;
                    mes++;
                }else if(dia==29){
                    dia =1;
                    mes++;
                }
            }
        }else {
            if((mes==1)||(mes==3)||(mes==5)||(mes==7)||(mes==8)||(mes==10)||(mes==12)){
                if(dia ==31){
                    dia=1;
                    mes++;
                }else dia+=1;
                }else {
                if(dia==30){
                    dia=1;
                    mes++;
                }else {
                    dia++;
                }
            }
        }
        System.out.println(+dia+"/"+mes);
        this.qwe=dia;
        }

    }
          