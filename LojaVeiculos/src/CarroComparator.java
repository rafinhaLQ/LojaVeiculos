//Essa classe compara dois objetos da classe Carro.
import java.util.Comparator;

public class CarroComparator implements Comparator<Carro>{
    @Override
    //Esse método compara dois valores de preço e retorna a diferenca.
    public int compare(Carro carro1, Carro carro2) {
        int diferenca = (int) (carro1.getPreco() - carro2.getPreco());
        return diferenca;
    }
}
