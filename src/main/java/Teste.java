
import dao.ClienteDao;
import java.util.Iterator;
import java.util.List;
import model.Cliente;


public class Teste {
     public static void main(String[] args) {
         

         ClienteDao dao = new ClienteDao();
        List<Cliente> l= dao.getLista();
 
         for (Cliente cl : l) {
             System.out.println("Departamentos: " + cl.getNome() +" , " + cl.getCpf());
         }
        
    }
}
