package com.rbondarovich.interfaces;

import com.rbondarovich.beans.AddressBean;

public interface AddressService {

    Iterable<AddressBean> getAllAddresses();

    AddressBean getAddressById(Long addressId);

    void saveAddress (AddressBean address);

    void deleteAddress (Long addressId);

}
