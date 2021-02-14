import java.util.Arrays;
import java.util.Scanner;
public class Main {
  
  public static void main(String[] args) {
    Generador gen = new Generador();
    Scanner scan = new Scanner(System.in);
    Sorts sort = new Sorts();

    System.out.println("Cuanto datos desea crear");
    boolean s = true;
    int cant =0;
    while(s)
    try{
      cant = scan.nextInt();
      if(cant<=3000 && cant>0){
        s = false;
      }
    }catch(Exception e){
      System.out.println("Ingrese valores numericos");
    }
    Integer[] arra = gen.Generar(cant);

    sort.radixsort(arra, cant-1);

    System.out.println(Arrays.toString(arra));

    scan.close();
    
  }
  
}
