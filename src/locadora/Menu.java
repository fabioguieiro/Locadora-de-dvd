package locadora;
import java.util.Scanner;
public class Menu {
    public void Men(){
        Scanner ler = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        int menu=1;
        String s;      
        Produto p = new Produto();
        Emprestimo emp = new Emprestimo();
        Cliente c = new Cliente();
        DVD dvd = new DVD();
        CD cd = new CD(); 
        Funcionario f = new Funcionario();
        int loop=1;
        
        System.out.println("****AREA DO PROGRAMADOR*****\n\n ");
        System.out.println("como deseja entrar na aplicação?\n");
        System.out.println("1- Administrador");
        System.out.println("2- Funcionario Comum");
        int op =ler.nextInt();
        do{
        switch(op){
            case 1:
                do{
                System.out.println("\t\t\t\t***Bem-Vindo à Locadora***\n\n"); 
                System.out.println("1- Cadastro de Funcionario Comum");
                System.out.println("2- Cadastro de Administrador");
                System.out.println("3- Cadastro de midia");
                System.out.println("4- Cadastra cliente");
                System.out.println("5- Pesquisa por mídia");
                System.out.println("6- Pesquisa por genero (DVD)");
                System.out.println("7- Pesquisa por banda (CD)");
                System.out.println("8- Pesquisa de todos os emprestimos de um cliente   ");
                System.out.println("9- Alugar um produto");
                System.out.println("0- Devolver um produto");
                menu=ler.nextInt();
                switch(menu){
                    case 1:
                        f.cadastra(false);
                        break;
                    case 2:
                        f.cadastra(true);
                        break;
                    case 3:
                        System.out.println("\n\nOque deseja cadastrar:");
                        System.out.println("1- DVD");
                        System.out.println("2- CD");
                        System.out.println("3- GAME");
                        int cat = ler.nextInt();
                        switch(cat){
                            case 1:                       
                                dvd.cadastra();
                                break;
                            case 2:
                                cd.cadastra();                      
                                break;
                            case 3:
                                Game game = new Game();
                                game.cadastra();
                                break;
                        }             
                        break;
                    case 4:
                        c.cadastra();
                        break;
                    case 5:
                        System.out.print("Digite o numero de identificação ");
                        int cod=ler.nextInt();
                        System.out.println("\n\n\n");
                        p.pesquisaMidia(cod);
                        break;
                    case 6:
                        dvd.pesquisaGenero();
                        break;
                    case 7:
                        cd.pesquisaBanda();
                        break;
                    case 8:
                        System.out.print("Qual o nome do Cliente ");
                        String cl = str.nextLine();
                        emp.pesquisa(cl);
                    case 9:
                        emp.Aluga();
                        break;
                    case 0:
                        System.out.println("Entre com o nome do Cliente ");
                        String cli = str.nextLine();
                        emp.devolve(cli);
                }
    }while (menu>0);
            case 2:
                do {
                System.out.println("\t\t\t\t***Bem-Vindo à Locadora***\n\n"); 
                
                System.out.println("1- Cadastro de midia");
                System.out.println("2- Cadastra cliente");
                System.out.println("3- Pesquisa por mídia");
                System.out.println("4- Pesquisa por genero (DVD)");
                System.out.println("5- Pesquisa por banda (CD)");
                System.out.println("6- Pesquisa de todos os emprestimos de um cliente   ");
                System.out.println("7- Alugar um produto");
                System.out.println("8- Devolver um produto");
                menu=ler.nextInt();
                switch(menu){
                    case 1:
                        System.out.println("\n\nOque deseja cadastrar:");
                        System.out.println("1- DVD");
                        System.out.println("2- CD");
                        System.out.println("3- GAME");
                        int cat = ler.nextInt();
                        switch(cat){
                            case 1:                       
                                dvd.cadastra();
                                break;
                            case 2:
                                cd.cadastra();                      
                                break;
                            case 3:
                                Game game = new Game();
                                game.cadastra();
                                break;
                        }             
                        break;
                    case 2:
                        c.cadastra();
                        break;
                    case 3:
                        System.out.print("Digite o numero de identificação ");
                        int cod=ler.nextInt();
                        System.out.println("\n\n\n");
                        p.pesquisaMidia(cod);
                        break;
                    case 4:
                        dvd.pesquisaGenero();
                        break;
                    case 5:
                        cd.pesquisaBanda();
                        break;
                    case 6 :
                        System.out.print("Qual o nome do Cliente ");
                        String cl = str.nextLine();
                        emp.pesquisa(cl);
                    case 7:
                        emp.Aluga();
                        break;
                }             
        
            
    
              
        }while(menu>0);
            
                             
        }while (menu>0);

   }while(loop>0);
}
}