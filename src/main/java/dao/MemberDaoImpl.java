package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Member;

public class MemberDaoImpl implements MemberDao {

	private DataSource ds;

	public MemberDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Member> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Member findByLoginId(String loginId) throws Exception {
		Member member = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM members WHERE login_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				member = mapToMember(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return member;
	}

	@Override
	public void insert(Member member) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO members (login_id, name, pass) " + " VALUES (?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getLoginId());
			stmt.setString(2, member.getMemberName());
			stmt.setString(3, BCrypt.hashpw(member.getLoginPass(), BCrypt.gensalt()));
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Member member) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Member member) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Member findByIdAndPass(String loginId, String loginPass) throws Exception {
		Member member = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM members WHERE login_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(loginPass, rs.getString("pass"))) {
					member = mapToMember(rs);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return member;
	}

	protected Member mapToMember(ResultSet rs) throws Exception {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setLoginId(rs.getString("login_id"));
		member.setMemberName(rs.getString("name"));
		member.setLoginPass(rs.getString("pass"));
		return member;
	}

}
