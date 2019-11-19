package com.ns.carrental.Repository;

import com.ns.carrental.model.BookedCarsList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookedCarsRepo extends JpaRepository<BookedCarsList, Long> {
    List<BookedCarsList> findByNumberplate(String numberplate);

    List<BookedCarsList> findByPhonenumber(long phonenumber);

    BookedCarsList findByNumberplateAndBookstatus(String numberplate, boolean bookstatus);
}
