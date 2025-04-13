package org.example.chatapp.repo;

import org.example.chatapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findTop20ByOrderByTimestampDesc(); // Oxirgi 20 ta xabar
}
