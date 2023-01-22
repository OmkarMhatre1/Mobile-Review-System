package mobileService.service;

import lombok.RequiredArgsConstructor;
import mobileService.entity.Mobile;
import mobileService.repository.MobileRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MobileService {

    private final MobileRepository repository;


    public List<Mobile> getAllMobile() {
        return repository.findAll();
    }

    public Mobile getMobile(String mobileId) {
        return repository.findById(mobileId).orElseThrow(() -> new RuntimeException(mobileId));

    }

    public Mobile saveMobile(Mobile mobile) {
        return repository.save(mobile);
    }


    public Mobile updateMobile(Mobile mobile) {
        Mobile mobile1 = repository.findById(mobile.getMobileId()).orElse(null);
        mobile1.setName(mobile.getName());
        mobile1.setBrand(mobile.getBrand());
        mobile1.setPrice(mobile.getPrice());

        return repository.save(mobile1);

    }

    public String deleteMobile(String mobileId) {
        repository.deleteById(mobileId);
        return "Deleted" + mobileId;
    }


}
