package com.example.demo.service.impl;


import com.example.demo.entity.TbCustomer;
import com.example.demo.repository.TbCustomerRepository;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private TbCustomerRepository customerRepository;


    // 创建一个固定大小的线程池，大小为1000
    ExecutorService executor = newFixedThreadPool(90);


    @Override
    public List<TbCustomer> queryAll() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(TbCustomer customer) {
        customer.setCreateTime(new Date());
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public TbCustomer updateCustomer(TbCustomer customer) {

        customerRepository.updateCustomerName(customer.getCustomerName(), customer.getId());
        return customerRepository.findTbCustomerById(customer.getId());
    }

    @Override
    public void allSave(TbCustomer customer) {

        IntStream.range(0, 100000).forEach(index -> {
            executor.execute(() -> {
                customer.setId(Long.valueOf(index));
                customer.setCreateTime(new Date());
                customer.setCustomerName(customer.getCustomerName());
                customerRepository.save(customer);
            });
        });


    }

    @Override
    public void deleteCustomer(TbCustomer customer) {
        if (Objects.isNull(customer.getId())){
            return;
        }
        customerRepository.deleteById(customer.getId());
    }


}
