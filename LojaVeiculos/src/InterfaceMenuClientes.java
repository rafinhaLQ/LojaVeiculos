//Essa classe contém o menu de clientes.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

public class InterfaceMenuClientes {
    
    private static Scanner scan = new Scanner(System.in);
    
    // Este metodo é responsável por criar um novo objeto da classe "Cliente".
    public static Cliente cadastrarCliente(){
        int idade;
        String nome, rg, cpf, endereco, data, email, telefone, textoIdade;
        System.out.printf("\n\tRegistrar Cliente!\n");
        System.out.println("Informe o nome: ");
        nome=scan.nextLine();
        System.out.println("Informe o RG: ");
        rg=scan.nextLine();
        System.out.println("Informe o CPF: ");
        cpf=scan.nextLine();
        System.out.println("Informe o endereco: ");
        endereco=scan.nextLine();
        System.out.println("Informe a data de nascimento: ");
        data=scan.nextLine();
        System.out.println("Informe o email: ");
        email=scan.nextLine();
        System.out.println("Informe o telefone: ");
        telefone=scan.nextLine();
        System.out.println("Informe a idade: ");
        textoIdade=scan.nextLine();
        idade=MudarTipoDeDado.transformarEmInt(textoIdade);
        
        Cliente cadastrar = new Cliente(email, telefone, nome, rg, cpf, endereco, data, idade);
        System.out.println("Cliente Cadastrado!");
        return cadastrar;
    }
    
    // Este metodo recebe o ArrayList de "Cliente" e lista todos os clientes registrados.
    public static void listarClientes(ArrayList<Cliente> clientes){
        int aux=0;
        System.out.print("\n");
        System.out.printf("Nome \tCPF \tEmail\n\n");
        for(Cliente listar : clientes){
            System.out.println(listar.listar());
            aux++;
        }
        if(aux==0)
            System.out.println("Sem clientes cadastrados!");
    }
    
    /*
    Este metodo recebe o ArrayList de "Cliente", solicita um CPF,
    busca esse CPF através do ArraysList e imprime as informações da que 
    tiver o CPF igual ao informado.
    */
    public static void buscarCliente(ArrayList<Cliente> clientes){
        int aux=0;
        String cpfBusca;
        System.out.println("Informe o CPF do cliente que procura: ");
        cpfBusca = scan.nextLine();
        for(Cliente busca:clientes){
            if(cpfBusca.equals(busca.getCpf())){
                System.out.println(busca.toString());
                aux++;
                break;
            }
        }
        if(aux==0)
            System.out.println("Nenhum cliente encontrado com esse CPF!");
    }
    //Esse método ordena os clientes por nome usando a classe ClienteComparator e chama o médodo listarClientes.
    public static void ordenarClientes(ArrayList<Cliente> clientes){
        Collections.sort(clientes, new ClienteComparator());
        System.out.println("Listar Clientes Ordenados");
        listarClientes(clientes);
    }
    //Esse método remove um objeto do arraylist clientes usando a variável cpf.
    public static void removerCliente(ArrayList<Cliente> clientes){
        int aux=0;
        String cpfRemover, textoOpcao;
        Iterator<Cliente> iterator = clientes.iterator();
        System.out.println("Informe o CPF que deseja remover: ");
        cpfRemover=scan.nextLine();
        while(iterator.hasNext()){
            Cliente remover = iterator.next();
            if(cpfRemover.equals(remover.getCpf())){
                int verifica;
                aux++;
                System.out.printf("\nTem certeza que é esse cliente que quer remover?\n%s\n1 - Sim \t2 - Não\n", remover.listar());
                textoOpcao=scan.nextLine();

                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1)
                    iterator.remove();
            }
        }
        if(aux==0)
            System.out.println("Nenhum cliente encontrado com esse CPF!");
    }
    /*
        Esse método modifica um objeto do arraylist clientes usando a variável cpf,
        chamando o método cadastrarClientes, que vai cadastrar um objeto com outros dados 
        por cima do que queria ser modificado.
    */
    public static void modificarCliente(ArrayList<Cliente> clientes){
        int aux=0;
        String cpfModificar, textoOpcao;
        System.out.println("Informe o CPF que deseja modificar: ");
        cpfModificar=scan.nextLine();
        for(int cont=0; cont<clientes.size(); cont++){
            if(cpfModificar.equals(clientes.get(cont).getCpf())){
                int verifica;
                aux++;
                System.out.printf("\nEsse é o cliente a ser modificado?\n%s\n1 - Sim \t2 - Não\n", clientes.get(cont).listar());
                textoOpcao=scan.nextLine();

                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1){
                    clientes.set(cont, cadastrarCliente());
                }    
            }
        }
        if(aux==0)
            System.out.println("Nenhum cliente encontrado com esse CPF!");
    }
    //Esse método contém o menu de gerenciamento de clientes.
    public static void exibirMenuClientes(ArrayList<Cliente> clientes) {
        int menu;
        String textoOpcao;
        
        do {
            System.out.printf("\n\tMENU CLIENTES\n\n");
            System.out.println("1 - Cadastrar Clientes");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente");
            System.out.println("4 - Ordenar Clientes");
            System.out.println("5 - Remover Cliente");
            System.out.println("6 - Modificar Cliente");
            System.out.println("7 - Voltar ao Menu Principal");
            textoOpcao=scan.nextLine();

            menu=MudarTipoDeDado.transformarEmInt(textoOpcao);

            switch (menu) {
                case 1: clientes.add(cadastrarCliente());
                    break;
                case 2: listarClientes(clientes);
                    break;
                case 3: buscarCliente(clientes);
                    break;
                case 4: ordenarClientes(clientes);
                    break;
                case 5: removerCliente(clientes);
                    break;
                case 6: modificarCliente(clientes);
                    break;
                case 7: System.out.println("Voltando ao Menu Principal...");
                    break;
                default: System.out.println("Opção Invalida!");
                    break;
            }
        }
        while (menu != 7);
    }
}
