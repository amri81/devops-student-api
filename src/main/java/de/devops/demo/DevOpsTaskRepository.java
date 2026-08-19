package de.devops.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DevOpsTaskRepository extends JpaRepository<DevOpsTask, Long> {
}