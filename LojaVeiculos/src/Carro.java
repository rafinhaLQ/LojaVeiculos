// Essa é a classe "Carro", filha da classe "Automovel", que contém todos os atributos unicos de um carro.
public class Carro extends Automovel{
    private int portas;
    private boolean arcondicionado;
   
    // Esse é o metodo construtor da classe.
    public Carro(int portas, boolean arcondicionado, String modelo, String placa, String marca, String cor, String motor, float preco, float quilometragem, boolean automatico, boolean hibrido) {
        super(modelo, placa, marca, cor, motor, preco, quilometragem, automatico, hibrido);
        this.portas = portas;
        this.arcondicionado = arcondicionado;
    }
    
     // Esses são os Gets e Sets.
    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public void setArcondicionado(boolean arcondicionado) {
        this.arcondicionado = arcondicionado;
    }

    // No metodo toString, foi incluido os atributos unicos da classe "Carro".
    @Override
    public String toString() {
        return String.format("%s\nPortas = %d\nArcondicionado = %b\n", super.toString(), portas, arcondicionado);
    }
    
    // Este é o metodo Listar, criado na classe pai como abstrato, que imprime apenas 3 atributos da classe.
    @Override
    public String listar() {
        return String.format("%s \t%s \t%.2f reais\n", super.getModelo(), super.getPlaca(), super.getPreco());
    }
}
