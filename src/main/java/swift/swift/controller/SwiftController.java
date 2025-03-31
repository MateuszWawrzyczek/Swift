package swift.swift.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swift.swift.model.Branch;
import swift.swift.model.Headquarter;
import swift.swift.service.SwiftService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/swift-codes")
public class SwiftController {

    private final SwiftService swiftService;

    public SwiftController(SwiftService swiftService) {
        this.swiftService = swiftService;
    }

    @GetMapping("/{swiftCode}")
    public ResponseEntity<?> getSwiftCodeInfo(@PathVariable String swiftCode) {
        Optional<Headquarter> headquarter = swiftService.getHeadquarterBySwiftCode(swiftCode);
        if (headquarter.isPresent()) {
            return ResponseEntity.ok(headquarter.get());
        }

        Optional<Branch> branch = swiftService.getBranchBySwiftCode(swiftCode);
        return branch.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/country/{countryISO2}")
    public ResponseEntity<List<String>> getSwiftCodesByCountry(@PathVariable String countryISO2) {
        List<String> swiftCodes = swiftService.getSwiftCodesByCountry(countryISO2);
        return ResponseEntity.ok(swiftCodes);
    }

    @PostMapping
    public ResponseEntity<String> addSwiftCode(@RequestBody Branch branch) {
        swiftService.addBranch(branch);
        return ResponseEntity.ok("SWIFT code added successfully.");
    }

    @DeleteMapping("/{swiftCode}")
    public ResponseEntity<String> deleteSwiftCode(@PathVariable String swiftCode) {
        swiftService.deleteSwiftCode(swiftCode);
        return ResponseEntity.ok("SWIFT code deleted successfully.");
    }
}
