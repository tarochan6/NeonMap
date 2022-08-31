package dao;

import java.util.List;

import domain.Neon;

public interface NeonDao {
	
List<Neon> findAll() throws Exception;

Neon findById(int id, int userId) throws Exception;

List<Neon> findByMember(int userId)throws Exception;

void insert(Neon neons) throws Exception; 
void update(Neon neons) throws Exception; 
void delete(int id,int userId) throws Exception;

}
