package telas;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import daos.Usuarios;
import dbos.Usuario;
import javafx.beans.binding.ObjectExpression;


public class TelaPrincipal extends JFrame implements ActionListener{


    private JPanel sidePanel = new JPanel();
    
    private JPanel mainPanel = new JPanel();

    private JPanel sideSubPanelNorth = new JPanel();

    private JPanel sideSubPanelSouth = new JPanel();

    private JPanel usuariosPanel = new JPanel();

    private JPanel eventosPanel = new JPanel();

    private JPanel eventosCenterPanel = new JPanel();

    private JPanel usuariosBotoesPanel = new JPanel();

    private JScrollPane tabelaUsuarioScrollPanel = new JScrollPane();

    private JPanel aplicarPanel = new JPanel();

    private JButton btnUsuarios = new JButton();

    private JButton btnEventos = new JButton();

    private JButton btnFiltrar = new JButton();

    private JButton btnAplicarEventos = new JButton();
    
    private JButton btnVerEventos = new JButton();

    private CardLayout cl = new CardLayout();

    private JTextField txtTitulo = new JTextField();

    private JTextField txtDescricao = new JTextField();

    private JTextField txtData = new JTextField();

    private JTextField txtHora = new JTextField();

    private JLabel labelTitulo = new JLabel();

    private JLabel labelDescricao = new JLabel();

    private JLabel labelData = new JLabel();

    private JLabel labelHora = new JLabel();

    private JTable tabelaUsuario;

    private GridBagConstraints gbc = new GridBagConstraints();

    private String[] colunas= {"Id do usuário","Nome do usuário", "Sobrenome do usuário", "Email", "Telefone"};


    private JFrame telaPesquisar =  new JFrame();



    public TelaPrincipal()
    {
        new JFrame();
        this.setLocationRelativeTo(null);
        this.setSize(800, 550);

        this.setMaximumSize(new Dimension(800,550)); // era pra funcionar
        this.setMinimumSize(new Dimension(800,550));
        
        ImageIcon logoImagem = new ImageIcon("src\\img\\LogoMinimalista.jpeg");
        this.setIconImage(logoImagem.getImage());

        this.setTitle("SmartCalendar - Tela de administração");

        this.setLayout(new BorderLayout());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }


    public void setarComponentes()
    {

        /*=================== SIDE PANEL ==================*/ 
        this.sidePanel.setPreferredSize(new Dimension(125,100));
        this.sidePanel.setBackground(Color.lightGray);
        // this.sidePanel.setBorder(null); // descobrir
        
        this.sidePanel.setLayout(new BorderLayout());

            /*=================== SIDE SUB PANEL NORTH ==================*/ 
            this.sideSubPanelNorth.setPreferredSize(new Dimension(100,100));
            this.sideSubPanelNorth.setBackground(Color.lightGray);
            this.sideSubPanelNorth.setLayout(new GridLayout(2,1,0,20));
            this.sideSubPanelNorth.setBorder(BorderFactory.createEmptyBorder(20, 10, 10,10));
        

            /*=================== SIDE SUB PANEL SOUTH ==================*/ 

            this.sideSubPanelSouth.setBackground(Color.lightGray);
            this.sideSubPanelSouth.setPreferredSize(new Dimension(100,100));
        
            this.sideSubPanelSouth.setLayout(new GridLayout(2,1));
        
        /*=================== MAIN PANEL ==================*/
        this.mainPanel.setLayout(cl);
    
        
            /*=================== USUARIOS PANEL ==================*/;
            this.usuariosPanel.setLayout(new BorderLayout());
            
            // this.tabelaUsuario = new JTable(new Object[0][0], colunas);
            this.tabelaUsuario = new JTable(preencherTabela());
            this.tabelaUsuario.setName("tabelaUsuario");
            this.tabelaUsuario.getTableHeader().setReorderingAllowed(false);
            this.tabelaUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            
            this.usuariosBotoesPanel.setPreferredSize(new Dimension(100,100));
            this.usuariosBotoesPanel.setLayout(new GridBagLayout());
        
            this.btnFiltrar.setText("    Filtrar...    ");
            this.btnFiltrar.setFocusable(false);
            this.btnFiltrar.setBackground(Color.white);
            this.btnFiltrar.addActionListener(this);
           
            this.btnVerEventos.setText("Ver eventos");
            this.btnVerEventos.setFocusable(false);
            this.btnVerEventos.setBackground(Color.white);
            this.btnVerEventos.addActionListener(this);

            gbc.insets = new Insets(100,100,100,100);


            /*=================== EVENTOS PANEL ================== */
            this.eventosPanel.setLayout(new BoxLayout(eventosPanel, BoxLayout.PAGE_AXIS));
            
            this.eventosCenterPanel.setLayout(new GridLayout(8,1,10,10));
            this.eventosCenterPanel.setMaximumSize(new Dimension(200,200));

            this.labelTitulo.setText("Título do evento");
            this.txtTitulo.setMaximumSize(new Dimension(150,30));
            
            this.labelDescricao.setText("Descrição do evento");
            this.txtDescricao.setMaximumSize(new Dimension(150,30));

            this.labelData.setText("Data do evento");
            this.txtData.setMaximumSize(new Dimension(150,30));

            this.labelHora.setText("Hora do evento");
            this.txtHora.setMaximumSize(new Dimension(150,30));

            this.aplicarPanel.setMaximumSize(new Dimension(100,100));
            
            this.btnAplicarEventos.setText("Aplicar");
            this.btnAplicarEventos.setFocusable(false);
            this.btnAplicarEventos.setBackground(Color.white);

        
    
        /* ------------- BOTAO MOSTRAR USUARIOS ------------*/
        this.btnUsuarios.setBackground(Color.white);
        this.btnUsuarios.setText("Usuários");
        this.btnUsuarios.addActionListener(this);
        this.btnUsuarios.setFocusable(false);
       
     

        /* ------------- BOTAO EVENTOS -------------------*/
        this.btnEventos.setBackground(Color.white);
        this.btnEventos.setText("Eventos");
        this.btnEventos.addActionListener(this);
        this.btnEventos.setFocusable(false);


    }

