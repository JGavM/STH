package STH;
import java.sql.*;

/**
 *
 * @author Gavito
 */
public class Conexion {
    private static Connection conex;
    public static Connection conectar() throws SQLException, ClassNotFoundException{
        if(conex == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conex = DriverManager.getConnection("jdbc:mysql://localhost/comida", "root", "*");
            }
            catch(SQLException ex){
                throw new SQLException(ex);
            }
            catch(ClassNotFoundException ex){
                throw new ClassNotFoundException(ex.getMessage());
            }
        }
        return conex;
    }
    
    public static void cerrar() throws SQLException{
        if(conex != null){
            conex.close();
        }
    }
}
