package com.aplikasi.chapter4.binarfud.repository;
import com.aplikasi.chapter4.binarfud.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    //
}
