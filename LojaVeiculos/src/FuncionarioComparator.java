//Essa classe compara dois objetos da classe Funcionario.
import java.util.Comparator;

public class FuncionarioComparator implements Comparator<Funcionario>{
    @Override
    //Esse método compara dois nomes e retorna o que vem primeiro em ordem alfabética.
    public int compare(Funcionario funcionario1, Funcionario funcionario2) {
        int diferenca = funcionario1.getNome().compareTo(funcionario2.getNome());
        return diferenca;
    }
}
