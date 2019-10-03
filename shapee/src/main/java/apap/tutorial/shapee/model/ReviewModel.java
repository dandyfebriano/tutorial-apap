package apap.tutorial.shapee.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "review")
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name= "nama_reviewer", nullable = false)
    private String namaReviewer;

    @NotNull
    @Size(max = 50)
    @Column(name= "isi_review", nullable = false)
    private String isiReview;

    @Size(max = 50)
    @Column(name= "kritik", nullable = true)
    private String kritik;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="productid", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ProductModel productModel;



}