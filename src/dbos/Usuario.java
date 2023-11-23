package dbos;

public class Usuario {

    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;

    public void setId(int id)throws Exception{
        if(id <= 0) throw new Exception("Id inválido");

        this.id = id;
    }

    public void setNome(String nome) throws Exception{
        if(nome == null || nome.equals("")) throw new Exception("Nome inválido!");

        this.nome = nome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email)throws Exception{
        if(email == null || email.equals("")) throw new Exception("Email inválido!");

        this.email=email;
    }

    public void setTelefone(String telefone){
        // if(telefone.equals("")) throw new Exception("Telefone inválido!");

        this.telefone = telefone;
    }


    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getSobrenome(){
        return this.sobrenome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTelefone(){
        return this.telefone;
    }

  

    public Usuario(int id, String nome, String sobrenome, String email, String telefone) throws Exception{
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        setTelefone(telefone);
    }

    @Override
    public String toString(){
        return 
        "id: " + this.id + "\n" +
        "Nome: " + this.nome + "\n" +
        "Sobrenome: " + this.sobrenome + "\n" +
        "Email: " + this.email + "\n" +
        "Telefone: " + this.telefone + "\n";
    }

    @Override 
    public int hashCode(){
        int ret = 1;
        
        ret += 7*ret + Integer.valueOf(this.id).hashCode();
        ret += 7*ret + String.valueOf(this.nome).hashCode();
        ret += 7*ret + String.valueOf(this.sobrenome).hashCode();
        ret += 7*ret + String.valueOf(this.email).hashCode();
        ret += 7*ret + String.valueOf(this.telefone).hashCode();

        if(ret< 0) ret = -ret;

        return ret;

    }

    @Override
    public boolean equals(Object u){
        if(u == null) return false;
        if(this.getClass() != u.getClass()) return false;
    
        Usuario usuario = (Usuario) u;

        if(this.getId() != usuario.getId()) return false;
        if(this.getNome() != usuario.getNome()) return false;
        if(this.getSobrenome() != usuario.getSobrenome()) return false;
        if(this.getEmail() != usuario.getEmail()) return false;
        if(this.getTelefone() != usuario.getTelefone()) return false;

        return true;
    }

    public Usuario(Usuario u) throws Exception{
        if(u == null) throw new Exception("Usuário nulo");

        this.id = u.getId();
        this.nome = u.getNome();
        this.sobrenome = u.getSobrenome();
        this.email = u.getEmail();
        this.telefone = u.getTelefone();

    }

    @Override
    public Usuario clone(){
        Usuario ret = null;

        try{

            ret = new Usuario(this);

        }catch(Exception e){}

        return ret;

    }
}
