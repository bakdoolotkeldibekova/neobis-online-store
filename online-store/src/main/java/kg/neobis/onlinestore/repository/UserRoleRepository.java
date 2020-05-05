package kg.neobis.onlinestore.repository;

import kg.neobis.onlinestore.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByRoleNameContainingIgnoringCase(String roleName);
}
