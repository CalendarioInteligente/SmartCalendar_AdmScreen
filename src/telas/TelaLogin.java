package telas;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame implements ActionListener{

    private JButton btnLogar;

    private JPasswordField pwd;

    private JLabel pwdLabel;

    private JLabel label;

    private boolean logado;

    public TelaLogin()
    {
        new JFrame();

        this.setLocationRelativeTo(null);

        this.setTitle("Adm - LOGIN");

        ImageIcon logoImagem = new ImageIcon("src\\img\\LogoMinimalista.jpeg");
        this.setIconImage(logoImagem.getImage());

    
        this.setSize(300, 350);
        this.setResizable(false);


        

        
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    public void setarComponentes()
    {
        this.label = new JLabel("SmartCalendar - ADM Screen");
        this.label.setBounds(60,3,200,50); 


        this.pwd = new JPasswordField();
        this.pwd.setBounds(75, 150, 150, 30);

        this.pwdLabel = new JLabel("Senha");
        this.pwdLabel.setBounds(75,115,50,50);
  

        this.btnLogar = new JButton();
        this.btnLogar.setBounds(115, 200, 70,30);
        this.btnLogar.setText("Logar");
        this.btnLogar.setBackground(Color.WHITE);
        this.btnLogar.addActionListener(this);
        this.btnLogar.setFocusable(false);
    }


    public void addComponentes()
    {
        this.add(this.label);
        this.add(this.pwd);
        this.add(this.btnLogar);
        this.add(this.pwdLabel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
      if(event.getSource() == this.btnLogar)
      {
        if(this.verificarSenha())
        {  
            this.logado= true;
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Senha incorreta!", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.logado= false;
        }
        
        
      }
    }

    public boolean isLogado()
    {
        if(this.logado) return true;
        
        return false;

    }


    private boolean verificarSenha()
    {
        if(this.pwd.getText().equals("admin")) return true;

        return false;
    }
}
