package swift.swift.service; 
import swift.swift.repository.*;
import swift.swift.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeadquarterService {

    @Autowired
    private HeadquarterRepository headquarterRepository;

    public List<BankResponseDTO> getAllHeadquarters() {
        List<Headquarter> headquarters = headquarterRepository.findAll();

        return headquarters.stream().map(hq -> new BankResponseDTO(
            hq.getAddress(),
            hq.getBankName(),
            hq.getCountryISO2(),
            hq.getCountryName(),
            hq.isHeadquarter(),
            hq.getSwiftCode(),
            hq.getBranches().stream().map(branch -> new BranchDTO(
                branch.getAddress(),
                branch.getBankName(),
                branch.getCountryISO2(),
                branch.isHeadquarter(),
                branch.getSwiftCode()
            )).collect(Collectors.toList())
        )).collect(Collectors.toList());
    }
}
