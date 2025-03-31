package swift.swift.controller; 
import swift.swift.service.*;
import swift.swift.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import swift.swift.model.Headquarter;
import swift.swift.service.HeadquarterService;

@RestController
public class HeadquarterController {

    @Autowired
    private HeadquarterService headquartersService;

    @GetMapping("/headquarters")
    public List<BankResponseDTO> getAllHeadquarters() {
        return headquartersService.getAllHeadquarters();
    }
}
