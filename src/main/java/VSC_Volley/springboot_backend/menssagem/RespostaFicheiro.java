package VSC_Volley.springboot_backend.menssagem;

public class RespostaFicheiro {
    private String nome;
    private String url;
    private String type;
    private long size;

    public RespostaFicheiro(String nome, String url, String type, long size) {
        this.nome = nome;
        this.url = url;
        this.type = type;
        this.size = size;
    }

    public String getNome() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }


}
