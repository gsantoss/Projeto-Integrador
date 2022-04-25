package com.wiprobootcamp.classeA.ProjetoFinal.controller;

import com.wiprobootcamp.classeA.ProjetoFinal.model.Customer;
import com.wiprobootcamp.classeA.ProjetoFinal.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @GetMapping("/{idCustomer}")
//    public ResponseEntity<Individual> getIndividualById(@PathVariable Integer idCustomer) {
//        Individual individual = this.service.findIndividualCustomerById(idCustomer);
//        return ResponseEntity.ok().body(individual);
//    }

    @GetMapping("/findall")
    public Iterable<Customer> getAllIndividual() {
        return this.customerService.findAllCustomer();
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createIndividualCustomer(@RequestBody Customer customer) throws Exception {
        Customer newCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateIndividual(@RequestBody Customer customer) throws Exception {
        customerService.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customer);
    }

//    @DeleteMapping("/delete/{idCustomer}")
//    public ResponseEntity<Void> deleteIndividual(@PathVariable Integer idCustomer) {
//        this.service.deleteIndividualCustomer(idCustomer);
//        return ResponseEntity.noContent().build();
//    }
}
