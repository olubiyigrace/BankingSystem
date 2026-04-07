package com.grolfbank.transaction.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grolfbank.users.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String reference;
    private String status;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "senderId", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiverId", nullable = false)
    private User receiver;


}
