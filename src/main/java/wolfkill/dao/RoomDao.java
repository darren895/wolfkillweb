package wolfkill.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import wolfkill.domain.Room;

public interface RoomDao extends JpaRepository<Room, Integer>, QueryDslPredicateExecutor<Room> {

	@Query("select min(id) from Room where status = false")
	public Integer getUnusedMinId();
}
