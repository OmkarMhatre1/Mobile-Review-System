package mobileService.controller;

import lombok.RequiredArgsConstructor;
import mobileService.entity.Mobile;
import mobileService.service.MobileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mobile")
public class MobileController {

    private final MobileService service;

    @PostMapping
    public ResponseEntity<Mobile> saveMobile(@RequestBody Mobile mobile) {

        Mobile mobile1 = service.saveMobile(mobile);
        return ResponseEntity.status(HttpStatus.CREATED).body(mobile1);
    }

    @GetMapping
    public ResponseEntity<List<Mobile>> getListOfMobile() {
        List<Mobile> allMobile = service.getAllMobile();
        return ResponseEntity.ok(allMobile);
    }

    @GetMapping("/{mobileId}")
    public ResponseEntity<Mobile> getMobileId(@PathVariable String mobileId) {
        Mobile mobile = service.getMobile(mobileId);
        return ResponseEntity.status(HttpStatus.FOUND).body(mobile);
    }

    @PutMapping
    public ResponseEntity<Mobile> updateMobile(@RequestBody Mobile mobile) {
        Mobile mobile1 = service.updateMobile(mobile);
        return ResponseEntity.status(HttpStatus.CREATED).body(mobile1);
    }

    @DeleteMapping("/{mobileId}")
    public String deleteMobile(@PathVariable String mobileId) {
        return service.deleteMobile(mobileId);
    }

}
