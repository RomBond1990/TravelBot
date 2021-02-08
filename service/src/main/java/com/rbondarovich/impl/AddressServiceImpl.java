package com.rbondarovich.impl;


import com.rbondarovich.beans.AddressBean;
import com.rbondarovich.entity.Address;
import com.rbondarovich.interfaces.AddressService;
import com.rbondarovich.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

       private final AddressRepository addressRepo;
       private final EntityBeanConverterImpl converter;

    @Override
    public Iterable<AddressBean> getAllAddresses() {
        List<Address> addresses = addressRepo.findAll();
        List<AddressBean> adressBeans = converter.convertToBeanList(addresses, AddressBean.class);

        return adressBeans;
    }

    @Override
    public AddressBean getAddressById(Long addressId) {
        Address address = addressRepo.getOne(addressId);
        AddressBean addressBean = converter.convertToBean(address, AddressBean.class);

        return addressBean;
    }

    @Override
    public void saveAddress(AddressBean address) {
        Address addressEntity = converter.convertToEntity(address, Address.class);
        addressRepo.save(addressEntity);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepo.deleteById(addressId);
    }
}
