//Essa classe contém o menu de funcionários.
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

public class InterfaceMenuFuncionarios {
    private static Scanner scan = new Scanner(System.in);
    
    // Este metodo é responsável por criar um novo objeto da classe "Funcionario".
    public static Funcionario cadastrarFuncionario(){
        float salario;
        int codigoIdentificacao, idade;
        String nome, rg, cpf, endereco, data, textoCodigoIdentificacao, textoIdade, textoSalario;
        System.out.printf("\n\tRegistrar Funcionario!\n");
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
        System.out.println("Informe o codigo de identificacao: ");
        textoCodigoIdentificacao=scan.nextLine();
        codigoIdentificacao=MudarTipoDeDado.transformarEmInt(textoCodigoIdentificacao);
        
        System.out.println("Informe a idade: ");
        textoIdade=scan.nextLine();
        idade=MudarTipoDeDado.transformarEmInt(textoIdade);
        
        System.out.println("Informe o salario: ");
        textoSalario=scan.nextLine();
        salario=MudarTipoDeDado.transformarEmFloat(textoSalario);
        
        Funcionario cadastrar = new Funcionario(salario, codigoIdentificacao, nome, rg, cpf, endereco, data, idade);
        System.out.println("Funcionário Cadastrado!");
        return cadastrar;
    }
    
    // Este metodo recebe o ArrayList de "Funcionario" e lista todos os funcionarios registrados.
    public static void listarFuncionarios(ArrayList<Funcionario> funcionarios){
        int aux=0;
        System.out.print("\n");
        System.out.printf("Nome \tCPF \tCodigo de identificacao\n\n");
        for(Funcionario listar : funcionarios){
            System.out.println(listar.listar());
            aux++;
        }
        if(aux==0)
            System.out.println("Sem funcionários cadastrados!");
    }
    
    /*
    Este metodo recebe o ArrayList de "Funcionário", solicita um CPF,
    busca esse CPF através do ArraysList e imprime as informações da que 
    tiver o CPF igual ao informado.
    */
    public static void buscarFuncionario(ArrayList<Funcionario> funcionarios){
        int aux=0, codigoBusca;
        String textoOpcao;
        System.out.println("Informe o codigo de identificação do funcionario que procura: ");
        textoOpcao=scan.nextLine();

        codigoBusca=MudarTipoDeDado.transformarEmInt(textoOpcao);
        for(Funcionario busca:funcionarios){
            if(codigoBusca==(busca.getCodigoIdentificacao())){
                System.out.println(busca.toString());
                aux++;
                break;
            }
        }
        if(aux==0)
            System.out.println("Nenhum funcionario encontrado com esse codigo de identificação!");
    }
    //Esse método ordena os funcionários por nome usando a classe FuncionarioComparator e chama o médodo listarFuncionarios.
    public static void ordenarFuncionarios(ArrayList<Funcionario> funcionarios){
        Collections.sort(funcionarios, new FuncionarioComparator());
        System.out.println("Listar Funcionarios Ordenados");
        listarFuncionarios(funcionarios);
    }
    //Esse método busca e remove um objeto do arraylist funcionários usando a variável codigoIndentificacao.
    public static void removerFuncionario(ArrayList<Funcionario> funcionarios){
        int aux=0, codigoRemover;
        String textoOpcao;
        Iterator<Funcionario> iterator = funcionarios.iterator();
        System.out.println("Informe o codigo de identificação que deseja remover: ");
        textoOpcao=scan.nextLine();

        codigoRemover=MudarTipoDeDado.transformarEmInt(textoOpcao);
        while(iterator.hasNext()){
            Funcionario remover = iterator.next();
            if(codigoRemover==(remover.getCodigoIdentificacao())){
                int verifica;
                aux++;
                System.out.printf("\nTem certeza que é esse funcionario que quer remover?\n%s\n1 - Sim \t2 - Não\n", remover.listar());
                textoOpcao=scan.nextLine();
                
                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1)
                    iterator.remove();
            }
        }
        if(aux==0)
            System.out.println("Nenhum funcionario encontrado com esse codigo de identificação!");
    }
    /*
        Esse método modifica um objeto do arraylist funcionarios usando a variável codigoIdentificacao,
        chamando o método cadastrarFuncionarios, que vai cadastrar um objeto com outros dados 
        por cima do que queria ser modificado.
    */
    public static void modificarFuncionario(ArrayList<Funcionario> funcionarios){
        int aux=0, codigoModificar;
        String textoOpcao;
        System.out.println("Informe o codigo de identificação que deseja modificar: ");
        textoOpcao=scan.nextLine();

        codigoModificar=MudarTipoDeDado.transformarEmInt(textoOpcao);
        for(int cont=0; cont<funcionarios.size(); cont++){
            if(codigoModificar==(funcionarios.get(cont).getCodigoIdentificacao())){
                int verifica;
                aux++;
                System.out.printf("\nEsse é o funcionario a ser modificado?\n%s\n1 - Sim \t2 - Não\n", funcionarios.get(cont).listar());
                textoOpcao=scan.nextLine();

                verifica=MudarTipoDeDado.transformarEmInt(textoOpcao);
                if(verifica==1){
                    funcionarios.set(cont, cadastrarFuncionario());
                }    
            }
        }
        if(aux==0)
            System.out.println("Nenhum funcionario encontrado com esse codigo de identificação!");
    }
    //Esse método contém o menu de gerenciamento de funcionários.
    public static void exibirMenuFuncionarios(ArrayList<Funcionario> funcionarios) {
        int menu;
        String textoOpcao;
        
        do {
            System.out.printf("\n\tMENU FUNCIONARIOS\n\n");
            System.out.println("1 - Cadastrar Funcionarios");
            System.out.println("2 - Listar Funcionarios");
            System.out.println("3 - Buscar Funcionario");
            System.out.println("4 - Ordenar Funcionarios");
            System.out.println("5 - Remover Funcionario");
            System.out.println("6 - Modificar Funcionario");
            System.out.println("7 - Voltar ao Menu Principal");
            textoOpcao=scan.nextLine();

            menu=MudarTipoDeDado.transformarEmInt(textoOpcao);

            switch (menu) {
                case 1: funcionarios.add(cadastrarFuncionario());
                    break;
                case 2: listarFuncionarios(funcionarios);
                    break;
                case 3: buscarFuncionario(funcionarios);
                    break;
                case 4: ordenarFuncionarios(funcionarios);
                    break;
                case 5: removerFuncionario(funcionarios);
                    break;
                case 6: modificarFuncionario(funcionarios);
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
