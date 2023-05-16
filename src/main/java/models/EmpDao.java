package models;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDao {

    private JdbcTemplate jdbcTemplate;

    public PreparedStatement insert(Emp emp) throws SQLException {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        Connection con = null;
        String sql = "INSERT INTO EMP2(EMPNO, ENAME, JOB) VALUES (?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"EMPNO"});
        pstmt.setString(1,"1");
        pstmt.setString(2,"홍길순");
        pstmt.setString(3,"1234");
        pstmt.executeUpdate();
        pstmt.close();

        return pstmt;
    }

    public void update(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO EMP2 (EMPNO, ENAME, JOB) VALUES (?,?,?)",
                new String[]{"EMPNO"});
                pstmt.setString(1, EMP2.getEMPNO();
        )
    }

    public void delete(int no) {
        String sql = "DELETE FROM EMP2 WHETE EMPNO=?";
        int affectedRows = jdbcTemplate.update(sql, no);
        System.out.println(affectedRows);
    }

    public Emp select() throws SQLException {
        Connection con = null;
        String sql = "SELECT * FROM EMP2 WHERE EMPNO=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);

        Emp emp = new Emp();
        emp.setEMPNO(rs.getLong("EMPNO"));
        emp.setENANE(rs.getString("ENAME"));
        emp.setJOB(rs.getString("JOB"));

        return emp;
    }
}
