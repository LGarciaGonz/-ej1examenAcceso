package code;

import database.ConexionBD;

import java.sql.*;

public class listarElementos {

    public static void listarElementos() {

        String dniEmp = null, nombreEmp = null;

        try(Connection miCon = ConexionBD.conectar()){
            PreparedStatement pstmt = miCon.prepareStatement("SELECT FROM maquinaria");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("\n**************************************************");
                System.out.println(rs.getString("- MODELO: " + "modelo"));

                dniEmp = rs.getString("empleado");

                PreparedStatement pstmt2 = miCon.prepareStatement("SELECT nombre FROM empleado  WHERE dni = ?");
                pstmt2.setString(1,dniEmp);

                // OBTENER NOMBRE DEL EMPLEADO --------
                ResultSet rs2 = pstmt2.executeQuery();
                while (rs2.next()) {
                    nombreEmp = rs2.getString("nombre");
                }

                System.out.println("- EMPLEADO: " + nombreEmp);
                System.out.println(rs.getString("- OBRA: " + "nombreObra"));

            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se cumple una condición de integridad de la base de datos");;
        } catch (SQLSyntaxErrorException e){
            System.out.println("Hay un error de sintaxis" + e.getMessage());
        }catch(SQLException e){
            System.out.println(">>> Error en la recogida de datos " + e.getMessage());
        }

    }

}

