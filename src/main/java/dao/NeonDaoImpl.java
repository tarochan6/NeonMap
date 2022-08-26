package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Neon;

public class NeonDaoImpl implements NeonDao {

	private DataSource ds;

	public NeonDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public List<Neon> findByAll(Neon neons) throws Exception {
		List<Neon> neon = new ArrayList<>();
		try	(Connection con = ds.getConnection()){
			String sql = "SELECT neons.*,"
					+ " members.name AS members_name FROM neons"
					+ " JOIN members ON neons.member_id = members.id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				neon.add(mapToNeon(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return neon;
		
	}
	
	@Override
	public List<Neon> findByMember(Neon neons) throws Exception {
		List<Neon> neon = new ArrayList<>();
		try	(Connection con = ds.getConnection()){
			String sql = "SELECT neons.*, members.name AS member_name FROM neons"
					+ " JOIN members ON neons.member_id = members.id WHERE member_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				neon.add(mapToNeon(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return neon;
		
	}

	@Override
	public Neon findById(int id, int userId) throws Exception {
		Neon neon = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT neons.*,"
					+ " members.name AS member_name FROM neons"
					+ " JOIN members ON neons.member_id = members.id WHERE neons.id = ? AND member_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				neon = mapToNeon(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return neon;
	}

	@Override
	public void insert(Neon neons) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void update(Neon neons) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void delete(int id, int userId) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	protected Neon mapToNeon(ResultSet rs) throws Exception {
		Neon neon = new Neon();
		neon.setId(rs.getInt("id"));
		neon.setMemberId(rs.getInt("member_id"));
		neon.setMemberName(rs.getString("member_name"));
		neon.setAddress(rs.getString("address"));
		neon.setRegistered(rs.getDate("registered"));
		neon.setNote(rs.getString("note"));
		return neon;
	}

}
