//Essa classe contém o Gerenciamento de carros podendo cadastrar, listar, buscar, ordenar, remover e modificar.

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

public class InterfaceMenuCarros {
    private static Scanner scan = new Scanner(System.in);
    
    // Este metodo é responsável por criar um novo objeto da classe "Carro".
    public static Carro cadastrarCarro(){
        int portas;
        boolean arcondicionado, automatico, hibrido;
        String modelo, placa, marca, cor, motor, textoPortas, textoValor, textoQuilometragem, textoArcondicionado, textoAutomatico, textoHibrido;
        float preco, quilometragem;
        System.out.printf("\n\tRegistrar Carro!\n");
        System.out.println("Informe o modelo: ");
        modelo=scan.nextLine();
        System.out.println("Informe a marca: ");
        marca=scan.nextLine();
        System.out.println("Informe a placa: ");
        placa=scan.nextLine();
        System.out.println("Informe a cor: ");
        cor=scan.nextLine();
        System.out.println("Informe o motor: ");
        motor=scan.nextLine();
        System.out.println("Informe o numero de portas: ");
        textoPortas=scan.nextLine();
        portas=MudarTipoDeDado.transformarEmInt(textoPortas);
        
        System.out.println("Informe o valor: ");
        textoValor=scan.nextLine();
        preco=MudarTipoDeDado.transformarEmFloat(textoValor);
        
        System.out.println("Informe a quilometragem: ");
        textoQuilometragem=scan.nextLine();
        quilometragem=MudarTipoDeDado.transformarEmFloat(textoQuilometragem);
        
        System.out.println("Informe se tem arcondicionado (true ou false): ");
        textoArcondicionado=scan.nextLine();
        arcondicionado=MudarTipoDeDado.transformarEmBoolean(textoArcondicionado);
        
        System.out.println("Informe se e automatico (true ou false): ");
        textoAutomatico=scan.nextLine();
        automatico=MudarTipoDeDado.transformarEmBoolean(textoAutomatico);
        
        System.out.println("Informe se e hibrido (true ou false): ");
        textoHibrido=scan.nextLine();
        hibrido=MudarTipoDeDado.transformarEmBoolean(textoHibrido);
        
        Carro cadastrar = new Carro (portas, arcondicionado, modelo, placa, marca, cor, motor, preco, quilometragem, automatico, hibrido);
        System.out.println("Carro Cadastrado!");
        return cadastrar;
    }
    
    // Este metodo recebe o ArrayList de "Carro" e lista todos os carros registrados.
    public static void listarCarros(ArrayList<Carro> carros){
        int aux=0;
        System.out.print("\n");
        System.out.printf("Modelo \tPlaca \tPreço\n\n");
        for(Carro listar : carros){
            System.out.println(listar.listar());
            aux++;
        }
        if(aux==0)
            System.out.println("Sem carros cadastrados!");
    }
    
    /*
    Este metodo recebe o ArrayList de "Carro", solicita uma placa,
    busca essa placa através do ArraysList e imprime as informações da que 
    tiver a placa igual à informada.
    */
    public static void buscarCarro(ArrayList<Carro> carros){
        int aux=0;
        String placa;
        System.out.println("Informe a placa do carro que procura: ");
        placa = scan.nextLine();
        for(Carro busca:carros){
            if(placa.equals(busca.getPlaca())){
                System.out.println(busca.toString());
                aux++;
                break;
            }
        }
        if(aux==0)
            System.out.println("Nenhum carro encontrado com essa placa!");
    }
    //Esse método ordena as carros por preço e chama o médodo listarCarros.
    public static void ordenarCarros(ArrayList<Carro> carros){
        Collections.sort(carros, new CarroComparator());
        System.out.println("Listar Carros Ordenados");
        listarCarros(carros);
    }
    //Esse método busca e remove um objeto do arraylist carros usando a variável placa.
    public static void removerCarro(ArrayList<Carro> carros){
        int aux=0;
        String placaRemover, textoOpcao;
        Iterator<Carro> iterator = carros.iterator();
        System.out.println("Informe a placa que deseja remover: ");
        placaRemover=scan.nextLine();
        while(iterator.hasNext()){
            Carro remover = iterator.next();
            if(placaRemover.equals(remover.getPlaca())){
                int verifica;
                aux++;
                System.out.printf("\nTem certeza que é esse carro que quer remover?\n%s\n1 - Sim \t2 - Não\n", remover.listar());
                textoOpcao=scan.nextLine();

                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1)
                    iterator.remove();
            }
        }
        if(aux==0)
            System.out.println("Nenhum carro encontrado com essa placa!");
    }
    /*
        Esse método modifica um objeto do arraylist carros usando a variável placa, chamando o método cadastrarCarros,
        que vai cadastrar um objeto com outros dados por cima do que queria ser modificado.
    */
    public static void modificarCarro(ArrayList<Carro> carros){
        int aux=0;
        String placaModificar, textoOpcao;
        System.out.println("Informe a placa que deseja modificar: ");
        placaModificar=scan.nextLine();
        for(int cont=0; cont<carros.size(); cont++){
            if(placaModificar.equals(carros.get(cont).getPlaca())){
                int verifica;
                aux++;
                System.out.printf("\nEsse é o carro a ser modificado?\n%s\n1 - Sim \t2 - Não\n", carros.get(cont).listar());
                textoOpcao=scan.nextLine();

                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1){
                    carros.set(cont, cadastrarCarro());
                }    
            }
        }
        if(aux==0)
            System.out.println("Nenhum carro encontrado com essa placa!");
    }
    //Esse método contém o menu de gerenciamento de carros.
    public static void exibirMenuCarros(ArrayList<Carro> carros) {
        int menu;
        String textoOpcao;
        
        do {
            System.out.printf("\n\tMENU CARROS\n\n");
            System.out.println("1 - Cadastrar Carros");
            System.out.println("2 - Listar Carros");
            System.out.println("3 - Buscar Carro");
            System.out.println("4 - Ordenar Carros");
            System.out.println("5 - Remover Carro");
            System.out.println("6 - Modificar Carro");
            System.out.println("7 - Voltar ao Menu Veiculos");
            textoOpcao=scan.nextLine();

            menu=MudarTipoDeDado.transformarEmInt(textoOpcao);

            switch (menu) {
                case 1: carros.add(cadastrarCarro());
                    break;
                case 2: listarCarros(carros);
                    break;
                case 3: buscarCarro(carros);
                    break;
                case 4: ordenarCarros(carros);
                    break;
                case 5: removerCarro(carros);
                    break;
                case 6: modificarCarro(carros);
                    break;
                case 7: System.out.println("Voltando ao Menu Veiculos...");
                    break;
                default: System.out.println("Opção Invalida!");
                    break;
            }
        }
        while (menu != 7);
    }
}
