

import java.util.Calendar;
import java.util.Date;
import model.Aluguel;
import model.Quartos;
import model.Quartos_;



public class Teste {

     public static void main(String[] args) {
            
     
    }

    
        
       public float valor(){
        Quartos quartos = new Quartos();
           Aluguel a = new Aluguel();
        float total = quartos.getValorQuarto()* a.verificaQtdDias();
        System.out.println("tt"+total);
        return total;
        }
}
