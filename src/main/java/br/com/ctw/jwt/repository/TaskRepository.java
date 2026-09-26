package br.com.ctw.jwt.repository;

import br.com.ctw.jwt.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {}
