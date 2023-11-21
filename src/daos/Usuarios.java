package daos;


import bdConnection.BDSQLServer;
import bdConnection.MeuResultSet;
import dbos.Usuario;


public class Usuarios {
    public static Usuario selectUsuario(int id){
        Usuario usuario = null;

        try{
            String sql = "Select * from calendario.usuario where id = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, id);

            MeuResultSet res = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            usuario = new Usuario(res.getInt("id"),
                                   res.getString("nome"),
                                   res.getString("sobrenome"),
                                   res.getString("email"),
                                   res.getString("telefone"),
                                   res.getString("senha"));
        }catch(Exception e){
            e.printStackTrace();
        }

        return usuario;

    }
    public static MeuResultSet selectUsuarios(){
        MeuResultSet usuarios = null;

        try{

            String sql;

            sql = "Select * from Calendario.Usuario ";

            BDSQLServer.COMANDO.prepareStatement(sql);
            usuarios= (MeuResultSet)BDSQLServer.COMANDO.executeQuery();



            // usuarios = new Usuario(res.getInt("id"),
            //                        res.getString("nome"),
            //                        res.getString("sobrenome"),
            //                        res.getString("email"),
            //                        res.getString("telefone"),
            //                        res.getString("senha"));

            
        } catch(Exception e){
            e.printStackTrace();
        }
        return usuarios;

    }

}
