package snake;
import java.io.IOException;
import java.util.Scanner;
import static snake.juego.*;


public class Snake {

    public static void main(String[] args) throws IOException {
          
        int salir = 20, contadorjuego = 1, jugador = 10, opcion2 = 0;
        int result[][] = new int [jugador][2];
        int resultado [];
       
        String opcion, nombre, nacimiento, caso0, caso3, caso4;
        String [][] jugadores = new String[jugador][2];
        nombre = "";
        nacimiento = "";
        caso0 = "   ";
        caso3 = "   ";
        caso4 = "   ";
        
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        
        for(int i= 0; i < jugador; i++){ //Inicia el Historial 
            for(int j = 0; j < 2; j++){
                jugadores [i][j] = "---------------";
                result[i][j] = 0;
            }
        }
            
    while(salir != 0){
            
            System.out.println("►►►► SNAKE ◄◄◄◄ ");
            System.out.println();
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Historial");
            System.out.println("3. Instrucciones");
            System.out.println("4. Salir");
            System.out.println();
            System.out.print("Elija Opcion ->  ");
            
            if(opcion2 !=0){
                opcion = String.valueOf(opcion2);
            }
            else{
                opcion = s.nextLine();
            }
            
            switch(opcion){
                case "1":
                    System.out.println("****** Iniciando Nueva Partida ******");
                    System.out.println();
                    System.out.print("Ingrese su nombre: ");
                    nombre = s1.nextLine();
                    System.out.print("Ingrese su fecha de nacimiento: ");
                    nacimiento = s1.nextLine();
                 
                    if (contadorjuego >10){
                        jugadores [0][0] = nombre;
                        jugadores [0][1] = nacimiento; 
                    }
                    else{
                        jugadores [contadorjuego-1][0] = nombre;
                        jugadores [contadorjuego-1][1] = nacimiento; 
                    }
                    
                    resultado = jugando(nombre,jugadores,result); //metodo que inicia el juego y los resultados son guardados en la variable resultado
                    
                    if (contadorjuego >10){
                        result [0][0] = resultado[0];
                        result [0][1] = resultado[1]; 
                    }
                    else{
                        result [contadorjuego - 1][0] = resultado [0]; //se guada el punteo total de la partida
                        result [contadorjuego - 1][1] = resultado [1]; //se guarda el numero total de movimientos de la partida
                    }
                    opcion2 = resultado [2];
                    System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n","");
                   
                    contadorjuego = contadorjuego + 1;
                    break;
                    
                case "2":
                    System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                    System.out.printf("%56s %n%n","******** PARTIDAS JUGADAS ********");
                    System.out.printf("%9s %41s %12s %12s %n%n", "Nombre", "Fecha de Nacimiento", "Punteo", "Movimientos");
                    for(int i = 0; i < 10; i++ ){
                        System.out.printf("%-2d. %-28s %-24s %5s %8s %n", (i+1), jugadores[i][0],jugadores[i][1], result[i][0], result[i][1]);
                    }
                    
                    while(caso3.equals(caso0) == true){
                        System.out.println();
                        System.out.println("Para ir al menu presione la tecla enter.");
                        caso3 = s1.nextLine();
                    }
                    caso3 = caso0;
                    System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n","");
                    break;
                case "3":
                    //Instrucciones
                    System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                    instrucciones();
                    while(caso4.equals(caso0) == true){
                        System.out.println("Para ir al menu presione la tecla enter.");
                        caso4 = s1.nextLine();
                    }
                    caso4 = caso0;
                    System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n","");
                    break;
                case "4":
                    if (opcion2 == 4){
                        salir = 0;
                    }
                    else{
                        String preg = "";
                        String resp = "s";
                        String resp1 = "n";
                        System.out.println("¿Esta seguro que desea salir de la aplicacion?");
                        System.out.println("Para responder Si presione 'S' y para responde No presione 'N'");
                        preg = s.nextLine();
                        while (preg.equalsIgnoreCase(resp) == false && preg.equalsIgnoreCase(resp1) == false){
                            System.out.println();
                            System.out.println("Opcion no valida. Solo puede responder 'S' o 'N'");
                            preg = s.nextLine();
                            System.out.println();
                        }
                        if (preg.equalsIgnoreCase(resp)){
                            salir = 0;
                        }
                        else{
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n","");
                            break;
                        }
                    }
                    System.out.println("Adios!!!!");
                    System.out.println();
                    break;
                default:
                    System.out.printf("%n%n%n%n%n","");
                    System.out.println("No esta entre las opciones");
                    System.out.printf("%n%n","");
                    break;
            }
        }
    }
}
