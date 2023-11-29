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
            String sql = "select * from calendario.ViewEventos";

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
            String sql = "select * from calendario.ViewEventos where id = ?";


           
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
}
