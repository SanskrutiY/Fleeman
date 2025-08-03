package repository;

import entity.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddOnRepository extends JpaRepository<AddOn, Integer> {
    List<AddOn> findByBookingBook_id(int bookId);
}
