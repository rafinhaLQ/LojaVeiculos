// Esta é a Classe abstrata "Pessoa", que contém todos os atributos "genericos" de uma pessoa.
public abstract class Pessoa {
    private String nome, rg, cpf, endereco, data;
    private int idade;

    // Esse é o metodo construtor da classe.
    public Pessoa(String nome, String rg, String cpf, String endereco, String data, int idade) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.data = data;
        this.idade = idade;
    }

    // Esses são os Gets e Sets.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Este é o metodo toString, que imprime todos os atributos da classe.
    @Override
    public String toString() {
        return String.format("\nNome = %s\nRG = %s\nCPF = %s\nEndereco = %s\nData de nascimento = %s\nIdade = %d anos", nome, rg, cpf, endereco, data, idade);
    }
    
    // Este é um metodo abstrato que irá imprimir apenas 3 atributos da classe.
    public abstract String listar();
}
