package Model.DAO.Customer;

import Model.Database.UserDatabase;
import Model.BEAN.Customer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerListDAO{

    public static CustomerListDAO getInstance() {
        return new CustomerListDAO();
    }

    public static List<Customer> getCustomerList() {
            List<Customer> result = new ArrayList<>();
            Customer customerList;
            try {
                // Tạo kết nối đến CSDL
                Connection con = UserDatabase.getConnection();

                // Tạo ra đối tượng PreparedStatement
                String sql = "SELECT * FROM mctmsys.customer";
                PreparedStatement st = con.prepareCall(sql);

                // Thực thi câu lệnh SQL
                System.out.println(sql);
                ResultSet rs = st.executeQuery();

                // Tìm kiếm trong database
                while(rs.next()) {
                    String cusName = rs.getString("CUS_NAME");
                    String cusUserName = rs.getString("CUS_USERNAME");
                    String cusPassWord = rs.getString("CUS_PASSWORD");
                    String cusPhoneNumber = rs.getString("CUS_PHONE_NUMBER");
                    String cusEmail = rs.getString("CUS_EMAIL");
                    String cusAddress = rs.getString("CUS_ADDRESS");
                    int cusId = rs.getInt("CUS_ID");
                    String cusType = rs.getString("CUS_TYPE");
                    int cusTotalPoint = rs.getInt("CUS_TOTAL_POINT");
                    int cusBalance = rs.getInt("CUS_BALANCE");
                    customerList = new Customer(cusId, cusName, cusUserName, cusPassWord, cusPhoneNumber, cusEmail, cusAddress, cusType, cusTotalPoint, cusBalance);
                    result.add(customerList);
                }

                // Đóng kết nối đến CSDL
                st.close();
                rs.close();
                UserDatabase.closeConnection(con);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
    }

    public static int getLastID(){
        int result = 0;
        try {
            Connection con = UserDatabase.getConnection();

            String sql = "Select CUS_ID from mctmsys.customer order by CUS_ID desc limit 1";
            PreparedStatement ps = con.prepareCall(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getInt("CUS_ID");
            }

            ps.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }
}
