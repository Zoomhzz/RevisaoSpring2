    package com.example.Revisao2.repository;

    import com.example.Revisao2.model.FuncionarioModel;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;

    @Repository
    public interface FuncionariosRepository extends JpaRepository<FuncionarioModel, Long> {
        Optional<FuncionarioModel> findByEmail(String email);
    }
