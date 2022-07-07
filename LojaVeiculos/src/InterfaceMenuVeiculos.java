//Essa classe contém o menu de veículos que redireciona para os menus de gerenciamento de carros e motos.
import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceMenuVeiculos {
    private static Scanner scan = new Scanner(System.in);
    //Este método contém o menu de veículos que redireciona para os menus de gerenciamento de carros e motos.
    public static void exibirMenuVeiculos(ArrayList<Moto> motos, ArrayList<Carro> carros){
        int menu;
        String textoOpcao;
        do{
            System.out.printf("\n\tMENU VEICULOS\n\n");
            System.out.println("1 - Gerenciar Motos");
            System.out.println("2 - Gerenciar Carros");
            System.out.println("3 - Voltar ao Menu Principal");
            textoOpcao=scan.nextLine();

            menu=MudarTipoDeDado.transformarEmInt(textoOpcao);
            
            switch(menu){
                case 1: InterfaceMenuMotos.exibirMenuMotos(motos);
                    break;
                case 2: InterfaceMenuCarros.exibirMenuCarros(carros);
                    break;
                case 3: System.out.println("Voltando ao Menu Principal...");
                    break;
                default: System.out.println("Opção Invalida!");
            }
        }
        while(menu!=3);
        
    }
}
