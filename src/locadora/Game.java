package locadora;
import java.util.Scanner;
public class Game extends Produto{
    private String nomeDoConsole;
    public static Game[] game= new Game[500];
    public static int qntGames=0;
    Scanner ler = new Scanner (System.in);
    protected void cadastra(){
        Game aux = new Game();
        super.cadastra(aux);
        System.out.print("Entre com o nome do Console ");
        aux.nomeDoConsole=ler.nextLine();
        game[qntGames]=aux;
        qntGames++;
    }
    
    protected String getNomeDoConsole(){
        return this.nomeDoConsole;
    }
    protected void setNomeDoConsole(String nome){
        this.nomeDoConsole=nome;
    }
    public double getPrec(int cod){
        if(cod == 1){
            return 2.99;
        }
        if(cod==2){
            return 1.99;
        }
        if (cod==3){
            return 3.99;
        }
        return 0.11;
    }
    
}
