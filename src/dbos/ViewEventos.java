package dbos;

public class ViewEventos {
    private String nome;
    private String sobrenome;
    private String titulo;
    private String descricao;
    private String data;
    private String hora;

    public ViewEventos(String nome, String sobrenome, String titulo, String descricao, String data, String hora) throws Exception{
        setNome(nome);
        setSobrenome(sobrenome);
        setTitulo(titulo);
        setDescricao(descricao);
        setData(data);
        setHora(hora);
    }

    public String getNome(){
        return this.nome;
    }

    public String getSobrenome(){
        return this.sobrenome;
    }

    public String getTitulo(){
        return this.titulo;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

    public String getData(){
        return this.data;
    }
    
    public String getHora(){
        return this.hora;
    }

    public void setNome(String nome) throws Exception{
        if(nome.equals("") || nome == null) throw new Exception("Nome inválido!");

        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) throws Exception{
        if(sobrenome.equals("") || sobrenome == null) throw new Exception("Sobrenome inválido!");

        this.sobrenome = sobrenome;
    }

    public void setTitulo(String titulo) throws Exception{
        if(titulo.equals("") || titulo == null)throw new Exception("Título inválido!");

        this.titulo = titulo;
    }

    public void setDescricao(String descricao) throws Exception{
        if(descricao.equals("") || descricao == null) throw new Exception("Descrição inválida!");

        this.descricao = descricao;
    }    

    public void setData(String data) throws Exception{
        if(data.equals("") || data == null) throw new Exception("Data inválida!");

        this.data= data;
    }

    public void setHora(String hora) throws Exception{
        if(hora.equals("") || hora == null) throw new Exception("Horá inválida!");

        this.hora = hora;
    }

    @Override
    public String toString(){
        return
            "Nome do usuário: " + this.nome + "\n" +
            "Sobrenome do usuário: " + this.sobrenome + "\n" +
            "Título do evento: " + this.titulo + "\n" +
            "Descrição do evento: " + this.descricao + "\n" +
            "Data do evento: " + this.data + "\n" +
            "Hora do evento: " + this.hora;
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        if(this == o) return true;

        ViewEventos v = (ViewEventos) o;

        if(this.getNome() != v.getNome()) return false;
        if(this.getSobrenome() != v.getSobrenome()) return false;
        if(this.getTitulo() != v.getTitulo()) return false;
        if(this.getDescricao() != v.getDescricao() ) return false;
        if(this.getData() != v.getData()) return false;
        if(this.getHora() != v.getHora()) return false;

        return true;
    }

    @Override
    public int hashCode(){
        int ret = 1;

        ret += 7*ret + String.valueOf(this.nome).hashCode();
        ret += 7*ret + String.valueOf(this.sobrenome).hashCode();
        ret += 7*ret + String.valueOf(this.titulo).hashCode();
        ret += 7*ret + String.valueOf(this.descricao).hashCode();
        ret += 7*ret + String.valueOf(this.data).hashCode();
        ret += 7*ret + String.valueOf(this.hora).hashCode();

        if(ret < 0) ret = -ret;

        return ret;
    }
}
