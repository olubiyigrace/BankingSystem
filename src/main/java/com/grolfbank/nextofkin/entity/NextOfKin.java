package com.grolfbank.nextofkin.entity;

import com.grolfbank.users.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nextOfKin_tbl")

public class NextOfKin {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String fullName;
     private String relationship;
     private String address;
     private String email;
     private String mobile;
     private String occupation;

    @OneToOne(mappedBy = "nextOfKin")
    private User user;
}
