package dao;

import java.util.List;

import domain.Neon;

public interface NeonDao {
	
List<Neon> findByAll(Neon neons) throws Exception;

Neon findById(int id, int userId) throws Exception;

void insert(Neon neons) throws Exception; 
void update(Neon neons) throws Exception; 
void delete(int id,int userId) throws Exception;

}
