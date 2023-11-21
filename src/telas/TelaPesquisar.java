package telas;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPesquisar extends JFrame{

    private JTextField txtId = new JTextField();

    private JTextField txtNome = new JTextField();

    private JTextField txtSobrenome = new JTextField();

    private JTextField txtEmail = new JTextField();

    private JTextField txtTelefone = new JTextField();

    private JLabel labelId = new JLabel();

    private JLabel labelNome = new JLabel();

    private JLabel labelSobrenome = new JLabel();

    private JLabel labelEmail = new JLabel();

    private JLabel labelTelefone = new JLabel();

    private JButton btnFiltrar = new JButton();

    private JPanel mainPanel = new JPanel();


    public TelaPesquisar(){
       new JFrame();

       this.setTitle("SmartCalendar - Pesquisar");

       ImageIcon logoImagem = new ImageIcon("src\\imgs\\LogoMinimalista.jpeg");
       this.setIconImage(logoImagem.getImage());

       this.setSize(300,500);

       this.setResizable(false);

    }

    public void setarComponentes(){
        this.mainPanel.setLayout(null);

        this.labelId.setText("Id do usuário");
        this.labelId.setBounds(112,35,75,10);
        this.txtId.setBounds(75,50,150,25);

        this.labelNome.setText("Nome do usuário");
        this.labelNome.setBounds(100,105,100,10);
        this.txtNome.setBounds(75,120,150,25);

        this.labelSobrenome.setText("Sobrenome do Usuário");
        this.labelSobrenome.setBounds(83,175,130,10);
        this.txtSobrenome.setBounds(75,190,150,25);

        this.labelEmail.setText("Email do usuário");
        this.labelEmail.setBounds(102,245,95,10);
        this.txtEmail.setBounds(75,260,150,25);

        this.labelTelefone.setText("Telefone do usuário");
        this.labelTelefone.setBounds(92,315,115,10);
        this.txtTelefone.setBounds(75,330, 150,25);

        this.btnFiltrar.setFocusable(false);
        this.btnFiltrar.setBackground(Color.white);
        this.btnFiltrar.setText("Filtrar");
        this.btnFiltrar.setBounds(105,390,90,25);
 
       
      
      

    }

    public void addComponentes(){

        this.add(mainPanel);

        this.mainPanel.add(labelId);
        this.mainPanel.add(txtId);

        this.mainPanel.add(labelNome);
        this.mainPanel.add(txtNome);

        this.mainPanel.add(labelSobrenome);
        this.mainPanel.add(txtSobrenome);

        this.mainPanel.add(labelEmail);
        this.mainPanel.add(txtEmail);

        this.mainPanel.add(labelTelefone);
        this.mainPanel.add(txtTelefone);

        this.mainPanel.add(btnFiltrar);

        

    }
    

    
    
    
    
}
