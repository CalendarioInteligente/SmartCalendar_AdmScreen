package dbos;

public class Evento implements Cloneable{

    private int id;
    private String descricao;
    private String titulo;
    private int idUsuario;
    private String data;
  

    public int getId(){
        return this.id;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public int getIdUsuario(){
        return this.idUsuario;
    }

    public String getData(){
        return this.data;
    }

    public void setId(int id)throws Exception{
        if(id < 0) throw new Exception("Id inválido!");

        this.id= id;
    }

    public void setDescricao(String descricao) throws Exception{
        if(descricao.equals("") || descricao == null) throw new Exception("A descrição não pode ser nula!");

        this.descricao = descricao;
    }

    public void setTitulo(String tiulo) throws Exception{
        if(titulo.equals("") || titulo== null) throw new Exception("Título não pode ser nulo!");

        this.titulo = titulo;
    }

    public void setIdUsuario(int id) throws Exception{
        if(id < 0) throw new Exception("O id não pode ser menor que 0!");

        this.idUsuario = id;
    }

    public void setData(String data) throws Exception{
        if(data.equals("") || data == null) throw new Exception("Data não poder ser nula!");

        this.data= data;
    }

    public Evento(int id, String descricao, String titulo, int idUsuario, String data /*,String hora */)throws Exception{
        setId(id);
        setDescricao(descricao);
        setTitulo(titulo);
        setIdUsuario(idUsuario);
        setData(data);
        // setHora(hora);
    }

    @Override
    public String toString(){
        return
        "IdEvento: " + this.id + "\n" +
        "Titulo: " + this.titulo + "\n" +
        "Descrição: " + this.descricao + "\n" +
        "idUsuário: " + this.idUsuario + "\n" +
        "Data: " + this.data + "\n";
   
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        if(this == o) return true;

        Evento evento = (Evento) o;

        if(this.id != evento.getId()) return false;
        if(this.titulo != evento.getTitulo()) return false;
        if(this.descricao != evento.getDescricao()) return false;
        if(this.idUsuario != evento.getIdUsuario()) return false;
        if(this.data != evento.getData()) return false;


        return true;
    }


    @Override
    public int hashCode(){
        int ret = 1;

        ret += 7*ret + Integer.valueOf(this.id).hashCode();
        ret += 7*ret + String.valueOf(this.descricao).hashCode();
        ret += 7*ret + String.valueOf(this.titulo).hashCode();
        ret += 7*ret + Integer.valueOf(this.idUsuario).hashCode();
        ret += 7*ret + String.valueOf(this.data).hashCode();

        if(ret < 0 ) ret = -ret;

        return ret;
    }


    public Evento(Evento e) throws Exception{
        if(e == null) throw new Exception("Objeto evento nulo!");

        this.id = e.id;
        this.titulo = e.titulo;
        this.descricao = e.descricao;
        this.idUsuario = e.idUsuario;
        this.data = e.data;
    }

    @Override
    public Evento clone(){
        Evento ret = null;
        try{
            ret = new Evento(this);
        }catch(Exception e){}

        return ret;
    } 
}
