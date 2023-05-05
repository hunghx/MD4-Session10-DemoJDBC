package ra.run;

import ra.util.ConnectionToDB;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String SQL = "create table Users(\n" +
                "    id int primary key auto_increment,\n" +
                "    name varchar(255) \n" +
                ") ";
        String SQL2 = "UPDATE USERS set name = 'NAM' WHERE id=1";
        Connection conn = ConnectionToDB.getConnection();
        System.out.println(conn);
        try {
            // khởi tạo 1 đối tựong Statement
            // Statement st = conn.createStatement();
          // thực thi câu lệnh SQL tĩnh
//            st.execute(SQL);
//            Statement st2 = conn.createStatement();
////            st2.executeUpdate(SQL2);
            // Query statement
//            int id =1;
//            PreparedStatement pre = conn.prepareStatement(
//                    "SELECT  * from Users where id ="+ id);
//            ResultSet rs =  pre.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("name"));
//            }
            // Insert, Update, Delete
//            String name ="Lâm";
//            PreparedStatement pre1 = conn.prepareStatement("Insert into Users(name) values(?)");
//            pre1.setString(1,name);
//            int rs = pre1.executeUpdate();
//            System.out.println(rs);
            // CallableStatement
            // gọi procedure : {call + tên procedure}
//            CallableStatement call = conn.prepareCall("{call PROC_GETALLUSERS()}");
//            ResultSet rs = call.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getString(2));
//            }
            CallableStatement call = conn.prepareCall("{call PROC_CREATENEWUSER(?)}");
            call.setString(1,"Thang");
            call.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
