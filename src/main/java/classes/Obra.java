package classes;

import java.sql.Date;

public class Obra {

    private int id;
    private String nombre;
    private String direccion;
    private Date entrega;


    public Obra() {
    }

    public Obra(int id, String nombre, String direccion, Date entrega) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.entrega = entrega;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }
}
