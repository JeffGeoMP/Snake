package snake;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class juego {
    
    static int comida(String tablero[][],int a, int b,int comida,int mov){
        String comida1,comida2,comida3;
        boolean aum=false;
        comida1 = "%";
        comida2 = "$";
        comida3 = "#"; 
        
        
        
        if(tablero[a][b].equalsIgnoreCase(comida1)){
            comida = comida + 10;
            aum=true;
        }
        if(tablero[a][b].equalsIgnoreCase(comida2)){
            comida = comida -10;
        }
        if(tablero[a][b].equalsIgnoreCase(comida3)){
            comida= comida;
        }
        return comida;
    }
    
    
    static void instrucciones(){
        System.out.println("********** INSTRUCCIONES DEL JUEGO **********");
        System.out.println();
        System.out.println("Personaje: 'C'");
        System.out.println();
        System.out.println("Items:  % Equivale a +10 puntos ");
        System.out.println("        $ Equivale a -15 puntos");
        System.out.println("        # Equivale a  0 puntos");
        System.out.println();
        System.out.println("Movimientos: Arriba    = Tecla W");
        System.out.println("             Abajo     = Tecla S");
        System.out.println("             Derecha   = Tecla D");
        System.out.println("             Izquierda = Tecla A");
        System.out.println();
        System.out.println("Explicación: Muévete por el tablero obteniendo ítems para ganar.");
        System.out.println("             Ganas cuando obtengas 100 puntos o más.");
        System.out.println("             Pierdes cuando te quedas sin puntos.");
        System.out.println();
    }
    
    static int [] jugando(String player, String [][]jugadores, int result[][]) throws IOException{
         
        int a, b, fil,col,comida,random,n,mov, option;
        
        mov = 0;
        fil = 30;
        col = 80;
        option = 0;
        comida = 10;
        n = fil*col;
        
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        String[][] tablero = new String[fil][col];
        String arriba, abajo, izquierda, espacio, pared,posicion, pausa,caso4,caso5,
                derecha, personaje, comida1, comida2, comida3,caso0,caso1,ladoslaterales,ladossuperiores  ;
        caso0 = "   ";
        caso1 = "   ";
        caso4 = "   ";
        caso5 = "   ";
        pausa = "m";
        arriba ="w";
        abajo = "s";
        derecha = "d";
        izquierda = "a";
        comida1 = "%";
        comida2 = "$";
        comida3 = "#";   
        espacio = " ";
        pared = "#";
        ladoslaterales = "#";
        ladossuperiores = "#";
        personaje = "♣";
        boolean M = false;

        //Coloca comidas en la matriz principal
        String[] comidas= new String[n];
        for(int p =0; p < n ; p++){
            if (p >= 0 && p < 40){
                comidas[p] = comida1;
            }
            else if (p >= 40 && p < 70){
                comidas[p] = comida2;
            }
            else if (p >= 70 && p < 90) {
                comidas[p] = comida3;      
            }
            else if (p >= 90 && p < 600 ){
                comidas [p] = pared;
            }
            else {
                comidas[p] = espacio;
            }
        }  
        for (int x = 0; x < fil; x++) { //RAMDON para la comida
            for (int y = 0; y < col; y++) {
                random = r.nextInt(n);
                tablero[x][y] = comidas[random];
                comidas[random] = comidas[n-1];
                n--;
            }
        }
       
        //Busca en donde colocar al pacman
        a = r.nextInt(fil);
        b = r.nextInt(col);

        while (tablero[a][b].equals(comida1) == true || tablero[a][b].equals(comida2)
                == true ||  tablero[a][b].equals(comida3) == true ){
            a = r.nextInt(fil);
            b = r.nextInt(col);                 
        }
            tablero[a][b] = personaje;
            
        // Imprime la matriz en consola por primera vez
        System.out.print("#");
        for (int x = 0; x < col; x++) {
             System.out.print(ladossuperiores);
        }
        System.out.println("#");
        for (int x = 0; x < fil; x++) {
                System.out.print(ladoslaterales);                 
                for (int y = 0; y < col; y++) {
                    System.out.print(tablero[x][y]);
            }
        System.out.print(ladoslaterales);    
        System.out.println();
        }
        System.out.print("#");
        for (int x = 0; x < col; x++) {
             System.out.print(ladossuperiores);
        }
        System.out.println("#");
        
        //Inicia el puntaje y el numero de movimientos
        System.out.printf("%s %3s %-9s %-32s %-4s "
                + "%-4s %-10s %-5s %-4s %n",
                ladoslaterales," ","Jugador:", player, "Puntos:", comida,
                "Movimientos:", mov,ladoslaterales);
        System.out.printf("%-16s %-63s %-2s %n",ladoslaterales,
                "Para regresar al menu presione la tecla'M'",ladoslaterales);
        System.out.print("#");
        for (int x = 0; x < col; x++) {
            System.out.print(ladossuperiores);
        }            
        System.out.println("#");
        
        //Inicia ciclo hasta ganar o perder. 
        while (comida > 0 && comida < 100){
            
            System.out.print("Movimiento ->");
            posicion = s.nextLine();
            
            if(pausa.equalsIgnoreCase(posicion) == true){
                boolean bol = true;
                boolean bol2 = false;
                System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n","");
                while(bol){
                    System.out.println("**** PACMAN :V ****");
                    System.out.println();
                    System.out.println("1. Iniciar Nuevo Juego");
                    System.out.println("2. Regresar a la Partida");
                    System.out.println("3. Terminar Partida");
                    System.out.println("4. Historial");
                    System.out.println("5. Instrucciones");
                    System.out.println("6. Salir");
                    System.out.println();
                    System.out.print("Elija Opcion ->  ");
                    String value = s.nextLine();
                    System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n","");
                    switch(value){
                        case "1":
                            String preg = "";
                            String resp = "s";
                            String resp1 = "n";
                            System.out.println("¿Esta seguro que desea iniciar un nuevo juego?");
                            System.out.println("Para responder Si presione 'S' y para responde No presione 'N'");
                            preg = s.nextLine();
                            while (preg.equalsIgnoreCase(resp) == false && preg.equalsIgnoreCase(resp1) == false){
                                System.out.println();
                                System.out.println("Opcion no valida. Solo puede responder 'S' o 'N'");
                                preg = s.nextLine();
                                System.out.println();
                            }
                            if (preg.equalsIgnoreCase(resp)){
                                bol = false;
                                bol2 = true;
                                option = 1;
                            }
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                            break;
                        case "2":
                            bol = false;
                            break;
                        case "3":
                            preg = "";
                            resp = "s";
                            resp1 = "n";
                            System.out.println("¿Esta seguro que desea terminar la partida?");
                            System.out.println("Para responder Si presione 'S' y para responde No presione 'N'");
                            preg = s.nextLine();
                            while (preg.equalsIgnoreCase(resp) == false && preg.equalsIgnoreCase(resp1) == false){
                                System.out.println();
                                System.out.println("Opcion no valida. Solo puede responder 'S' o 'N'");
                                preg = s.nextLine();
                                System.out.println();
                            }
                            if (preg.equalsIgnoreCase(resp)){
                                bol = false;
                                bol2 = true;
                            }
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                            break;
                        case "4":
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                            System.out.printf("%56s %n%n","******** PARTIDAS JUGADAS ********");
                            System.out.printf("%9s %41s %12s %12s %n%n", "Nombre", "Fecha de Nacimiento", "Punteo", "Movimientos");
                            for(int i = 0; i < 10; i++ ){
                                 System.out.printf("%-2d. %-28s %-24s %5s %8s %n", (i+1), jugadores[i][0],jugadores[i][1], result[i][0], result[i][1]);
                            }
                            while(caso4.equals(caso0) == true){
                                System.out.println();
                                System.out.println("Para ir al menu presione la tecla enter.");
                                caso4 = s.nextLine();
                            }
                            caso4 = caso0;
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                            break;
                        case "5":
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                            instrucciones();
                            while(caso5.equals(caso0) == true){
                            System.out.println("Para ir al menu presione la tecla enter.");
                            caso5 = s.nextLine();
                            }
                            caso5 = caso0;
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n","");
                                break;
                        case "6":
                            preg = "";
                            resp = "s";
                            resp1 = "n";
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
                                bol = false;
                                bol2 = true;
                                option = 4;
                            }
                            break;
                        default:
                            System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n","");
                            System.out.println("No esta entre las opciones");
                            System.out.printf("%n%n","");
                            break;
                    }       
                }
                if (bol2){
                    caso1 ="1";
                    
                    break;
                }
            }   
          
            if (arriba.equalsIgnoreCase(posicion)== true) {
                a = a - 1;
                if(a < 0){
                        a = 0;
                        tablero[a][b] = personaje; 
                    
                } else {
                    if(tablero[a][b].equalsIgnoreCase(pared)){
                        mov = mov - 1;
                        a = a + 1;
                        M = true;
                    }
                    comida = comida(tablero,a,b,comida,mov);
                    if (M == true){
                        tablero[a][b] = personaje;
                        M = false;
                    }
                    else{
                        if(tablero[a][b].equalsIgnoreCase(espacio)){
                            tablero[a][b] = personaje;
                            tablero[a+1][b] = espacio;
                        }
                        else{
                            if(tablero[a][b].equalsIgnoreCase(comida1)){
                                tablero[a][b] = personaje;
                                tablero[a+1][b] = personaje;
                            }
                            else{
                                if(tablero[a][b].equals(comida2)){
                                    tablero[a][b] = personaje;
                                    tablero[a+1][b] = espacio;
                                }
                            }
                        }
                    }
                }
                mov = mov + 1;
            }
            if (abajo.equalsIgnoreCase(posicion) == true){
                a = a + 1;
                if (a > fil - 1){
                        a = fil-1;
                        tablero[a][b] = personaje; 
                }
                else{
                    if(tablero[a][b].equalsIgnoreCase(pared)){
                        mov = mov - 1;
                        a = a - 1;
                        M = true;
                    }                    
                    comida = comida(tablero,a,b,comida,mov);
                    if (M == true){
                        tablero[a][b] = personaje;
                        M = false;
                    }
                    else{
                        if(tablero[a][b].equalsIgnoreCase(espacio)){
                            tablero[a][b] = personaje;
                            tablero[a-1][b] = espacio;
                        }
                        else{
                            if(tablero[a][b].equalsIgnoreCase(comida1)){
                                tablero[a][b] = personaje;
                                tablero[a-1][b] = personaje;
                            }
                            else{
                                if(tablero[a][b].equals(comida2)){
                                    tablero[a][b] = personaje;
                                    tablero[a-1][b] = espacio;
                                }
                            }
                        }
                    }                     
                }
                mov = mov + 1;
            }
            if (izquierda.equalsIgnoreCase(posicion) == true){
                b = b - 1;
                if(b < 0){
                    b = 0;
                    tablero[a][b] = personaje;
                }
                else {
                    if(tablero[a][b].equalsIgnoreCase(pared)){
                        mov = mov - 1;
                        b = b + 1;
                        M = true;
                    }
                    comida = comida(tablero,a,b,comida,mov);
                    if (M == true){
                        tablero[a][b] = personaje;
                        M = false;
                    }
                    else{
                        if(tablero[a][b].equalsIgnoreCase(espacio)){
                            tablero[a][b] = personaje;
                            tablero[a][b+1] = espacio;
                        }
                        else{
                            if(tablero[a][b].equalsIgnoreCase(comida1)){
                                tablero[a][b] = personaje;
                                tablero[a][b+1] = personaje;
                            }
                            else{
                                if(tablero[a][b].equals(comida2)){
                                    tablero[a][b] = personaje;
                                    tablero[a][b-1] = espacio;
                                }
                            }
                        }
                    }
                }
                mov = mov + 1;              
            }
            if (derecha.equalsIgnoreCase(posicion) == true){
                b = b + 1;
                if (b > col - 1){
                        b = col - 1;
                        tablero[a][b] = personaje; 
                        mov = mov - 1;
                }   
                else{
                    if(tablero[a][b].equalsIgnoreCase(pared)){
                        mov = mov - 1;
                        b = b - 1;
                        M = true;
                    }
                    comida = comida(tablero,a,b,comida,mov);
                    if (M == true){
                        tablero[a][b] = personaje;
                        M = false;
                    }
                    else{
                        if(tablero[a][b].equalsIgnoreCase(espacio)){
                            tablero[a][b] = personaje;
                            tablero[a][b-1] = espacio;
                        }
                        else{
                            if(tablero[a][b].equalsIgnoreCase(comida1)){
                                tablero[a][b] = personaje;
                                tablero[a][b-1] = personaje;
                            }
                            else{
                                if(tablero[a][b].equals(comida2)){
                                    tablero[a][b] = personaje;
                                    tablero[a][b+1] = espacio;
                                }
                            }
                        }
                    }
                }
                mov = mov + 1;
            }
            
            //Imprime el tablero conforme se mueve el personaje
            System.out.print("#");
            for (int x = 0; x < col; x++) {
                System.out.print(ladossuperiores);
            }
            System.out.println("#");
            for (int x = 0; x < fil; x++) {
                System.out.print(ladoslaterales);
                for (int y = 0; y < col; y++) {
                    System.out.print(tablero[x][y]);
                }
            System.out.print(ladoslaterales);
            System.out.println();
            }
            System.out.print("#");
            for (int x = 0; x < col; x++) {
                System.out.print(ladossuperiores);
            }
            System.out.println("#");
            
            //Imprime el puntje y el numero de movimientos durante el juego
            if (comida < 0){
                comida = 0;
            }
            
             System.out.printf("%s %3s %-9s %-32s %-4s "
                + "%-4s %-10s %-5s %-4s %n",
                ladoslaterales," ","Jugador:", player, "Puntos:", comida,
                "Movimientos:", mov,ladoslaterales);
            System.out.printf("%-16s %-63s %-2s %n",ladoslaterales,
                "Para regresar al menu presione la tecla 'M'",ladoslaterales);
            System.out.print("#");
            for (int x = 0; x < col; x++) {
                System.out.print(ladossuperiores);
            }            
            System.out.println("#");
        }
        
        //Imprime si ha ganado o perdido
        System.out.println();
        System.out.println();
        if (comida <= 0){
            System.out.println("******* HAS PERDIDO. TE HAS QUEDADO SIN PUNTOS *******");
            System.out.println("Punteo final = " + 0 +  " puntos."+ " Has hecho " + mov + " movimientos.");
        }
        if (comida >= 100) {
            System.out.println("     ****** ¡¡¡FELICIDADES HAS GANADO!!! ******");
            System.out.println("Puntos Obtenidos = " + comida +  " puntos."+ " Has hecho " + mov + " movimientos.");       
        }
        while(caso1.equals(caso0) == true){
            System.out.println();
            System.out.println("Para ir al menu presione la tecla enter.");
            caso1 = s.nextLine();
        }
        caso1 = caso0;
        return new int [] {comida , mov, option} ;
    }
}
