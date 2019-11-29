package com.ns.carrental.repository;

import com.ns.carrental.model.BookedCarsList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedCarsRepo extends JpaRepository<BookedCarsList, Long> {
    List<BookedCarsList> findByNumberplate(String numberplate);

    List<BookedCarsList> findByPhonenumber(long phonenumber);

    BookedCarsList findByNumberplateAndBookstatus(String numberplate, boolean bookstatus);
}
