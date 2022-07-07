//Essa classe muda o tipo primitivo dos dados
import java.util.Scanner;

public class MudarTipoDeDado {
    //Esse método transforma String em inteiro e fica em loop enquanto não digitar im valor válido.
    public static int transformarEmInt(String texto){
        Scanner scan = new Scanner(System.in);
        int i;
        try{
            i=Integer.parseInt(texto);
        }
        catch(NumberFormatException e){
            System.out.println("Nao escreveu um valor valido!");
            System.out.println("Escreva um numero inteiro: ");
            texto=scan.nextLine();
            i=transformarEmInt(texto);
        }
        return i;
    }
    //Esse método transforma String em float e fica em loop enquanto não digitar im valor válido.
    public static float transformarEmFloat(String texto){
        Scanner scan = new Scanner(System.in);
        float i;
        try{
            i=Float.parseFloat(texto);
        }
        catch(NumberFormatException e){
            System.out.println("Nao escreveu um valor valido!");
            System.out.println("Escreva um numero flutuante: ");
            texto=scan.nextLine();
            i=transformarEmFloat(texto);
        }
        return i;
    }
    //Esse método transforma String em boolean e fica em loop enquanto não digitar im valor válido.
    public static boolean transformarEmBoolean(String texto){
        Scanner scan = new Scanner(System.in);
        boolean i;
        if(texto.toLowerCase().equals("true")||texto.toLowerCase().equals("false")){
            i=Boolean.parseBoolean(texto);
        }
        else{
            System.out.println("Nao escreveu um valor valido!");
            System.out.println("Escreva um valor booleano (true ou false): ");
            texto=scan.nextLine();
            i=transformarEmBoolean(texto);
        }
        return i;
    }
}
