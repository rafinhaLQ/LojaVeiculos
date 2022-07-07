// Essa é a classe "Funcionario", filha da classe "Pessoa", que contém todos os atributos unicos de um funcionario.
public class Funcionario extends Pessoa{
    private float salario;
    private int codigoIdentificacao;

    // Esse é o metodo construtor da classe.
    public Funcionario(float salario, int codigoIdentificacao, String nome, String rg, String cpf, String endereco, String data, int idade) {
        super(nome, rg, cpf, endereco, data, idade);
        this.salario = salario;
        this.codigoIdentificacao = codigoIdentificacao;
    }
    
    // Esses são os Gets e Sets.
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getCodigoIdentificacao() {
        return codigoIdentificacao;
    }

    public void setCodigoIdentificacao(int codigoIdentificacao) {
        this.codigoIdentificacao = codigoIdentificacao;
    }
    
    // No metodo toString, foi incluido os atributos unicos da classe "Funcionario".
    @Override
    public String toString(){
        return String.format("%s\nSalario = %.2f reais\nCodigo de Identificacao = %s\n", super.toString(), salario, codigoIdentificacao);
    }
    
    // Este é o metodo Listar, criado na classe pai como abstrato, que imprime apenas 3 atributos da classe.
    @Override
    public String listar(){
        return String.format("%s \t%s \t%s\n", super.getNome(), super.getCpf(), this.getCodigoIdentificacao());
    }
}
