package dao;

import java.util.List;

import domain.Member;

public interface MemberDao {

	List<Member> findAll() throws Exception;
	Member findByLoginId(String LoginId) throws Exception;
	void insert(Member member) throws Exception;
	void update(Member member) throws Exception;
	void delete(Member member) throws Exception;
	
	Member findByIdAndPass(String loginId, String loginPass) throws Exception;
}
