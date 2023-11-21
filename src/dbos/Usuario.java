package dbos;

public class Usuario {

    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String senha;

    public void setId(int id)throws Exception{
        if(id <= 0) throw new Exception("Id inválido");

        this.id = id;
    }

    public void setNome(String nome) throws Exception{
        if(nome == null || nome.equals("")) throw new Exception("Nome inválido!");

        this.nome = nome;
    }

    public void setSobrenome(String sobrenome)throws Exception{
        if(sobrenome == null || sobrenome.equals("")) throw new Exception("Sobrenome inválido!");

        this.sobrenome = sobrenome;
    }

    public void setEmail(String email)throws Exception{
        if(email == null || email.equals("")) throw new Exception("Email inválido!");

        this.email=email;
    }

    public void setTelefone(String telefone)throws Exception{
        if(telefone == null || telefone.equals("")) throw new Exception("Telefone inválido!");

        this.telefone = telefone;
    }

    public void setSenha(String senha)throws Exception{
        if(senha == null || senha.equals("")) throw new Exception("Senha inválida!");

        this.senha = senha;
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

    public String getSenha(){
        return this.senha;
    }

    public Usuario(int id, String nome, String sobrenome, String email, String telefone, String senha) throws Exception{
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        setTelefone(telefone);
        setSenha(senha);
    }

    @Override
    public String toString(){
        return 
        "id: " + this.id +
        " Nome: " + this.nome +
        " Sobrenome: " + this.sobrenome +
        " Email: " + this.email +
        " Telefone: " + this.telefone+
        " Senha: " + this.senha;
    }
    // TODO: hashCode(), equals(), clone(), construtor de copoia
}
