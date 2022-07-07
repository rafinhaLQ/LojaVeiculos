//Essa classe Contem o Gerenciamento de motos podendo cadastrar, listar, buscar, ordenar, remover e modificar.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

class InterfaceMenuMotos {
    private static Scanner scan = new Scanner(System.in);
    
    // Este metodo é responsável por criar um novo objeto da classe "Moto".
    public static Moto cadastrarMoto(){
        boolean quebraVento, automatico, hibrido;
        String modelo, placa, marca, cor, motor, textoValor, textoQuilometragem, textoAutomatico, textoHibrido, textoQuebraVento;
        float preco, quilometragem;
        System.out.printf("\n\tRegistrar Moto!\n");
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
        System.out.println("Informe o valor: ");
        textoValor=scan.nextLine();
        preco=MudarTipoDeDado.transformarEmFloat(textoValor);
        
        System.out.println("Informe a quilometragem: ");
        textoQuilometragem=scan.nextLine();
        quilometragem=MudarTipoDeDado.transformarEmFloat(textoQuilometragem);
        
        System.out.println("Informe se e automatico (true ou false): ");
        textoAutomatico=scan.nextLine();
        automatico=MudarTipoDeDado.transformarEmBoolean(textoAutomatico);
        
        System.out.println("Informe se e hibrido (true ou false): ");
        textoHibrido=scan.nextLine();
        hibrido=MudarTipoDeDado.transformarEmBoolean(textoHibrido);
        
        System.out.println("Informe se tem quebra vento (true ou false): ");
        textoQuebraVento=scan.nextLine();
        quebraVento=MudarTipoDeDado.transformarEmBoolean(textoQuebraVento);
        
        Moto cadastrar = new Moto(quebraVento, modelo, placa, marca, cor, motor, preco, quilometragem, automatico, hibrido);
        System.out.println("Moto Cadastrada!");
        return cadastrar;
    }
    
    // Este metodo recebe o ArrayList de "Moto" e lista todos os carros registrados.
    public static void listarMotos(ArrayList<Moto> motos){
        int aux=0;
        System.out.print("\n");
        System.out.printf("Modelo \tPlaca \tPreço\n\n");
        for(Moto listar : motos){
            System.out.println(listar.listar());
            aux++;
        }
        if(aux==0)
            System.out.println("Sem motos cadastradas!");
    }
    
    /*
    Este metodo recebe o ArrayList de "Moto", solicita uma placa,
    busca essa placa através do ArraysList e imprime as informações da que 
    tiver a placa igual à informada.
    */
    public static void buscarMoto(ArrayList<Moto> motos){
        int aux=0;
        String placa;
        System.out.println("Informe a placa da moto que procura: ");
        placa = scan.nextLine();
        for(Moto busca:motos){
            if(placa.equals(busca.getPlaca())){
                System.out.println(busca.toString());
                aux++;
                break;
            }
        }
        if(aux==0)
            System.out.println("Nenhuma moto encontrada com essa placa!");
    }
    //Esse método ordena as motos por preço e chama o médodo listarMotos
    public static void ordenarMotos(ArrayList<Moto> motos){
        Collections.sort(motos, new MotoComparator());
        System.out.println("Listar Motos Ordenadas");
        listarMotos(motos);
    }
    //Esse método busca e remove um objeto do arraylist motos usando a variável placa.
    public static void removerMoto(ArrayList<Moto> motos){
        int aux=0;
        String placaRemover, textoOpcao;
        Iterator<Moto> iterator = motos.iterator();
        System.out.println("Informe a placa que deseja remover: ");
        placaRemover=scan.nextLine();
        while(iterator.hasNext()){
            Moto remover = iterator.next();
            if(placaRemover.equals(remover.getPlaca())){
                int verifica;
                aux++;
                System.out.printf("\nTem certeza que é essa moto que quer remover?\n%s\n1 - Sim \t2 - Não\n", remover.listar());
                textoOpcao=scan.nextLine();

                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1)
                    iterator.remove();
            }
        }
        if(aux==0)
            System.out.println("Nenhuma moto encontrada com essa placa!");
    }
    /*
        Esse método modifica um objeto do arraylist motos usando a variável placa, chamando o método cadastrarMotos,
        que vai cadastrar um objeto com outros dados por cima do que queria ser modificado.
    */
    public static void modificarMoto(ArrayList<Moto> motos){
        int aux=0;
        String placaModificar, textoOpcao;
        System.out.println("Informe a placa que deseja modificar: ");
        placaModificar=scan.nextLine();
        for(int cont=0; cont<motos.size(); cont++){
            if(placaModificar.equals(motos.get(cont).getPlaca())){
                int verifica;
                aux++;
                System.out.printf("\nEssa é a moto a ser modificado?\n%s\n1 - Sim \t2 - Não\n", motos.get(cont).listar());
                textoOpcao=scan.nextLine();

                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1){
                    motos.set(cont, cadastrarMoto());
                }    
            }
        }
        if(aux==0)
            System.out.println("Nenhuma moto encontrada com essa placa!");
    }
    //Esse método contém o menu de gerenciamento de motos.
    public static void exibirMenuMotos(ArrayList<Moto> motos) {
        int menu;
        String textoOpcao;
        
        do {
            System.out.printf("\n\tMENU MOTOS\n\n");
            System.out.println("1 - Cadastrar Motos");
            System.out.println("2 - Listar Motos");
            System.out.println("3 - Buscar Moto");
            System.out.println("4 - Ordenar Motos");
            System.out.println("5 - Remover Moto");
            System.out.println("6 - Modificar Moto");
            System.out.println("7 - Voltar ao Menu Veiculos");
            textoOpcao=scan.nextLine();

            menu=MudarTipoDeDado.transformarEmInt(textoOpcao);

            switch (menu) {
                case 1: motos.add(cadastrarMoto());
                    break;
                case 2: listarMotos(motos);
                    break;
                case 3: buscarMoto(motos);
                    break;
                case 4: ordenarMotos(motos);
                    break;
                case 5: removerMoto(motos);
                    break;
                case 6: modificarMoto(motos);
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
