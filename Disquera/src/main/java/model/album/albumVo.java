package model.album;

public class albumVo {
    
    private int idAlbum;
    private String nombreAlbum;
    private String anoPublicado;
    private Boolean estadoAlbum;
    
    
    public albumVo(){

    }

    public albumVo(int idAlbum, String nombreAlbum, String anoPublicado, Boolean estadoAlbum){

        this.idAlbum = idAlbum;
        this.nombreAlbum =nombreAlbum;
        this.anoPublicado = anoPublicado;
        this.estadoAlbum = estadoAlbum;

     
}

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
        
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getanoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(String anoPublicado){
        this.anoPublicado = anoPublicado;
    }

    public Boolean getEstadoAlbum() {
        return estadoAlbum;
    }
    public void setEstadoAlbum(Boolean estadoAlbum){
        this.estadoAlbum= estadoAlbum;
    }

}