package kg.easyit.onlineshop.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends AbstractPersistable<Long> {
    @Column(name = "product_name", nullable = false)
    String productName;

    @Column(name = "price", nullable = false)
    BigDecimal price;

    @Column(name = "units_in_stock", nullable = false)
    Integer unitsInStock;

    @Column(name = "is_active", nullable = false)
    Boolean isActive;

}
