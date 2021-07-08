/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.Sql;
import java.sql.*;
/**
 *
 * @author mtskaioken
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(Sql.SqlConnect());      
        System.out.println(Sql.SqlRequest("MTSKaioken", "kaio2011"));
       
    }
}
    
