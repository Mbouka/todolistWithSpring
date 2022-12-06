package org.isj.ing.annuarium.webapp.Annuarium.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")
public class Todolist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name = "status")
    private String status;

    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
}
