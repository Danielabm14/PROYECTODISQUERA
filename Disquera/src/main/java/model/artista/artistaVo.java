package model.artista;

public class artistaVo {
    private int idArtista;
    private String numeroDocumento;
    private String tipoDocumento;
    private String nombreArtista;
    private String apellidoArtista;
    private String nombreArtistico;
    private String fechaNacimiento;
    private String emailArtista;
    private Boolean estadoArtista;



public artistaVo(){

}
public artistaVo(int idArtista, String numeroDocumento, String tipoDocumento, String nombreArtista, String apellidoArtista, String nombreArtistico, String fechaNacimiento, String emailArtista, Boolean estadoArtista ){


    this.idArtista = idArtista;
    this.numeroDocumento = numeroDocumento;
    this.tipoDocumento = tipoDocumento;
    this.nombreArtista = nombreArtista;
    this.apellidoArtista = apellidoArtista;
    this.nombreArtistico = nombreArtistico;
    this.fechaNacimiento = fechaNacimiento;
    this.emailArtista = emailArtista;
    this.estadoArtista = estadoArtista;


}
public int getIdArtista() {
    return idArtista;
}
public void setIdArtista(int idArtista) {
    this.idArtista = idArtista;
}
public String getNumeroDocumento() {
    return numeroDocumento;
}
public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
}
public String getTipoDocumento() {
    return tipoDocumento;
}
public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
}
public String getNombreArtista() {
    return nombreArtista;
}
public void setNombreArtista(String nombreArtista) {
    this.nombreArtista = nombreArtista;
}
public String getApellidoArtista() {
    return apellidoArtista;
}
public void setApellidoArtista(String apellidoArtista) {
    this.apellidoArtista = apellidoArtista;
}
public String getNombreArtistico() {
    return nombreArtistico;
}
public void setNombreArtistico(String nombreArtistico) {
    this.nombreArtistico = nombreArtistico;
}
public String getFechaNacimiento() {
    return fechaNacimiento;
}
public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
}
public String getEmailArtista() {
    return emailArtista;
}
public void setEmailArtista(String emailArtista) {
    this.emailArtista = emailArtista;
}
public Boolean getEstadoArtista() {
    return estadoArtista;
}
public void setEstadoArtista(Boolean estadoArtista) {
    this.estadoArtista = estadoArtista;
}



}
