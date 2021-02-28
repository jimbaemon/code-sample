package hello.core.member;

import java.sql.*;


public class JdbcMemberRepository implements MemberRepository{
    Connection con;
    Statement stmt;
    ResultSet rs;
    String url = "jdbc:h2:file:~/present";
    String id = "sa";
    String pw = "";

    public JdbcMemberRepository(){

        try{
            Class.forName("org.h2.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void getConnection(){

        try{
            //커넥션을 가져온다.
            con = DriverManager.getConnection(url, id, pw);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void closeConnection(){

        try{
            //자원 반환
            if(rs != null) {
                rs.close();
            }
            stmt.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void save(Member member) {

        try{

            getConnection();

            stmt = con.createStatement();
            //데이터를 가져온다.
            stmt.executeUpdate("insert into Member (id, name) values ("+member.getId()+", '" + member.getName() + "' )");

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }

    }

    @Override
    public Member findById(Long memberId) {
        Member member = new Member();
        try{

            getConnection();

            stmt = con.createStatement();
            //데이터를 가져온다.
            rs = stmt.executeQuery("select id, name from MEMBER WHERE id = " + memberId);

            while(rs.next()){
                //출력
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }

        return member;
    }
}
