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

        for(int i = 0; i < listaClausula.size(); i++){
            if(listaClausula.get(i).equals("")){}
            else{

                if(i == listaClausula.size() - 1 && listaClausula.get(i - 1).equals("")){
                    clausulas += " and ";
                
                }
                clausulas += nomeCampos.get(i) + " like " + "'%" + listaClausula.get(i) + "%'";

                if(i == listaClausula.size() - 1){}
                else if(!listaClausula.get(i + 1).equals("")){
                    clausulas += " and ";
                }
            }
        }


        
        String sql = "select * from calendario.usuario where " + clausulas;

        System.out.println(sql);
                  
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

