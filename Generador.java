import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
public class Generador {

  private Random rand = new Random();

  public Integer[] Generar(int cantidad){
    
    Integer[] lista = new Integer[cantidad];
    String numbers = "";

    for(int i =0; i<cantidad; i++){
      int agregar = rand.nextInt(30001);
      lista[i] = agregar;
      numbers+= agregar +",";
    }



    try {
      FileWriter myWriter = new FileWriter("Datos.txt");
      myWriter.write(numbers);
      myWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lista;
  }

}
