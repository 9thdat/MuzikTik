package Model.DAO.Employee;

import Model.Database.UserDatabase;
import Model.BEAN.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static EmployeeDAO getInstance() {
        return new EmployeeDAO();
    }
    public Employee selectUserandPassByID(String t) {
        Employee ketQua = null;
        try {
            // Tạo kết nối đến CSDL
            Connection con = UserDatabase.getConnection();

            // Tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM mctmsys.employee WHERE EMP_USERNAME = ?";
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, t);
            // Thực thi câu lệnh SQL

            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Tìm kiếm trong database
            while(rs.next()) {
                String username = rs.getString("EMP_USERNAME");
                String password = rs.getString("EMP_PASSWORD");

                ketQua = new Employee(username, password);

            }
            // Đóng kết nối đến CSDL
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public static String getEmailByUsername(String userName){
        String email = "";
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT EMP_EMAIL FROM mctmsys.employee WHERE EMP_USERNAME = ?";
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                email = rs.getString("EMP_EMAIL");
            }
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return email;
    }

    public static List<String> getListUsername(){
        List<String> listUsername = new ArrayList<>();
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT EMP_USERNAME FROM mctmsys.employee";
            PreparedStatement st = con.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                listUsername.add(rs.getString("EMP_USERNAME"));
            }
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUsername;
    }

    public static void updatePasswordByUsername(String userName, String password){
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "UPDATE mctmsys.employee SET EMP_PASSWORD = ? WHERE EMP_USERNAME = ?";
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, password);
            st.setString(2, userName);
            st.executeUpdate();
            st.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Employee getUserByUsername(String username){
        Employee employee = null;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "SELECT * FROM mctmsys.employee WHERE EMP_USERNAME = ?";
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String userName = rs.getString("EMP_USERNAME");
                String password = rs.getString("EMP_PASSWORD");
                String email = rs.getString("EMP_EMAIL");
                String phoneNumber = rs.getString("EMP_PHONE_NUMBER");
                String address = rs.getString("EMP_ADDRESS");
                byte[] avatar = rs.getBytes("EMP_AVATAR");
                Date DOB = rs.getDate("EMP_DOB");
                String urlAvatar = rs.getString("EMP_URLAVT");
                employee = new Employee(userName, password, email, phoneNumber, address, DOB, avatar, urlAvatar);

            }
            st.close();
            rs.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    public static int updateEmployee(Employee employee){
        int rowChanged = 0;
        try{
            Connection con = UserDatabase.getConnection();
            String sql = "UPDATE mctmsys.employee SET EMP_EMAIL = ?, EMP_PHONE_NUMBER = ?, EMP_ADDRESS = ?, EMP_DOB = ?, EMP_AVATAR = ?, EMP_URLAVT = ? WHERE EMP_USERNAME = ?";
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, employee.getEmail());
            st.setString(2, employee.getPhoneNumber());
            st.setString(3, employee.getAddress());
            st.setDate(4, employee.getDOB());
            st.setBytes(5, employee.getAvatar());
            st.setString(6, employee.getUrlAvatar());
            st.setString(7, employee.getUsername());
            rowChanged = st.executeUpdate();
            st.close();
            UserDatabase.closeConnection(con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowChanged;
    }
}