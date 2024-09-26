package com.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
	
	public List<Character> findByParentId(Long id);

}
