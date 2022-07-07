// Essa é a classe "Moto", filha da classe "Automovel", que contém o atributo unico de uma Moto..
public class Moto extends Automovel{
    private boolean quebraVento;

    // Esse é o metodo construtor da classe.
    public Moto(boolean quebraVento, String modelo, String placa, String marca, String cor, String motor, float preco, float quilometragem, boolean automatico, boolean hibrido) {
        super(modelo, placa, marca, cor, motor, preco, quilometragem, automatico, hibrido);
        this.quebraVento = quebraVento;
    }

    // Esse é o Get e Set.
    public boolean isQuebraVento() {
        return quebraVento;
    }

    public void setQuebraVento(boolean quebraVento) {
        this.quebraVento = quebraVento;
    }

     // No metodo toString, foi incluido o atributo unico da classe "Moto".
    @Override
    public String toString() {
        return String.format("%s\nQuebra Vento = %b", super.toString(), quebraVento);
    }
    
    // Este é o metodo Listar, criado na classe pai como abstrato, que imprime apenas 3 atributos da classe.
    @Override
    public String listar() {
        return String.format("%s \t%s \t%.2f reais\n", super.getModelo(), super.getPlaca(), super.getPreco());
    }
}
