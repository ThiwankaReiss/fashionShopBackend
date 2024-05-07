package org.example.service.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.CustomerDto;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CustomerEntity save(CustomerDto customerDto) {
        customerDto.setStatus("customer");
        if(customerDto.getId()==null || customerDto.getId().equals("")){
            CustomerEntity customerEntity=new CustomerEntity();
            if(customerRepository.findByUserName(customerDto.getUserName()).isPresent()){
                return new CustomerEntity(
                     null,
                     "present"  ,
                        null,
                        null,
                        null,
                        null
                );
            }
            if(customerRepository.findByPassword(customerDto.getPassword()).isPresent()){
                return new CustomerEntity(
                        null,
                        null  ,
                        null,
                        "present",
                        null,
                        null
                );
            }
            if(customerRepository.findByEmail(customerDto.getEmail()).isPresent()){
                return new CustomerEntity(
                        null,
                        null  ,
                        "present",
                        null,
                        null,
                        null
                );
            }
        }else{
            CustomerEntity entity=customerRepository.findByPassword(customerDto.getPassword()).orElse(null);

            if(!entity.getUserName().equals(customerDto.getUserName())){

                if(customerRepository.findByUserName(customerDto.getUserName()).isPresent()){

                    return new CustomerEntity(
                            null,
                            "present"  ,
                            null,
                            null,
                            null,
                            null
                    );
                }

            }
            if(!entity.getPassword().equals(customerDto.getPassword())){
                if(customerRepository.findByPassword(customerDto.getPassword()).isPresent()){
                    return new CustomerEntity(
                            null,
                            null  ,
                            null,
                            "present",
                            null,
                            null
                    );
                }
            }
            if(!entity.getEmail().equals(customerDto.getEmail())){
                if(customerRepository.findByEmail(customerDto.getEmail()).isPresent()){
                    return new CustomerEntity(
                            null,
                            null  ,
                            "present",
                            null,
                            null,
                            null
                    );
                }
            }



        }

        return customerRepository.save(mapper.convertValue(customerDto,CustomerEntity.class));
    }
    @Override
    public boolean delete(Long value) {
        if(customerRepository.findById(value).isPresent()){
            customerRepository.deleteById(value);
            return true;
        }
        return false;
    }
    @Override
    public List<CustomerDto> getAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(entity -> mapper.convertValue(entity, CustomerDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Long getNextId() throws SQLException {
        return customerRepository.count() + 1;
    }
    @Override
    public CustomerDto getById(Long id) {
        return customerRepository.findById(id)
                .map(entity -> mapper.convertValue(entity, CustomerDto.class))
                .orElse(null);
    }

    public CustomerDto authCustomer(CustomerDto dto){

        if(customerRepository.findByUserName(dto.getUserName()).isPresent() && customerRepository.findByPassword(dto.getPassword()).isPresent()){
            return mapper.convertValue(customerRepository.findByUserName(dto.getUserName()).orElse(null),CustomerDto.class);
        }
        return null;
    }
}
