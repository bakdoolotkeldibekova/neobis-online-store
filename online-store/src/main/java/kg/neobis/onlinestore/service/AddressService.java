package kg.neobis.onlinestore.service;

import kg.neobis.onlinestore.entity.Address;

import java.util.List;

public interface AddressService {
    Address create(Address address);
    List<Address> getAll();
    Address getById(Long id);
}
