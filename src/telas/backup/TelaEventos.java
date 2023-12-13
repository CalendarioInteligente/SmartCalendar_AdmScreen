package telas.backup;



import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import daos.Eventos;
import daos.Usuarios;
import dbos.Usuario;
import dbos.ViewEventos;

public class TelaEventos extends JFrame{

    private String[] colunasEventos= {"Nome","Sobrenome", "Título", "Descrição", "Data","Hora"};

    private JTable tabelaEventos;
    
    private JScrollPane tabelaEventosScrollPane;


    public TelaEventos(){
        new JFrame();
        setTitle("SmartCalendar - Eventos");
        setSize(600,400);
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout());
    }

    public void setarComponentes(){
        this.tabelaEventos = new JTable(preencherTabelaEventos());
        this.tabelaEventos.getTableHeader().setReorderingAllowed(false);
        this.tabelaEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.tabelaEventosScrollPane = new JScrollPane(tabelaEventos);
    }

    public void addComponentes(){
        add(tabelaEventosScrollPane, BorderLayout.CENTER);
    }

    public DefaultTableModel preencherTabelaEventos(){
        ArrayList<ViewEventos> listEventos = Eventos.getEventos();
        DefaultTableModel tabelaModelo =  new DefaultTableModel(new Object[0][listEventos.size()], colunasEventos){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }};


        Object[] linha = new Object[6];
        for(int i = 0; i< listEventos.size(); i++){
            linha[0]=listEventos.get(i).getNome();
            linha[1]=listEventos.get(i).getSobrenome();
            linha[2]=listEventos.get(i).getTitulo();
            linha[3]=listEventos.get(i).getDescricao();
            linha[4]=listEventos.get(i).getData();
            linha[5]=listEventos.get(i).getHora();
            tabelaModelo.addRow(linha);
        }

        return tabelaModelo;

    }
}
