import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Tree<String, String> traductor;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int op = 0;

        while(op<1||op>3){
            System.out.println("Ingrese la opción de Mapeo:");
            System.out.println("1. RedBlackTree");
            System.out.println("2. AVL Tree");
            System.out.println("3. Salir");
            try{
                op = scan.nextInt();
                if(op==1){
                    Controller("rbt");
                } else if (op==2) {
                    Controller("avl");
                }
            } catch(Exception e){
                System.out.println("Opción Inválida");
            }
        }


    }

    public static void Controller(String mapeo){
        traductor = Factory.TreeGen(mapeo);
        Reader(true);
        String[] texto = Reader(false);
        String tem;
        String txtTraducido = "";
        for (String st:texto) {
            tem = traductor.search(st);
            if(tem!=null){
                txtTraducido+=" "+tem;
            } else{
                txtTraducido+=" *"+st+"*";
            }
        }
        System.out.println(txtTraducido);
    }
    public static String[] Reader(boolean map_trad){
        String[] texto = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader("src/Spanish.txt"))) {
            String line;
            if(map_trad){
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String[] tem = line.split("-");
                    traductor.insert(tem[1],tem[0]);
                }
                return null;
            } else{
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    texto = line.split(" ");
                }
            }
            return texto;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
