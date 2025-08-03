package repository;

import entity.Addon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddOnRepository extends JpaRepository<Addon, Integer> {

}
