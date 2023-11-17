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


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class TelaPrincipal extends JFrame implements ActionListener{


    private JPanel sidePanel = new JPanel();
    
    private JPanel mainPanel = new JPanel();

    private JPanel sideSubPanelNorth = new JPanel();

    private JPanel sideSubPanelSouth = new JPanel();

    private JPanel usuariosPanel = new JPanel();

    private JPanel eventosPanel = new JPanel();

    private JPanel usuariosBotoesPanel = new JPanel();

    private JButton btnUsuarios = new JButton();

    private JButton btnEventos = new JButton();

    private JButton btnFiltrar = new JButton();
    
    private JButton btnVerEventos = new JButton();

    private CardLayout cl = new CardLayout();

    private JTextField txtTitulo = new JTextField();

    private JTextField txtDescricao = new JTextField();

    private JTextField txtData = new JTextField();

    private JTextField txtHora = new JTextField();



    private JTable tabelaUsuario;


    private GridBagConstraints gbc = new GridBagConstraints();

    
  
    private String[] colunas= {"Nome","Idade"};

    private Object[][] registros = {
        {"João",18},
        {"Leo",19},
        {"Biel",19}
    };



    public TelaPrincipal()
    {
        new JFrame();
        this.setLocationRelativeTo(null);
        this.setSize(800, 550);

        this.setMaximumSize(new Dimension(800,550)); // era pra funcionar
        this.setMinimumSize(new Dimension(800,550));
        
        ImageIcon logoImagem = new ImageIcon("src\\imgs\\LogoMinimalista.jpeg");
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
    
        
            /*=================== USUARIOS PANEL ==================*/
            this.usuariosPanel.setBackground(Color.green);
            this.usuariosPanel.setLayout(new BorderLayout());

            this.tabelaUsuario = new JTable(registros, colunas);

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

            this.txtTitulo.setAlignmentX(JTextField.CENTER_ALIGNMENT);
         



    
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
            this.usuariosPanel.add(tabelaUsuario, BorderLayout.CENTER);
            this.usuariosPanel.add(usuariosBotoesPanel, BorderLayout.NORTH);

            this.usuariosBotoesPanel.add(btnFiltrar, gbc);
            this.usuariosBotoesPanel.add(btnVerEventos, gbc);


            /* ======EVENTOS PANEL====== */

            
            this.eventosPanel.add(txtTitulo);
            this.eventosPanel.add(txtDescricao);
            this.eventosPanel.add(txtData);
            this.eventosPanel.add(txtHora);


            

    }


    private boolean usuariosOn = true;
    private boolean eventosOn = false;

    private TelaPesquisar telaPesquisar = new TelaPesquisar();

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
                telaPesquisar.setarComponentes();
                telaPesquisar.addComponentes();
                telaPesquisar.setVisible(true);
            }

        

        


        }
    }

 
    

    
    
}
