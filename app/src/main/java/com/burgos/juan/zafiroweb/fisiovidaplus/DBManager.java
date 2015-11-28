package com.burgos.juan.zafiroweb.fisiovidaplus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrador on 27/11/2015.
 */
public class DBManager
{
    private String url = "jdbc:mysql://us-cdbr-azure-east-b.cloudapp.net/acsm_c83cee60e46dfea";

    public void guardarCuenta(String correo, String pass, String nombre, Double estatura, String fecha, Double peso, String genero)
    {
        try
        {
            Connection conn;
            PreparedStatement st;
            String idGenero = "N";

            if(genero.equals("2131492957")){
                idGenero = "M";
            }
            else if(genero.equals("2131492958"))
            {
                idGenero = "F";
            }

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");

            st = conn.prepareStatement(
                    "Insert into persona(Correo, Password, Nombre, Estatura, FechaNacimiento, Peso, Genero)" +
                            " VALUES (?,?,?,?,?,?,?)"
            );

            st.setString(1, correo);
            st.setString(2, pass);
            st.setString(3, nombre);
            st.setDouble(4, estatura);
            st.setString(5, fecha);
            st.setDouble(6, peso);
            st.setString(7, idGenero);
            st.execute();

            st.close();
            conn.close();

            System.out.println("FINALIZOOOOOOOO!!!!!!!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
        }

    }

    public void guardarPresion(int sistolica, int diastolica, int id)
    {
        try
        {
            Connection conn;
            PreparedStatement st;
            String idGenero = "N";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");

            st = conn.prepareStatement(
                    "Insert into Presion(persona_idPersona, Sistolica, Diastolica, fecha)" +
                            " VALUES (?,?,?, NOW())"
            );

            st.setInt(1, sistolica);
            st.setInt(2, diastolica);
            st.setInt(3, id);

            st.execute();
            st.close();
            conn.close();

            System.out.println("FINALIZOOOOOOOO!!!!!!!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
        }
    }

    public void guardarGlucometria(int id, int glucometria)
    {
        try
        {
            Connection conn;
            PreparedStatement st;
            String idGenero = "N";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");

            st = conn.prepareStatement(
                    "Insert into Glucometria(persona_idPersona, valor, fecha)" +
                            " VALUES (?,?, NOW())"
            );

            st.setInt(1, id);
            st.setInt(2, glucometria);

            st.execute();
            st.close();
            conn.close();

            System.out.println("FINALIZOOOOOOOO!!!!!!!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
        }
    }

    public void guardarIndicadoresViceral(int id, int viceral)
    {
        try
        {
            Connection conn;
            PreparedStatement st;
            String idGenero = "N";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");

            st = conn.prepareStatement(
                    "Insert into Indicadores(persona_idPersona, GrasaViceral, fecha)" +
                            " VALUES (?,?, NOW())"
            );

            st.setInt(1, id);
            st.setInt(2, viceral);

            st.execute();
            st.close();
            conn.close();

            System.out.println("FINALIZOOOOOOOO!!!!!!!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
        }
    }

    public void guardarIndicadoresCorporal(int id, int corporal)
    {
        try
        {
            Connection conn;
            PreparedStatement st;
            String idGenero = "N";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");

            st = conn.prepareStatement(
                    "Insert into Indicadores(persona_idPersona, MuscCorporal, fecha)" +
                            " VALUES (?,?, NOW())"
            );

            st.setInt(1, id);
            st.setInt(2, corporal);

            st.execute();
            st.close();
            conn.close();

            System.out.println("FINALIZOOOOOOOO!!!!!!!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
        }
    }

    public String consultaPeso(int id)
    {
        try
        {   String peso;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");
            String querySql = "SELECT peso FROM Persona WHERE idPersona = " + id;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            rs.next();
            peso = rs.getString(1);
            System.out.println(peso);
            //st.close();
            //rs.close();
            System.out.println("FINALIZOOOOOOOO!!!!!!!");
            conn.close();
            return  peso;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
            return  "";
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
            return  "";
        }
    }

    public String consultaEstatura(int id)
    {
        try
        {   String estatura;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");
            String querySql = "SELECT Estatura FROM Persona WHERE idPersona = " + id;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            rs.next();
            estatura = rs.getString(1);
            System.out.println(estatura);
            //st.close();
            //rs.close();
            System.out.println("FINALIZOOOOOOOO!!!!!!!");
            conn.close();
            return  estatura;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
            return  "";
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
            return  "";
        }
    }

    public String consultaCorreo(int id)
    {
        try
        {   String estatura;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");
            String querySql = "SELECT Correo FROM Persona WHERE idPersona = " + id;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            rs.next();
            estatura = rs.getString(1);
            System.out.println(estatura);
            //st.close();
            //rs.close();
            System.out.println("FINALIZOOOOOOOO!!!!!!!");
            conn.close();
            return  estatura;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
            return  "";
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
            return  "";
        }
    }

    public String consultaPass(int id)
    {
        try
        {   String estatura;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");
            String querySql = "SELECT Password FROM Persona WHERE idPersona = " + id;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            rs.next();
            estatura = rs.getString(1);
            System.out.println(estatura);
            //st.close();
            //rs.close();
            System.out.println("FINALIZOOOOOOOO!!!!!!!");
            conn.close();
            return  estatura;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
            return  "";
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
            return  "";
        }
    }

    public String consultaID(int id)
    {
        try
        {   String estatura;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "bce40ced77ca51", "33e0659c");
            String querySql = "SELECT idPersona FROM Persona WHERE idPersona = " + id;

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querySql);
            rs.next();
            estatura = rs.getString(1);
            System.out.println(estatura);
            //st.close();
            //rs.close();
            System.out.println("FINALIZOOOOOOOO!!!!!!!");
            conn.close();
            return  estatura;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Error clase!!!!!!!!");
            return  "";
        }
        catch (SQLException e)
        {
            System.out.println("Error SQL!!!!!!! " +  e.toString());
            return  "";
        }
    }

}
