package daos;


import java.sql.SQLException;
import java.util.ArrayList;

import bdConnection.BDSQLServer;
import bdConnection.MeuResultSet;
import dbos.Usuario;


public class Usuarios {

   public static Usuario getUsuario(int id)throws Exception{
    Usuario usuario = null;
    try{
        String sql;

        sql = "SELECT * " +
              "FROM CALENDARIO.USUARIO " +
              "WHERE ID = ?";

        BDSQLServer.COMANDO.prepareStatement (sql);

        BDSQLServer.COMANDO.setInt (1, id);

        MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
        if(!resultado.first())
            throw new Exception("Usuário de id: " + id + " não cadastrado!");
        
        usuario = new Usuario(resultado.getInt("ID"),
                              resultado.getString("NOME"),
                              resultado.getString("SOBRENOME"),
                              resultado.getString("EMAIL"),
                              resultado.getString("TELEFONE"));

    } catch(Exception e){
        e.printStackTrace();
    }

    return usuario;
   }

//    public static MeuResultSet getUsuarios() throws Exception
//     {
//         MeuResultSet resultado = null;

//         try
//         {
//             String sql;

//             sql = "select * from calendario.usuario";

//             BDSQLServer.COMANDO.prepareStatement (sql);

//             resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

//         }
//         catch (SQLException erro)
//         {
//             throw new Exception ("Erro ao buscar por usuários!");
//         }

//         return resultado;
//     }


    public static ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> usuarioList = new ArrayList<>();
        try{

            String sql;

            sql = "select * from calendario.usuario";

            BDSQLServer.COMANDO.prepareStatement(sql);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            Usuario usuario = null;
            while(resultado.next()){
                usuario = new Usuario(resultado.getInt("ID"),
                              resultado.getString("NOME"),
                              resultado.getString("SOBRENOME"),
                              resultado.getString("EMAIL"),
                              resultado.getString("TELEFONE"));
                usuarioList.add(usuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return usuarioList;
        
    } 

}
