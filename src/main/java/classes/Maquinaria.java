package classes;

public class Maquinaria {

    private String matricula;
    private String modelo;
    private String empleado;
    private String nombreObra;

    public Maquinaria() {
    }

    public Maquinaria(String matricula, String modelo, String empleado, String nombreObra) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.empleado = empleado;
        this.nombreObra = nombreObra;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }
}
