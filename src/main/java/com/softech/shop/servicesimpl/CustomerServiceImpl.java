/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.shop.servicesimpl;

import com.softech.shop.model.Customers;
import com.softech.shop.repository.CustomerRepository;
import com.softech.shop.services.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nguyen Tri
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     *
     * @return
     */
    @Override
    public Customers save(Customers cus) {
        return customerRepository.save(cus);

    }

    @Override
    public Customers findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public List<String> listEmail() {
        return customerRepository.listEmail();
    }
}
