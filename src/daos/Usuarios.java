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


    public static ArrayList<Usuario> getUsuariosComClausula(String id, String nome, String sobrenome, String email, String telefone){

        ArrayList<Usuario> usuarioList = new ArrayList<>();

        try{

        ArrayList<String> listaClausula = new ArrayList<>();

        listaClausula.add(id);
        listaClausula.add(nome);
        listaClausula.add(sobrenome);
        listaClausula.add(email);
        listaClausula.add(telefone);

        ArrayList<String> nomeCampos = new ArrayList<>();

        nomeCampos.add("id");
        nomeCampos.add("nome");
        nomeCampos.add("sobrenome");
        nomeCampos.add("email");
        nomeCampos.add("telefone");
      
        String clausulas = "";

        boolean and = false;
        for(int i = 0; i < listaClausula.size(); i++){
            if(listaClausula.get(i).equals("")){}
            else{
                if(and == true)
                    clausulas += " and ";    
            
                clausulas += nomeCampos.get(i) + " like " + "'%" + listaClausula.get(i) + "%'";
                and = true;
            }
        }

        if(clausulas != ""){
            String temp = clausulas;
            clausulas =  " where ";
            clausulas += temp;
        }
        else{}
        
        String sql = "select * from calendario.usuario" + clausulas;
                  
        BDSQLServer.COMANDO.prepareStatement(sql);

        MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

        Usuario usuario = null;

        while(resultado.next()){
            usuario = new Usuario(
                            resultado.getInt("ID"),
                            resultado.getString("NOME"),
                            resultado.getString("SOBRENOME"),
                            resultado.getString("EMAIL"),
                            resultado.getString("TELEFONE")
                            );
                usuarioList.add(usuario);
            }

            

        }catch(Exception e){
        e.printStackTrace();
        }

        return usuarioList;
    }

}

