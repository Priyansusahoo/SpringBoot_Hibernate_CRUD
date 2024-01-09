package com.example.demo.repo;

import com.example.demo.entity.AddressClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AddressRepo extends JpaRepository<AddressClass, Long> {
    /**
     * This interface method is not needed as we are handling it in CrudService class.
     */
//    @Modifying
//    @Transactional
//    @Query("insert into AddressClass values(:addressid, :pincode, :city)")
//    int insertAddressById(@Param("addressid") String addressid,
//                          @Param("pincode") String pincode,
//                          @Param("city") String city);
}
