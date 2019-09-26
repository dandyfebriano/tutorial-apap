package apap.tutorial.shapee.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="store")
public class StoreModel implements Serializable, Comparable<StoreModel>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name="nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 30)
    @Column(name="keterangan", nullable = false)
    private String keterangan;

    @NotNull
    @Column(name= "followers")
    private Integer followers;

    @OneToMany(mappedBy = "storeModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  List<ProductModel> listProduct;



	public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getFollowers() {
        return this.followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    @Override
    public int compareTo(StoreModel store){
        if(getNama() == null || store.getNama() == null){
            return 0;
        }
        return getNama().compareTo(store.getNama());
    }


}