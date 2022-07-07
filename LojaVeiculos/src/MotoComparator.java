//Essa classe compara dois objetos da classe Moto.
import java.util.Comparator;

public class MotoComparator implements Comparator<Moto>{
    @Override
    //Esse método compara dois valores de preço e retorna a diferenca.
    public int compare(Moto moto1, Moto moto2) {
        int diferenca = (int) (moto1.getPreco() - moto2.getPreco());
        return diferenca;
    }
}
