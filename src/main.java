import daos.Usuarios;
import telas.TelaLogin;
import telas.TelaPrincipal;

public class main {

    public static void main(String[] args){
        try
        {
          // TelaLogin telaLogin = new TelaLogin();
          // telaLogin.setarComponentes();
          // telaLogin.addComponentes();
          // telaLogin.setVisible(true);

          // boolean logou;
          // do{
          //   logou = telaLogin.isLogado();
          //   Thread.sleep(300);
          // } while (!logou);

          TelaPrincipal telaPrincipal = new TelaPrincipal();
          telaPrincipal.setarComponentes();
          telaPrincipal.addComponentes();
          telaPrincipal.setVisible(true);
        }
          
        
        catch(Exception erro){System.out.println(erro);}

    }
    


}
