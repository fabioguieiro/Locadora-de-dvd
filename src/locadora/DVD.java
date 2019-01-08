package locadora;
import java.util.Scanner;
public class DVD extends Produto{
    private String genero;
    private String idioma;
    public static int qntDVDS=0;
    public static DVD[] dvd = new DVD[500];
    Scanner com = new Scanner (System.in);
    
    @Override
    String getInfo(){
        String informacaoBasica = super.getInfo();
        String informacao = informacaoBasica + " \nGenero: "+this.genero + "\nIdioma: "+this.idioma;
        return informacao;
    }


    public double getPrec(int cod){
        double preco;
        if(cod == 1) preco = 2.5;
        else if(cod==2) preco = 1.5;
        else preco=3;
        return preco;
    }

    protected void cadastra(){
        DVD aux = new DVD();
        super.cadastra(aux);
        System.out.print("Entre com o Genero do Filme ");
        aux.genero=com.nextLine();
        System.out.print("Entre com o Idioma ");
        aux.idioma=com.nextLine();
        dvd[qntDVDS]=aux;
        qntDVDS++;
        System.out.println(qntDVDS);
        
    }
    
           
        public void pesquisaGenero(){
            System.out.print("Digite o genero a ser buscado ");
            String gen=com.nextLine();
            System.out.println("\n\n\n");
        
            for (int i=0; i<qntDVDS;i++) {
                if(dvd[i].genero.equalsIgnoreCase(gen)){
                    System.out.println("---------------------------------------------\n"+dvd[i].getInfo()+"\n----------------------------------------------\n");
                }
            }
        }
    
    protected String getGenero(){
        return this.genero;
    }
    protected void setGenero(String genero){
        this.genero=genero;
    }
    protected String getIdioma(){
        return this.idioma;
    }
    protected void setIdioma (String idioma){
        this.idioma=idioma;
    }
    
}