    public void addComponentes()
    {
        /* ========= SIDE PANEL ADDS =========*/
        this.add(sidePanel, BorderLayout.WEST);

        this.sidePanel.add(sideSubPanelNorth, BorderLayout.NORTH);
        this.sidePanel.add(sideSubPanelSouth, BorderLayout.SOUTH); // ADD BOTAO COMO USAR O POGRAMA

            /* ---------- SIDE SUB PANEL NORTH ADDS ----------*/
            this.sideSubPanelNorth.add(btnUsuarios);
            this.sideSubPanelNorth.add(btnEventos);

             /* ---------- SIDE SUB PANEL SOUTH ADDS ----------*/



        /* ========= MAIN PANEL ADDS =========*/
        this.add(mainPanel, BorderLayout.CENTER);
        this.mainPanel.add(usuariosPanel, "usuariosPanel");
        this.mainPanel.add(eventosPanel, "eventosPanel");
        cl.show(mainPanel, "usuariosPanel");

            /* ======USUÁRIO PANEL====== */
          
            // this.usuariosPanel.add(tabelaUsuarioScrollPanel, BorderLayout.CENTER);
            this.usuariosPanel.add(new JScrollPane(tabelaUsuario), BorderLayout.CENTER);

    
            this.usuariosPanel.add(usuariosBotoesPanel, BorderLayout.NORTH);
            this.usuariosBotoesPanel.add(btnFiltrar, gbc);
            this.usuariosBotoesPanel.add(btnVerEventos, gbc);


            /* ======EVENTOS PANEL====== */
            

            
            this.eventosPanel.add(Box.createHorizontalStrut(160));
            this.eventosPanel.add(Box.createVerticalGlue());

            
            this.eventosPanel.add(eventosCenterPanel);

            this.eventosCenterPanel.add(labelTitulo);
            this.eventosCenterPanel.add(txtTitulo);
        
          
            this.eventosCenterPanel.add(labelDescricao);
            this.eventosCenterPanel.add(txtDescricao);
            
            
            this.eventosCenterPanel.add(labelData);
            this.eventosCenterPanel.add(txtData);
            
            
            this.eventosCenterPanel.add(labelHora);
            this.eventosCenterPanel.add(txtHora);

            this.eventosPanel.add(Box.createRigidArea(new Dimension(0,10)));
           
            this.eventosPanel.add(aplicarPanel);

            this.aplicarPanel.add(btnAplicarEventos);
        
            this.eventosPanel.add(Box.createVerticalGlue());
            this.eventosPanel.add(Box.createHorizontalStrut(160));

    }


    private boolean usuariosOn = true;
    private boolean eventosOn = false;

    // private TelaPesquisar telaPesquisar = new TelaPesquisar();

    private TelaEventos telaEventos = new TelaEventos();

