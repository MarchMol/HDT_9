import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Tree<String, String> traductor;

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // Menu donde se escoge la implentación
        int op = 0;
        while(op<1||op>3){
            System.out.println("Ingrese la opción de Mapeo:");
            System.out.println("1. RedBlackTree");
            System.out.println("2. AVL Tree");
            System.out.println("3. Salir");
            try{
                op = scan.nextInt();
                if(op==1){ // Se corre el controlador con la implementación escogida
                    Controller("rbt");
                } else if (op==2) {
                    Controller("avl");
                }
            } catch(Exception e){
                // Programación defensiva
                System.out.println("Opción Inválida");
            }
        }
    }

    /**
     *
     * @param mapeo
     */
    public static void Controller(String mapeo){
        //Factory del trauctor ingresa el mapeo escogido
        traductor = Factory.TreeGen(mapeo);
        //Se mapea el diccionario ingles a español
        Reader(true, "src/Spanish.txt");
        //Se lee el archivo Text y se almacena en un Array
        String[] texto = Reader(false, "src/Texto.txt");
        String tem;
        String txtTraducido = "";
        // For each traduce todas las palabras utilzando el traductor
        for (String st:texto) {
            tem = traductor.search(st.toLowerCase());
            if(tem!=null){
                txtTraducido+=" "+tem;
            } else{
                txtTraducido+=" *"+st+"*";
            }
        }
        //Se imprime el resultado
        System.out.println(txtTraducido);
    }

    /**
     *
     * @param map_trad
     * @param archivo
     * @return
     */
    public static String[] Reader(boolean map_trad, String archivo){
        String[] texto = new String[0];
        //Se intenta leer el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            //Si se desea mapear, los contenidos del archivo Spanish.txt se almacenan en traductor
            if(map_trad){
                while ((line = br.readLine()) != null) {
                    String[] tem = line.split("-");
                    traductor.insert(tem[1].toLowerCase(),tem[0].toLowerCase());
                }
                //se regresa null pues no requiere de un valor
                return null;
            } else{
                //Se lee el archivo Texto.txt y se almacena en un array
                while ((line = br.readLine()) != null) {
                    texto = line.split(" ");
                }
            }
            //se regresa el array
            return texto;
        } catch (IOException e) {
            //En caso de que ocurra un error leyendo el archivo, se regresa null y se imprime el error
            e.printStackTrace();
            return null;
        }
    }
}
