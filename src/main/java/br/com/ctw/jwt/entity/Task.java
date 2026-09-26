package br.com.ctw.jwt.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_task")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            length = 30,
            nullable = false,
            unique = true
    )
    private String title;

    @Column(
            nullable = false
    )
    private String description;

    @Column(
            nullable = false
    )
    private Boolean completed;
    
    @ManyToOne()
    @JoinColumn(
            name = "user_id"
    )
    private User userId;
}
