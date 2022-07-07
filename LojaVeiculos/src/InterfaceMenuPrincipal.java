//Esta é a classe que contém a interface principal do menu do sistema, contendo o menu de opções ao usuário.
import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceMenuPrincipal {
    //Esse método contém o menu principal do sistema, e cria os objetos de teste.
    public static void exibirMenuPrincipal() {
        ArrayList<Moto> motos = new ArrayList<>();

        Moto s1000RR = new Moto (true, "S1000RR", "249", "BMW", "Prata", "999cc", 76900, 0, false, true);
        Moto fatBoy = new Moto (false, "Fat Boy", "636", "Harley-Davidson", "Preto", "1690cc", 65400, 10315, false, true);
        motos.add(s1000RR);
        motos.add(fatBoy);
        
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        Funcionario carlos = new Funcionario(3500, 123, "Carlos Alberto", "1234567890", "32165498710", "Salvador, Brotas, Rua Carmem, nº 21", "01/01/1985", 37);
        funcionarios.add(carlos);
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        Cliente neymar = new Cliente ("neyjunior@gmail.com", "55 13 3476-1111", "Neymar Junior", "4862486215", "7211652159", "Mangaratiba, condomínio Portobello", "05/02/1992", 30);
        clientes.add(neymar);
        
        ArrayList<Carro> carros = new ArrayList<>();
        
        Carro camaro = new Carro (2, true, "Camaro", "123", "Chevrolet", "Amarelo", "V8", 486840, 0, true, false);
        Carro fusca = new Carro (2, false, "Fusca", "959", "Volkswagen", "Azul", "1.2 F4", 31000, 19829, false, false);
        Carro rangeRover = new Carro (4, true, "Range Rover", "387", "Land Rover", "Branca", "V8", 792950, 0, true, false);
        carros.add(camaro);
        carros.add(fusca);
        carros.add(rangeRover);
        
        Scanner scan = new Scanner(System.in);
        int menu;
        String textoOpcao;
        
        do{
            
            System.out.printf("\n\tMENU\n\n");
            System.out.println("1 - Gerenciar Veículos");
            System.out.println("2 - Gerenciar Funcionários");
            System.out.println("3 - Gerenciar Clientes");
            System.out.println("4 - Sair");
            textoOpcao=scan.nextLine();

            menu=MudarTipoDeDado.transformarEmInt(textoOpcao);
            switch(menu){
                case 1: InterfaceMenuVeiculos.exibirMenuVeiculos(motos, carros);
                    break;
                case 2: InterfaceMenuFuncionarios.exibirMenuFuncionarios(funcionarios);
                    break;
                case 3: InterfaceMenuClientes.exibirMenuClientes(clientes);
                    break;
                case 4: System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default: System.out.println("Opção Invalida!");
                    break;
            }
        }
        while(menu!=4);
    }
}
