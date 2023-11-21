package telas;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TelaEventos extends JFrame{

    private String[] colunas= {"Nome","Idade"};

    private Object[][] registros = {
        {"João",18},
        {"Leo",19},
        {"Biel",19}
    };

    private JTable tabelaEventos = new JTable(registros,colunas);

    public TelaEventos(){
        new JFrame();
        setTitle("SmartCalendar - Eventos");
        setSize(600,400);
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout());
    }

    public void setarComponentes(){
        
    }

    public void addComponentes(){
        add(tabelaEventos, BorderLayout.CENTER);


    }
}
