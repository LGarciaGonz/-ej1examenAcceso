package classes;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlRootElement(name = "empleados")
@XmlType(propOrder = {"empleados"})

public class Empleados {

    private List<Empleado> empleado;

    @XmlElement(name = "empleado")
    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }
}
