package main.Concept.JavaQuestion.Security;

public class SomeBadNGoodUsage {


    /*** Bad example.
     public String getUserName(HttpServletRequest request) {
     String userId = request.getParameter("userId");
     Connection conn = DriverManager.getConnection(DB_URL);
     Statement stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery("SELECT name FROM users WHERE id = " + userId);
     if (rs.next()) {
     return rs.getString("name");
     }
     return null;
     }

     public void updateUserEmail(int userId, String email) {
     String sql = "UPDATE users SET email = '" + email + "' WHERE id = " + userId;
     Statement stmt = connection.createStatement();
     stmt.executeUpdate(sql);
     }
     ***/
}
