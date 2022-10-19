package dio.diodesafiopadroesprojetonapratica.repository;

import dio.diodesafiopadroesprojetonapratica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
