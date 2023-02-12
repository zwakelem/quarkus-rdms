package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_purchase_order_lines")
public class OrderLine extends PanacheEntity {

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "item_fk")
  public Item item;

  @Column(nullable = false)
  public Integer quantity;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "purchase_order_fk")
  public PurchaseOrder purchaseOrder;

  @Column(name = "created_date", nullable = false)
  public Instant createdDate = Instant.now();

}
