import java.util.Arrays;
import java.util.Scanner;
public class Main {
  
  public static void main(String[] args) {
    Generador gen = new Generador();
    Scanner scan = new Scanner(System.in);
    Sorts sort = new Sorts();

    boolean menuPrincipal = true;
    boolean s = true;
    int cant =0;

    while(menuPrincipal){
      try{
        System.out.println("\nQue tipo de sort quiere utilizar?");
        System.out.println("1. Gnome Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Quick Sort");
        System.out.println("4. Radix Sort");
        System.out.println("5. Selection Sort");
        System.out.println("6. Salir");

        int seleccionMenu = scan.nextInt();

        switch(seleccionMenu){
          case 1:{
            s = true;
            while(s){
              try{
                System.out.println("Cuanto datos desea crear");
                cant = scan.nextInt();
                if(cant<=3000 && cant>0){
                  s = false;
                }
              }catch(Exception e){
                System.out.println("Ingrese valores numericos");
              }
            }
            Integer[] arra = gen.Generar(cant);
            System.out.println("El Array Original es:");
            System.out.println(Arrays.toString(arra));
            sort.gnomeSort(arra);
            System.out.println("El Array Sorteado utilizando el algoritmo Gnome sort es:");
            System.out.println(Arrays.toString(arra));

            /*
            for(int i =10; i <= 3000; i++){
              Integer[] arra = gen.Generar(i);
              System.out.println("El Array Original es:");
              System.out.println(Arrays.toString(arra));
              sort.gnomeSort(arra);
              System.out.println("El Array Sorteado utilizando el algoritmo Gnome sort es:");
              System.out.println(Arrays.toString(arra));
            }
            */

            break;

          }
          case 2:{
            s = true;
            while(s){
              try{
                System.out.println("Cuanto datos desea crear");
                cant = scan.nextInt();
                if(cant<=3000 && cant>0){
                  s = false;
                }
              }catch(Exception e){
                System.out.println("Ingrese valores numericos");
              }
            }
            Integer[] arra = gen.Generar(cant);
            System.out.println("El Array Original es:");
            System.out.println(Arrays.toString(arra));
            arra = sort.mergeSort(arra);
            System.out.println("El Array Sorteado utilizando el algoritmo Merge sort es:");
            System.out.println(Arrays.toString(arra));

            break;

          }
          case 3:{
            s = true;
            while(s){
              try{
                System.out.println("Cuanto datos desea crear");
                cant = scan.nextInt();
                if(cant<=3000 && cant>0){
                  s = false;
                }
              }catch(Exception e){
                System.out.println("Ingrese valores numericos");
              }
            }
            Integer[] arra = gen.Generar(cant);
            System.out.println("El Array Original es:");
            System.out.println(Arrays.toString(arra));
            sort.quicksort(arra, 0, cant-1);
            System.out.println("El Array Sorteado utilizando el algoritmo Quick sort es:");
            System.out.println(Arrays.toString(arra));

            break;

          }
          case 4:{
            s = true;
            while(s){
              try{
                System.out.println("Cuanto datos desea crear");
                cant = scan.nextInt();
                if(cant<=3000 && cant>0){
                  s = false;
                }
              }catch(Exception e){
                System.out.println("Ingrese valores numericos");
              }
            }
            Integer[] arra = gen.Generar(cant);
            System.out.println("El Array Original es:");
            System.out.println(Arrays.toString(arra));
            sort.radixsort(arra, cant-1);
            System.out.println("El Array Sorteado utilizando el algoritmo Radix sort es:");
            System.out.println(Arrays.toString(arra));

            break;

          }
          case 5:{
            s = true;
            while(s){
              try{
                System.out.println("Cuanto datos desea crear");
                cant = scan.nextInt();
                if(cant<=3000 && cant>0){
                  s = false;
                }
              }catch(Exception e){
                System.out.println("Ingrese valores numericos");
              }
            }
            Integer[] arra = gen.Generar(cant);
            System.out.println("El Array Original es:");
            System.out.println(Arrays.toString(arra));
            sort.selectionSort(arra);
            System.out.println("El Array Sorteado utilizando el algoritmo Selection sort es:");
            System.out.println(Arrays.toString(arra));

            break;

          }
          case 6:{
            System.out.println("Gracias por utilizar nuestro programa");
            menuPrincipal = false;
            break;

          }
          default:{
            scan.nextLine();
            System.out.println("Se ingreso una opcion invalida, intentelo de nuevo.");
          }
        }
      } catch (Exception e) {
        scan.nextLine();
        System.err.println("Se ingreso una opcion invalida, intentelo de nuevo");
      }
    }

  }
  
}