    @Override
    public void actionPerformed(ActionEvent event) {

        if(event.getSource() == this.btnUsuarios && usuariosOn == false){   
            cl.show(mainPanel, "usuariosPanel");
            usuariosOn = !usuariosOn;
            eventosOn= !eventosOn;
        }

        if(event.getSource() == this.btnEventos  && eventosOn == false){
            cl.show(mainPanel, "eventosPanel");  
            eventosOn= !eventosOn;
            usuariosOn= !usuariosOn;
        }

        if(event.getSource() == this.btnFiltrar){
            if(telaPesquisar.isVisible())
            {}else{
                //telaPesquisar.setarComponentes();
                //telaPesquisar.addComponentes();
                //telaPesquisar.setVisible(true);
                construirTelaPesquisar(); // Creio que esse modo de fazer uma nova tela está errado, porem não encontrei uma forma de filtrar a tabela que esta na telaPrincipal usando dados de outra instãncia (telaPesquisar)
                telaPesquisar.setVisible(true);
            }
        }

        if(event.getSource()== this.btnVerEventos){
            if(telaEventos.isVisible())
            {}else{
                telaEventos.setarComponentes();
                telaEventos.addComponentes();
                telaEventos.setVisible(true);
            }
        }
    }

    public DefaultTableModel preencherTabela(){
        ArrayList<Usuario> listUsuario = Usuarios.getUsuarios();
        DefaultTableModel tabelaModelo =  new DefaultTableModel(new Object[0][listUsuario.size()], colunas){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }};


        Object[] linha = new Object[5];
        for(int i = 0; i< listUsuario.size(); i++){
            linha[0]=listUsuario.get(i).getId();
            linha[1]=listUsuario.get(i).getNome();
            linha[2]=listUsuario.get(i).getSobrenome();
            linha[3]=listUsuario.get(i).getEmail();
            linha[4]=listUsuario.get(i).getTelefone();
            tabelaModelo.addRow(linha);
        }

        return tabelaModelo;

    }
 
    private void construirTelaPesquisar(){
    JTextField txtId = new JTextField();

    JTextField txtNome = new JTextField();

    JTextField txtSobrenome = new JTextField();

    JTextField txtEmail = new JTextField();

    JTextField txtTelefone = new JTextField();

    JLabel labelId = new JLabel();

    JLabel labelNome = new JLabel();

    JLabel labelSobrenome = new JLabel();

    JLabel labelEmail = new JLabel();

    JLabel labelTelefone = new JLabel();

    JButton btnFiltrar = new JButton();

    JPanel mainPanel = new JPanel();

    telaPesquisar.setTitle("SmartCalendar - Pesquisar");

    ImageIcon logoImagem2 = new ImageIcon("src\\imgs\\LogoMinimalista.jpeg");
    telaPesquisar.setIconImage(logoImagem2.getImage());

    telaPesquisar.setLocationRelativeTo(null);
    telaPesquisar.setSize(300,500);

    telaPesquisar.setResizable(false);

    mainPanel.setLayout(null);

    labelId.setText("Id do usuário");
    labelId.setBounds(112,35,75,10);
    txtId.setBounds(75,50,150,25);

    labelNome.setText("Nome do usuário");
    labelNome.setBounds(100,105,100,10);
    txtNome.setBounds(75,120,150,25);

    labelSobrenome.setText("Sobrenome do Usuário");
    labelSobrenome.setBounds(83,175,130,10);
    txtSobrenome.setBounds(75,190,150,25);

    labelEmail.setText("Email do usuário");
    labelEmail.setBounds(102,245,95,10);
    txtEmail.setBounds(75,260,150,25);

    labelTelefone.setText("Telefone do usuário");
    labelTelefone.setBounds(92,315,115,10);
    txtTelefone.setBounds(75,330, 150,25);

    btnFiltrar.setFocusable(false);
    btnFiltrar.setBackground(Color.white);
    btnFiltrar.setText("Filtrar");
    btnFiltrar.setBounds(105,390,90,25);
    btnFiltrar.addActionListener(this);

    telaPesquisar.add(mainPanel);

    mainPanel.add(labelId);
    mainPanel.add(txtId);

    mainPanel.add(labelNome);
    mainPanel.add(txtNome);

    mainPanel.add(labelSobrenome);
    mainPanel.add(txtSobrenome);

    mainPanel.add(labelEmail);
    mainPanel.add(txtEmail);

    mainPanel.add(labelTelefone);
    mainPanel.add(txtTelefone);

    mainPanel.add(btnFiltrar);
    }


    
    
}
