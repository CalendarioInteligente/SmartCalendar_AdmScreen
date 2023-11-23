package dbos;

public class Evento {
    /* id int IDENTITY(1, 1) NOT NULL,
	descricao varchar(200) not null,
	titulo varchar(40) not null,
	idUsuario int not null,
	data datetime not null, */

    private int id;
    private String descricao;
    private String titulo;
    private int idUsuario;
    private String data;
    private String hora;


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

    public String getHora(){
        return this.hora;
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

    public void setHora(String hora)throws Exception{
        if(hora.equals("")|| hora== null) throw new Exception("Hora não pode ser nula!");

        this.hora = hora;
    }



    public Evento(int id, String descricao, String titulo, int idUsuario, String data, String hora)throws Exception{
        setId(id);
        setDescricao(descricao);
        setTitulo(titulo);
        setIdUsuario(idUsuario);
        setData(data);
        setHora(hora);
    }

    @Override
    public String toString(){
        return
        "IdEvento: " + this.id + "\n" +
        "Titulo: " + this.titulo + "\n" +
        "Descrição: " + this.descricao + "\n" +
        "idUsuário: " + this.idUsuario + "\n" +
        "Data: " + this.data + "\n" +
        "Hora: " + this.hora + "\n";
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
        if(this.hora != evento.getHora()) return false;

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
        ret += 7*ret + String.valueOf(this.hora).hashCode();

        if(ret < 0 ) ret = -ret;

        return ret;
    }


    


    
}
