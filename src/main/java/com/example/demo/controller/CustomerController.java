package com.example.demo.controller;

import com.example.demo.entity.TbCustomer;
import com.example.demo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qi_gaui
 */
@RestController
@Slf4j
@RequestMapping("/demo/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询所有customer
     * @return
     */
    @GetMapping("query_all")
    public List<TbCustomer> queryAll(){
        return customerService.queryAll();
    }

    /**
     * 保存customer
     * @return
     */
    @PostMapping("save_customer")
    public void saveCustomer (@RequestBody TbCustomer customer){
        customerService.saveCustomer(customer);
    }



    /**
     * 更新customer
     * @return
     */
    @PostMapping("update_customer")
    public TbCustomer updateCustomer (@RequestBody TbCustomer customer){
        TbCustomer dbCustomer = customerService.updateCustomer(customer);
        return dbCustomer  ;
    }



    /**
     * 大量保存customer
     * @return
     */
    @PostMapping("allSave")
    public void allSave (@RequestBody TbCustomer customer){
        customerService.allSave(customer);
    }



    /**
     * 删除customer
     * @return
     */
    @PostMapping("deleteCustomer")
    public void deleteCustomer(@RequestBody TbCustomer customer){
        customerService.deleteCustomer(customer);
    }



}
