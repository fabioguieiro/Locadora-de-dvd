package locadora;
import java.util.Scanner;
public class CD extends Produto {
    private String grupo;
    public static CD[] cd = new CD[500];
    public static int qntCDS=0;
    private int numeroDeMusicas;
    public String ban;
    Scanner ler = new Scanner (System.in);
    Scanner mus = new Scanner (System.in);
    
    protected void cadastra(){
        CD aux = new CD();
        super.cadastra(aux);
        System.out.print("Entre com o grupo/cantor/banda ");
        aux.grupo=mus.nextLine();
        System.out.print("Entre com a Quantidade de musicas deste CD ");
        aux.numeroDeMusicas=ler.nextInt();
       cd[qntCDS]= aux;
       qntCDS++;
       
    }
    
    public double getPrec(int cod){
        double preco;
        if(cod == 1) preco = 1;
        else if(cod==2) preco = 0.75;
        else preco=1.5;
        return preco;
    }
    
    public void pesquisaBanda(){
        System.out.print("Digite o nome a banda/grupo/cantor a ser procurado ");
         ban = mus.nextLine();
        System.out.println("\n\n\n");
        for (int i=0; i<qntCDS;i++) {
            if(cd[i].grupo.equalsIgnoreCase(ban)){
            System.out.println("---------------------------------------------\n"+cd[i].getInfo()+"\n----------------------------------------------\n");
            }
        }
    }
    
    @Override
    String getInfo(){
        String informacaoBasica = super.getInfo();
        String informacao = informacaoBasica + " \nCantor: "+this.grupo + "\nNumero de Musicas: "+this.numeroDeMusicas;
        return informacao;
    }
    
    protected String getGrupo(){
        return this.grupo;
    }
    protected void setGrupo(String grupo){
        this.grupo=grupo;
    }
    protected int getNumeroDeMusicas(){
        return this.numeroDeMusicas;
    }
    protected void setNumeroDeMusicas (int numero){
        this.numeroDeMusicas=numero;
    }
}
