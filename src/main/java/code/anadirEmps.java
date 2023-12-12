package code;

import classes.Empleado;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import classes.Empleados;
import database.ConexionBD;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class anadirEmps {

    public final static List<Empleado> LISTAEMPLEADOS = new ArrayList<>();

    public static void leerXML() {

        Path p = Path.of("src/main/java/resources/empleados.xml");

        if (libs.CheckFiles.ficheroLegible(p)) {

            Empleados emp = new Empleados();

            try {

                // LEER EL DOCUMENTO XML -------------------
                JAXBContext contexto = JAXBContext.newInstance(Empleado.class);
                Unmarshaller unmarshaller = contexto.createUnmarshaller();
                emp = (Empleados) unmarshaller.unmarshal(p.toFile());

                List<Empleado> listaEmps = emp.getEmpleado();

                // RECORRER LOS EMPLEADOS
                for (Empleado empl : listaEmps) {

                    // COMPROBACIONES ANTES DE AÑADIR A LA BASE DE DATOS --------------------
                    if (empl.getNombre() == null){
                        System.err.println("\n>>> ERROR: No se añadirá el empleado por falta de nombre.");
                    } else if (comprobarDni(empl.getDni())){
                        System.err.println("\n>>> ERROR: No se añadirá el empleado porque el DNI ya se encuentra en la base de datos.");
                    } else if (empl.getDni().length() > 9 || empl.getDni().length() < 9) {
                        System.err.println("\n>>> ERROR: No se añadirá el empleado porque el DNI no se ajusta al formato.");
                    } else if (comprobarObra(empl.getNombreObra())) {
                        System.err.println("\n>>> ERROR: No se añadirá el empleado porque la obra asignada ya existe.");
                    } else {

                        Empleado empleado = new Empleado(empl.getDni(), empl.getNombre(), empl.getSueldo(), empl.getNombreObra());
                        LISTAEMPLEADOS.add(empleado);

                        // Informar al usuario
                        System.out.println("\n>>> EMPLEADOS CREADOS CORRECTAMENTE.");

                    }

                }

            } catch (JAXBException e) {
                System.err.println(">>> ERROR EN LA LECTURA DEL ARCHIVO " + e.getMessage());
            }
        }
    }

    private static boolean comprobarObra(String nombreObra) {

        boolean encontrado = false;

        // BUSCAR EN LA BASE DE DATOS SI YA EXISTE LA OBRA ------------------
        try(Connection miCon = ConexionBD.conectar()){
            PreparedStatement pstmt = miCon.prepareStatement("SELECT nombre FROM empleado  WHERE nombreObra = ?");
            pstmt.setString(1,nombreObra);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                encontrado = true;
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se cumple una condición de integridad de la base de datos");;
        } catch (SQLSyntaxErrorException e){
            System.out.println("Hay un error de sintaxis" + e.getMessage());
        }catch(SQLException e){
            System.err.println(">>> Error en la comprobación de la obra");
        }

        return encontrado;
    }

    public static boolean comprobarDni(String dni){

        boolean encontrado = false;

        // BUSCAR EN LA BASE DE DATOS SI YA EXISTE EL DNI -------------
        try(Connection miCon = ConexionBD.conectar()){

            PreparedStatement pstmt = miCon.prepareStatement("SELECT nombre FROM empleado  WHERE dni = ?");
            pstmt.setString(1,dni);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                encontrado = true;
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se cumple una condición de integridad de la base de datos");;
        } catch (SQLSyntaxErrorException e){
            System.out.println("Hay un error de sintaxis" + e.getMessage());
        }catch(SQLException e){
            System.err.println(">>> Error en la comprobación del DNI " + e.getMessage());
        }

        return encontrado;
    }

}
