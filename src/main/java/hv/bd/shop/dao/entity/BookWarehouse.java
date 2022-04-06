package hv.bd.shop.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bookwarehouse")
@Getter
@Setter
@RequiredArgsConstructor
public class BookWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Book> Book;

    @Column
    private int availableBooks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookWarehouse bookWarehouse = (BookWarehouse) o;
        return id!= null && Objects.equals(id,bookWarehouse.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "BookWarehouse{" +
                "id=" + id +
                ", Book=" + Book +
                ", availableBooks=" + availableBooks +
                '}';
    }
}
