/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postgreeSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pervaiz Ahmad
 */
public class TableModel extends JTableModel  {
    String[] columnNames;
    private Object[][] data;

    public void setColumnNames(String[] col) {
        columnNames = new String[col.length];
        for (int j = 0; j < col.length; j++) {
            columnNames[j] = col[j];
        }
        this.setColumnName(columnNames);
    }

    public void setTableData(ArrayList list) {
        data = new Object[list.size()][columnNames.length];
        int row = 0;
        for (int i = 0; i < list.size(); i++) {

            City objData = (City) list.get(i);

            data[row][0] = objData.getId();
            data[row][1] = objData.getName();

            row++;
        }
        this.setData(data);
    }

    public void populateTable() {
        String[] col = {"City #", "City Name"};
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Connection con;
            String URL="jdbc:postgresql://127.0.0.1:5432/new_db";
            String userName="postgres";
            String password="ahmad1213";
            con=DriverManager.getConnection(URL,userName,password);
            
            String qry="SELECT * FROM city.\"CITIES\" ";
            Statement stmnt;
            stmnt=(Statement) con.createStatement();
            ResultSet rs = stmnt.executeQuery(qry);
            
            while(rs.next())
            {
                String $data=rs.getString("city_id");
                int id=Integer.parseInt($data);
                String name=rs.getString("city_name");
                cityList.add(new City(id,name));
               
            }
            rs.close();
            stmnt.close();
            con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //studentList.add(new Student("001", "Asad", "MCS"));
            
        
        setColumnNames(col);
        setTableData(cityList);
    }
}
