/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieutm.mobile;

import hieutm.util.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author hieu1
 */
public class MobileDAO implements Serializable {

    public List<MobileDTO> listMobile() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MobileDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select IdMobile, NameMobile, Price, Description "
                        + "From Mobile ";

                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileid = rs.getString("IdMobile");
                    String mobilename = rs.getString("NameMobile");
                    int price = rs.getInt("Price");
                    String description = rs.getString("Description");
                    MobileDTO dto = new MobileDTO(mobileid, mobilename, price, description);

                    list.add(dto);

                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
