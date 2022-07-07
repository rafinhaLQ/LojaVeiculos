// Essa é a classe "Cliente", filha da classe "Pessoa", que contém todos os atributos unicos de um cliente.
public class Cliente extends Pessoa{
    private String email;
    private String telefone;

     // Esse é o metodo construtor da classe.
    public Cliente(String email, String telefone, String nome, String rg, String cpf, String endereco, String data, int idade) {
        super(nome, rg, cpf, endereco, data, idade);
        this.email = email;
        this.telefone = telefone;
    }

     // Esses são os Gets e Sets.
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    // No metodo toString, foi incluido os atributos unicos da classe "Cliente".
    @Override
    public String toString(){
        return String.format("%s\nEmail = %s\nTelefone = %s\n", super.toString(), email, telefone);
    }
    
    // Este é o metodo Listar, criado na classe pai como abstrato, que imprime apenas 3 atributos da classe.
    @Override
    public String listar(){
        return String.format("%s \t%s \t%s\n", super.getNome(), super.getCpf(), this.getEmail());
    }
}
