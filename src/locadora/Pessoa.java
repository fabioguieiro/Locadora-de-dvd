package locadora;
abstract class Pessoa {
    protected String nome;
    protected String telefone;
    protected String getNome(){
        return this.nome;
    }
    protected void setNome(String nome){
        this.nome=nome;
    }
    protected String getTelefone(){
        return this.telefone;
    }
    protected void setTelefone (String telefone){
        this.telefone=telefone;
    }
}
