package swift.swift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swift.swift.model.Headquarter;
import java.util.List;
import java.util.Optional;

public interface HeadquarterRepository extends JpaRepository<Headquarter, Long> {
    Optional<Headquarter> findBySwiftCode(String swiftCode);

    List<Headquarter> findAllByCountryISO2(String countryISO2);

    void deleteBySwiftCode(String swiftCode);
}
