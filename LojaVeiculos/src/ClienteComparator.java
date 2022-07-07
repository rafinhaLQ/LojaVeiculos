//Essa classe compara dois objetos da classe Cliente.
import java.util.Comparator;

public class ClienteComparator implements Comparator<Cliente>{
    @Override
    //Esse método compara dois nomes e retorna o que vem primeiro em ordem alfabética.
    public int compare(Cliente cliente1, Cliente cliente2) {
        int diferenca = cliente1.getNome().compareTo(cliente2.getNome());
        return diferenca;
    }
}
