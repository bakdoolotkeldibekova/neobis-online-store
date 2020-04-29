package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Address;

import java.util.List;

public interface AddressService {
    Address create(Address address);
    Address update(Address address);
    Address getById(Long id);
    List<Address> getAll();
    void deleteById(Long id);
}
