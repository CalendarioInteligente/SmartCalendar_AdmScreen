package daos;

import java.util.ArrayList;

import bdConnection.BDSQLServer;
import bdConnection.MeuResultSet;
import dbos.Evento;
import dbos.ViewEventos;

public class Eventos {

    public static ArrayList<ViewEventos> getEventos(){
            ArrayList<ViewEventos> eventoList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM CALENDARIO.ViewEventos";

            BDSQLServer.COMANDO.prepareStatement(sql);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
            while(resultado.next()){
                ViewEventos evento = new ViewEventos(resultado.getString("Nome"), 
                                            resultado.getString("Sobrenome"), 
                                            resultado.getString("Titulo"),
                                            resultado.getString("Descricao"),
                                            resultado.getDate("Data").toString(),
                                            resultado.getTime("Data").toString());
                eventoList.add(evento);
            }



        }catch(Exception e){
            e.printStackTrace();
        }

        return eventoList;

    }
    
     public static ArrayList<ViewEventos> getEventos(int id){
            ArrayList<ViewEventos> eventoList = new ArrayList<>();
        try{
            String sql = "SELECT * FROM CALENDARIO.ViewEventos WHERE id = ?";


            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, id);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();
            while(resultado.next()){
                ViewEventos evento = new ViewEventos(resultado.getString("Nome"), 
                                            resultado.getString("Sobrenome"), 
                                            resultado.getString("Titulo"),
                                            resultado.getString("Descricao"),
                                            resultado.getDate("Data").toString(),
                                            resultado.getTime("Data").toString());
                eventoList.add(evento);
            }



        }catch(Exception e){
            e.printStackTrace();
        }

        return eventoList;

    }


    public static boolean setEventoGlobalmente(String titulo, String descricao, String data, String hora){

        try{
            String dataComHoras = data + " " + hora;

            String sql = "DECLARE @dat DATETIME = CONVERT(DATETIME,'" + dataComHoras + "',103); " +
                         "EXEC Calendario.aplicarEventoGlobalmente '" + descricao +"', '" + titulo + "', @dat";

            BDSQLServer.COMANDO.prepareStatement(sql);

            // BDSQLServer.COMANDO.setString(1, descricao); Não funciona
            // BDSQLServer.COMANDO.setString(2, titulo);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
            
            return true;
        

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
