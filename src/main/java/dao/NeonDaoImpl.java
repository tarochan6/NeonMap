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
	public List<Neon> findAll() throws Exception {
		List<Neon> neon = new ArrayList<>();
		try	(Connection con = ds.getConnection()){
			String sql = "SELECT neons.*,"
					+ " members.name AS member_name FROM neons"
					+ " JOIN members ON neons.member_id = members.id ORDER BY registered DESC";
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
	public List<Neon> findByMember(int userId) throws Exception {
		List<Neon> neon = new ArrayList<>();
		try	(Connection con = ds.getConnection()){
			String sql = "SELECT neons.*, members.name AS member_name FROM neons"
					+ " JOIN members ON neons.member_id = members.id WHERE member_id = ? ORDER BY registered DESC";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, userId);
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
		try (Connection con = ds.getConnection()) {
		String sql = "INSERT INTO neons (name, member_id, address, registered, note) VALUES (?, ?, ?, now(), ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, neons.getName());
		stmt.setInt(2, neons.getMemberId());
		stmt.setString(3, neons.getAddress());
		stmt.setString(4, neons.getNote());
		stmt.executeLargeUpdate();
	}catch (Exception e) {
		throw e;
	}
	
	}

	@Override
	public void update(Neon neons) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE neons SET name = ?, address = ?, note = ? WHERE id = ? AND member_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, neons.getName());
			stmt.setString(2, neons.getAddress());
			stmt.setString(3, neons.getNote());
			stmt.setInt(4, neons.getId());
			stmt.setInt(5, neons.getMemberId());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public void delete(int id, int userId) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM neons WHERE id = ? AND member_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, userId);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	protected Neon mapToNeon(ResultSet rs) throws Exception {
		Neon neon = new Neon();
		neon.setId(rs.getInt("id"));
		neon.setName(rs.getString("name"));
		neon.setMemberId(rs.getInt("member_id"));
		neon.setMemberName(rs.getString("member_name"));
		neon.setAddress(rs.getString("address"));
		neon.setRegistered(rs.getDate("registered"));
		neon.setNote(rs.getString("note"));
		return neon;
	}

}
