package com.example.listener;

import com.example.entity.History;
import com.example.entity.Product;
import com.example.repository.HistoryRepository;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class AuditProductListener {

    private final HistoryRepository historyRepository;

    @PrePersist
    private void prePersis(Product product) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        History history = new History();
        history.setName(product.getName());
        history.setDate(LocalDateTime.now());
        history.setOperation("INSERT");
        history.setUser(user);
        this.historyRepository.save(history);
    }

    @PreUpdate
    private void preUpdate(Product product) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        History history = new History();
        history.setName(product.getName());
        history.setDate(LocalDateTime.now());
        history.setOperation("UPDATE");
        history.setUser(user);
        this.historyRepository.save(history);
    }

    @PreRemove
    private void preRemove(Product product) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        History history = new History();
        history.setName(product.getName());
        history.setDate(LocalDateTime.now());
        history.setOperation("DELETE");
        history.setUser(user);
        this.historyRepository.save(history);
    }
}
