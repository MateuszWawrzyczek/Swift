package swift.swift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swift.swift.model.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    
    Optional<Branch> findBySwiftCode(String swiftCode);

    List<Branch> findAllByCountryISO2(String countryISO2);

    void deleteBySwiftCode(String swiftCode);
}
