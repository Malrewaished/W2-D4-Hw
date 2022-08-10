package com.example.w2d21.controller;

import com.example.w2d21.model.Api;
import com.example.w2d21.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BankController {
    ArrayList<Customer> clientList = new ArrayList<>();


        @GetMapping("/customers")
        public ArrayList<Customer> getCustomers() {
            return clientList;
        }


        @PostMapping("/customers")
        public Api addCustomer(@RequestBody Customer client) {
            clientList.add(client);
            return new Api("Customer Added");
        }

        @PutMapping("/customers/{index}")
        public Api updateCustomer(@RequestBody Customer client, @PathVariable int index) {
            clientList.set(index, client);
            return new Api("Customer updated");
        }

        @DeleteMapping("/customers/{index}")
        public Api deleteCustomer(@PathVariable int index) {
            clientList.remove(index);
            return new Api("Customer removed");
        }


        @PostMapping("/customers/deposit/{index}/{balance}")
        public Api deposit(@PathVariable int index, @PathVariable int balance){
        Customer client = clientList.get(index);
        int oldBalance = client.getBalance();
        client.setBalance(oldBalance + balance);
            return new Api("Deposit done!");
    }

        @PostMapping("/customers/withdraw/{index}/{balance}")
        public Api withdraw(@PathVariable int index, @PathVariable int balance){
        Customer client = clientList.get(index);
        int oldBalance = client.getBalance();
        client.setBalance(oldBalance - balance);
        return new Api("Withdraw done!");
    }
}
