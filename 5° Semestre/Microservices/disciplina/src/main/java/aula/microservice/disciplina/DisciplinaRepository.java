package aula.microservice.disciplina;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="disciplina")
public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, String>{
    
}
