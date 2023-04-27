package eyenet.controller.db;

import eyenet.controller.gestorDB;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class humanResourcesDB extends gestorDB {

    public humanResourcesDB() throws IOException {
        super();


    }
    public void createPayRoll(int egunKop, float PFEZ, float soldataGordin, int ezinBestekoOrduak, Date data,int orduExtrak,float soldataGarbia, String bankuKontua){
        java.sql.Date actualDate = new java.sql.Date(data.getTime());
        try{
            String query="insert into nominak (egun_kopurua,PFEZ,soldata_gordina,ezinbesteko_ordua,data,ordu_extrak,soldata_garbia,banku_kontua) values (?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connect().prepareStatement(query);
            statement.setInt(1,egunKop);
            statement.setFloat(2,PFEZ);
            statement.setFloat(3,soldataGordin);
            statement.setInt(4,ezinBestekoOrduak);
            statement.setDate(5,actualDate);
            statement.setInt(6,orduExtrak);
            statement.setFloat(7,soldataGarbia);
            statement.setString(8,bankuKontua);
            statement.execute();
            statement.close();
        }catch (SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
