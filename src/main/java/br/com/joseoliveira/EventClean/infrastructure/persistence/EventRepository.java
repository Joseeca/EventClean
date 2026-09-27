package br.com.joseoliveira.EventClean.infrastructure.persistence;

import br.com.joseoliveira.EventClean.core.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<Event> findByIdentificator (String identificator);
}
