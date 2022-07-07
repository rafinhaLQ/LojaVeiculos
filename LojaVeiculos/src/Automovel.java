// Esta é a Classe abstrata Automovel, que contém todos os atributos "genericos" de um veículo.
public abstract class Automovel {
    private String modelo, placa, marca, cor, motor;
    private float preco, quilometragem;
    private boolean automatico, hibrido;
    
    // Esse é o metodo construtor da classe.
    public Automovel(String modelo, String placa, String marca, String cor, String motor, float preco, float quilometragem, boolean automatico, boolean hibrido) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.motor = motor;
        this.preco = preco;
        this.quilometragem = quilometragem;
        this.automatico = automatico;
        this.hibrido = hibrido;
    }
    
// Esses são os Gets e Sets.
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    public boolean isHibrido() {
        return hibrido;
    }

    public void setHibrido(boolean hibrido) {
        this.hibrido = hibrido;
    }
    
    // Este é o metodo toString, que imprime todos os atributos da classe.
    @Override
    public String toString() {
        return String.format("\nModelo = %s\nPlaca = %s\nMarca = %s\nCor = %s\nMotor = %s\nPreco = %.2f reais\nQuilometragem = %.2f\nAutomatico = %b\nHibrido = %b", modelo, placa, marca, cor, motor, preco, quilometragem, automatico, hibrido);
    }   
    
    // Este é um metodo abstrato que irá imprimir apenas 3 atributos da classe.
    public abstract String listar();
}
